package dtoConcorrencia;

import dtoAtividades.Atividade;
import dtoAtividades.Formula;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class FormulaAlg {

    /* Essa ArrayList é temporaria, para teste. A definitiva será uma variavel global
     * que receberá todas as atividades existentes no banco.
     */
    static ArrayList<Atividade> listaAtividades = new ArrayList<Atividade>();
    /* Esse HashMap é temporario, para teste. O definitivo será uma variavel global
     * que receberá todas as áreas (atividades sem mãe) existentes no banco.
     */
    static Map<Integer, Integer> mapaAreas = new HashMap<Integer, Integer>();
    /* Essa ArrayList é temporaria, para teste. A definitiva será uma variavel global
     * que receberá todas as fórmulas existentes no banco.
     */
    static ArrayList<Formula> listaFormulas = new ArrayList<Formula>();

    public static void main(String[] args) throws IOException, ScriptException {

        String formula = "";

//        StringBuilder numId = new StringBuilder("");
//        numId.append(1);
//        /* Não precisamos mais desse método, já que não acessamos mais o banco. */
//        try {
//            
//            List<Formula> formulas = listar(Formula.class, numId);
//            formula = formulas.get(0).getDescricao();
//            System.out.println("Formula: " + formula);
//        } catch (Exception ex) {
//            System.out.println("Erro:" + ex.getMessage());
//        }

        System.out.println("### JSON ###");
        // Chama o leitor de JSON
        LeitorJSON leitor = new LeitorJSON(new File("json.json"));
        // Os dados do JSON são armazenados no ArrayList
        ArrayList<DadosJSON> dadosJson = new ArrayList<DadosJSON>();
        dadosJson = leitor.getListaProfessoresJSON();
        // Para cada professor, há uma iteração
        for (int i = 0; i < dadosJson.size(); i++) {
            System.out.println("Nome: " + dadosJson.get(i).getNomeProfessor());
            System.out.println("Id: " + dadosJson.get(i).getIdProfessor());
            System.out.println("Atividades: ");
            // Para cada atividade, há uma iteração
            for (int j = 0; j < dadosJson.get(i).getListaAtividades().size(); j++) {
                String codAtividade = dadosJson.get(i).getListaAtividades().get(j).getCodAtividade();

                // Procura a atividade cadastrada no banco
                Atividade atividade = getAtividadeBanco(codAtividade);

                // Busca a formula da atividade, se houver
                if (atividade.getIdFormula() != null) {
                    formula = buscarFormula(atividade);
                }

                // Procura a área da atividade
                Atividade area = procuraArea(atividade);

                System.out.println("\tId Atividade: " + dadosJson.get(i).getListaAtividades().get(j).getCodAtividade());
                System.out.println("\tParametros: " + dadosJson.get(i).getListaAtividades().get(j).getParametros());

                // Manda calcular a fórmula, se houver.
                // Caso contrário, chama o valor da pontuação.
                int resultadoCalculoAtividade;  
                if (!formula.isEmpty()) {
                String expressao = preparaCalculo(formula, dadosJson.get(i).getListaAtividades().get(j).getParametros().toString());
                resultadoCalculoAtividade = realizarCalculo(expressao);
                } else {
                    resultadoCalculoAtividade = atividade.getPontos().intValue();
                }
                System.out.println("Resultado: " + resultadoCalculoAtividade);

                // Adiciona a pontuação da atividade à sua área
                if (mapaAreas.containsKey(area.getIdAtividade())) {
                    mapaAreas.put(area.getIdAtividade(), mapaAreas.get(area.getIdAtividade()) + resultadoCalculoAtividade);
                }
            }
        }
    }

    private static Atividade getAtividadeBanco(String codAtividade) {
        for (int i = 0; i < listaAtividades.size(); i++) {
            if (listaAtividades.get(i).getCodigo().equals(codAtividade)) {
                return listaAtividades.get(i);
            }
        }
        return null;
    }

    private static Atividade procuraArea(Atividade atividade) {
        Atividade atividadeAnterior = atividade;
        boolean isArea = false;
        while (!isArea) {
            Atividade ativ = atividadeAnterior;
            if (ativ.getIdAtividadeMae() != null) {
                isArea = false;
                atividadeAnterior = getAtividadeBanco(ativ.getIdAtividadeMae().getCodigo());
            } else {
                atividadeAnterior = ativ;
                isArea = true;
            }
        }
        return atividadeAnterior;
    }

    private static String buscarFormula(Atividade atividade) {
        for (int i = 0; i < listaFormulas.size(); i++) {
            if (listaFormulas.get(i).getIdFormula() == atividade.getIdFormula().getIdFormula()) {
                return listaFormulas.get(i).getDescricao();
            }
        }
        return null;
    }

    public static String preparaCalculo(String formula, String variaveis) {
        // Split na formula
        String[] partesFormula = null;
        partesFormula = formula.split(" ");

        // Split nas variaveis
        String variaveisPrep = variaveis.substring(1, (variaveis.length()) - 1);
        String[] partesVariaveis = null;
        partesVariaveis = variaveisPrep.split(",");

        // Loop para contar as variaveis
        int numVariaveis = 0;
        for (int i = 0; i < partesFormula.length; i++) {
            if (Character.isUpperCase(partesFormula[i].charAt(0))) {
                numVariaveis++;
            }
        }

        // Loop para substituir as variaveis na formula
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

        // Juntando as partes da formula em uma so string novamente
        String tudoJunto = "";
        for (String parte : partesFormula) {
            tudoJunto = tudoJunto + parte;
        }

        return tudoJunto;
    }

    public static int realizarCalculo(String expressao) {
        // Cria um Script Engine Manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // Cria um JavaScript Engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        try {
            // evaluate JavaScript code from String
            Object obj = engine.eval(expressao);
            //System.out.println(obj);
            //System.out.println(obj.getClass());
            double d = ((Number) obj).doubleValue();
            int resultado = (int) Math.round(d);
            return resultado;
        } catch (ScriptException e) {
            System.err.println("Erro na validação do cálculo. Verifique a fórmula.");
            e.printStackTrace();
        }
        return 0;
    }

//    public static List listar(Class classeEntidade, StringBuilder hql) {
//
//        Session session = HibernateFactory.getSession();
//
//        StringBuilder hqlQuery = new StringBuilder("from " + classeEntidade.getName() + " bean where idFormula = ");
//        hqlQuery.append(hql);
//
//        org.hibernate.Query query = session.createQuery(hqlQuery.toString());
//
//        List lista = query.list();
//        session.close();
//        return lista;
//    }
}
