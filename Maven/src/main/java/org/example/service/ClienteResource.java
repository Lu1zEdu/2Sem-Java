package com.api.resource;

import com.api.model.Cliente;
import com.api.model.Endereco;
import com.api.service.CPFService;
import com.api.service.ViaCEPService;
import com.api.service.DatabaseConnection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clientes")
public class ClienteResource {

    private ViaCEPService viaCEPService = new ViaCEPService();
    private CPFService cpfService = new CPFService();
    private DatabaseConnection dbConnection = new DatabaseConnection();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarCliente(Cliente cliente) {
        try {
            if (!cpfService.verificarCPF(cliente.getCpf())) {
                return Response.status(Response.Status.BAD_REQUEST).entity("CPF inválido").build();
            }

            Endereco endereco = viaCEPService.buscarEnderecoPorCEP(cliente.getEndereco().getCep());
            cliente.setEndereco(endereco);

            // Salvar no banco de dados
            dbConnection.salvarCliente(cliente);

            return Response.status(Response.Status.CREATED).entity(cliente).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
