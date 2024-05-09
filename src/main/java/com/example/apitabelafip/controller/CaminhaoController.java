package com.example.apitabelafip.controller;

import com.example.apitabelafip.model.Marca;
import com.example.apitabelafip.service.FipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fipe")
public class CaminhaoController {

    private final FipeService fipeService;

    public CaminhaoController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/caminhao/marcas")
    public List<Marca> getMarcasCarro() {
        return fipeService.getMarcas("caminhao");
    }
}
