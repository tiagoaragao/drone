package tiagojavaprogramador.drone.view;

import java.util.ArrayList;
import java.util.List;

import tiagojavaprogramador.drone.adapter.AdapterJTable;
import tiagojavaprogramador.drone.controller.GetVideoInformation;
import tiagojavaprogramador.drone.controller.GetVideoPercentDownload;
import tiagojavaprogramador.drone.model.Video;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class MainView extends javax.swing.JFrame {

    private GetVideoPercentDownload d;
    private AdapterJTable model;
    List<Video>  init = new ArrayList<Video>();

    public MainView() {

        initComponents();
        model = new AdapterJTable(init);
        tabela.setModel(model);     
        tabela.setRowHeight(120);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JEditorPane();
        label = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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

        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 910, 270));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setViewportView(textArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 760, 90));

        label.setText("jLabel1");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 24, 390, 20));

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

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

        GetVideoInformation g = new GetVideoInformation("https://www.youtube.com/watch?v=h_k5GW_eKR0", model, tabela, textArea);
        g.comandosInfo();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        model.onAddAll(getListaVideo());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JTable tabela;
    private javax.swing.JEditorPane textArea;
    // End of variables declaration//GEN-END:variables
private List<Video> getListaVideo() {
    
        List<Video> video = new ArrayList<Video>();

        Video vi = new Video();
        vi.setDescVideo("Jack");
        vi.setIdVideo("wqwqwq");
        vi.setLinkDownVideo("eeeeeeeeee");
        vi.setLinkVideo("ddddddddd");
        vi.setUrlImage("ddddddddd");

       
        video.add(vi);

        return video;
    }

 

}
