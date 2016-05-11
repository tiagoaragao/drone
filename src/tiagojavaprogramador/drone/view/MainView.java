package tiagojavaprogramador.drone.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;

import tiagojavaprogramador.drone.adapter.CellRenderers;
import tiagojavaprogramador.drone.adapter.RssFeedCellEditor;

import tiagojavaprogramador.drone.adapter.TableModel;
import tiagojavaprogramador.drone.controller.GetVideoPercentDownload;

import tiagojavaprogramador.drone.model.Video;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class MainView extends javax.swing.JFrame {

    private GetVideoPercentDownload d;
    //private TableModel model;

    private TableModel model;

    List feeds;
    private String[] columnNames = {};
    private Object[] data = {};
    private JScrollPane scrollPane;

    public MainView() {

        feeds = new ArrayList();
        model = new TableModel(feeds);

        initComponents();

        tabela.setModel(model);

        tabela.setDefaultRenderer(Video.class, new CellRenderers());
        tabela.setDefaultEditor(Video.class, new RssFeedCellEditor());

        tabela.setRowHeight(125);

        tabela.setTableHeader(null);
        jScrollPane1.setViewportView(tabela);
        tabela.setEnabled(true);

      

        tabela.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {//must be mouseReleased
                tabela.setValueAt(0, tabela.getSelectedRow(), tabela.getSelectedColumn());
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        label = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        imagem = new javax.swing.JTextField();
        link = new javax.swing.JTextField();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Testar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, -1));

        tabela.setModel(model);
        tabela.setOpaque(false);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 910, 270));

        label.setText("jLabel1");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 24, 80, 20));

        jButton2.setText("Teste 01");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jButton3.setText("Teste 02");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        imagem.setText("/tiagojavaprogramador/drone/img/icone.png");
        getContentPane().add(imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 410, -1));
        getContentPane().add(link, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 300, -1));

        fundo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/fundo.png"))); // NOI18N
        fundo.setText("Aguarde");
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        d = new GetVideoPercentDownload("https://www.youtube.com/watch?v=h_k5GW_eKR0", label);
        d.tw.start();

        //GetVideoInformation g = new GetVideoInformation("https://www.youtube.com/watch?v=h_k5GW_eKR0", model, tabela, textArea);
        //g.comandosInfo();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // model.onAddAll(getListaVideo());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ArrayList feeds = new ArrayList();
        feeds.add(new Video(link.getText(), link.getText(),  link.getText(),  link.getText(), imagem.getText()));

        model.onAddAll(feeds);
    
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel fundo;
    private javax.swing.JTextField imagem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField link;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
