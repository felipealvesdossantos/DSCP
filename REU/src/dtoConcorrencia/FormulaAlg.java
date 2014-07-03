package dtoConcorrencia;

import dtoAtividades.Formula;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.script.ScriptException
     */
    public static void main(String[] args) throws IOException, ScriptException {
        // Pegar o caminho dos arquivos de formula e de variaveis
        // Esses arquivos foram usados somente para teste.
        //File arqFormula = new File("/home/eric/formula.txt").getAbsoluteFile();
        //File arqVariaveis = new File("/home/eric/variaveis.txt").getAbsoluteFile();
        String formula = "";

        //Geral geral = new Geral();
        //PersistenciaDao persistenciaDao = new PersistenciaDao();
        StringBuilder numId = new StringBuilder("");
        numId.append(1);


        try {
            List<Formula> formulas = listar(Formula.class, numId);
            formula = formulas.get(0).getDescricao();
            System.out.println("Formula: " + formula);
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
        }

        System.out.println("### JSON ###");
        LeitorJSON leitor = new LeitorJSON(new File("json.json"));
        ArrayList<DadosJSON> dadosJson = new ArrayList<DadosJSON>();
        dadosJson = leitor.getListaAtividadesEVariaveis();
        for (int i = 0; i < dadosJson.size(); i++) {
            System.out.println("Nome: " + dadosJson.get(i).getNomeProfessor());
            System.out.println("Id: " + dadosJson.get(i).getIdProfessor());
            System.out.println("Atividades: ");
            for (int j = 0; j < dadosJson.get(i).getListaAtividades().size(); j++) {
                System.out.println("\tId Atividade: " + dadosJson.get(i).getListaAtividades().get(j).getIdAtividade());
                System.out.println("\tParametros: " + dadosJson.get(i).getListaAtividades().get(j).getParametros());
            }
        }
        
        
        
        String variaveis = "";
        // Chama o leitor para o arquivo variaveis.txt
        //LeitorDeArquivo leitorVariaveis = new LeitorDeArquivo(arqVariaveis);
        //String variaveis = leitorVariaveis.getConteudo();
        //System.out.println("Variáveis: " + variaveis);

        // Junta a formula e as variaveis
        String expressaoPreparada = preparaCalculo(formula, variaveis);
        System.out.println("Expressao Preparada: " + expressaoPreparada);
        
        int resultado = realizarCalculo(expressaoPreparada);
        System.out.println("Resultado: "+resultado);
    }

    public static String preparaCalculo(String formula, String variaveis) {
        // Split na formula
        String[] partesFormula = null;
        partesFormula = formula.split(" ");

        // Split nas variaveis
        String[] partesVariaveis = null;
        partesVariaveis = variaveis.split(",");

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
            System.out.println(obj);
            System.out.println(obj.getClass());
            double d = ((Number) obj).doubleValue();
            int resultado = (int) Math.round(d);
            return resultado;
        } catch (ScriptException e) {
            System.err.println("Erro na validação do cálculo. Verifique a fórmula.");
            e.printStackTrace();
        }
        return 0;
    }

    public static List listar(Class classeEntidade, StringBuilder hql) {

        Session session = HibernateFactory.getSession();

        StringBuilder hqlQuery = new StringBuilder("from " + classeEntidade.getName() + " bean where idFormula = ");
        hqlQuery.append(hql);

        org.hibernate.Query query = session.createQuery(hqlQuery.toString());

        List lista = query.list();
        session.close();
        return lista;
    }
}
