package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DistribuicaoAutomaticaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private static final int COL_PROFESSOR = 0;
	private static final int COL_UNIDADE_CURRICULAR = 1;
	private static final int COL_CARGA_HORARIA = 2;

	private List<DistribuicaoAutomatica> valores;       

	public DistribuicaoAutomaticaTableModel(List<DistribuicaoAutomatica> valores) {
		this.valores = new ArrayList<DistribuicaoAutomatica>(valores);
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {

		if (column == COL_PROFESSOR) return "Professor";
		if (column == COL_UNIDADE_CURRICULAR) return "Unidade Curricular";
		if (column == COL_CARGA_HORARIA) return "Carga Horaria";
		return ""; 
	}

	public Object getValueAt(int row, int column) {
		DistribuicaoAutomatica distribuicaoAutomatica = valores.get(row);
		if (column == COL_PROFESSOR)
			return distribuicaoAutomatica.getProfessor();
		else 
			if (column == COL_UNIDADE_CURRICULAR) 
					return distribuicaoAutomatica.getUnidadeCurricular();
			else 
				if (column == COL_CARGA_HORARIA) 
					return distribuicaoAutomatica.getCargaHoraria();
		return "";
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		DistribuicaoAutomatica distribuicaoAutomatica = valores.get(rowIndex);
		if (columnIndex == COL_PROFESSOR)
			distribuicaoAutomatica.getProfessor().setNome(aValue.toString());
		else 
			if (columnIndex == COL_UNIDADE_CURRICULAR) 
				distribuicaoAutomatica.getUnidadeCurricular().setCodigoUnidade(aValue.toString());
			else 
				if (columnIndex == COL_CARGA_HORARIA) 
					distribuicaoAutomatica.getCargaHoraria().getCargaHoraria();
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public DistribuicaoAutomatica get(int row) {
		return valores.get(row);
	}

}
