package br.com.fiap.cliente.models;


public class Endereço extends Client{
    private int cep;
    private String Logradouro;
    private String Complemento;
    private int Unidade;
    private String Bairro;
    private Enum EnumUf;
    private String Estado;
    private String Regiao;
    private int DDD;

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public int getUnidade() {
        return Unidade;
    }

    public void setUnidade(int unidade) {
        Unidade = unidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public Enum getEnumUf() {
        return EnumUf;
    }

    public void setEnumUf(Enum enumUf) {
        EnumUf = enumUf;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String regiao) {
        Regiao = regiao;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }
}
