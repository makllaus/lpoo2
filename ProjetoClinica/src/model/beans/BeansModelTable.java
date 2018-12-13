package model.beans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BeansModelTable extends AbstractTableModel {
    private ArrayList linhas = null;
    private String[] colunas = null;

    public BeansModelTable(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linha) {
        this.linhas = linha;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linha = (Object[])getLinhas().get(rowIndex);
        return linha[columnIndex];
    }
    
}
