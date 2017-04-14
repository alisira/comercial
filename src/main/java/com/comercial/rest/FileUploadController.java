package com.comercial.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.storage.StorageException;
import com.comercial.storage.StorageFileNotFoundException;
import com.comercial.storage.StorageService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
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
    public @ResponseBody String UploadFile(@RequestParam(value="file", required=true) MultipartFile file, RedirectAttributes redirectAttributes) {
        
    	JSONObject jsonObject = null;
    	try {
    		
    		String newFile = storageService.store(file);
        	
        	Map<String, Object> toParse = new HashMap<String, Object>();
    	    toParse.put("imageUrl", "/file/" +newFile);
    	    toParse.put("idImage", 123);
    		jsonObject = new JSONObject(toParse);
        	
        } catch (StorageException e) {
        	throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
        }

	    return jsonObject.toJSONString();
        //redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        //return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
