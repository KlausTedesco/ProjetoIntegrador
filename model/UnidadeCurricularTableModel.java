package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UnidadeCurricularTableModel extends AbstractTableModel{
		
	private static final long serialVersionUID = 1L;
	private static final int COL_CODIGO_UNIDADE = 0;
	private static final int COL_NOME_CURSO = 1;
	private static final int COL_FASE_CURSO = 2;

	private List<UnidadeCurricular> valores;       

	public UnidadeCurricularTableModel(List<UnidadeCurricular> valores) {
		this.valores = new ArrayList<UnidadeCurricular>(valores);
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {

		if (column == COL_CODIGO_UNIDADE) return "Unidade Curricular";
		if (column == COL_NOME_CURSO) return "Curso";
		if (column == COL_FASE_CURSO) return "Fase / Semestre";
		return ""; 
	}

	public Object getValueAt(int row, int column) {
		UnidadeCurricular unidadeCurricular = valores.get(row);
		if (column == COL_CODIGO_UNIDADE) 
				return unidadeCurricular.getCodigoUnidade();
		else 
			if (column == COL_NOME_CURSO) 
				return unidadeCurricular.getNomeCurso();
			else 
				if (column == COL_FASE_CURSO) 
					return unidadeCurricular.getFaseCurso();
		return "";
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		UnidadeCurricular unidadeCurricular = valores.get(rowIndex);
		if (columnIndex == COL_CODIGO_UNIDADE) 
			unidadeCurricular.setCodigoUnidade(aValue.toString());
		else 
			if (columnIndex == COL_NOME_CURSO) 
				unidadeCurricular.setNomeCurso(aValue.toString());
			else 
				if (columnIndex == COL_FASE_CURSO) 
					unidadeCurricular.setFaseCurso(Integer.parseInt(aValue.toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	public UnidadeCurricular get(int row) {
		return valores.get(row);
	}

}
