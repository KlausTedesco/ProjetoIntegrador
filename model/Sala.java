package model;

public class Sala {
	
	private int idSala;
	private String codigo;
	private int nMaximoAlunos;
	private String equipamentos;

	public Sala() {
	}

	public Sala(String codigo) {
		super();
		this.codigo = codigo;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getnMaximoAlunos() {
		return nMaximoAlunos;
	}

	public void setnMaximoAlunos(int nMaximoAlunos) {
		this.nMaximoAlunos = nMaximoAlunos;
	}

	public String getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}

	@Override
	public String toString() {
		return codigo;
	}
	
	

}
