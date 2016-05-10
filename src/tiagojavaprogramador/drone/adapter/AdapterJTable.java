package tiagojavaprogramador.drone.adapter;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tiagojavaprogramador.drone.model.Video;

/**
 * @author Tiago Alexandre Soares Aragão tiagojavaprogramador@gmail.com
 * http://tiagojavaprogramador.blogspot.com
 */
public class AdapterJTable extends AbstractTableModel {

    private final String colunas[] = {"Imagem:", "Titulo:", "Botao:", "ProgressBar:", "LINK:"};
    private final List<Video> dados;
    private final int IMAGEM = 0;
    private final int TITULO = 1;
    private final int BOTAO = 2;
    private final int PROGRESSBAR = 3;
    private final int LINKDOWNVIDEO = 4;

    public AdapterJTable(List<Video> dados) {
        this.dados = dados;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //retorna o tipo de dado, para cada coluna
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;

            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");

        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //retorna o valor conforme a coluna e linha

        //pega o dados corrente da linha
        Video video = dados.get(rowIndex);

        //retorna o valor da coluna
        switch (columnIndex) {
            case 0:
                return video.getUrlImage();
            case 1:
                return video.getDescVideo();
            case 2:
                return video.getLinkDownVideo();
            case 3:
                return video.getIdVideo();
            case 4:
                return video.getLinkVideo();

            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");

        }
    }

    public void onAdd(Video video) {
        dados.add(video);
        fireTableRowsInserted(indexOf(video), indexOf(video));
    }

    public int indexOf(Video video) {
        return dados.indexOf(video);
    }

    public void onAddAll(List<Video> dadosIn) {
        dados.addAll(dadosIn);
        fireTableDataChanged();
    }

    public void onRemoveAll() {
        dados.clear();
        fireTableDataChanged();
    }

}
