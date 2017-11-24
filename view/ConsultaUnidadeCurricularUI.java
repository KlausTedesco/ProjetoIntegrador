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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.UnidadeCurricularController;
import dao.UnidadeCurricularDAO;
import model.UnidadeCurricular;
import model.UnidadeCurricularTableModel;
import java.awt.Font;

public class ConsultaUnidadeCurricularUI extends JInternalFrame {
	private JTextField jtfPesquisarUnidCurricular;
	private JTable jtListaUnidadeCurricular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUnidadeCurricularUI frame = new ConsultaUnidadeCurricularUI();
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
	public ConsultaUnidadeCurricularUI() {
		setTitle("Consulta Unidade Curricular");
		setClosable(true);
		setBounds(1, 1, 450, 308);
		
		JPanel jpConsultaUnidCurricular = new JPanel();
		jpConsultaUnidCurricular.setBorder(new TitledBorder(null, "Pesquisa de Unidade Curricular", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane jspTabelaConsultaUnidCurricular = new JScrollPane();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserirUnidadeCurricularUI unidadeCurricularUI = new InserirUnidadeCurricularUI();
				getParent().add(unidadeCurricularUI,0);
				unidadeCurricularUI.setVisible(true);
				
			}
		});
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = jtListaUnidadeCurricular.getSelectedRow();
				if(linhaSelecionada >= 0){
					UnidadeCurricular unidadeCurricular = new UnidadeCurricularTableModel(UnidadeCurricularDAO.obterInstancia().listaUnidadeCurriculares).get(linhaSelecionada);
					InserirUnidadeCurricularUI unidadeCurricularUI = new InserirUnidadeCurricularUI();
					unidadeCurricularUI.setUnidadeCurricularParaEdicao(unidadeCurricular);
					getParent().add(unidadeCurricularUI,0);
					unidadeCurricularUI.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Selecione uma unidade curricular");
				}
			}
		});
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int linhaSelecionada = jtListaUnidadeCurricular.getSelectedRow();
					if(linhaSelecionada >= 0){
						UnidadeCurricular unidadeCurricular = new UnidadeCurricularTableModel(UnidadeCurricularDAO.obterInstancia().listaUnidadeCurriculares).get(linhaSelecionada);
						new UnidadeCurricularController().remover(unidadeCurricular);
						JOptionPane.showMessageDialog(null, "Unidade curricular excluída com sucesso", "Exclusão da Unidade curricular",JOptionPane.WARNING_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Selecione uma unidade curricular");
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			
			}
		});		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<UnidadeCurricular> filtro = new UnidadeCurricularController().pesquisarUnidadeCurricularPorNome(jtfPesquisarUnidCurricular.getText());
				
				UnidadeCurricularTableModel modelUnidadeCurricular = new UnidadeCurricularTableModel(filtro);
				jtListaUnidadeCurricular.setModel(modelUnidadeCurricular);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jpConsultaUnidCurricular, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addComponent(jspTabelaConsultaUnidCurricular, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnExcluir)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpConsultaUnidCurricular, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jspTabelaConsultaUnidCurricular, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jtListaUnidadeCurricular = new JTable();
		jtListaUnidadeCurricular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		UnidadeCurricularTableModel modelUnidadeCurricular = new UnidadeCurricularTableModel(new UnidadeCurricularController().listarTodos());
		jtListaUnidadeCurricular.setModel(modelUnidadeCurricular);
		jspTabelaConsultaUnidCurricular.setViewportView(jtListaUnidadeCurricular);

		jtfPesquisarUnidCurricular = new JTextField();
		jtfPesquisarUnidCurricular.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<UnidadeCurricular> filtro = new UnidadeCurricularController().pesquisarUnidadeCurricularPorNome(jtfPesquisarUnidCurricular.getText());
				
				UnidadeCurricularTableModel modelUnidadeCurricular = new UnidadeCurricularTableModel(filtro);
				jtListaUnidadeCurricular.setModel(modelUnidadeCurricular);
			}
		});		
		GroupLayout gl_jpConsultaUnidCurricular = new GroupLayout(jpConsultaUnidCurricular);
		gl_jpConsultaUnidCurricular.setHorizontalGroup(
			gl_jpConsultaUnidCurricular.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jpConsultaUnidCurricular.createSequentialGroup()
					.addContainerGap()
					.addComponent(jtfPesquisarUnidCurricular, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesquisar)
					.addContainerGap())
		);
		gl_jpConsultaUnidCurricular.setVerticalGroup(
			gl_jpConsultaUnidCurricular.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jpConsultaUnidCurricular.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_jpConsultaUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPesquisar)
						.addComponent(jtfPesquisarUnidCurricular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		jpConsultaUnidCurricular.setLayout(gl_jpConsultaUnidCurricular);
		getContentPane().setLayout(groupLayout);

	}
}
