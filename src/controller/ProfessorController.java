package controller;

abstract class ProfessorController {

	public void salvar(Professor professor);
	
	public void editar(Professor professor, int id);
	
	public void remover(int id);
	
	public List<Produto> listarProfessor();

}