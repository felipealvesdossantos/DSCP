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
    public static String buscaFormula(int id){
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
        Atividade atv = new Atividade();

        for (int i = 0; i < Arrays.listaAtividades.size(); i++) {
            if (Arrays.listaAtividades.get(i).getIdAtividade() == id) {
                if (Arrays.listaAtividades.get(i).getIdAtividadeMae() == 0) {
                    System.out.println("Atividade1: " + Arrays.listaAtividades.get(i).getDescricao());
                    System.out.println("Atv Mae1: " + Arrays.listaAtividades.get(i).getIdAtividadeMae());
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

        Atividade 
               atv = buscaAreaMae(165);

        System.out.println("Id: " + atv.getIdAtividade());
        System.out.println("Descrição: " + atv.getDescricao());
        System.out.println("Codigo: " + atv.getCodigo());
        System.out.println("Pontos: " + atv.getPontos());
        System.out.println("idMae: " + atv.getIdAtividadeMae());
//        int b = 0;
//        for (int i = 0; i < listaAtividades.size(); i++) {
//            if (listaAtividades.get(i).getIdAtividadeMae() == 0) {
//                b++;
//                System.out.println(listaAtividades.get(i).getDescricao());
//            }
//        }
//        System.out.println(b);
    }
}
