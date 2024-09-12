package org.example;

import java.util.regex.Pattern;
import org.example.models.Cliente;
import org.example.models.Endereco;
import org.example.service.CPFService;
import org.example.service.DatabaseConnection;
import org.example.service.ViaCEPService;

import java.util.Scanner;

public class Menu {

    private static ViaCEPService viaCEPService = new ViaCEPService();
    private static CPFService cpfService = new CPFService();
    private static DatabaseConnection dbConnection = new DatabaseConnection();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 2);

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner) {
        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF (somente números): ");
            String cpf = scanner.nextLine();

            if (!cpfService.verificarCPF(cpf)) {
                System.out.println("CPF inválido!");
                return;
            }

            System.out.print("Digite o CEP: ");
            String cep = scanner.nextLine();

            Endereco endereco = viaCEPService.buscarEnderecoPorCEP(cep);
            Cliente cliente = new Cliente(nome, cpf, endereco);

            dbConnection.salvarCliente(cliente);

            System.out.println("Cliente cadastrado com sucesso!");
            System.out.println(cliente);

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
}