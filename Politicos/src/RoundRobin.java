
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

    private void imprimir() {
        int ultimo = candidatos.size() - 1;
        int meio = ((candidatos.size() / 2));

        for (int i = 0; i < meio; i++) {
            System.out.println(formataCandidato(candidatos.get(i)) + "  VS  " + formataCandidato(candidatos.get(ultimo--)));
        }
        System.out.println();
    }

    public void gerarDebates() {

        for (int i = 0; i < candidatos.size() - 1; i++) {
            imprimir();
            trocarPosicoes();
        }
        if (candidatos.size() == 3) {
            System.out.println(formataCandidato(candidatos.get(candidatos.size() - 1)) + "  VS  " + formataCandidato(candidatos.get(candidatos.size() - 2)));
        }
    }
}
