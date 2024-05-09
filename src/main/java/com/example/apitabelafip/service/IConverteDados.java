package com.example.apitabelafip.service;

import java.util.List;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterCodigo(String json, Class<T> classe);

}
