package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EditarDistribuicaoUI extends JInternalFrame {
	private JTable jtDistribuicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarDistribuicaoUI frame = new EditarDistribuicaoUI();
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
	public EditarDistribuicaoUI() {
		setTitle("Editar Distribui\u00E7\u00E3o de Salas");
		setClosable(true);
		setBounds(1, 1, 450, 300);
		
		JPanel jpDistribuicao = new JPanel();
		jpDistribuicao.setBorder(new TitledBorder(null, "Distribui\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnGerarRelatorio = new JButton("Gerar Relatorio");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpDistribuicao, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(145)
							.addComponent(btnGerarRelatorio)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpDistribuicao, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnGerarRelatorio)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JScrollPane jspDistribuicao = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnExcluir = new JButton("Excluir");
		
		JButton btnRegistrarNovo = new JButton("Registrar Novo");
		GroupLayout gl_jpDistribuicao = new GroupLayout(jpDistribuicao);
		gl_jpDistribuicao.setHorizontalGroup(
			gl_jpDistribuicao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDistribuicao.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpDistribuicao.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jspDistribuicao, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jpDistribuicao.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(18)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnRegistrarNovo)))
					.addContainerGap())
		);
		gl_jpDistribuicao.setVerticalGroup(
			gl_jpDistribuicao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDistribuicao.createSequentialGroup()
					.addComponent(jspDistribuicao, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDistribuicao.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnRegistrarNovo)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtDistribuicao = new JTable();
		jspDistribuicao.setViewportView(jtDistribuicao);
		jpDistribuicao.setLayout(gl_jpDistribuicao);
		getContentPane().setLayout(groupLayout);

	}

}
