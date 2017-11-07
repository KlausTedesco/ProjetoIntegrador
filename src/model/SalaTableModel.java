package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SalaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private static final int COL_CODIGO = 0;
	private static final int COL_NUMERO_MAXIMO_ALUNOS = 1;
	private static final int COL_EQUIPAMENTOS = 2;

	private List<Sala> valores;       

	public SalaTableModel(List<Sala> valores) {
		this.valores = new ArrayList<Sala>(valores);
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {

		if (column == COL_CODIGO) return "Código";
		if (column == COL_NUMERO_MAXIMO_ALUNOS) return "Capacidade";
		if (column == COL_EQUIPAMENTOS) return "Equipamentos";
		return ""; 
	}

	public Object getValueAt(int row, int column) {
		Sala sala = valores.get(row);
		if (column == COL_CODIGO)
			return sala.getCodigo();
		else 
			if (column == COL_NUMERO_MAXIMO_ALUNOS) 
					return sala.getnMaximoAlunos();
			else 
				if (column == COL_EQUIPAMENTOS) 
					return sala.getEquipamentos();
		return "";
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Sala sala = valores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			sala.setCodigo(aValue.toString());
		else 
			if (columnIndex == COL_NUMERO_MAXIMO_ALUNOS) 
				sala.setnMaximoAlunos(Integer.parseInt(aValue.toString()));
			else 
				if (columnIndex == COL_EQUIPAMENTOS) 
					sala.setEquipamentos(aValue.toString());
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public Sala get(int row) {
		return valores.get(row);
	}

}
