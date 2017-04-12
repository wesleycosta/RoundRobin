
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

    public void salvarEmArquivo() 
    {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoCandidato);
        arq.escrever(getNome() + ";" + getApelido() + ";" + getCPF() + ";" + getDataNascimento() + ";" + getFormacaoAcademica() + ";" + getProfissao() + ";" + getEstado() + ";" + getCargo());
    }
}
