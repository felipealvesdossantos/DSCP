package dtoConcorrencia;

import Funcoes.ArraysBanco;
import Telas.TelaInicial;
import dtoAtividades.Atividade;
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por calcular os pontos das atividades de cada professor.
 *
 * @author eric
 */
public class CalculaPontos implements Runnable {

    /* Constante NUM_VEZES_ATIVIDADE representa o parametro responsável por 
     * dizer quantas vezes a atividade foi feita (ou seja, o primeiro parametro)
     */
    private static final int NUM_VEZES_ATIVIDADE = 0;
    private static final int ID_AREA_I = 1;
    private static final int ID_AREA_II = 8;
    private static final int ID_AREA_III = 106;
    private static final int ID_AREA_IV = 135;
    private static final int ID_AREA_V = 156;
    private List<ProfessorJson> listaJson = new ArrayList<ProfessorJson>();
    private int inicio;
    private int fim;
    private String formula = "";
    DefaultTableModel tableModel = new DefaultTableModel();
    int idArea;

    private ProfessorJson professor;

    public CalculaPontos(List<ProfessorJson> jsonLido, int inicio, int fim, TelaInicial tela) {
        listaJson = jsonLido;
        this.inicio = inicio;
        this.fim = fim;
        tableModel = (DefaultTableModel) tela.getjTable1().getModel();
    }

    /* Substitui as variáveis vindas do TelaInicial na fórmula */
    public synchronized static String preparaCalculo(String formula, String variaveis) {
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
    public synchronized static int realizarCalculo(String expressao) {
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

    public synchronized void imprimeLinhaNaTela(ProfessorJson professor) {
        tableModel.addRow(new Object[]{
            professor.getIdProfessor(),
            professor.getNomeProfessor(),
            professor.pontosAreas.get(ArraysBanco.listaIdAreas.get(ID_AREA_I)),
            professor.pontosAreas.get(ArraysBanco.listaIdAreas.get(ID_AREA_II)),
            professor.pontosAreas.get(ArraysBanco.listaIdAreas.get(ID_AREA_III)),
            professor.pontosAreas.get(ArraysBanco.listaIdAreas.get(ID_AREA_IV)),
            professor.pontosAreas.get(ArraysBanco.listaIdAreas.get(ID_AREA_V)),
            professor.getMedia()
            //professor.getSomaAreas()
        });
    }

    @Override
    public void run() {
        /* Para cada professor, há uma iteração */
        for (int i = inicio; i < fim; i++) {
            professor = new ProfessorJson();
            professor = listaJson.get(i);

            /* Para cada atividade, há uma iteração */
            for (int j = 0; j < professor.getListaAtividades().size(); j++) {
                DadosAtividadeJson dadosAtividadeJSON = professor.getListaAtividades().get(j);

                /* Procura a atividade cadastrada */
                Atividade at = new Atividade();
                at = ArraysBanco.buscaAtividade(dadosAtividadeJSON.getCodAtividade());

                /* Busca a formula da atividade, se houver */
                if (at.getIdFormula() != 0) {
                    formula = ArraysBanco.buscaFormula(at.getIdFormula());
                }

                /* Procura a área da atividade */
                Atividade area = ArraysBanco.buscaAreaMae(at.getIdAtividade());

                /* Manda calcular a fórmula, se houver.
                 * Caso contrário, chama o valor da pontuação e o multiplica pela
                 * quantidade (primeiro parametro vindo do TelaInicial).
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

                /* Adiciona a pontuação da atividade à sua área */
                idArea = area.getIdAtividade();
                professor.pontosAreas.put(idArea, (professor.pontosAreas.get(idArea)) + resultadoCalculoAtividade);
            }
            double media = (professor.pontosAreas.get(ID_AREA_I) + professor.pontosAreas.get(ID_AREA_II) +
                         professor.pontosAreas.get(ID_AREA_III) + professor.pontosAreas.get(ID_AREA_IV) +
                         professor.pontosAreas.get(ID_AREA_V)) / 5;
            professor.setMedia(media);
            imprimeLinhaNaTela(professor);

        }
    }
}
