
public class RoundRobin {

    java.util.ArrayList<Candidato> candidatos = new java.util.ArrayList<>();

    RoundRobin(java.util.ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    private void trocarPosicoes() {
        int fim = candidatos.size() - 1;
        for (int i = 1; i < candidatos.size(); i++) {
            Candidato x = candidatos.get(i);
            candidatos.set(i, candidatos.get(i + (--fim)));
            candidatos.set(i + fim, x);
        }
    }

    private void imprimir() {
        int j = candidatos.size() - 1;
        int meio = ((candidatos.size() / 2));

        for (int i = 0; i < meio; i++) {
            System.out.println(candidatos.get(i).getNome() + " VS " + candidatos.get(j--).getNome());
        }
        System.out.println();
    }

    public void gerarDebates() {

        for (int i = 0; i < candidatos.size() - 1; i++) {
            imprimir();
            trocarPosicoes();
        }
        if (candidatos.size() == 3) {
            System.out.println(candidatos.get(candidatos.size() - 1).getNome()
                    + " VS "
                    + candidatos.get(candidatos.size() - 2).getNome());
        }
    }
}
