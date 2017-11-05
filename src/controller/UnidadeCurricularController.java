package controller;

abstract class UnidadeCurricularController {

	public void salvar(UnidadeCurricular unidadeCurricular);
	
	public void editar(UnidadeCurricular unidadeCurricular, int id);
	
	public void remover(int id);
	
	public List<Produto> listarUnidadeCurricular();

}