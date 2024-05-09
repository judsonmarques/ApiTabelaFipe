package com.example.apitabelafip.controller;

import com.example.apitabelafip.model.Marca;
import com.example.apitabelafip.service.FipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fipe")
public class MotoController {

    private final FipeService fipeService;

    public MotoController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GetMapping("/moto/marcas")
    public List<Marca> getMarcasMoto() {
        return fipeService.getMarcas("moto");
    }
}
