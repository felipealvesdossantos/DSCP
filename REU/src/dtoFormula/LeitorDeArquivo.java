package dtoFormula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author eric
 */
public class LeitorDeArquivo {

    private String conteudo = null;

    public LeitorDeArquivo(File arquivo) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader reader = new BufferedReader(fileReader);
        String str = "";

        while (reader.ready()) {
            str = reader.readLine();
            System.out.println("Leitor de Arquivo: Arquivo lido.");
        }
        fileReader.close();
        reader.close();

        conteudo = str;
    }

    public String getConteudo() {
        return conteudo;
    }

}
