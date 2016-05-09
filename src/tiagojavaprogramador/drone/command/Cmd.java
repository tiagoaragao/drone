package tiagojavaprogramador.drone.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class Cmd {

    private String resposta = "";
    private String comando = "";
    private String line;

    public String comandosDownload(String comandos) {
        this.comando = comandos;
        Thread tw = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    
                    ProcessBuilder builders = new ProcessBuilder("cmd.exe", "/c", comando);
                    builders.redirectErrorStream(true);
                    Process z = builders.start();
                    BufferedReader rs = new BufferedReader(new InputStreamReader(z.getInputStream()));
                 
                    String multipleLine = "";
                    boolean tentativas = false;
                    while (true) {
                        line = rs.readLine();
                        if (line.contains("ERROR:") || line.contains("conex�o") || line.contains("URLError")) {

                            resposta = "type_error=Cheque a conexao!";
                            tentativas = true;

                        }
                        if (line.contains("has already been downloaded")) {
                            resposta = "type_error=Este video ja foi baixado!";
                        }
                        if (line.contains("%")) {
                            float porcent = Float.parseFloat(line.substring(line.indexOf("]"), line.lastIndexOf("%")).replace(" ", "").replace("]", "").replace("%", ""));

                            if (line.equals("100")) {
                                resposta = "type_percent=Download concluido!";
                            }else{
                                 resposta = "type_percent=" + line;
                            }
                        }

                        if (line == null) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    resposta = "type_error=";
                } catch (NullPointerException e) {
                    resposta = "type_error=";
                }
            }
        });
        tw.start();

        return resposta;
    }
}
