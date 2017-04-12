
import java.util.ArrayList;
import java.util.Scanner;

public class Candidato extends Pessoa {

    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

        System.out.print("Entre com a Formação Academica..: ");
        setFormacaoAcademica(in.nextLine());

        System.out.print("Entre com a Profissão...........: ");
        setProfissao(in.nextLine());

        System.out.print("Entre com o Estado..............: ");
        setEstado(in.nextLine());

        System.out.print("Entre com o Cargo...............: ");
        setCargo(in.nextLine());
    }

    public void imprimir() {
        System.out.println("\n");
        System.out.println("DADOS DO Canditado " + getNome());
        System.out.println("Nome.................: " + getNome());
        System.out.println("Apelido..............: " + getApelido());
        System.out.println("CPF..................: " + getCPF());
        System.out.println("Data de Nascimento...: " + getDataNascimento());
        System.out.println("Formação Academica...: " + getFormacaoAcademica());
        System.out.println("Profissão............: " + getProfissao());
        System.out.println("Estado...............: " + getEstado());
        System.out.println("Cargo...............: " + getCargo());
    }

    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoCandidato);
        arq.escrever(getNome() + ";" + getApelido() + ";" + getCPF() + ";" + getDataNascimento() + ";" + getFormacaoAcademica()
                + ";" + getProfissao() + ";" + getEstado() + ";" + getCargo());
    }

    private Candidato converterLinhaParaCandidato(String linha) {
        Candidato candidato = new Candidato();
        String[] elementos = linha.split(";");
        candidato.nome = elementos[0];
        candidato.apelido = elementos[1];
        candidato.CPF = elementos[2];
        candidato.dataNascimento = elementos[3];
        candidato.formacaoAcademica = elementos[4];
        candidato.profissao = elementos[5];
        candidato.estado = elementos[6];
        candidato.cargo = elementos[7];

        return candidato;
    }

    public ArrayList<Candidato> carregarCandidatos() {
        ArrayList<Candidato> listaCandidatos = new ArrayList<>();
        Arquivo arq = new Arquivo();
        ArrayList<String> linhasDoArquivo = arq.ler(ConfiguracaoArquivo.caminhoCandidato);

        for (int i = 0; i < linhasDoArquivo.size(); i++) {
            listaCandidatos.add(converterLinhaParaCandidato(linhasDoArquivo.get(i)));
        }
        
        return listaCandidatos;
    }

}
