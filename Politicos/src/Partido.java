
import java.util.ArrayList;
import java.util.Scanner;

public class Partido {

    private String nome;
    private String sigla;
    private String numero;

    Partido() {

    }

    Partido(String nome, String sigla, String numero) {
        setNome(nome);
        setSigla(sigla);
        setNumero(numero);
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void leia() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Cadastro de Partido");
        System.out.println("");

        System.out.print("Entre o nome do partido.......: ");
        setNome(in.nextLine());

        System.out.print("Entre com a sigla do partido..: ");
        setSigla(in.nextLine());

        System.out.print("Entre o número do partido.....: ");
        setNumero(in.nextLine());
    }

    public void imprimir() {
        System.out.println("\n");
        System.out.println("DADOS DO PARTIDO");
        System.out.println("Nome....: " + getNome());
        System.out.println("Sigla...: " + getSigla());
        System.out.println("Número..: " + getNumero());
    }

    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoPartido);
        arq.escrever(getNome() + ";" + getSigla() + ";" + getNumero());
    }

    public void mantemCadastro() {
        leia();
        salvarEmArquivo();
    }

    private static Partido converteLinhaParaPartido(String linha) {
        Partido partido = new Partido();
        String[] elementos = linha.split(";");
        partido.nome = elementos[0];
        partido.sigla = elementos[1];
        partido.numero = elementos[2];

        return partido;
    }

    public static ArrayList<Partido> carregarPartidos() {
        ArrayList<Partido> listaDePartidos = new ArrayList<>();

        Arquivo arq = new Arquivo();
        ArrayList<String> linhasDoArquivo = arq.ler(ConfiguracaoArquivo.caminhoPartido);

        for (int i = 0; i < linhasDoArquivo.size(); i++) {
            listaDePartidos.add(converteLinhaParaPartido(linhasDoArquivo.get(i)));
        }

        return listaDePartidos;
    }

    private static void imprmirListaDePartidos(ArrayList<Partido> listaDePartidos) {
        for (int i = 0; i < listaDePartidos.size(); i++) {
            Partido partido = listaDePartidos.get(i);
            System.out.println("[" + (i + 1) + "] - " + partido.sigla + "(" + partido.nome + ") - " + partido.numero);
        }
    }

    public static Partido selecionarPardito() {
        Scanner in = new Scanner(System.in);
        ArrayList<Partido> listaDePartido = Partido.carregarPartidos();
        int opcao = 0;

        do {
            System.out.print("\n***SELECIONE UM PARTIDO***\n");
            imprmirListaDePartidos(listaDePartido);
            System.out.print("OPÇÃO: ");
            opcao = Integer.parseInt(in.nextLine());
        } while (opcao <= 0 || opcao > listaDePartido.size());

        return listaDePartido.get(opcao - 1);
    }

    public static Partido getPartidoPeloNumero(String numPartido) {
        ArrayList<Partido> listaDePartido = Partido.carregarPartidos();

        for (Partido partido : listaDePartido) {
            if(partido.numero.equals(numPartido))
                return partido;
        }

        return new Partido("", "", numPartido);
    }
}
