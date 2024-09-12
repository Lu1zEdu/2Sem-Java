package org.example.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/clientes")
public class ClienteResource {

    private ViaCEPService viaCEPService = new ViaCEPService();
    private CPFService cpfService = new CPFService();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente criarCliente(Cliente cliente) throws Exception {
        if (!cpfService.verificarCPF(cliente.getCpf())) {
            throw new BadRequestException("CPF inválido");
        }
        
        Endereco endereco = viaCEPService.buscarEnderecoPorCEP(cliente.getEndereco().getCep());
        cliente.setEndereco(endereco);

        // Salvar no banco de dados
        DatabaseConnection db = new DatabaseConnection();
        db.salvarCliente(cliente);

        return cliente;
    }
}
