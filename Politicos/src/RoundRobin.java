
import java.util.ArrayList;

public class RoundRobin {

    ArrayList<Candidato> candidatos = new ArrayList<>();

    RoundRobin(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void gerarDebates() {
        for (int i = 0; i < candidatos.size() - 1; i++) {
            imprimir();
            trocarPosicoes();
        }

        if (candidatos.size() == 3) {
            imprimirDebate(candidatos.get(candidatos.size() - 1), candidatos.get(candidatos.size() - 2));
        }
    }

    private void imprimir() {
        int ultimo = candidatos.size() - 1;
        int meio = (candidatos.size() / 2);

        for (int i = 0; i < meio; i++) {
            imprimirDebate(candidatos.get(i), candidatos.get(ultimo--));
        }

        System.out.println("\n");
    }

    private void trocarPosicoes() {
        int ultimo = candidatos.size() - 1;

        for (int i = 1; i < candidatos.size(); i++) {
            Candidato x = candidatos.get(i);
            candidatos.set(i, candidatos.get(i + (--ultimo)));
            candidatos.set(i + ultimo, x);
        }
    }

    private void imprimirDebate(Candidato candidato1, Candidato candidato2) {
        int maiorNome = getMaiorNome();

        String candidatoStr1 = formataCandidato(candidato1);
        String candidatoStr2 = formataCandidato(candidato2);

        candidatoStr1 = candidatoStr1 + novoEspaco(25 - candidatoStr1.length());
        candidatoStr2 = novoEspaco((25 - maiorNome) / 2) + candidatoStr2;

        System.out.println(candidatoStr1 + " X " + candidatoStr2);
        System.out.println();
    }

    private String formataCandidato(Candidato candidato) {
        return candidato.getNome() + " (" + candidato.getPardito().getSigla() + ") ";
    }

    private String novoEspaco(int numero) {
        return new String(new char[numero]).replace('\0', ' ');
    }

    private int getMaiorNome() {
        int maior = 0;

        for (int i = 0; i < candidatos.size(); i++) {
            if (maior < candidatos.get(i).getNome().length()) {
                maior = candidatos.get(i).getNome().length();
            }
        }

        return maior;
    }
}
