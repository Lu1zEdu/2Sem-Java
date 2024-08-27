package Models;

import java.util.List;

public interface IRepository {
    void inserir(Titulo titulo);
    Filme consultarFilme(String nome);
    List<Filme> listarFilmes();
}
