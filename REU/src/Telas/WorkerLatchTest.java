/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Funcoes.ArraysBanco;
import dtoConcorrencia.Pontuador;
import dtoConcorrencia.ProfessorJSON;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class WorkerLatchTest extends JApplet {

    private static final int N = 8;
    private static final Random rand = new Random();
    private Queue<JLabel> labels = new LinkedList<JLabel>();
    private JPanel panel = new JPanel(new GridLayout(0, 1));
    private JButton startButton = new JButton(new StartAction("Do work"));
    public static JSON inst = new JSON();
    static DefaultTableModel adm = (DefaultTableModel) inst.getjTable1().getModel();
    public static JButton btnAvaliar = (JButton) inst.getBtnAvaliar();
    static JTextField txtCaminho = (JTextField) inst.getTxtCaminho();
    static int i;
    static int posicaoJaLida = 0;
    static ArrayList<ProfessorJSON> profs = new ArrayList<ProfessorJSON>();

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                new WorkerLatchTest().createGUI();
                inst.setVisible(true);

            }
        });
    }

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                add(new WorkerLatchTest().createGUI());
            }
        });
    }

    public JPanel createGUI() {

        for (int i = 0; i < N; i++) {
            JLabel label = new JLabel("0", JLabel.CENTER);
            label.setOpaque(true);
            panel.add(label);
            labels.add(label);
        }
        btnAvaliar.addActionListener(new StartAction("Do work"));
        //panel.add(startButton);
        return panel;
    }

    public class StartAction extends AbstractAction {

        private StartAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(false);
            ArraysBanco.jsonLido = ArraysBanco.populaJsonLido(txtCaminho.getText());
            CountDownLatch latch = new CountDownLatch(N);
            ExecutorService executor = Executors.newFixedThreadPool(N);
            for (JLabel label : labels) {
                label.setBackground(Color.white);
                executor.execute(new Counter(label, latch));
            }
            new Supervisor(latch).execute();
        }
    }

    private class Supervisor extends SwingWorker<Void, Void> {

        CountDownLatch latch;

        public Supervisor(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        protected Void doInBackground() throws Exception {
            latch.await();
            return null;
        }

        @Override
        protected void done() {
            for (JLabel label : labels) {
                label.setText("Fin!");
                label.setBackground(Color.lightGray);
            }

            btnAvaliar.setEnabled(true);

        }
    }

    private static class Counter extends SwingWorker<Void, ProfessorJSON> {

        private JLabel label;
        CountDownLatch latch;

        public Counter(JLabel label, CountDownLatch latch) {
            this.label = label;
            this.latch = latch;
        }

        @Override
        protected Void doInBackground() throws Exception {

            
            //Pontuador pontuador = new Pontuador();
            //pontuador.calcula(ArraysBanco.jsonLido, 0, ArraysBanco.jsonLido.size(), inst);
            //ArrayList<ProfessorJSON> profs = new ArrayList<ProfessorJSON>();
            
            //ArrayList<ProfessorJSON> profs = new ArrayList<ProfessorJSON>();
            //synchronized(this) {
//            for (int cont = 0; cont < ArraysBanco.jsonLido.size(); cont++) {
//                    //int p = getPosicaoJaLida();
//                    //setPosicaoJaLida(p+1);
//                    //profs = (ArrayList<ProfessorJSON>) pontuador.calcula(ArraysBanco.jsonLido, posicaoJaLida, posicaoJaLida + 1);
//                posicaoJaLida++;
//                //int latency = rand.nextInt(42) + 10;
//                //for (i = 0; i < profs.size(); i++) {
//                    publish(profs.get(i));
//                //publish(profs.get(cont));
//                
//                //Thread.sleep(latency);
//                }
           //}//}
            
            // profs = (ArrayList<ProfessorJSON>) pontuador.calcula(ArraysBanco.jsonLido, posicaoJaLida, ArraysBanco.jsonLido.size());
//            int latency = rand.nextInt(42) + 10;
//            for (i = 0; i < profs.size(); i++) {
//                publish(profs.get(i));
//                //Thread.sleep(latency);
//            }
            return null;
            
        }

        //Atualiza a table com os dados do Professor
        @Override
        protected void process(List<ProfessorJSON> values) {

            //for (int j = 0; j < values.size(); j++) {
//            for (ProfessorJSON row : values) {
//                adm.addRow(new Object[]{values.get(i).getIdProfessor(), values.get(i).getNomeProfessor(),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(0)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(1)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(2)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(3)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(4))});
//            }

//            for (int i = 0; i < ArraysBanco.jsonLido.size(); i++) {
//                adm.setNumRows(i);
//                adm.addRow(new Object[]{values.get(i).getIdProfessor(), values.get(i).getNomeProfessor(),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(0)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(1)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(2)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(3)),
//                    values.get(i).pontosAreas.get(ArraysBanco.listaIdAreas.get(4))});
//            }
        }

        @Override
        protected void done() {
            
            label.setBackground(Color.green);
            latch.countDown();
        }
    }
}
