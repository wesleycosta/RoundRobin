
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    private static void partido() {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("[1] - CADASTRAR PARTIDO");
            System.out.println("[2] - LISTAR    PARTIDOS");
            System.out.println("[3] - VOLTAR");
            System.out.println("OPÇÃO: ");

            opcao = Integer.parseInt(in.nextLine());

            if (opcao == 1) {
                Partido pardito = new Partido();
                pardito.mantemCadastro();
            } else if (opcao == 2) {
                Partido.listaPartidos();
            }
        } while (opcao <= 0 || opcao > 3);
    }
    
     private static void candidato()
    {
        int opcao = 0;
        
        Scanner in = new Scanner(System.in);
        
        do
        {
            System.out.println("[1] - CADASTRAR CANDITADO");
            System.out.println("[2] - LISTAR CANDITADO");
            System.out.println("[3] - VOLTAR");
            System.out.println("OPCAO: ");
            opcao = Integer.parseInt(in.nextLine());
            
            switch(opcao)
            {
                case 1: Candidato canditado = new Candidato();
                        canditado.mantemCadastro();
                    break;
                    
                case 2: Candidato.listarCandidatos();
                    break;
            }
            
        }while(opcao <= 0 || opcao >= 3);
        
    }

    public static void main(String[] args) {
        int opcao = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("[1] - PARTIDO");
            System.out.println("[2] - CANDIDATO");
            System.out.println("[3] - ROUND ROBIN");
            System.out.println("[4] - SAIR");

            System.out.println("OPÇÃO: ");

            opcao = Integer.parseInt(in.nextLine());
            
            if(opcao == 1)
                partido();
            else if(opcao == 2);
              candidato();
        } while (opcao < 0 || opcao > 3);
    }

    // ALFA
}
