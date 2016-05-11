package tiagojavaprogramador.drone.adapter;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import tiagojavaprogramador.drone.model.Video;
import tiagojavaprogramador.drone.model.VideoPanel;

/**  @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com - http://tiagojavaprogramador.blogspot.com */

public class RssFeedCellEditor extends AbstractCellEditor implements TableCellEditor {
  VideoPanel feedComponent;
 
  public RssFeedCellEditor() {
    feedComponent = new VideoPanel();
  }
 
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    Video feed = (Video)value;
    feedComponent.updateData(feed);
    return feedComponent;
  }
 
  public Object getCellEditorValue() {
    return null;
  }
}
