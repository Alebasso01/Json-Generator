package com.spring.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/json")
public class JsonController {

    @GetMapping
    public String getJsonData() {
        try {
            // Carica il file JSON dalla cartella resources
            ClassPathResource resource = new ClassPathResource("data.json");
            // Usa InputStream per leggere il contenuto del file
            InputStream inputStream = resource.getInputStream();
            // Converte l'InputStream in una stringa
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\": \"Errore durante la lettura del file JSON\"}";
        }
    }
}
