package Telas;

import Funcoes.ArraysBanco;
import dtoConcorrencia.Pontuador;
import dtoConcorrencia.ProfessorJSON;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Henrique
 */
public class JSON extends javax.swing.JFrame {

    long idProfessor;
    String nomeProfessor;
    
    public JSON() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCaminho = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAvaliar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        jLabel1.setText("Caminho JSON");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Professor", "Nome Professor", "Area I", "Area II", "Area III", "Area IV", "Area V", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAvaliar.setText("Avaliar");
        btnAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarActionPerformed(evt);
            }
        });
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCaminho)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAvaliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaliar)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        BuscaCaminho bscCaminho = new BuscaCaminho();
        
        
      if (!bscCaminho.flagJSON){
        txtCaminho.setText(bscCaminho.nomeArquivo);
      }else{
         //nada
      }
      
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        ArraysBanco.jsonLido = ArraysBanco.populaJsonLido(txtCaminho.getText());
        
        Pontuador pontuador = new Pontuador(ArraysBanco.jsonLido, 0, ArraysBanco.jsonLido.size());
        AtualizaTabela atlza = new AtualizaTabela();
        atlza.atualizaTabela(txtCaminho.getText());
        
        //insereTabela(atlza.getPJSON());
        
    }//GEN-LAST:event_btnAvaliarActionPerformed
 
    
    private void insereTabela(ArrayList<ProfessorJSON> json){
         long idProfessor;
         String nomeProfessor;
         
       
        
        DefaultTableModel adm = (DefaultTableModel) jTable1.getModel();
        
       for(int i=0; i< json.size();i++){
           
        idProfessor = json.get(i).getIdProfessor();
        nomeProfessor = json.get(i).getNomeProfessor();
        
        adm.setNumRows(i);
        
        adm.addRow(new Object[]{
                        idProfessor,
                        nomeProfessor,
                            
                        });
       }
        //jTable1.setValueAt(nomeProfessor, 0,1);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//          JSON frame = new JSON ();
//          frame.setSize(400, 300);
//          frame.setLocation(200, 100);
//          frame.setVisible(true);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JSON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvaliar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField txtCaminho;
    // End of variables declaration//GEN-END:variables

}
