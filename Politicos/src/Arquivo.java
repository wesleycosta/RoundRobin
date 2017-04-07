
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Arquivo {

    private String nomeArquivo;
    private String quebraLinha = System.getProperty("line.separator");

    Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    Arquivo() {

    }

    public void escrever(String texto) {
        try {
            BufferedWriter escrever = new BufferedWriter(new FileWriter(this.nomeArquivo, true));
            escrever.write(texto.replace("\n", this.quebraLinha));
            escrever.newLine();
            escrever.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void ler(String caminhoDoArquivo) {

        if (new File(caminhoDoArquivo).exists()) {
            try {
                BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo));

                String linha;
                while ((linha = leitor.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (Exception ex) {
                System.out.printf(ex.toString());
            }
        }
    }

    public String buscarArquivo(final File diretorio, String nomeArquivo) {
        for (final File arquivo : diretorio.listFiles()) {
            if (arquivo.isDirectory()) {
                buscarArquivo(arquivo, nomeArquivo);
            } else if (arquivo.getName().equals(nomeArquivo)) {
                return arquivo.getPath();
            }
        }

        return null;
    }
}
