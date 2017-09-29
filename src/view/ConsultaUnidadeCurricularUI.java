package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
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
		setBounds(100, 100, 450, 308);
		
		JPanel jpConsultaUnidCurricular = new JPanel();
		jpConsultaUnidCurricular.setBorder(new TitledBorder(null, "Pesquisa de Unidade Curricular", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane jspTabelaConsultaUnidCurricular = new JScrollPane();
		
		JButton btnInserir = new JButton("Inserir");
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnExcluir = new JButton("Excluir");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpConsultaUnidCurricular, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addComponent(jspTabelaConsultaUnidCurricular, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
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
						.addComponent(btnExcluir))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		jtListaUnidadeCurricular = new JTable();
		jtListaUnidadeCurricular.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Unidade Curricular", "Curso", "Fase/Semestre"
			}
		));
		jtListaUnidadeCurricular.getColumnModel().getColumn(0).setPreferredWidth(137);
		jtListaUnidadeCurricular.getColumnModel().getColumn(1).setPreferredWidth(149);
		jspTabelaConsultaUnidCurricular.setViewportView(jtListaUnidadeCurricular);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		
		jtfPesquisarUnidCurricular = new JTextField();
		jtfPesquisarUnidCurricular.setColumns(10);
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
