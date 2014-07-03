package Funcoes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import org.json.simple.JSONValue;

/**
 *
 * @author eric
 */
public class GeraJSON {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
    
        LinkedList professores = new LinkedList();

        FileWriter writeFile = null;

        for (int i = 0; i < 5; i++) {
            Map dados = new LinkedHashMap();
            dados.put("nome", stringAleatoria());
            dados.put("id", idProfessorAleatorio());
            LinkedList listaAtividades = new LinkedList();
            
            for (int j = 0; j < 3; j++) {
                LinkedHashMap objetoAtividade = new LinkedHashMap();
                LinkedList parametrosAtividade = new LinkedList();
                objetoAtividade.put("codAtividade", codAtividadeAleatorio());
                parametrosAtividade.add(parametroAleatorio());
                parametrosAtividade.add(parametroAleatorio());
                objetoAtividade.put("param", parametrosAtividade);
                listaAtividades.add(objetoAtividade);
            }
            dados.put("atividades", listaAtividades);
            professores.add(dados);
        }
        
        Map jsonFinal = new LinkedHashMap();
        jsonFinal.put("JSON", professores);
        
        String jsonTexto = JSONValue.toJSONString(jsonFinal);
        
        try {
            writeFile = new FileWriter("json.json");
            writeFile.write(jsonTexto);
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonTexto);
    }

    private static String stringAleatoria() {
        Random rand = new Random();
        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }

    private static long idProfessorAleatorio() {
        Random rand = new Random();
        long num = rand.nextLong();
        return num;
    }

    private static String codAtividadeAleatorio() {
        Random rand = new Random();
        char[] letras = "IVX".toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }

    private static int numeroAtividadesAleatorio() {
        Random rand = new Random();
        int num = rand.nextInt(10) + 1;
        return num;
    }
    
    private static int parametroAleatorio() {
        Random rand = new Random();
        int num = rand.nextInt(50) + 1;
        return num;
    }
}
