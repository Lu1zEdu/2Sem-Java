package java.org.example.service;

public class CPFService {

    public boolean verificarCPF(String cpf) {
        // Validação fictícia de CPF, você pode integrar a uma API real aqui
        return cpf != null && cpf.matches("\\d{11}");
    }
}