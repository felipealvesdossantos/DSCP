package dtoConcorrencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author eric
 */
public class LeitorJSON {

    private ArrayList listaAtividadesEVariaveis = new ArrayList<DadosJSON>();

    public LeitorJSON(File arquivoJSON) {
        JSONObject jsonTotal;

        JSONObject professorObjeto;

        JSONArray professores = new JSONArray();

        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();

        //Variaveis que irão armazenar os dados do JSON
        String nome = "";
        long idProfessor;

        JSONArray atividades = new JSONArray();
        JSONObject atividadeObjeto;

        try {
            jsonTotal = (JSONObject) parser.parse(new FileReader(arquivoJSON));
            professores = ((JSONArray) jsonTotal.get("JSON"));
            Iterator<JSONObject> it = professores.iterator();
            
            while (it.hasNext()) {
                professorObjeto = (JSONObject) it.next();
                nome = (String) professorObjeto.get("nome");
                idProfessor = ((Number) professorObjeto.get("id")).longValue();
                atividades = ((JSONArray) professorObjeto.get("atividades"));
                Iterator<JSONObject> iterator = atividades.iterator();
                DadosJSON var = new DadosJSON();
                var.setNomeProfessor(nome);
                var.setIdProfessor(idProfessor);
                while (iterator.hasNext()) {
                    atividadeObjeto = (JSONObject) iterator.next();
                    JSONArray parametros = new JSONArray();
                    parametros = ((JSONArray) atividadeObjeto.get("param"));                 
                    DadosAtividadeJSON ativ = new DadosAtividadeJSON();
                    ativ.setIdAtividade((String) atividadeObjeto.get("idAtividade"));
                    ativ.setParametros(parametros);
                    var.listaAtividades.add(ativ);
                }
                listaAtividadesEVariaveis.add(var);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getListaAtividadesEVariaveis() {
        return listaAtividadesEVariaveis;
    }
}
