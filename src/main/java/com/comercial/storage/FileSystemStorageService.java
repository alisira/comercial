package com.comercial.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            
    		LocalDateTime now = LocalDateTime.now();            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSS");
            String formatDateTime = now.format(formatter);
            
            String str = file.getOriginalFilename();
            String [] fileName = str.split("\\.");
            
            String newFileName =  fileName[0].replace(' ','_') + "_" + formatDateTime + "." + fileName[1];
            
            long resp =  Files.copy(file.getInputStream(), this.rootLocation.resolve(newFileName));            
            
            if (resp > 0){
            	return newFileName;
            }else{
            	throw new StorageException("Error desconocido al guardar Archivo " + file.getOriginalFilename());
            }
            
        } catch (IOException e) {
            throw new StorageException("Error al guardar Archivo " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Path storagePath() {
        return rootLocation;
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(this.rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            
            if (!Files.exists(this.rootLocation))            
            	Files.createDirectory(this.rootLocation);
            
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
