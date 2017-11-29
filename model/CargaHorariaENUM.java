package model;

public enum CargaHorariaENUM {
		
	CARGA_HORARIA_35(35),
	CARGA_HORARIA_70(70),
	CARGA_HORARIA_140(140),
	CARGA_HORARIA_280(280);
	
	private Integer cargaHoraria;
	
	private CargaHorariaENUM(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	

}
