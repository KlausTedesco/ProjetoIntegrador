package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExecutarUI extends JInternalFrame {
	private JTable jtAssociacoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExecutarUI frame = new ExecutarUI();
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
	public ExecutarUI() {
		setClosable(true);
		setTitle("Inserir Dados da Distribui\u00E7\u00E3o Autom\u00E1tica de Sala");
		setBounds(1, 1, 450, 400);
		
		JPanel panelRegistrarAssociacao = new JPanel();
		panelRegistrarAssociacao.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registrar Associa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panelConsultarAssociacoes = new JPanel();
		panelConsultarAssociacoes.setBorder(new TitledBorder(null, "Consultar Associa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnExecutar = new JButton("Executar Distribui\u00E7\u00E3o");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnExcluirAssociao = new JButton("Excluir Associa\u00E7\u00E3o");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelRegistrarAssociacao, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelConsultarAssociacoes, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnExecutar)
							.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
							.addComponent(btnExcluirAssociao)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelRegistrarAssociacao, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelConsultarAssociacoes, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExecutar)
						.addComponent(btnExcluirAssociao))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane jspAssociacoes = new JScrollPane();
		GroupLayout gl_panelConsultarAssociacoes = new GroupLayout(panelConsultarAssociacoes);
		gl_panelConsultarAssociacoes.setHorizontalGroup(
			gl_panelConsultarAssociacoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsultarAssociacoes.createSequentialGroup()
					.addContainerGap()
					.addComponent(jspAssociacoes, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panelConsultarAssociacoes.setVerticalGroup(
			gl_panelConsultarAssociacoes.createParallelGroup(Alignment.LEADING)
				.addComponent(jspAssociacoes, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
		);
		
		jtAssociacoes = new JTable();
		jspAssociacoes.setViewportView(jtAssociacoes);
		panelConsultarAssociacoes.setLayout(gl_panelConsultarAssociacoes);
		
		JLabel lblProfessor = new JLabel("Professor:");
		
		JLabel lblCargaHoraria = new JLabel("Carga Horaria:");
		
		JLabel lblUnidadeCurricular = new JLabel("Unidade Curricular:");
		
		JComboBox jcbProfessor = new JComboBox();
		
		JComboBox jcbCargaHoraria = new JComboBox();
		
		JComboBox jcbUnidadeCurricular = new JComboBox();
		
		JButton btnAdicionar = new JButton("Adicionar");
		GroupLayout gl_panelRegistrarAssociacao = new GroupLayout(panelRegistrarAssociacao);
		gl_panelRegistrarAssociacao.setHorizontalGroup(
			gl_panelRegistrarAssociacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRegistrarAssociacao.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRegistrarAssociacao.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegistrarAssociacao.createSequentialGroup()
							.addComponent(lblUnidadeCurricular, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(274))
						.addGroup(gl_panelRegistrarAssociacao.createSequentialGroup()
							.addGroup(gl_panelRegistrarAssociacao.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(jcbUnidadeCurricular, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblProfessor, Alignment.LEADING)
								.addComponent(jcbProfessor, Alignment.LEADING, 0, 263, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panelRegistrarAssociacao.createParallelGroup(Alignment.TRAILING)
								.addComponent(jcbCargaHoraria, 0, 94, Short.MAX_VALUE)
								.addComponent(lblCargaHoraria, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(btnAdicionar, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_panelRegistrarAssociacao.setVerticalGroup(
			gl_panelRegistrarAssociacao.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRegistrarAssociacao.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRegistrarAssociacao.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProfessor)
						.addComponent(lblCargaHoraria))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRegistrarAssociacao.createParallelGroup(Alignment.BASELINE)
						.addComponent(jcbProfessor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcbCargaHoraria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUnidadeCurricular, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRegistrarAssociacao.createParallelGroup(Alignment.BASELINE)
						.addComponent(jcbUnidadeCurricular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionar))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panelRegistrarAssociacao.setLayout(gl_panelRegistrarAssociacao);
		getContentPane().setLayout(groupLayout);

	}
}
