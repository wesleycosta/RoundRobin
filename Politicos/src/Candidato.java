
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

        System.out.print("Entre o nome do Canditado.......: ");
        setNome(in.nextLine());

        System.out.print("Entre com o Apelido.............: ");
        setApelido(in.nextLine());

        System.out.print("Entre com o CPF.................: ");
        setCPF(in.nextInt());
        
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
        System.out.println("DADOS DO Canditado " + getNome());
        System.out.print("Nome.................: " + getNome());
        System.out.print("Apelido..............: " + getApelido());
        System.out.print("CPF..................: " + getCPF());
        System.out.print("Data de Nascimento...: " + getDataNascimento());
        System.out.print("Formação Academica...: " + getFormacaoAcademica());
        System.out.print("Profissão............: " + getProfissao());
        System.out.print("Estado...............: " + getEstado());
        System.out.print("Cargo...............: " + getCargo());
    }
    
    public void salvarEmArquivo() {
        Arquivo arq = new Arquivo(ConfiguracaoArquivo.caminhoPartido);
        arq.escrever(getNome() + ";" + getApelido()+ ";"  + getCPF()+ ";" +getDataNascimento()+ ";" +getFormacaoAcademica()+ ";" +getProfissao()+ ";" +getEstado()+ ";" +getCargo());
    }
}
