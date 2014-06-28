package dtoFormula;

import java.io.File;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author eric
 */
public class FormulaAlg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ScriptException {
        // Pegar o caminho dos arquivos de formula e de variaveis
        // Esses arquivos foram usados somente para teste.
        File arqFormula = new File("/home/eric/formula.txt").getAbsoluteFile();
        File arqVariaveis = new File("/home/eric/variaveis.txt").getAbsoluteFile();

        // Chama o leitor para o arquivo formula.txt
        LeitorDeArquivo leitorFormula = new LeitorDeArquivo(arqFormula);
        String formula = leitorFormula.getConteudo();
        System.out.println("Veio do Leitor: " + formula);

        // Chama o leitor para o arquivo variaveis.txt
        LeitorDeArquivo leitorVariaveis = new LeitorDeArquivo(arqVariaveis);
        String variaveis = leitorVariaveis.getConteudo();
        System.out.println("Veio do Leitor: " + variaveis);

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

    public static int realizarCalculo(String expressao){
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        try {
            // evaluate JavaScript code from String
            Object obj = engine.eval(expressao);
            System.out.println(obj);
            System.out.println(obj.getClass());
            double d = ((Number)obj).doubleValue();
            int resultado = (int) Math.round(d);
            return resultado;
        } catch (ScriptException e) {
            System.err.println("Erro na validação do cálculo. Verifique a fórmula.");
            e.printStackTrace();
        }
        return 0;
    }
}
