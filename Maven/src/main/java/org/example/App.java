package com.api;

import model.Cliente;
import com.api.model.Endereco;
import com.api.service.CPFService;
import com.api.service.ViaCEPService;
import com.api.service.DatabaseConnection;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CPFService cpfService = new CPFService();
        ViaCEPService viaCEPService = new ViaCEPService();
        DatabaseConnection dbConnection = new DatabaseConnection();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // consumir a nova linha

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("CPF: ");
                String cpf = scanner.nextLine();

                try {
                    if (!cpfService.verificarCPF(cpf)) {
                        System.out.println("CPF inválido!");
                        continue;
                    }

                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();

                    Endereco endereco = viaCEPService.buscarEnderecoPorCEP(cep);

                    Cliente cliente = new Cliente(nome, cpf, endereco);
                    dbConnection.salvarCliente(cliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
