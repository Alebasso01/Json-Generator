package com.spring.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/json")
public class JsonController {

    @GetMapping
    public String getJsonData() {
        try {
            // Carica il file JSON dalla cartella resources
            Path jsonFilePath = Paths.get(new ClassPathResource("data.json").getURI());
            // Legge il contenuto del file
            return new String(Files.readAllBytes(jsonFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\": \"Errore durante la lettura del file JSON\"}";
        }
    }
}
