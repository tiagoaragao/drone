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

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {

                    URL url = new URL(link);
                    try {
                        BufferedImage image = ImageIO.read(url);

                        label.setIcon(new javax.swing.ImageIcon(image));

                    } catch (IIOException e) {
                        JOptionPane.showMessageDialog(null, "" + e.getCause().getMessage(), "Erro MAINxIIEx0029", 0);
                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "" + e, "Erro MAINxEx0011", 0);

                }

            }
        });

    }
}
