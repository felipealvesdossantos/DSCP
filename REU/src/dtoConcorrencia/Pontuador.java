//<<<<<<< HEAD
package dtoConcorrencia;

import Funcoes.Geral;
import dtoAtividades.Atividade;
import dtoAtividades.Formula;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.hibernate.Session;
import persist.HibernateFactory;

/**
 *
 * @author eric
 */
public class Pontuador {

    private static final int NUM_VEZES_ATIVIDADE = 0;

    public static void main(String[] args) throws IOException, ScriptException {

        String formula = "";

        /* Chama o leitor de JSON */
        LeitorJSON leitor = new LeitorJSON(new File("json.json"));
        /* Os dados do JSON são armazenados no ArrayList */
        ArrayList<ProfessorJSON> dadosJson = new ArrayList<ProfessorJSON>();
        dadosJson = leitor.getListaProfessoresJSON();

        ProfessorJSON professor;
        /* Para cada professor, há uma iteração */
        for (int i = 0; i < dadosJson.size(); i++) {
            professor = new ProfessorJSON();
            professor = dadosJson.get(i);
            System.out.println("\nNome: " + professor.getNomeProfessor());
            System.out.println("Id: " + professor.getIdProfessor());
            System.out.println("Atividades: ");
            /* Para cada atividade, há uma iteração */
            for (int j = 0; j < professor.getListaAtividades().size(); j++) {
                DadosAtividadeJSON dadosAtividadeJSON = professor.getListaAtividades().get(j);

                /* Procura a atividade cadastrada */
                Atividade at = new Atividade();
                at = Geral.buscaAtividade(dadosAtividadeJSON.getCodAtividade());

                /* Busca a formula da atividade, se houver */
                if (at.getIdFormula() != 0) {
                    formula = Geral.buscaFormula(at.getIdFormula());
                }

                /* Procura a área da atividade */
                Atividade area = Geral.buscaAreaMae(at.getIdAtividade());

                System.out.println("\tidAtividade: " + at.getIdAtividade());
                System.out.println("\tidArea: " + area.getIdAtividade());

                System.out.println("\tCod Atividade: " + dadosAtividadeJSON.getCodAtividade());
                System.out.println("\tParametros: " + dadosAtividadeJSON.getParametros().get(0).intValue());

                /* Manda calcular a fórmula, se houver.
                 * Caso contrário, chama o valor da pontuação e o multiplica pela
                 * quantidade (primeiro parametro vindo do JSON).
                 */
                int resultadoCalculoAtividade = 0;
                if (!formula.isEmpty()) {
                    String expressao = preparaCalculo(formula, dadosAtividadeJSON.getParametros().toString());
                    resultadoCalculoAtividade = realizarCalculo(expressao);
                } else {
                    int pontosAtividade = at.getPontos().intValue();
                    int quantidade = dadosAtividadeJSON.getParametros().get(NUM_VEZES_ATIVIDADE).intValue();
                    resultadoCalculoAtividade = pontosAtividade * quantidade;
                }
                System.out.println("\tResultado: " + resultadoCalculoAtividade);

                /* Adiciona a pontuação da atividade à sua área */
                int idArea = area.getIdAtividade();
                if (professor.pontosAreas.containsKey(idArea)) {
                    System.out.println("\tPontosAreaAntes: " + professor.pontosAreas.get(idArea));
                } else {
                    System.out.println("\tErro: Map não contem a chave!");
                }
                professor.pontosAreas.put(idArea, (professor.pontosAreas.get(idArea)) + resultadoCalculoAtividade);
                System.out.println("\tPontosAreaDepois: " + professor.pontosAreas.get(idArea));
            }
        }
        return;
    }

    public static String preparaCalculo(String formula, String variaveis) {
        /* Split na formula */
        String[] partesFormula = null;
        partesFormula = formula.split(" ");

        /* Split nas variaveis */
        String variaveisPrep = variaveis.substring(1, (variaveis.length()) - 1);
        String[] partesVariaveis = null;
        partesVariaveis = variaveisPrep.split(",");

        /* Loop para contar as variaveis */
        int numVariaveis = 0;
        for (int i = 0; i < partesFormula.length; i++) {
            if (Character.isUpperCase(partesFormula[i].charAt(0))) {
                numVariaveis++;
            }
        }

        /* Loop para substituir as variaveis na formula */
        char letra = 'A';
        for (int i = 0; i < partesVariaveis.length; i++) {
            if (numVariaveis == 0) {
                break;
            } else {
                for (int j = 0; j < partesFormula.length; j++) {
                    if (partesFormula[j].contains(String.valueOf(letra))) {
                        partesFormula[j] = partesVariaveis[i];
                    }
                }
                letra++;
                numVariaveis--;
            }
        }

        /* Juntando as partes da formula em uma so string novamente */
        String tudoJunto = "";
        for (String parte : partesFormula) {
            tudoJunto = tudoJunto + parte;
        }

        return tudoJunto;
    }

    public static int realizarCalculo(String expressao) {
        /* Cria um Script Engine Manager */
        ScriptEngineManager factory = new ScriptEngineManager();
        /* Cria um JavaScript Engine */
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        try {
            /* Faz o eval() da String expressao */
            Object obj = engine.eval(expressao);
            double d = ((Number) obj).doubleValue();
            int resultado = (int) Math.round(d);
            return resultado;
        } catch (ScriptException e) {
            System.err.println("Erro na validação do cálculo. Verifique a fórmula.");
            e.printStackTrace();
        }
        return 0;
    }
}
