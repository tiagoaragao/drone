package tiagojavaprogramador.drone.model;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class VideoPanel extends JPanel {

    String titulo;
    Video feed;

    public VideoPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImagem = new javax.swing.JLabel();
        btDownload = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        pbProgresso = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        epTitle = new javax.swing.JEditorPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lbImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 100, 100));

        btDownload.setText("Download");
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });
        add(btDownload, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        btDeletar.setText("Deletar");
        add(btDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));
        add(pbProgresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 160, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        epTitle.setEnabled(false);
        jScrollPane1.setViewportView(epTitle);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 550, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed
JOptionPane.showMessageDialog(null, "Reading "+feed.getIdVideo());        // TODO add your handling code here:
    }//GEN-LAST:event_btDownloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btDownload;
    private javax.swing.JEditorPane epTitle;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbImagem;
    private javax.swing.JProgressBar pbProgresso;
    // End of variables declaration//GEN-END:variables

    public void updateData(Video feed) {
        this.feed = feed;
        
        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(feed.getUrlImage())));
        
        System.out.println(feed.getUrlImage());
      
        epTitle.setText( feed.getLinkVideo());
     
        
       
    }
}
