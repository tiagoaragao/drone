package tiagojavaprogramador.drone.controller;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
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
import tiagojavaprogramador.drone.adapter.AdapterJTable;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class GetVideoInformation {

    private String idVideo;
    private String resposta;
    String path;
    ProcessBuilder builders;
    List list;

    Process z;
    BufferedReader rs;
    AdapterJTable  model;
    JTable tabela;
    JEditorPane textArea;
    String comando;

    public GetVideoInformation(String comando, AdapterJTable  model, JTable tabela, JEditorPane textArea) {
        this.model = model;
        this.tabela = tabela;
        this.textArea = textArea;
        this.comando = comando;
    }

    public String comandosInfo() {

        idVideo = comando.substring(comando.indexOf("=") + 1, comando.length());

        try {

            path = "" + javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory() + "/MyVideos";
            path = path.replace("/", "\\");

            builders = null;
            z = null;

            builders = new ProcessBuilder("cmd.exe", "/c", "drone.exe --dump-single-json " + comando + " > " + path + "\\temp\\" + idVideo + ".json");
            builders.redirectErrorStream(true);
            z = builders.start();
            rs = new BufferedReader(new InputStreamReader(z.getInputStream()));
            String line = "";

            while (true) {
                line = rs.readLine();

                tabela.repaint();

                resposta = line;

                if (line == null) {

                    try {
                        System.out.println("Finalizou.... ");
                        JSONParser parser = new JSONParser();

                        path = "" + javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory() + "/MyVideos";
                        path = path.replace("/", "\\");
                        Object obj = parser.parse(new FileReader(path + "\\" + "temp\\" + idVideo + ".json"));
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
                                  + "</body>"
                                  + "</html>";

                        textArea.setText(textArea.getText() + webContent);

                        TableColumn col = new TableColumn(1, 80);

                        textArea.enable(false);

                        /////////////////////////////////////////
                        StyleSheet styleSheet = new StyleSheet();
                        styleSheet.addRule("body { margin:0;}");
                        styleSheet.addRule(".titulo {font-size: 16pt; color: gray;  width :100px;    text-overflow:    ellipsis; overflow: hidden;   font-weight: bold; }");
                        styleSheet.addRule(".like {font-size: 14pt; color: gray;   width :100px;  text-overflow:    ellipsis; overflow: hidden;}");

                        styleSheet.addRule(".time {font-size: 13pt; color: gray;  width :100px;   text-overflow:    ellipsis; overflow: hidden; }");

                        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                        htmlEditorKit.setStyleSheet(styleSheet);

                        textArea.setEditorKit(htmlEditorKit);
                        textArea.setText(webContent);
                        
                     

                       // model.setValueAt(new Object[]{textArea},0,0);

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

            JOptionPane.showMessageDialog(null, "" + e.getCause().getMessage(), "Erro MAINxNPEx0013", 0);
            textArea.setText("");

        } catch (NullPointerException e) {

        }

        try {

            builders = new ProcessBuilder("cmd.exe", "/c", "del  " + path + "\\temp\\" + "*.json");
            z = builders.start();

        } catch (Exception ex) {

        }

        return resposta;
    }
}
