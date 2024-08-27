package Principal;

import Models.ClassifcacaoEnum;
import Models.Filme;
import Models.Serie;

public class Principal {
    public static void main(String[] args) {
        Serie novaSerie = new Serie();
        novaSerie.setNome("Naruto");
        novaSerie.setAnoLancamento(2004);
        novaSerie.setDuracaoMinutos(500000);
        novaSerie.setAtivo(false);
        novaSerie.setTemporadas(18);
        novaSerie.setEpPorTemp(20);
        novaSerie.setMinPorEp(24);
        novaSerie.setClassifcacaoEnum(ClassifcacaoEnum.C10);
        novaSerie.exibirFichaTecnica();

        System.out.println("\n --------------------------- \n");

        Filme novoFilme = new Filme();
        novoFilme.setNome("Sem memória");

    }
}
