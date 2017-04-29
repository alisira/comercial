package com.comercial.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.model.Image;
import com.comercial.model.Products;
import com.comercial.service.ImageService;
import com.comercial.storage.StorageException;
import com.comercial.storage.StorageFileNotFoundException;
import com.comercial.storage.StorageService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {

    private final StorageService storageService;
    private final ImageService imageService;

    @Autowired
    public FileUploadController(StorageService storageService, ImageService imageService) {
        this.storageService = storageService;
        this.imageService = imageService;
    }

    @RequestMapping(value = "/file/{filename:.+}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

    	Resource file = storageService.loadAsResource(filename);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @RequestMapping(value="/file", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseEntity UploadFile(@RequestParam(value="file", required=true) MultipartFile file, RedirectAttributes redirectAttributes) {
        
    	JSONObject jsonObject = null;
    	try {
    		
    		String newFile = storageService.store(file);
    		
    		Image image = imageService.save(new Image(newFile));
        	
        	Map<String, Object> toParse = new HashMap<String, Object>();
    	    toParse.put("imageUrl", "/file/" +newFile);
    	    toParse.put("idImage", image.getIdImage());
    		jsonObject = new JSONObject(toParse);
        	
        } catch (StorageException e) {
        	//return new ResponseEntity<Object>(jsonObject.toJSONString(), HttpStatus.OK);	
        	throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
        	
        	//return ResponseEntity.notFound().build();
        	
        	
        }    	
    	
    	return new ResponseEntity<Object>(jsonObject.toJSONString(), HttpStatus.OK);
    	//return jsonObject.toJSONString();
        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        //return "redirect:/";
    }    

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
