
import java.util.Scanner;

public class Partido {

    private String nome;
    private String sigla;
    private String numero;

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
        System.out.println("");
        System.out.println("Cadastro Partido");
        System.out.println("");

        System.out.print("Entre o nome do partido.......: ");
        setNome(in.nextLine());

        System.out.print("Entre com a sigla do partido..: ");
        setSigla(in.nextLine());

        System.out.print("Entre o número do partido.....: ");
        setNumero(in.nextLine());
    }

    public void imprimir() {
        System.out.println("DADOS DO PARTIDO " + getNome());
        System.out.print("Nome....: " + getNome());
        System.out.print("Sigla...: " + getSigla());
        System.out.print("Número..: " + getNumero());
    }

    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoPartido);
        arq.escrever(getNome() + ";" + getSigla() + ";"  + getNumero());
    }
}
