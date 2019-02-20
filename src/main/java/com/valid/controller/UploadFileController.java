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
import com.valid.repository.DocumentoRepository;

@Controller
public class UploadFileController {

    @Autowired
    DocumentoRepository documentoRepository;

    @GetMapping("/")
    public String index() {
        return "formulariodecarga";
    }

    @PostMapping("/")
    public String subirArhivo(@RequestParam("files") MultipartFile[] files, Model model) {
        List<String> archivoNombre = new ArrayList<>();

        try {
            List<Documento> archivoAlmacenado = new ArrayList<>();

            for (MultipartFile file : files) {
                Documento documento = documentoRepository.findByNombre(file.getOriginalFilename());
                if (documento != null) {
                    documento.setData(file.getBytes());
                } else {
                    documento = new Documento(file.getOriginalFilename(), file.getContentType(), file.getBytes());
                }

                archivoNombre.add(file.getOriginalFilename());
                archivoAlmacenado.add(documento);
            }

            // Guarda la data
            documentoRepository.saveAll(archivoAlmacenado);

            model.addAttribute("message", "Archivos subidos exitosamente!");
            model.addAttribute("files", archivoNombre);
        } catch (Exception e) {
            model.addAttribute("message", "Ningún archivo seleccionado!");
            model.addAttribute("files", archivoNombre);
        }

        return "formulariodecarga";
    }
}
