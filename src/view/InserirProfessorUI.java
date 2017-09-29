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
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class InserirProfessorUI extends JInternalFrame {
	private JTextField jtfNome;
	private JTextField jtfMatricula;
	private JTextField jtfFormacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirProfessorUI frame = new InserirProfessorUI();
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
	public InserirProfessorUI() {
		setClosable(true);
		setTitle("Inserir Professor");
		setBounds(100, 100, 747, 438);
		
		JPanel jpDadosProfessor = new JPanel();
		jpDadosProfessor.setBorder(new TitledBorder(null, "Dados Professor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnExcluir = new JButton("Excluir");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpDadosProfessor, GroupLayout.PREFERRED_SIZE, 410, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
							.addComponent(btnExcluir)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpDadosProfessor, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnExcluir))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel("Nome:");
		
		jtfNome = new JTextField();
		jtfNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula: ");
		
		jtfMatricula = new JTextField();
		jtfMatricula.setColumns(10);
		
		JLabel lblCargaHoraria = new JLabel("Carga horaria:");
		
		JLabel lblFormacao = new JLabel("Forma\u00E7\u00E3o:");
		
		jtfFormacao = new JTextField();
		jtfFormacao.setColumns(10);
		
		JComboBox jcbCargaHorariaMensal = new JComboBox();
		jcbCargaHorariaMensal.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50", "60"}));
		
		JLabel lblDiasDaSemana = new JLabel("Dia(s) da semana:");
		
		JCheckBox chckbxSegundafeira = new JCheckBox("Segunda-feira");
		
		JCheckBox chckbxTercafeira = new JCheckBox("Ter\u00E7a-feira");
		
		JCheckBox chckbxQuartafeira = new JCheckBox("Quarta-feira");
		
		JCheckBox chckbxQuintafeira = new JCheckBox("Quinta-feira");
		
		JCheckBox chckbxSextafeira = new JCheckBox("Sexta-feira");
		
		JCheckBox chckbxSabdo = new JCheckBox("Sab\u00E1do");
		
		JCheckBox chckbxDomingo = new JCheckBox("Domingo");
		
		JPanel jpHorarios = new JPanel();
		jpHorarios.setBorder(new TitledBorder(null, "Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_jpDadosProfessor = new GroupLayout(jpDadosProfessor);
		gl_jpDadosProfessor.setHorizontalGroup(
			gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDadosProfessor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
						.addComponent(jtfNome, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
						.addGroup(gl_jpDadosProfessor.createSequentialGroup()
							.addComponent(chckbxSegundafeira)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxTercafeira)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxQuartafeira)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxQuintafeira)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSextafeira)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSabdo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxDomingo))
						.addComponent(lblNome)
						.addGroup(gl_jpDadosProfessor.createSequentialGroup()
							.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatricula)
								.addComponent(jtfMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jcbCargaHorariaMensal, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCargaHoraria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpDadosProfessor.createSequentialGroup()
									.addComponent(lblFormacao)
									.addGap(54))
								.addComponent(jtfFormacao, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)))
						.addComponent(lblDiasDaSemana)
						.addComponent(jpHorarios, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_jpDadosProfessor.setVerticalGroup(
			gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDadosProfessor.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatricula)
						.addComponent(lblCargaHoraria)
						.addComponent(lblFormacao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfFormacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcbCargaHorariaMensal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDiasDaSemana)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxSegundafeira)
						.addComponent(chckbxTercafeira)
						.addComponent(chckbxQuartafeira)
						.addComponent(chckbxQuintafeira)
						.addComponent(chckbxSextafeira)
						.addComponent(chckbxSabdo)
						.addComponent(chckbxDomingo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jpHorarios, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JCheckBox chckbxAula1 = new JCheckBox("Aula 1 - 08:00 as 08:55");
		
		JCheckBox chckbxAula2 = new JCheckBox("Aula 2 - 08:55 as 09:45");
		
		JCheckBox chckbxAula3 = new JCheckBox("Aula 3 - 09:45 as 10:40");
		
		JCheckBox chckbxAula4 = new JCheckBox("Aula 4 - 10:40 as 11:30");
		
		JCheckBox chckbxAula5 = new JCheckBox("Aula 5 - 13:00 as 13:55");
		
		JCheckBox chckbxAula6 = new JCheckBox("Aula 6 - 13:55 as 14:45");
		
		JCheckBox chckbxAula7 = new JCheckBox("Aula 7 - 14:45 as 15:40");
		
		JCheckBox chckbxAula8 = new JCheckBox("Aula 8 - 15:40 as 16:30");
		
		JCheckBox chckbxAula9 = new JCheckBox("Aula 9 - 19:00 as 19:55");
		
		JCheckBox chckbxAula10 = new JCheckBox("Aula 10 - 19:55 as 20:45");
		
		JCheckBox chckbxAula11 = new JCheckBox("Aula 11 - 20:45 as 21:30");
		
		JCheckBox chckbxAula12 = new JCheckBox("Aula 12 - 21:30 as 22:30");
		GroupLayout gl_jpHorarios = new GroupLayout(jpHorarios);
		gl_jpHorarios.setHorizontalGroup(
			gl_jpHorarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpHorarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpHorarios.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAula1)
						.addComponent(chckbxAula2)
						.addComponent(chckbxAula3)
						.addComponent(chckbxAula4))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(gl_jpHorarios.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAula5)
						.addComponent(chckbxAula6)
						.addComponent(chckbxAula7)
						.addComponent(chckbxAula8))
					.addGap(69)
					.addGroup(gl_jpHorarios.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAula9)
						.addComponent(chckbxAula10)
						.addComponent(chckbxAula11)
						.addComponent(chckbxAula12))
					.addContainerGap())
		);
		gl_jpHorarios.setVerticalGroup(
			gl_jpHorarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpHorarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpHorarios.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpHorarios.createSequentialGroup()
							.addComponent(chckbxAula5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula8))
						.addGroup(gl_jpHorarios.createSequentialGroup()
							.addComponent(chckbxAula9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula10)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula11)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula12))
						.addGroup(gl_jpHorarios.createSequentialGroup()
							.addComponent(chckbxAula1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxAula4)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		jpHorarios.setLayout(gl_jpHorarios);
		jpDadosProfessor.setLayout(gl_jpDadosProfessor);
		getContentPane().setLayout(groupLayout);

	}
}
