
import java.util.ArrayList;
import java.util.Scanner;

public class Candidato extends Pessoa {

    private int cargo;
    private double salario;
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

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void leia() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Cadastro de Candidato");
        System.out.println("");

        System.out.print("Entre o nome do Candidato.......: ");
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

        System.out.print("Entre com o Salario.............: ");
        setSalario(in.nextDouble());

        leiaCargo();
        leiaPardito();
    }

    private void leiaCargo() {
        int cargo = Cargo.leiaCandidato();
        setCargo(cargo);
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
        System.out.println("Salario.............: " + getSalario());
        System.out.println("Cargo...............: " + Cargo.getNome(getCargo()));

        System.out.println("************ PARTIDO ************");
        getPardito().imprimir();
    }

    @Override
    public String toString() {
        return getNome() + ";" //[0]
                + getApelido() + ";" //[1]
                + getCPF() + ";" //[2]
                + getDataNascimento() + ";" //[3]
                + getFormacaoAcademica() + ";" //[4]
                + getProfissao() + ";" //[5]
                + getEstado() + ";" //[6]
                + getCidade() + ";" //[7]
                + getSalario() + ";" //[8]
                + getCargo() + ";" //[9]
                + partido.getNumero();//[10]

    }

    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoCandidato);
        arq.escrever(toString());
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

        candidato.setNome(elementos[0]);
        candidato.setApelido(elementos[1]);
        candidato.setCPF(elementos[2]);
        candidato.setDataNascimento(elementos[3]);
        candidato.setFormacaoAcademica(elementos[4]);
        candidato.setProfissao(elementos[5]);
        candidato.setEstado(elementos[6]);
        candidato.setCidade(elementos[7]);
        candidato.setSalario(Double.parseDouble(elementos[8]));
        candidato.setCargo(Integer.parseInt(elementos[9]));
        candidato.setPartido(Partido.getPartidoPeloNumero(elementos[10]));

        return candidato;
    }

    public static ArrayList<Candidato> carregarCandidatos() {
        ArrayList<Candidato> listaCandidatos = new ArrayList<>();
        Arquivo arq = new Arquivo();
        ArrayList<String> linhasDoArquivo = arq.ler(ConfiguracaoArquivo.caminhoCandidato);

        for (int i = 0; i < linhasDoArquivo.size(); i++) {
            if (!linhasDoArquivo.get(i).isEmpty()) {
                listaCandidatos.add(converterLinhaParaCandidato(linhasDoArquivo.get(i)));
            }
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

    private static boolean existeCandidato(String cpf) {
        for (Candidato candidato : carregarCandidatos()) {
            if (cpf.equals(candidato.getCPF())) {
                return true;
            }
        }

        return false;
    }
}
