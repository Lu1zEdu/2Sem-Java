package Lista;

public class RevisaoVetor {
    public static void main(String[] args) {
        String[] alunos = new String[5];
        alunos[0] = "Luiz";
        alunos[1] = "Eu";
        alunos[2] = "Ana";
        alunos[3] = "Murilo";
        alunos[4] = "Pamela";

        System.out.println("Lista de Alunos : \n ");

        for (int i = 0; i < 5; i++) {
            System.out.println( i+1 +". " + alunos[i]);
        }
    }
}
