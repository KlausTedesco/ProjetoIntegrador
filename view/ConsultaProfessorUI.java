package view;

import java.awt.EventQueue;
import java.awt.Font;




import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




import controller.ProfessorController;
import controller.SalaController;
import dao.ProfessorDAO;
import dao.SalaDAO;
import model.Professor;
import model.ProfessorTableModel;
import model.Sala;
import model.SalaTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultaProfessorUI extends JInternalFrame {
	private JTextField jtfPesquisaDeProfessor;
	private JTable jtListaProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProfessorUI frame = new ConsultaProfessorUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaProfessorUI() {
		setTitle("Consulta Professor");
		setClosable(true);
		setBounds(1, 1, 450, 300);
		
		JPanel jpPesquisaProfessor = new JPanel();
		jpPesquisaProfessor.setBorder(new TitledBorder(null, "Pesquisa de Professor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane jspTabelaConsultaProfessor = new JScrollPane();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.addActionListener( arg -> {
			InserirProfessorUI ui = new InserirProfessorUI();
			getParent().add(ui,0);
			ui.setVisible(true);
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.addActionListener( arg -> {
			int linhaSelecionada = jtListaProfessor.getSelectedRow();
			if(linhaSelecionada >= 0){
				Professor prof = new ProfessorTableModel(ProfessorDAO.obterInstancia().listarTodos()).get(linhaSelecionada);
				InserirProfessorUI ui = new InserirProfessorUI();
				ui.setProfessorParaEdicao(prof);
				getParent().add(ui,0);
				ui.setVisible(true);
			}
			
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener( arg ->{
			try {
				int linhaSelecionada = jtListaProfessor.getSelectedRow();
					if(linhaSelecionada >= 0){
					Professor prof = new ProfessorTableModel(ProfessorDAO.obterInstancia().listaProfessores).get(linhaSelecionada);
					new ProfessorController().remover(prof);
					JOptionPane.showMessageDialog(null, "Professor excluída com sucesso", "Exclusão de Professor",JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um Professor");
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Professor> filtro = new ProfessorController().pesquisarProfessorPorNome(jtfPesquisaDeProfessor.getText());
				
				ProfessorTableModel modelProfessor = new ProfessorTableModel(filtro);
				jtListaProfessor.setModel(modelProfessor);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpPesquisaProfessor, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(btnInserir)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEditar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAtualizar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExcluir))
							.addComponent(jspTabelaConsultaProfessor, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpPesquisaProfessor, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jspTabelaConsultaProfessor, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtListaProfessor = new JTable();
		ProfessorTableModel tableModel = new ProfessorTableModel(new ProfessorController().listarTodos());
		
		jtListaProfessor.setModel(tableModel);
		jtListaProfessor.getColumnModel().getColumn(1).setPreferredWidth(207);
		jtListaProfessor.getColumnModel().getColumn(2).setPreferredWidth(103);
		jspTabelaConsultaProfessor.setViewportView(jtListaProfessor);
		
		jtfPesquisaDeProfessor = new JTextField();
		jtfPesquisaDeProfessor.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Professor> filtro = new ProfessorController().pesquisarProfessorPorNome(jtfPesquisaDeProfessor.getText());
				
				ProfessorTableModel modelProfessor = new ProfessorTableModel(filtro);
				jtListaProfessor.setModel(modelProfessor);
			}
		});
		GroupLayout gl_jpPesquisaProfessor = new GroupLayout(jpPesquisaProfessor);
		gl_jpPesquisaProfessor.setHorizontalGroup(
			gl_jpPesquisaProfessor.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jpPesquisaProfessor.createSequentialGroup()
					.addContainerGap()
					.addComponent(jtfPesquisaDeProfessor, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(btnPesquisar)
					.addContainerGap())
		);
		gl_jpPesquisaProfessor.setVerticalGroup(
			gl_jpPesquisaProfessor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPesquisaProfessor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpPesquisaProfessor.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfPesquisaDeProfessor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		jpPesquisaProfessor.setLayout(gl_jpPesquisaProfessor);
		getContentPane().setLayout(groupLayout);

	}
}
