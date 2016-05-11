package tiagojavaprogramador.drone.model;

import java.io.Serializable;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import tiagojavaprogramador.drone.model.Video;

/**
 * @author Tiago Alexandre Soares Aragão tiagojavaprogramador@gmail.com
 * http://tiagojavaprogramador.blogspot.com
 */
public class TableModel extends DefaultTableModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Video> feeds;

    public TableModel(List feeds) {
        this.feeds = feeds;
    }

    public Class getColumnClass(int columnIndex) {
        return Video.class;
    }

    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int columnIndex) {
        return "";
    }

    public int getRowCount() {
        return (feeds == null) ? 0 : feeds.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        return (feeds == null) ? null : feeds.get(rowIndex);
    }

    public void onAddAll(List<Video> dadosIn) {
        feeds.addAll(dadosIn);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

       // .out.println("Editando = linha: " + rowIndex + " - Coluna: " + columnIndex);
        return columnIndex < 2;
    }
     
   
}
