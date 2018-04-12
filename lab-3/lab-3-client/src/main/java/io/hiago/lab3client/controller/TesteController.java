package io.hiago.lab3client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @Value("${teste}")
    String testeValue;

    @GetMapping("/teste")
    public String getTesteValue() {
        return "Teste: " + this.testeValue;
    }
}
