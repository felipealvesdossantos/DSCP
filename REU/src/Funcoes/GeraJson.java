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
public class GeraJson {

    static int cont = 1; 
    static final int QTD_VEZES_ATIVIDADE = 1;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        LinkedList professores = new LinkedList();

        FileWriter writeFile = null;

        System.out.println("Gerando JSON...");
        
        for (int i = 0; i <= 10000; i++) {
            Map dados = new LinkedHashMap();
            dados.put("nome", stringAleatoria());
            dados.put("id", cont);
            cont++;
            LinkedList listaAtividades = new LinkedList();

            for (int j = 0; j < 100; j++) {
                LinkedHashMap objetoAtividade = new LinkedHashMap();
                LinkedList parametrosAtividade = new LinkedList();
                //objetoAtividade.put("codAtividade", "II - 1 - 1 - 1.2");
                objetoAtividade.put("codAtividade", codAtividadeAleatorio());
                if (objetoAtividade.get("codAtividade").equals("I -1 -1")
                        || objetoAtividade.get("codAtividade").equals("I -1 -2")
                        || objetoAtividade.get("codAtividade").equals("I - 2 - 1")
                        || objetoAtividade.get("codAtividade").equals("I - 2 - 2")) {
                    parametrosAtividade.add(new Integer(parametroAleatorio()));
                    parametrosAtividade.add(new Integer(parametroAleatorio()));
                } else {
                    parametrosAtividade.add(new Integer(QTD_VEZES_ATIVIDADE));
                }
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
        int i = rand.nextInt(ArraysBanco.listaAtividades.size());

        return ArraysBanco.listaAtividades.get(i).getCodigo();
    }

    private static int numeroAtividadesAleatorio() {
        Random rand = new Random();
        int num = rand.nextInt(50) + 1;
        return num;
    }

    private static int parametroAleatorio() {
        Random rand = new Random();
        int num = rand.nextInt(50) + 1;
        return num;
    }
}
