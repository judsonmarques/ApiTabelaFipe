package com.example.apitabelafip.model;

import com.example.apitabelafip.service.ConsumoApi;
import com.example.apitabelafip.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {


    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";


    public void exibeMenu() {

        int opcao;
        do {
            System.out.println("""
                    \n
                    *** OPÇÕES ***
                    1. Carro
                    2. Moto
                    3. Caminhão
                                        
                    Digite o número da opção desejada:
                    """);

            while (!leitura.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número entre 1 e 3.");
                leitura.next(); // Consumir entrada inválida
            }
            opcao = leitura.nextInt();
            String endereco = "";


            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu Carro.");
                    endereco = URL_BASE + "carros/marcas";
                    break;
                case 2:
                    System.out.println("Você escolheu Moto.");
                    endereco = URL_BASE + "motos/marcas";
                    break;
                case 3:
                    System.out.println("Você escolheu Caminhão.");
                    endereco = URL_BASE + "caminhoes/marcas";
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número entre 1 e 3.");
            }
            var json = consumo.obterDados(endereco);
            System.out.println(json);
            var marcas = converte.obterCodigo(json, Marca.class);
            marcas.stream()
                    .sorted(Comparator.comparing(Marca::codigo))
                    .forEach(System.out::println);

            System.out.println("Informe o código da marca para consulta: ");
            var codigoMarca = leitura.nextLine();

            endereco = endereco + "/" + codigoMarca + "/modelos";
            json = consumo.obterDados(endereco);
            var modeloLista = converte.obterDados(json, Modelos.class);

            System.out.println("\n Modelos dessa marca: ");
            modeloLista.modelos().stream()
                    .sorted(Comparator.comparing(Marca::codigo))
                    .forEach(System.out::println);



        } while (opcao < 1 || opcao > 3);
        String continuar;
        do {
            System.out.print("Deseja fazer outra consulta (S/N)? ");
            continuar = leitura.next().toUpperCase();
        } while (!continuar.equals("S") && !continuar.equals("N"));

        while (continuar.equalsIgnoreCase("S"));


        leitura.close();
        System.out.println("Consulta encerrada");
    }

    }

