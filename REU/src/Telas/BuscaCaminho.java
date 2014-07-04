/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class BuscaCaminho extends JFrame {
    JFileChooser busca;
    String nomeArquivo;
    Boolean flagJSON;
    
    public BuscaCaminho() {
    flagJSON = false;
    busca = new JFileChooser();
    int r = busca.showOpenDialog(new JFrame());
        if (r == JFileChooser.APPROVE_OPTION) {
        nomeArquivo = busca.getSelectedFile().getPath();
        }
        
        String filename = nomeArquivo;
        String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

        String excel = "json";
        if (!excel.equalsIgnoreCase(extension)) {
            JOptionPane.showMessageDialog(null, "Escolha um arquivo Jason!");
            flagJSON = true;
        }
        else {
        
        }
    }
}

