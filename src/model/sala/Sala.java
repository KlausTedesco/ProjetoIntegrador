package model.sala;

public class Sala {

	private Long idSala;
	private Long codigo;
	private Integer numeroAunos;
	private String equipamentos; 

	public Sala(Integer numeroAunos, Long codigo) {
		this.numeroAunos = numeroAunos;
		this.codigo = codigo;
	}

	public Sala(Long idSala, Integer numeroAunos, Long codigo) {
		this.idSala = idSala;
		this.numeroAunos = numeroAunos;
		this.codigo = codigo;
	}

	public void setCodigo(Long codigo){
		this.codigo = codigo;
	}

	public void setNumeroAunos(Integer numeroAunos){
		this.numeroAunos = numeroAunos;
	}

	public void setEquipamentos(String equipamentos){
		this.equipamentos = equipamentos;
	}

	public Long getCodigo(){
		return this.codigo;
	}

	public Integer getNumeroAunos(){
		return this.numeroAunos;
	}

	public String getEquipamentos(){
		return this.equipamentos;
	}
}