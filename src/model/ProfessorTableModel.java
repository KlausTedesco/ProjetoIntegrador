package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {
		
	private static final long serialVersionUID = 1L;
	private static final int COL_MATRICULA = 0;
	private static final int COL_NOME = 1;
	private static final int COL_CARGA_HORARIA = 2;

	private List<Professor> valores;       

	public ProfessorTableModel(List<Professor> valores) {
		this.valores = new ArrayList<Professor>(valores);
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {

		if (column == COL_MATRICULA) return "Matricula";
		if (column == COL_NOME) return "Nome Professor";
		if (column == COL_CARGA_HORARIA) return "Carga Horaria";
		return ""; 
	}

	public Object getValueAt(int row, int column) {
		Professor professor = valores.get(row);
		if (column == COL_MATRICULA)
			return professor.getMatricula();
		else 
			if (column == COL_NOME) 
					return professor.getNome();
			else 
				if (column == COL_CARGA_HORARIA) 
					return professor.getCargaHorariaContratada();
		return "";
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Professor professor = valores.get(rowIndex);
		if (columnIndex == COL_MATRICULA)
			professor.setMatricula(aValue.toString());
		else 
			if (columnIndex == COL_NOME) 
				professor.setNome(aValue.toString());
			else 
				if (columnIndex == COL_CARGA_HORARIA) 
					professor.setCargaHorariaContratada(Double.parseDouble(aValue.toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public Professor get(int row) {
		return valores.get(row);
	}

}
