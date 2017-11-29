package view;

import static model.Horario.*;
import static model.Dia.*;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import model.Dia;
import model.DiaSemana;
import model.Horario;
import model.Professor;
import controller.ProfessorController;

public class InserirProfessorUI extends JInternalFrame {
	private JTextField jtfNome;
	private JTextField jtfMatricula;
	// private JTextField
	private JTextField jtfFormacao;
	private List<DiaSemana> diasSemana;
	private Map<Integer, DiaSemana> semanaMap;
	private Professor professorParaEdicao;

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
		setBounds(1, 1, 747, 438);

		JPanel jpDadosProfessor = new JPanel();
		jpDadosProfessor.setBorder(new TitledBorder(null, "Dados Professor",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JComboBox jcbCargaHorariaMensal = new JComboBox();
		jcbCargaHorariaMensal.setModel(new DefaultComboBoxModel(new String[] {
				"10", "20", "30", "40", "50", "60" }));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (professorParaEdicao == null) {
					Professor professor = new Professor();
					professor.setNome(jtfNome.getText());
					professor.setMatricula(jtfMatricula.getText());
					professor.setCargaHorariaContratada(Double.parseDouble(jcbCargaHorariaMensal.getSelectedItem().toString()));
					professor.setFormacao(jtfFormacao.getText());
					
					// professor.setDiaSemana(.getText());
					professor.setFormacao(jtfFormacao.getText());
					professor.setListaDiaSemana(new ArrayList<DiaSemana>(semanaMap.values()));

					new ProfessorController().salvar(professor);

					JOptionPane.showMessageDialog(null,
							"Professor Cadastrado com sucesso");
				} else {
					professorParaEdicao.setNome(jtfNome.getText());
					professorParaEdicao.setMatricula(jtfMatricula.getText());
					professorParaEdicao.setCargaHorariaContratada(Double
							.parseDouble(jcbCargaHorariaMensal
									.getSelectedItem().toString()));
					professorParaEdicao.setFormacao(jtfFormacao.getText());

					new ProfessorController().editar(professorParaEdicao);

					JOptionPane.showMessageDialog(null,
							"Professor Editado com sucesso");
				}
				dispose();
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnConsultarProfessores = new JButton("Consultar professores");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpDadosProfessor, GroupLayout.PREFERRED_SIZE, 707, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarProfessores)
							.addPreferredGap(ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
							.addComponent(btnLimpar)))
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
						.addComponent(btnLimpar)
						.addComponent(btnConsultarProfessores))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

		JLabel lblDiasDaSemana = new JLabel("Dia(s) da semana:");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_jpDadosProfessor = new GroupLayout(jpDadosProfessor);
		gl_jpDadosProfessor
				.setHorizontalGroup(gl_jpDadosProfessor
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jpDadosProfessor
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_jpDadosProfessor
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_jpDadosProfessor
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				tabbedPane,
																				GroupLayout.DEFAULT_SIZE,
																				679,
																				Short.MAX_VALUE))
														.addGroup(
																gl_jpDadosProfessor
																		.createSequentialGroup()
																		.addGroup(
																				gl_jpDadosProfessor
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								jtfNome,
																								GroupLayout.DEFAULT_SIZE,
																								679,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblNome)
																						.addGroup(
																								gl_jpDadosProfessor
																										.createSequentialGroup()
																										.addGroup(
																												gl_jpDadosProfessor
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblMatricula)
																														.addComponent(
																																jtfMatricula,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(18)
																										.addGroup(
																												gl_jpDadosProfessor
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																jcbCargaHorariaMensal,
																																0,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblCargaHoraria,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE))
																										.addGap(18)
																										.addGroup(
																												gl_jpDadosProfessor
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_jpDadosProfessor
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblFormacao)
																																		.addGap(54))
																														.addComponent(
																																jtfFormacao,
																																GroupLayout.DEFAULT_SIZE,
																																487,
																																Short.MAX_VALUE)))
																						.addComponent(
																								lblDiasDaSemana))
																		.addContainerGap()))));
		gl_jpDadosProfessor
				.setVerticalGroup(gl_jpDadosProfessor
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_jpDadosProfessor
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNome)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jtfNome,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jpDadosProfessor
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblMatricula)
														.addComponent(
																lblCargaHoraria)
														.addComponent(
																lblFormacao))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_jpDadosProfessor
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																jtfMatricula,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jtfFormacao,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jcbCargaHorariaMensal,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lblDiasDaSemana)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(tabbedPane,
												GroupLayout.DEFAULT_SIZE, 199,
												Short.MAX_VALUE)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Segunda-feira", null, panel, null);
		this.setTabCheckBoxs(panel, SEGUNDA);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Terça-feira", null, panel_1, null);
		this.setTabCheckBoxs(panel_1, TERCA);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Quarta-feira", null, panel_2, null);
		this.setTabCheckBoxs(panel_2, QUARTA);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Quinta-feira", null, panel_3, null);
		this.setTabCheckBoxs(panel_3, QUINTA);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Sexta-feira", null, panel_4, null);
		this.setTabCheckBoxs(panel_4, SEXTA);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Sábado", null, panel_5, null);
		this.setTabCheckBoxs(panel_5, SABADO);

		jpDadosProfessor.setLayout(gl_jpDadosProfessor);
		getContentPane().setLayout(groupLayout);

	}

	private void setTabCheckBoxs(JPanel panel, Dia dia) {
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox(AULA1.getNome());
		chckbxNewCheckBox_4.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA1));
		panel.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox(AULA2.getNome());
		chckbxNewCheckBox_1.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA2));
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox(AULA3.getNome());
		chckbxNewCheckBox_8.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA3));
		panel.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox(AULA4.getNome());
		chckbxNewCheckBox_2.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA4));
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox(AULA5.getNome());
		chckbxNewCheckBox_3.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA5));
		panel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox(AULA6.getNome());
		chckbxNewCheckBox_6.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA6));
		panel.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox(AULA7.getNome());
		chckbxNewCheckBox_9.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA7));
		panel.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox(AULA8.getNome());
		chckbxNewCheckBox_5.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA8));
		panel.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(AULA9.getNome());
		chckbxNewCheckBox.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA9));
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox(AULA10.getNome());
		chckbxNewCheckBox_7.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA10));
		panel.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox(AULA11.getNome());
		chckbxNewCheckBox_10.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(), AULA11));
		panel.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox(AULA12.getNome());
		chckbxNewCheckBox_11.addItemListener( action ->toggleDiaSemana(dia,action.getStateChange(),AULA2));
		panel.add(chckbxNewCheckBox_11);
	}
	
	public void toggleDiaSemana(Dia dia, int state, Horario horario) {
		
		if(semanaMap == null) {
			semanaMap = new HashMap<Integer, DiaSemana>();
		}
		
		if(state == 1) {	
			if(semanaMap.get(dia.getNumero()) == null) {
				semanaMap.put(dia.getNumero(), new DiaSemana(dia.getNome(), dia));
			}
			semanaMap.get(dia.getNumero()).setHorarios(horario);
		}else {
			System.out.println("Deleted: "+dia.getNome());
			semanaMap.get(dia.getNumero()).getHorarios().remove(horario);
		}
		
		printAll();
	 
	}
	
	public void printAll() {
		System.out.println("FIREDED");
		for(DiaSemana ds: new ArrayList<DiaSemana>(semanaMap.values())){
			for(Horario h: ds.getHorarios()){
				System.out.println("DIA: "+ ds.getNome() +", horario: "+ h.getNome());
			}
		}
	}
}
