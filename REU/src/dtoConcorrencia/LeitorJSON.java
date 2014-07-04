package dtoConcorrencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author eric
 */
public class LeitorJSON {

    // Lista que armazena todos os professores contidos no arquivo JSON
    private ArrayList listaProfessoresJSON = new ArrayList<ProfessorJSON>();

    public LeitorJSON(File arquivoJSON) {
        // Objeto que armazena o nível mais externo do JSON
        JSONObject jsonTotal;

        // Objeto que armazena o objeto ProfessorJSON
        JSONObject professorObjeto;
        
        // Lista de professores
        JSONArray professores = new JSONArray();

        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();

        //Variaveis que irão armazenar os dados dos professores do JSON
        String nome = "";
        long idProfessor;
        
        // Lista que armazena o conjunto de objetos de atividade
        JSONArray atividades = new JSONArray();
        
        // Objeto que armazena o objeto DadosAtividadeJSON
        JSONObject atividadeObjeto;

        try {
            // jsonTotal recebe o arquivo JSON
            FileReader frArquivo = new FileReader(arquivoJSON);
            jsonTotal = (JSONObject) parser.parse(frArquivo);
            // professores recebe o par "JSON":[Array de professores]
            professores = ((JSONArray) jsonTotal.get("JSON"));
            Iterator<JSONObject> it = professores.iterator();
            // Para cada professor:
            while (it.hasNext()) {
                // professorObjeto recebe seu professor
                professorObjeto = (JSONObject) it.next();
                nome = (String) professorObjeto.get("nome");
                idProfessor = ((Number) professorObjeto.get("id")).longValue();
                // atividades recebe o par "atividades":[Array de atividades]
                atividades = ((JSONArray) professorObjeto.get("atividades"));
                Iterator<JSONObject> iterator = atividades.iterator();
                // var recebe os dados do professor atual
                ProfessorJSON var = new ProfessorJSON();
                var.setNomeProfessor(nome);
                var.setIdProfessor(idProfessor);
                // Para cada atividade:
                while (iterator.hasNext()) {
                    // atividadeObjeto recebe os parametros da atividade atual, em long
                    atividadeObjeto = (JSONObject) iterator.next();
                    JSONArray parametrosLong = new JSONArray();
                    parametrosLong = ((JSONArray) atividadeObjeto.get("param"));
                    
                    List<Integer> parametros = new ArrayList<Integer>();
                    // Converte para int os valores de "parametrosLong" e armazena-os em "parametros"
                    for (int cont = 0; cont < parametrosLong.size(); cont++) {
                        int valor = ((Number) parametrosLong.get(cont)).intValue();
                        parametros.add(valor);
                    }
                    
                    // Um novo objeto da atividade é criado, e recebe os dados da atividade atual
                    DadosAtividadeJSON ativ = new DadosAtividadeJSON();
                    ativ.setCodAtividade((String) atividadeObjeto.get("codAtividade"));
                    ativ.setParametros(parametros);
                    // A atividade atual é adicionada à lista de atividades do objeto ProfessorJSON atual
                    var.listaAtividades.add(ativ);
                }
                // O ProfessorJSON atual é adicionado na lista de professores
                listaProfessoresJSON.add(var);
            }
            frArquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getListaProfessoresJSON() {
        return listaProfessoresJSON;
    }
}
