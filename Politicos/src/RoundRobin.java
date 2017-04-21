
import java.util.ArrayList;

public class RoundRobin {

    ArrayList<Candidato> candidatos = new ArrayList<>();

    RoundRobin(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    private void trocarPosicoes() {
        int ultimo = candidatos.size() - 1;

        for (int i = 1; i < candidatos.size(); i++) {
            Candidato x = candidatos.get(i);
            candidatos.set(i, candidatos.get(i + (--ultimo)));
            candidatos.set(i + ultimo, x);
        }
    }

    private String formataCandidato(Candidato candidato) {
        return candidato.getNome() + " (" + candidato.getPardito().getSigla() + ") ";
    }

    private String novoEspaco(int numero) {
        return new String(new char[numero]).replace('\0', ' ');
    }

    // RETORNAR O TAMANHO DO MAIOR NOME DA LISTA DE CANDIDATOS
    private int getMaiorNome() {
        int maior = 0;

        for (int i = 0; i < candidatos.size(); i++) {
            if (maior < candidatos.get(i).getNome().length()) {
                maior = candidatos.get(i).getNome().length();
            }
        }

        return maior;
    }

    private void imprimir() {
        int ultimo = candidatos.size() - 1;
        int meio = ((candidatos.size() / 2));
        int maiorNome = getMaiorNome();

        for (int i = 0; i < meio; i++) {
            String candidato1 = formataCandidato(candidatos.get(i));
            String candidato2 = formataCandidato(candidatos.get(ultimo--));
            candidato1 = candidato1 + novoEspaco(25 - candidato1.length());
            candidato2 = novoEspaco((25 - maiorNome) / 2) + candidato2;

            System.out.println(candidato1 + " X " + candidato2);
            System.out.println();
        }

        System.out.println("\n");
    }

    public void gerarDebates() {
        for (int i = 0; i < candidatos.size() - 1; i++) {
            imprimir();
            trocarPosicoes();
        }

        if (candidatos.size() == 3) {
            System.out.println(formataCandidato(candidatos.get(candidatos.size() - 1)) + "  X  " + formataCandidato(candidatos.get(candidatos.size() - 2)));
        }
    }
}
