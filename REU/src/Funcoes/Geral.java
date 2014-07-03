/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import dtoAtividades.Atividade;

/**
 *
 * @author felipe
 */
public class Geral {
    static Atividade atv = new Atividade();
    /*
     Busca uma atividade em especifico atravez do seu codigo
     */
    public static Atividade buscaAtividade(String codigo) {
        int id = 0;
        Atividade atv = null;

        for (int i = 0; i < Arrays.listaAtividades.size(); i++) {
            if (Arrays.listaAtividades.get(i).getCodigo().equals(codigo)) {
                id = Arrays.listaAtividades.get(i).getIdAtividade();
                atv = Arrays.listaAtividades.get(i);
            }
        }
        return atv;
    }

    /*
     Busca uma formula em especifico atravez do seu id
     */
    public static String buscaFormula(int id) {
        String formula = "";

        for (int i = 0; i < Arrays.listaFormulas.size(); i++) {
            if (Arrays.listaFormulas.get(i).getIdFormula() == id) {
                formula = Arrays.listaFormulas.get(i).getDescricao();
            }
        }
        return formula;
    }

    /*
     Busca uma area mae recursicamente atravez do id de uma atividade
     */
    public static Atividade buscaAreaMae(int id) {
        
        for (int i = 0; i < Arrays.listaAtividades.size(); i++) {
            if (Arrays.listaAtividades.get(i).getIdAtividade() == id) {
                if (Arrays.listaAtividades.get(i).getIdAtividadeMae() == 0) {
                    atv = Arrays.listaAtividades.get(i);
                    break;
                } else {
                    buscaAreaMae(Arrays.listaAtividades.get(i).getIdAtividadeMae());              
                }
            }
        }
        return atv;
    }

    public static void main(String[] args) {

        Atividade a = buscaAreaMae(165);

        System.out.println("Id: " + a.getIdAtividade());
        System.out.println("Descrição: " + a.getDescricao());
        System.out.println("Codigo: " + a.getCodigo());
        System.out.println("Pontos: " + a.getPontos());
        System.out.println("idMae: " + a.getIdAtividadeMae());
        
        Atividade b = buscaAreaMae(4);

        System.out.println("Id: " + b.getIdAtividade());
        System.out.println("Descrição: " + b.getDescricao());
        System.out.println("Codigo: " + b.getCodigo());
        System.out.println("Pontos: " + b.getPontos());
        System.out.println("idMae: " + b.getIdAtividadeMae());
    }
}
