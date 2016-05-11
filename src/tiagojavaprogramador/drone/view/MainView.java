package tiagojavaprogramador.drone.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JScrollPane;

import tiagojavaprogramador.drone.adapter.CellRenderers;
import tiagojavaprogramador.drone.adapter.CellEditor;
import tiagojavaprogramador.drone.controller.GetVideoInformation;

import tiagojavaprogramador.drone.model.TableModel;
import tiagojavaprogramador.drone.controller.GetVideoPercentDownload;

import tiagojavaprogramador.drone.model.Video;
import tiagojavaprogramador.drone.string.PtBr;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class MainView extends javax.swing.JFrame {

    BufferedImage image, images;
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
        tabela.setDefaultEditor(Video.class, new CellEditor());

        tabela.setRowHeight(145);

        tabela.setTableHeader(null);
        jScrollPane1.setViewportView(tabela);
        tabela.setEnabled(true);

        URL paths = getClass().getResource("/tiagojavaprogramador/drone/img/iconezinho.png");

        try {
            images = ImageIO.read(paths);
           
            setIconImage(images);

        } catch (IOException e) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        tfLink = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        playlist = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pasta = new javax.swing.JLabel();
        ajuda = new javax.swing.JLabel();
        sair = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabela.setModel(model);
        tabela.setOpaque(false);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 980, 290));

        tfLink.setBackground(null);
        tfLink.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfLink.setText("https://www.youtube.com/watch?v=h_k5GW_eKR0");
        tfLink.setBorder(null);
        tfLink.setOpaque(false);
        getContentPane().add(tfLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 860, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/drone.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        playlist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/playlist.png"))); // NOI18N
        playlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playlistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playlistMouseExited(evt);
            }
        });
        getContentPane().add(playlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 120, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/get.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/tfFundo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        pasta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/pasta.png"))); // NOI18N
        pasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pastaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pastaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pastaMouseExited(evt);
            }
        });
        getContentPane().add(pasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 100, 50));

        ajuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/ajuda.png"))); // NOI18N
        ajuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ajudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ajudaMouseExited(evt);
            }
        });
        getContentPane().add(ajuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 100, 50));

        sair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/sair.png"))); // NOI18N
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sairMouseExited(evt);
            }
        });
        getContentPane().add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 90, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/menu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 50));

        fundo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/fundo.png"))); // NOI18N
        fundo.setText("Aguarde");
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        GetVideoInformation g = new GetVideoInformation("https://www.youtube.com/watch?v=h_k5GW_eKR0", model, tabela);
        g.comandosInfo();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/get2.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/get.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void playlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistMouseClicked

    }//GEN-LAST:event_playlistMouseClicked

    private void playlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistMouseEntered
        playlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/playlist2.png")));
    }//GEN-LAST:event_playlistMouseEntered

    private void playlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistMouseExited
        playlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/playlist.png")));           // TODO add your handling code here:
    }//GEN-LAST:event_playlistMouseExited

    private void pastaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pastaMouseClicked
        try {
            Runtime.getRuntime().exec("cmd.exe /c explorer " + PtBr.getPATH());
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_pastaMouseClicked

    private void pastaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pastaMouseEntered
        pasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/pasta2.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_pastaMouseEntered

    private void pastaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pastaMouseExited
        pasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/pasta.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_pastaMouseExited

    private void ajudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajudaMouseClicked
//        About tiago = new About();
//        tiago.show();// TODO add your handling code here:
    }//GEN-LAST:event_ajudaMouseClicked

    private void ajudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajudaMouseEntered
        ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/ajuda2.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_ajudaMouseEntered

    private void ajudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajudaMouseExited
        ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/ajuda.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_ajudaMouseExited

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_sairMouseClicked

    private void sairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseEntered
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/sair2.png")));         // TODO add your handling code here:
    }//GEN-LAST:event_sairMouseEntered

    private void sairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseExited
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiagojavaprogramador/drone/img/sair.png")));         // TODO add your handling code here:
    }//GEN-LAST:event_sairMouseExited

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
    private javax.swing.JLabel ajuda;
    private static javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pasta;
    private javax.swing.JLabel playlist;
    private javax.swing.JLabel sair;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tfLink;
    // End of variables declaration//GEN-END:variables

}
