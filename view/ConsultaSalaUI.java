package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.SalaController;
import dao.SalaDAO;
import model.Sala;
import model.SalaTableModel;
import java.awt.Font;

public class ConsultaSalaUI extends JInternalFrame {
	private JTextField jtfPesquisar;
	private JTable jtListaSala;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaSalaUI frame = new ConsultaSalaUI();
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
	public ConsultaSalaUI() {
		setTitle("Consulta Sala");
		setClosable(true);
		setBounds(1, 1, 450, 300);
		
		JPanel jpPesquisaSala = new JPanel();
		jpPesquisaSala.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesquisa de Sala", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JScrollPane jspTabelaConsultaSala = new JScrollPane();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserirSalaUI salaUI = new InserirSalaUI();
				getParent().add(salaUI,0);
				salaUI.setVisible(true);
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = jtListaSala.getSelectedRow();
				if(linhaSelecionada >= 0){
					Sala sala = new SalaTableModel(SalaDAO.obterInstancia().listaSalas).get(linhaSelecionada);
					InserirSalaUI salaUI = new InserirSalaUI();
					salaUI.setSalaParaEdicao(sala);
					getParent().add(salaUI,0);
					salaUI.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Selecione uma Sala");
				}
			}
		});
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int linhaSelecionada = jtListaSala.getSelectedRow();
						if(linhaSelecionada >= 0){
						Sala sala = new SalaTableModel(SalaDAO.obterInstancia().listaSalas).get(linhaSelecionada);
						new SalaController().remover(sala);
						JOptionPane.showMessageDialog(null, "Sala excluída com sucesso", "Exclusão da Sala",JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Selecione uma Sala");
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Sala> filtro = new SalaController().pesquisarSalaPorNome(jtfPesquisar.getText());
				
				SalaTableModel modelSala = new SalaTableModel(filtro);
				jtListaSala.setModel(modelSala);
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpPesquisaSala, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnInserir)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEditar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnAtualizar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExcluir))
							.addComponent(jspTabelaConsultaSala, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpPesquisaSala, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jspTabelaConsultaSala, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtListaSala = new JTable();
		SalaTableModel modelSala = new SalaTableModel(new SalaController().listarTodos());
		jtListaSala.setModel(modelSala);
		jspTabelaConsultaSala.setViewportView(jtListaSala);

		jtfPesquisar = new JTextField();
		jtfPesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Sala> filtro = new SalaController().pesquisarSalaPorNome(jtfPesquisar.getText());
				
				SalaTableModel modelSala = new SalaTableModel(filtro);
				jtListaSala.setModel(modelSala);
			}
		});		
		GroupLayout gl_jpPesquisaSala = new GroupLayout(jpPesquisaSala);
		gl_jpPesquisaSala.setHorizontalGroup(
			gl_jpPesquisaSala.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPesquisaSala.createSequentialGroup()
					.addContainerGap()
					.addComponent(jtfPesquisar, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_jpPesquisaSala.setVerticalGroup(
			gl_jpPesquisaSala.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPesquisaSala.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpPesquisaSala.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		jpPesquisaSala.setLayout(gl_jpPesquisaSala);
		getContentPane().setLayout(groupLayout);

	}
}
