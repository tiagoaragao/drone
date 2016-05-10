package tiagojavaprogramador.drone.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tiagojavaprogramador.drone.view.MainView;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class GetVideoPercentDownload extends Thread {

    private static String resposta = "nok";
    private static String comando;
    public static String line;
    static MainView frame;

    private static JLabel label;

    public GetVideoPercentDownload(String comandos, JLabel label) {
        this.comando = comandos;
        this.label = label;
    }

    public static Thread tw = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                String  path = "" + javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory() + "/MyVideos";
                path = path.replace("/", "\\");
                
                String lineCommand = "drone.exe -cit "+ comando+" "+path;
               /// JOptionPane.showMessageDialog(null,lineCommand);

                ProcessBuilder builders = new ProcessBuilder("cmd.exe", "/c","drone.exe --output  "+path + "\\%(title)s.%(ext)s "+ comando);
                builders.redirectErrorStream(true);
                Process z = builders.start();
                BufferedReader rs = new BufferedReader(new InputStreamReader(z.getInputStream()));
                
                
           

                while (true) {

                    line = rs.readLine();

                    if (line.contains("ERROR:") || line.contains("conex�o") || line.contains("URLError")) {
                        resposta = "type_error=Cheque a conexao!";
                    }
                    if (line.contains("has already been downloaded")) {
                        resposta = "type_error=Este video ja foi baixado!";
                    }
                    if (line.contains("%")) {
                        float porcent = Float.parseFloat(line.substring(line.indexOf("]"), line.lastIndexOf("%")).replace(" ", "").replace("]", "").replace("%", ""));

                        if (line.equals("100")) {
                            resposta = "type_percent=Download concluido!";
                            tw.interrupt();
                        } else {
                            resposta = "type_percent=" + porcent;
                        }
                    }

                    if (line == null) {
                        break;
                    }

                    if (resposta.equals("nok")) {
                    } else {
                        System.out.println(resposta);

                        label.setText(resposta.substring(resposta.indexOf("=") + 1));
                    }
                }
            } catch (IOException e) {
                resposta = "type_error=Erro na entrada de dados, consulte o desenvolverdor do sistema!";
                System.out.println("Erro");
            } catch (NullPointerException e) {
                resposta = "type_error=Erro, não houve resposta do servidor, ou não há conteudo a ser mostrado!";
                System.out.println("Erro");
            }
        }
    });


}
