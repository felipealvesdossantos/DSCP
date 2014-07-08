package Telas;

import Funcoes.ArraysBanco;
import dtoConcorrencia.CalculaPontos;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Henrique
 */
public class TelaInicial extends javax.swing.JFrame {

    long idProfessor;
    String nomeProfessor;

    public TelaInicial() {
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
                "ID Professor", "Nome Professor", "Area I", "Area II", "Area III", "Area IV", "Area V", "Media Areas"
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        TelaBuscaCaminhoJason bscCaminho = new TelaBuscaCaminhoJason();
        
        if (!bscCaminho.flagJSON) {
            txtCaminho.setText(bscCaminho.nomeArquivo);
        } else {
            //nada
        }

    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        ArraysBanco.jsonLido = ArraysBanco.populaJsonLido(txtCaminho.getText());
        CalculaPontos pontuador1 = new CalculaPontos(ArraysBanco.jsonLido, 0, 1999, TelaInicial.this);
        CalculaPontos pontuador2 = new CalculaPontos(ArraysBanco.jsonLido, 2000, 3999, TelaInicial.this);
        CalculaPontos pontuador3 = new CalculaPontos(ArraysBanco.jsonLido, 4000, 5999, TelaInicial.this);
        CalculaPontos pontuador4 = new CalculaPontos(ArraysBanco.jsonLido, 6000, 7999, TelaInicial.this);
        CalculaPontos pontuador5 = new CalculaPontos(ArraysBanco.jsonLido, 8000, 10000, TelaInicial.this);

        Thread t1 = new Thread(pontuador1);
        Thread t2 = new Thread(pontuador2);
        Thread t3 = new Thread(pontuador3);
        Thread t4 = new Thread(pontuador4);
        Thread t5 = new Thread(pontuador5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        
//        ArraysBanco.jsonLido = ArraysBanco.populaJsonLido(txtCaminho.getText());
//        CalculaPontos pontuador1 = new CalculaPontos(ArraysBanco.jsonLido, 0, 999, TelaInicial.this);
//        CalculaPontos pontuador2 = new CalculaPontos(ArraysBanco.jsonLido, 1000, 2999, TelaInicial.this);
//        CalculaPontos pontuador3 = new CalculaPontos(ArraysBanco.jsonLido, 3000, 3999, TelaInicial.this);
//        CalculaPontos pontuador4 = new CalculaPontos(ArraysBanco.jsonLido, 4000, 4999, TelaInicial.this);
//        CalculaPontos pontuador5 = new CalculaPontos(ArraysBanco.jsonLido, 5000, 5999, TelaInicial.this);
//        CalculaPontos pontuador6 = new CalculaPontos(ArraysBanco.jsonLido, 6000, 6999, TelaInicial.this);
//        CalculaPontos pontuador7 = new CalculaPontos(ArraysBanco.jsonLido, 7000, 7999, TelaInicial.this);
//        CalculaPontos pontuador8 = new CalculaPontos(ArraysBanco.jsonLido, 8000, 8999, TelaInicial.this);
//        CalculaPontos pontuador9 = new CalculaPontos(ArraysBanco.jsonLido, 9000, 9999, TelaInicial.this);
//        CalculaPontos pontuador10 = new CalculaPontos(ArraysBanco.jsonLido, 8000, 9999, TelaInicial.this);
//       
//        Thread t1 = new Thread(pontuador1);
//        Thread t2 = new Thread(pontuador2);
//        Thread t3 = new Thread(pontuador3);
//        Thread t4 = new Thread(pontuador4);
//        Thread t5 = new Thread(pontuador5);
//        Thread t6 = new Thread(pontuador6);
//        Thread t7 = new Thread(pontuador7);
//        Thread t8 = new Thread(pontuador8);
//        Thread t9 = new Thread(pontuador9);
//        Thread t10 = new Thread(pontuador10);
//        
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
//        t9.start();
//        t10.start();
    }//GEN-LAST:event_btnAvaliarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
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

    public JTextField getTxtCaminho() {
        return txtCaminho;
    }

    public void setTxtCaminho(JTextField txtCaminho) {
        this.txtCaminho = txtCaminho;
    }

    public JButton getBtnAvaliar() {
        return btnAvaliar;
    }

    public void setBtnAvaliar(JButton btnAvaliar) {
        this.btnAvaliar = btnAvaliar;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

}
