package model.unidadecurricular;

public class UnidadeCurricular {

	private Long idUnidadeCurricular; 
	private Long codigo;
	private Long cargaHoraria;
	private String curso;
	private DateFormat dataInicio;
	private DateFormat dataFinal;

	public UnidadeCurricular(Long codigo, Long cargaHoraria, String curso, DateFormat dataInicio, DateFormat dataFinal) {
		this.codigo = codigo;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
		this.dataFinal = dataFinal;
		this.dataInicio = dataInicio;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setCargaHoraria(Long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setDataInicio(DateFormat dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFinal(DateFormat dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public Long getCargaHoraria() {
		return this.cargaHoraria;
	}

	public String getCurso() {
		return this.curso;
	}

	public DateFormat getDataInicio() {
		return this.dataInicio;
	}

	public DateFormat getDataFinal() {
		return this.dataFinal;
	}
}