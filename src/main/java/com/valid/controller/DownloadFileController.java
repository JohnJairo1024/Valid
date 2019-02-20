package com.valid.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.valid.model.FileInfo;
import com.valid.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.valid.model.Documento;

@Controller
public class DownloadFileController {

	@Autowired
    FileRepository fileRepository;
	
	/*
	 * Retrieve Files' Information
	 */
	@GetMapping("/files")
	public String getListFiles(Model model) {
		List<FileInfo> fileInfos = fileRepository.findAll().stream().map(
				documento ->	{
					String filename = documento.getNombre();
					String url = MvcUriComponentsBuilder.fromMethodName(DownloadFileController.class,
	                        "downloadFile", documento.getNombre().toString()).build().toString();
					return new FileInfo(filename, url); 
				} 
			)
			.collect(Collectors.toList());
	
		model.addAttribute("files", fileInfos);
		return "listfiles";
	}
 
    /*
     * Download Files
     */
	@GetMapping("/files/{filename}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) {
		Documento file = fileRepository.findByNombre(filename);
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getNombre() + "\"")
					.body(file.getPic());	
	}
}