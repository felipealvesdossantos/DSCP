package dtoConcorrencia;

import Funcoes.ArraysBanco;
import dtoAtividades.Atividade;
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Classe responsável por calcular os pontos das atividades de cada professor.
 * 
 * @author eric
 */
public class Pontuador {

    /* Constante NUM_VEZES_ATIVIDADE representa o parametro responsável por 
     * dizer quantas vezes a atividade foi feita (ou seja, o primeiro parametro)
     */
    private List<ProfessorJSON> listProf = new ArrayList<ProfessorJSON>();
    private static final int NUM_VEZES_ATIVIDADE = 0;
    private String formula = "";

    private ProfessorJSON professor;

    public Pontuador() {
       
    }

    public List<ProfessorJSON> calcula(List<ProfessorJSON> jsonLido, int inicio, int fim) {
        
        /* Para cada professor, há uma iteração */
        for (int i = inicio; i < fim; i++) {
            professor = new ProfessorJSON();
            professor = jsonLido.get(i);
            System.out.println("\nNome: " + professor.getNomeProfessor());
            System.out.println("Id: " + professor.getIdProfessor());
            System.out.println("Atividades: ");

            /* Para cada atividade, há uma iteração */
            for (int j = 0; j < professor.getListaAtividades().size(); j++) {
                DadosAtividadeJSON dadosAtividadeJSON = professor.getListaAtividades().get(j);

                /* Procura a atividade cadastrada */
                Atividade at = new Atividade();
                at = ArraysBanco.buscaAtividade(dadosAtividadeJSON.getCodAtividade());

                /* Busca a formula da atividade, se houver */
                if (at.getIdFormula() != 0) {
                    formula = ArraysBanco.buscaFormula(at.getIdFormula());
                }

                /* Procura a área da atividade */
                Atividade area = ArraysBanco.buscaAreaMae(at.getIdAtividade());

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
            System.out.println("\tSOMA AREAS: "+professor.getSomaAreas());;
            listProf.add(professor);
        }
        return listProf;
    }
    
    /* Substitui as variáveis vindas do JSON na fórmula */
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

    /* Realiza o cálculo da fórmula */
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
