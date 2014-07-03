/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoConcorrencia;

import dtoAtividades.Atividade;
import java.util.ArrayList;
import java.util.List;
import persist.PersistenciaDao;

/**
 *
 * @author felipe
 */
public class Arrays {

    public static List<Atividade> listaAtividade = listaAtv();
    public static ArrayList<Integer> listaAreaMae = new ArrayList<Integer>();

    public static List listaAtv() {
        List<Atividade> lista = null;

        try {
            PersistenciaDao pers = new PersistenciaDao();
            lista = pers.listar(Atividade.class);
        } catch (Exception ex) {
            System.out.println("Erros ao buscar lista de Atividades: " + ex.getMessage());
        }
        return lista;
    }

    public static int buscaId(String codigo) {
        int id = 0;

        for (int i = 0; i < listaAtividade.size(); i++) {
            if (listaAtividade.get(i).getCodigo().equals(codigo)) {
                id = listaAtividade.get(i).getIdAtividade();
            }
        }
        return id;
    }

    public static int id(String codigoMae) {
        int idMae = 0;
        for (int i = 0; i < listaAtividade.size(); i++) {
            if (listaAtividade.get(i).getCodigoMae().equals(codigoMae)) {
                idMae = listaAtividade.get(i).getIdAtividade();
            }
        }
        return idMae;
    }

    public static void buscaAreaMae(int id) {
        for (int i = 0; i < listaAtividade.size(); i++) {
            if (listaAtividade.get(i).getIdAtividade() == id && !listaAtividade.get(i).getCodigoMae().isEmpty()) {
                //System.out.println(listaAtividade.get(i).getDescricao());
                
                int idMae = id(listaAtividade.get(i).getCodigoMae());
                System.out.println("idMae :" + idMae + " <> " + listaAtividade.get(idMae).getDescricao());
                buscaAreaMae(idMae);
            }
            else{
                System.out.println("Atv Mae: " + listaAtividade.get(i).getDescricao());
                break;
            }
        }

    }

    public static void main(String[] args) {

        buscaAreaMae(1);
//        for (int i = 0; i < listaAtividade.size(); i++) {
//            if (listaAtividade.get(i).getCodigoMae().isEmpty()) {
//                System.out.println(listaAtividade.get(i).getDescricao());
//            }
//        }

    }
}
