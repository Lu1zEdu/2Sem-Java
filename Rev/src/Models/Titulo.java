package Models;

public abstract class Titulo {
    //Atributos -> Caraterísticas
    private String nome;
    private int anoLancamento;
    private int duracaoMinutos;
    protected double somaAvaliacao;
    protected int totalAvaliacao;
    private ClassifcacaoEnum classifcacaoEnum;

    //Getters e Setters


    public double getSomaAvaliacao() {
        return somaAvaliacao;
    }

    public void setSomaAvaliacao(double somaAvaliacao) {
        this.somaAvaliacao = somaAvaliacao;
    }

    public int getTotalAvaliacao() {
        return totalAvaliacao;
    }

    public void setTotalAvaliacao(int totalAvaliacao) {
        this.totalAvaliacao = totalAvaliacao;
    }

    public ClassifcacaoEnum getClassifcacaoEnum() {
        return classifcacaoEnum;
    }

    public void setClassifcacaoEnum(ClassifcacaoEnum classifcacaoEnum) {
        this.classifcacaoEnum = classifcacaoEnum;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }


    //Métodos
    public void exibirFichaTecnica(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento: " + anoLancamento);
    }
    //Método abstrato
    public abstract void somarAvaliacoes(double nota);
}
