
import tiagojavaprogramador.drone.adapter.*;
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

    public void onAddAll(List<Video> dadosIn) {
        feeds.addAll(dadosIn);
        fireTableDataChanged();
    }

}
