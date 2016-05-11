package tiagojavaprogramador.drone.controller;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import tiagojavaprogramador.drone.model.TableModel;

import tiagojavaprogramador.drone.model.Video;
import tiagojavaprogramador.drone.model.VideoPanel;
import tiagojavaprogramador.drone.string.PtBr;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class GetVideoInformation {

    private String idVideo;
    private String resposta;

    ProcessBuilder builders;
    List list;

    Process z;
    BufferedReader rs;
    TableModel model;
    JTable tabela;
    JEditorPane textArea;
    String comando;

    java.util.List<Video> video;
    Video vi;
    java.util.List<Video> init = new ArrayList<Video>();
    ArrayList contentVideo;

    public GetVideoInformation(String comando, TableModel model, JTable tabela) {
        this.model = model;
        this.tabela = tabela;
        this.textArea = textArea;
        this.comando = comando;

    }

    public java.util.List<Video> comandosInfo() {

        idVideo = comando.substring(comando.indexOf("=") + 1, comando.length());

        try {

            builders = null;
            z = null;

            builders = new ProcessBuilder("cmd.exe", "/c", "drone.exe --dump-single-json " + comando + " > " + PtBr.getPATH() + "\\temp\\" + idVideo + ".json");
            builders.redirectErrorStream(true);
            z = builders.start();
            rs = new BufferedReader(new InputStreamReader(z.getInputStream()));
            String line = "";

            while (true) {
                System.out.println("Iniciando while.... ");
                line = rs.readLine();

                contentVideo = null;

                resposta = line;

                if (line == null) {

                    try {
                        System.out.println("wait while.... ");
                        JSONParser parser = new JSONParser();

                        System.out.println("Iniciando file reader.... " + PtBr.getPATH() + "\\" + "temp\\" + idVideo + ".json");
                        Object obj = parser.parse(new FileReader(PtBr.getPATH() + "\\" + "temp\\" + idVideo + ".json"));
                        System.out.println("Passou pelo file reader.... " + PtBr.getPATH());
                        JSONObject jsonObject = (JSONObject) obj;

                        String linkDownload = (String) jsonObject.get("url");
                        String title = (String) jsonObject.get("title");
                        String visualizacao = "" + jsonObject.get("view_count");
                        String duracao = "" + jsonObject.get("duration");
                        String extensao = "" + jsonObject.get("ext");

                        JSONArray list = (JSONArray) jsonObject.get("thumbnails");

                        String thumbnails = list.get(0).toString();

                        Object obj2 = parser.parse(thumbnails);

                        JSONObject jsonObject2 = (JSONObject) obj2;

                        String webContent = "<html>"
                                  + "<head>"
                                  + "</head>"
                                  + "<body>"
                                  + "<span class='titulo'>" + title + "<br>" + "</span>"
                                  + "<span class='time'>" + duracao + "<br>" + "</span>"
                                  + "</body>"
                                  + "</html>";

                        contentVideo = new ArrayList();
                        
                        Video v = new Video();
                        
                        v.setDescVideo(webContent);
                        v.setUrlImage(""+jsonObject2.get("url"));
                        v.setLinkDownVideo("teste");

                        contentVideo.add(v);

                        model.onAddAll(contentVideo);

                        tabela.scrollRectToVisible(tabela.getCellRect(tabela.getRowCount() - 1, 0, true));

                    } catch (Exception ex) {

                        JOptionPane.showMessageDialog(null, "Este link está indísponivel para download no momento.", "Erro MAINxNPEx0090", 0);

                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {

                    }

                    break;
                }

            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "" + e, "Erro MAINxNPEx0013", 0);
            // textArea.setText("");

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "" + e, "Erro MAINxNPEx0013", 0);
            System.out.println("" + e);
        }

        try {

            builders = new ProcessBuilder("cmd.exe", "/c", "del  " + PtBr.getPATH() + "\\temp\\" + "*.json");
            z = builders.start();

        } catch (Exception ex) {

        }
        System.out.println("Retornou dados");
        return contentVideo;

    }

}
