
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

        System.out.print("Entre com a Formacao Academica..: ");
        setFormacaoAcademica(in.nextLine());

        System.out.print("Entre com a Profissao...........: ");
        setProfissao(in.nextLine());

        System.out.print("Entre com o Estado..............: ");
        setEstado(in.nextLine());

        System.out.print("Entre com a Cidade..............: ");
        setCidade(in.nextLine());

        leiaCargo();
        leiaPardito();
    }

    private void leiaCargo() {
        setCargo(Cargo.leiaMenu());
    }

    private void leiaPardito() {
        Partido partido = Partido.selecionarPardito();
        setPartido(partido);
    }

    public void imprimir() {
        System.out.println("Nome................: " + getNome());
        System.out.println("Apelido.............: " + getApelido());
        System.out.println("CPF.................: " + getCPF());
        System.out.println("Data de Nascimento..: " + getDataNascimento());
        System.out.println("Formacao Academica..: " + getFormacaoAcademica());
        System.out.println("Profissao...........: " + getProfissao());
        System.out.println("Estado..............: " + getEstado());
        System.out.println("Cidade..............: " + getCidade());
        System.out.println("Cargo...............: " + Cargo.getNome(getCargo()));

        System.out.println("************ PARTIDO ************");
        getPardito().imprimir();
    }

    private String paraCSV() {
        return getNome() + ";" //[0]
                + getApelido() + ";" //[1]
                + getCPF() + ";" //[2]
                + getDataNascimento() + ";" //[3]
                + getFormacaoAcademica() + ";" //[4]
                + getProfissao() + ";" //[5]
                + getEstado() + ";" //[6]
                + getCidade() + ";" //[7]
                + getCargo() + ";" //[8]
                + partido.getNumero();//[9]

    }

    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoCandidato);
        arq.escrever(paraCSV());
    }

    public void mantemCadastro() {
        leia();

        if (existeCandidato(getCPF())) {
            System.out.println("Ja existe um candidato cadastrado com esse CPF " + getCPF() + ".");
        } else {
            salvarEmArquivo();
        }
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

        System.out.print("\n\n");
        System.out.println("**********************************");
        System.out.println("******  LISTA DE CANDIDATOS ******");
        System.out.println("**********************************");

        System.out.print("\n");

        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println("**********************************");
            System.out.printf("********** CANDIDATO %2d **********\n", i + 1);
            System.out.println("**********************************");

            candidatos.get(i).imprimir();
            System.out.print("\n\n");
        }
    }

    public static ArrayList<Candidato> filtrarCandidato(int cargo) {
        ArrayList<Candidato> listaCandidato = new ArrayList<>();

        for (Candidato candidato : carregarCandidatos()) {
            if (candidato.getCargo() == cargo) {
                listaCandidato.add(candidato);
            }
        }

        return listaCandidato;
    }

    private boolean existeCandidato(String cpf) {
        for (Candidato candidato : carregarCandidatos()) {
            if (cpf.equals(candidato.getCPF())) {
                return true;
            }
        }

        return false;
    }
}
