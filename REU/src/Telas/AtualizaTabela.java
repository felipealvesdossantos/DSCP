/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import dtoConcorrencia.DadosJSON;
import dtoConcorrencia.LeitorJSON;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alunoinf
 */
public class AtualizaTabela {
     ArrayList<DadosJSON> dadosJSON = new ArrayList<DadosJSON>();

    public ArrayList<DadosJSON> getDadosJSON() {
        return dadosJSON;
    }
     
    public AtualizaTabela(){
       
    }
    
    public void atualizaTabela(String caminho){
         LeitorJSON leitor = new LeitorJSON(new File(caminho));
        
         dadosJSON=leitor.getListaProfessoresJSON();
        
    
    }
            
}
