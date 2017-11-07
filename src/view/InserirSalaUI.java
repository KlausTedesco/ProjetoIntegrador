package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class InserirSalaUI extends JInternalFrame {
	private JTextField jtfCodigoSala;
	private JTextField jtfCapacidadeAluno;
	private JTextField jtfEquipamentoSala;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirSalaUI frame = new InserirSalaUI();
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
	public InserirSalaUI() {
		setClosable(true);
		setTitle("Inserir Sala");
		setBounds(100, 100, 450, 244);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados da Sala", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnConsultarSalasCadastradas = new JButton("Consultar salas cadastradas");
		
		JButton btnLimpar = new JButton("Limpar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(37)
							.addComponent(btnConsultarSalasCadastradas)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLimpar)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnLimpar)
						.addComponent(btnConsultarSalasCadastradas))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		
		JLabel lblCodigoNomeSala = new JLabel("C\u00F3digo/Nome da sala: ");
		
		jtfCodigoSala = new JTextField();
		jtfCodigoSala.setColumns(10);
		
		JLabel lblCapacidadeAluno = new JLabel("Capacidade de alunos:");
		
		jtfCapacidadeAluno = new JTextField();
		jtfCapacidadeAluno.setColumns(10);
		
		JLabel lblEquipamentoSala = new JLabel("Equipamentos disponiveis:");
		
		jtfEquipamentoSala = new JTextField();
		jtfEquipamentoSala.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCodigoNomeSala)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfCodigoSala, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCapacidadeAluno)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfCapacidadeAluno, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEquipamentoSala)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfEquipamentoSala, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoNomeSala)
						.addComponent(jtfCodigoSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfCapacidadeAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCapacidadeAluno))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEquipamentoSala)
						.addComponent(jtfEquipamentoSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
