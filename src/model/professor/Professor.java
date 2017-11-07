package model.professor;

public class Professor {

	private Long idProfessor;
	private Long cargahoraria;
	private Long matricula;
	private String nome;
	private String formacao;
	private String diasDisponiveis;
	private String horasDisponiveis;

	public Professor(Long idProfessor, String nome, Long matricula) {
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.matricula = matricula;
	}

	public Professor(String nome, Long matricula) {
		this.nome = nome;
		this.matricula = matricula;
		/* TODO: GENERATE id*/
	}

	public void setCargahoraria(Long cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFormacao( String formacao) {
		this.formacao = formacao;
	}

	public void setDiasDisponiveis(String diasDisponiveis) {
		this.diasDisponiveis = diasDisponiveis;
	}

	public void setHorasDisponiveis(String horasDisponiveis) {
		this.horasDisponiveis = horasDisponiveis;
	}

	public Long getIdProfessor() {
		return this.idProfessor;
	}

	public Long getCargahoraria() {
		return this.cargahoraria;
	}

	public Long getMatricula() {
		return this.matricula;
	}

	public Long getNome() {
		return this.nome;
	}

	public String getFormacao() {
		return this.formacao;
	}

	public String getDiasDisponiveis() {
		return this.diasDisponiveis;
	}

	public String getHorasDisponiveis() {
		return this.horasDisponiveis;
	}

}