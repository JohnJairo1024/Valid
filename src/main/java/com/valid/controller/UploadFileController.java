package com.valid.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.valid.model.Documento;
import com.valid.repository.FileRepository;

@Controller
public class UploadFileController {
	
	@Autowired
	FileRepository fileRepository;
	
    @GetMapping("/")
    public String index() {
        return "uploadform";
    }
    
    @PostMapping("/")
    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model model) {
    	List<String> fileNames = new ArrayList<String>();
    	
		try {
			List<Documento> storedFile = new ArrayList<Documento>();
			
			for(MultipartFile file: files) {
				Documento documento = fileRepository.findByNombre(file.getOriginalFilename());
				if(documento != null) {
					// update new contents
					documento.setPic(file.getBytes());
				}else {
					documento = new Documento(file.getOriginalFilename(), file.getContentType(), file.getBytes());
				}
				
				fileNames.add(file.getOriginalFilename());				
				storedFile.add(documento);
			}
			
			// Save all Files to database
	    	fileRepository.saveAll(storedFile);
	    	
			model.addAttribute("message", "Files uploaded successfully!");
			model.addAttribute("files", fileNames);
		} catch (Exception e) {
			model.addAttribute("message", "Fail!");
			model.addAttribute("files", fileNames);
		}
		
        return "uploadform";
    }
}
