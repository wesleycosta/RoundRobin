
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Arquivo {

    private String nomeArquivo;

    Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    Arquivo() {

    }

    public void escrever(String texto) {
        try {
            BufferedWriter escrever = new BufferedWriter(new FileWriter(this.nomeArquivo, true));
            escrever.write(texto);
            escrever.newLine();
            escrever.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public ArrayList<String> ler(String caminhoDoArquivo) {

        ArrayList<String> lista = new ArrayList<String>();
        if (new File(caminhoDoArquivo).exists()) {
            try {
                BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo));

                String linha;
                while ((linha = leitor.readLine()) != null) {
                    lista.add(linha);
                }
            } catch (Exception ex) {
                System.out.printf(ex.toString());
            }
        }

        return lista;
    }

    public static String getDiretorioAtual() {
        try {
            return new File(".").getCanonicalPath();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return ".";
    }
}
