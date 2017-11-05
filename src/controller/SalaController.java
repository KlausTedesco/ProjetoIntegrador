package controller;

abstract class SalaController {

	public void salvar(Sala sala);
	
	public void editar(Sala sala, int id);
	
	public void remover(int id);
	
	public List<Produto> listarSala();

}