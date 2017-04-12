
import java.util.Scanner;

public class Candidato extends Pessoa
{
    private String cargo;
    
    public String getCargo() {
        return cargo;
    }
    
    // asdasdasd

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void leia() {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Cadastro de Canditado");
        System.out.println("");

        System.out.println("Entre o nome do Canditado.......: ");
        setNome(in.nextLine());

        System.out.println("Entre com o Apelido..: ");
        setApelido(in.nextLine());

        System.out.println("Entre com o CPF.....: ");
        setCPF(in.nextInt());
        
        System.out.println("Entre com a Data de Nascimento.....: ");
        setDataNascimento(in.nextLine());
        
        System.out.println("Entre com a Formação Academica.....: ");
        setFormacaoAcademica(in.nextLine());
        
        System.out.println("Entre com a Profissão.....: ");
        setProfissao(in.nextLine());
        
        System.out.println("Entre com o Estado.....: ");
        setEstado(in.nextLine());
    }

    public void imprimir() {
        System.out.println("DADOS DO Canditado " + getNome());
        System.out.println("Nome.................: " + getNome());
        System.out.println("Apelido..............: " + getApelido());
        System.out.println("CPF..................: " + getCPF());
        System.out.println("Data de Nascimento...: " + getDataNascimento());
        System.out.println("Formação Academica...: " + getFormacaoAcademica());
        System.out.println("Profissão............: " + getProfissao());
        System.out.println("Estado...............: " + getEstado());
    }
}
