package com.example.apitabelafip.service;

import com.example.apitabelafip.model.Marca;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FipeService {

    private final RestTemplate restTemplate;

    public FipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Marca> getMarcas(String tipoVeiculo) {
        String url = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas";
        ResponseEntity<Marca[]> response = restTemplate.getForEntity(url, Marca[].class);
        return Arrays.asList(response.getBody());
    }
}
