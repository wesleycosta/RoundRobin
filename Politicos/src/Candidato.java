
import java.util.ArrayList;
import java.util.Scanner;

public class Candidato extends Pessoa {

    private int cargo;
    private Partido partido;

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public Partido getPardito() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void leia() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Cadastro de Canditado");
        System.out.println("");

        System.out.print("Entre o nome do Canditado.......: ");
        setNome(in.nextLine());

        System.out.print("Entre com o Apelido.............: ");
        setApelido(in.nextLine());

        System.out.print("Entre com o CPF.................: ");
        setCPF(in.nextLine());

        System.out.print("Entre com a Data de Nascimento..: ");
        setDataNascimento(in.nextLine());

        System.out.print("Entre com a FormaÃ§Ã£o Academica..: ");
        setFormacaoAcademica(in.nextLine());

        System.out.print("Entre com a ProfissÃ£o...........: ");
        setProfissao(in.nextLine());

        System.out.print("Entre com o Estado..............: ");
        setEstado(in.nextLine());

        setCargo(Cargo.leiaMenu());
        
        Partido partido = Partido.selecionarPardito();
        setPartido(partido);
    }

    public void imprimir() {
        System.out.println("\n");
        System.out.println("DADOS DO CANDIDATO");
        System.out.println("Nome.................: " + getNome());
        System.out.println("Apelido..............: " + getApelido());
        System.out.println("CPF..................: " + getCPF());
        System.out.println("Data de Nascimento...: " + getDataNascimento());
        System.out.println("FormaÃ§Ã£o Academica...: " + getFormacaoAcademica());
        System.out.println("ProfissÃ£o............: " + getProfissao());
        System.out.println("Estado...............: " + getEstado());
        System.out.println("Cargo...............: " + Cargo.getNome(getCargo()));

        getPardito().imprimir();
    }

    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoCandidato);
        arq.escrever(getNome() + ";" + getApelido() + ";" + getCPF() + ";" + getDataNascimento() + ";"
                + getFormacaoAcademica() + ";" + getProfissao() + ";" + getEstado() + ";"
                + getCidade() + ";" + getCargo() + ";" + partido.getNumero());
    }

    public void mantemCadastro() {
        leia();
        salvarEmArquivo();
    }

    private static Candidato converterLinhaParaCandidato(String linha) {
        Candidato candidato = new Candidato();
        String[] elementos = linha.split(";");
        candidato.nome = elementos[0];
        candidato.apelido = elementos[1];
        candidato.CPF = elementos[2];
        candidato.dataNascimento = elementos[3];
        candidato.formacaoAcademica = elementos[4];
        candidato.profissao = elementos[5];
        candidato.estado = elementos[6];
        candidato.cidade = elementos[7];
        candidato.cargo = Integer.parseInt(elementos[8]);
        candidato.partido = Partido.getPartidoPeloNumero(elementos[9]);

        return candidato;
    }

    public static ArrayList<Candidato> carregarCandidatos() {
        ArrayList<Candidato> listaCandidatos = new ArrayList<>();
        Arquivo arq = new Arquivo();
        ArrayList<String> linhasDoArquivo = arq.ler(ConfiguracaoArquivo.caminhoCandidato);

        for (int i = 0; i < linhasDoArquivo.size(); i++) {
            listaCandidatos.add(converterLinhaParaCandidato(linhasDoArquivo.get(i)));
        }

        return listaCandidatos;
    }

    public static void listarCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        candidatos = Candidato.carregarCandidatos();

        for (int i = 0; i < candidatos.size(); i++) {
            candidatos.get(i).imprimir();
        }
    }
}
