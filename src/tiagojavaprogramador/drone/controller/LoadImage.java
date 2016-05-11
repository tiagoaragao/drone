package tiagojavaprogramador.drone.controller;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class LoadImage {

    public void geraImageView(final JLabel label, final String link) {

        String idvideo = "";
        idvideo = link.substring(idvideo.indexOf("=") + 1);

        final String urls = "http://img.youtube.com/vi/" + idvideo + "/1.jpg";

        System.out.println("Load image into frame..."+link);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {

                    URL url = new URL(link);
                    try {
                        BufferedImage image = ImageIO.read(url);
                        System.out.println("Finalizou Load image wait..");

                        label.setIcon(new javax.swing.ImageIcon(image));

                    } catch (IIOException e) {
                        //J//OptionPane.showMessageDialog(null,""+e.getCause().getMessage(),"Erro MAINxIIEx0029",0);
                    }

                    try {
                        //jlImagem.setIcon(new ImageIcon(image));
                    } catch (NullPointerException e) {
                        //JOptionPane.showMessageDialog(null,""+e.getCause().getMessage(),"Erro MAINxNPEx0030",0);
                    }

                    // progress1.setVisible(false);
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "" + e, "Erro MAINxEx0011", 0);

                }

            }
        });

    }
}
