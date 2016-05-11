package tiagojavaprogramador.drone.model;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import tiagojavaprogramador.drone.controller.LoadImage;

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
        epTitle.setBorder(null);
        jScrollPane1.setBorder(null);

        btDownload.setBorderPainted(false);
        btDownload.setContentAreaFilled(false);
        btDownload.setFocusPainted(false);
        btDownload.setOpaque(false);

        btDeletar.setBorderPainted(false);
        btDeletar.setContentAreaFilled(false);
        btDeletar.setFocusPainted(false);
        btDeletar.setOpaque(false);
        
        feed = null;

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
        add(lbImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 140, 90));

        btDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/download.png"))); // NOI18N
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });
        add(btDownload, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 60, -1));

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/download.png"))); // NOI18N
        add(btDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 60, -1));
        add(pbProgresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 110, 20));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        epTitle.setEditable(false);
        epTitle.setBackground(new java.awt.Color(255, 255, 255));
        epTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        epTitle.setCaretColor(new java.awt.Color(255, 255, 255));
        epTitle.setEnabled(false);
        jScrollPane1.setViewportView(epTitle);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 620, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed
        JOptionPane.showMessageDialog(null, feed.getIdVideo());
        System.out.println(evt.getActionCommand());
        evt.getActionCommand();
    }//GEN-LAST:event_btDownloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btDownload;
    private javax.swing.JEditorPane epTitle;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbImagem;
    private javax.swing.JProgressBar pbProgresso;
    // End of variables declaration//GEN-END:variables

    public void updateData(Video feed) {

        StyleSheet styleSheet = new StyleSheet();
        styleSheet.addRule("body { margin:0;}");
        styleSheet.addRule(".titulo {font-size: 16pt; color: gray;  width :100px;    text-overflow:    ellipsis; overflow: hidden;   font-weight: bold; }");
        styleSheet.addRule(".like {font-size: 14pt; color: gray;   width :100px;  text-overflow:    ellipsis; overflow: hidden;}");

        styleSheet.addRule(".time {font-size: 13pt; color: gray;  width :100px;   text-overflow:    ellipsis; overflow: hidden; }");

        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        htmlEditorKit.setStyleSheet(styleSheet);

        epTitle.setEditorKit(htmlEditorKit);

        this.feed = feed;        
        
        new LoadImage().geraImageView(lbImagem, feed.getUrlImage());
     

        epTitle.setText(feed.getDescVideo());

        lbImagem.repaint();

        btDownload.setActionCommand(feed.getLinkVideo());

    }

}
