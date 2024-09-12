package org.example.service;
import org.example.models.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String DB_USER = "seu_usuario";
    private static final String DB_PASSWORD = "sua_senha";

    public Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void salvarCliente(Cliente cliente) throws Exception {
        String sql = "INSERT INTO CLIENTE (NOME, CPF, CEP, LOGRADOURO, BAIRRO, CIDADE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco().getCep());
            stmt.setString(4, cliente.getEndereco().getLogradouro());
            stmt.setString(5, cliente.getEndereco().getBairro());
            stmt.setString(6, cliente.getEndereco().getCidade());
            stmt.setString(7, cliente.getEndereco().getEstado());
            
            stmt.executeUpdate();
        }
    }
}