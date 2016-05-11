package tiagojavaprogramador.drone.adapter;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import tiagojavaprogramador.drone.model.Video;
import tiagojavaprogramador.drone.model.VideoPanel;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class CellRenderers implements TableCellRenderer {

    VideoPanel videoPanel;
    Video contentVideo;
    Video value;

    public CellRenderers() {
        videoPanel = new VideoPanel();
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        this.contentVideo = (Video) value;

        videoPanel.updateData(contentVideo);

        return videoPanel;
    }
}
