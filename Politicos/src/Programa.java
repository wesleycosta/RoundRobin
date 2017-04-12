
import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {
        Partido partido = new Partido();
        ArrayList<Partido> partidos = new ArrayList<>();

        partidos = partido.carregarPartidos();

        for (int i = 0; i < partidos.size(); i++) {
            partidos.get(i).imprimir();
        }

//        Candidato canditado = new Candidato();
//        canditado.leia();
//        canditado.salvarEmArquivo();
//        canditado.imprimir();
    }
}
