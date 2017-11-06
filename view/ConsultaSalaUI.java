package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
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
		setBounds(100, 100, 450, 300);
		
		JPanel jpPesquisaSala = new JPanel();
		jpPesquisaSala.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesquisa de Sala", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JScrollPane jspTabelaConsultaSala = new JScrollPane();
		
		JButton btnInserir = new JButton("Inserir");
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnExcluir = new JButton("Excluir");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpPesquisaSala, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(btnInserir)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnEditar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExcluir))
							.addComponent(jspTabelaConsultaSala, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(btnExcluir))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtListaSala = new JTable();
		jtListaSala.setModel(new DefaultTableModel(
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
				"C\u00F3digo / Nome", "Capacidade", "Equipamentos"
			}
		));
		jtListaSala.getColumnModel().getColumn(0).setPreferredWidth(108);
		jtListaSala.getColumnModel().getColumn(1).setPreferredWidth(98);
		jtListaSala.getColumnModel().getColumn(2).setPreferredWidth(109);
		jspTabelaConsultaSala.setViewportView(jtListaSala);
		
		jtfPesquisar = new JTextField();
		jtfPesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
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
