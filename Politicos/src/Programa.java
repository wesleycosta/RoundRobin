
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    private static void limparTela() {
        System.out.println("\n\n");
    }

    private static void pause() {
        System.out.print("\nTecle <ENTER> para continuar...");
        new Scanner(System.in).nextLine();
    }

    private static void partido() {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("**********************************");
            System.out.println("*** [1] - CADASTRAR  PARTIDO   ***");
            System.out.println("*** [2] - LISTAR     PARTIDOS  ***");
            System.out.println("*** [3] - VOLTAR               ***");
            System.out.println("**********************************");
            System.out.print("OPÇÃO: ");

            opcao = Integer.parseInt(in.nextLine());

            if (opcao == 1) {
                Partido pardito = new Partido();
                pardito.mantemCadastro();
                pause();
            } else if (opcao == 2) {
                Partido.listaPartidos();
                pause();
            }
        } while (opcao != 3);
    }

    private static void candidato() {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

        do {
            limparTela();
            System.out.println("**********************************");
            System.out.println("*** [1] - CADASTRAR CANDIDATO  ***");
            System.out.println("*** [2] - LISTAR    CANDIDATOS ***");
            System.out.println("*** [3] - VOLTAR               ***");
            System.out.println("**********************************");
            System.out.print("OPCAO: ");
            opcao = Integer.parseInt(in.nextLine());

            if (opcao == 1) {
                Candidato candidato = new Candidato();
                candidato.mantemCadastro();
                pause();
            } else if (opcao == 2) {
                Candidato.listarCandidatos();
                pause();
            }
        } while (opcao != 3);
    }

    private static void roundRobin() {
        int cargo = Cargo.leiaCandidato();
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos = Candidato.filtrarCandidato(cargo);

        if (candidatos.size() >= 2) {
            System.out.println("********************************************************************");
            System.out.println("***                        LISTA DE DEBATES                      ***");
            System.out.println("********************************************************************");
            RoundRobin rRobin = new RoundRobin(candidatos);
            rRobin.gerarDebates();
        } else {
            System.out.println("A quantidade de candidatos é menor que 2 ");
            System.out.println("Não é possivel gerar os debates !!!");
        }

        pause();
    }

    public static void main(String[] args) {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("**********************************");
            System.out.println("*** [1] - PARTIDO              ***");
            System.out.println("*** [2] - CANDIDATO            ***");
            System.out.println("*** [3] - ROUND ROBIN          ***");
            System.out.println("*** [4] - SAIR                 ***");
            System.out.println("**********************************");

            System.out.print("OPÇÃO: ");

            opcao = Integer.parseInt(in.nextLine());

            if (opcao == 1) {
                partido();
            } else if (opcao == 2) {
                candidato();
            } else if (opcao == 3) {
                roundRobin();
            }

            limparTela();
        } while (opcao != 4);
    }
}
