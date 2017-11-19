package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.ClienteController;
import controller.ProfessorController;
import model.Cliente;
import static model.Horario.*;
import model.Professor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;

public class InserirProfessorUI extends JInternalFrame {
	private JTextField jtfNome;
	private JTextField jtfMatricula;
	private JTextField jtfFormacao;
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
		setBounds(100, 100, 747, 438);
		
		JPanel jpDadosProfessor = new JPanel();
		jpDadosProfessor.setBorder(new TitledBorder(null, "Dados Professor", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JComboBox jcbCargaHorariaMensal = new JComboBox();
		jcbCargaHorariaMensal.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50", "60"}));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (professorParaEdicao == null){
					Professor professor = new Professor();
					professor.setNome(jtfNome.getText());
					professor.setMatricula(jtfMatricula.getText());
					professor.setCargaHorariaContratada(Double.parseDouble(jcbCargaHorariaMensal.getSelectedItem().toString()));
					professor.setFormacao(jtfFormacao.getText());
					//professor.setDiaSemana(.getText());
					professor.setFormacao(jtfFormacao.getText());
					
					new ProfessorController().salvar(professor);
					
					JOptionPane.showMessageDialog(null, "Professor Cadastrado com sucesso");
				}else{
					professorParaEdicao.setNome(jtfNome.getText());
					//professorParaEdicao.setCpf(jtfCpf.getText());
					//professorParaEdicao.setTelefone(jtfTelefone.getText());
					//professorParaEdicao.setEndereco(jtfEndereco.getText());
					
					new ProfessorController().editar(professorParaEdicao);

					JOptionPane.showMessageDialog(null, "Professor Editado com sucesso");
				}
				dispose();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
						.addComponent(btnLimpar))
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
		
		
		JLabel lblDiasDaSemana = new JLabel("Dia(s) da semana:");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_jpDadosProfessor = new GroupLayout(jpDadosProfessor);
		gl_jpDadosProfessor.setHorizontalGroup(
			gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDadosProfessor.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpDadosProfessor.createSequentialGroup()
							.addGap(10)
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
						.addGroup(gl_jpDadosProfessor.createSequentialGroup()
							.addGroup(gl_jpDadosProfessor.createParallelGroup(Alignment.LEADING)
								.addComponent(jtfNome, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
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
										.addComponent(jtfFormacao, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)))
								.addComponent(lblDiasDaSemana))
							.addContainerGap())))
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
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Segunda-feira", null, panel, null);
		this.setTabCheckBoxs(panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Terça-feira", null, panel_1, null);
		this.setTabCheckBoxs(panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Quarta-feira", null, panel_2, null);
		this.setTabCheckBoxs(panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Quinta-feira", null, panel_3, null);
		this.setTabCheckBoxs(panel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Sexta-feira", null, panel_4, null);
		this.setTabCheckBoxs(panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Sábado", null, panel_5, null);
		this.setTabCheckBoxs(panel_5);
		
		jpDadosProfessor.setLayout(gl_jpDadosProfessor);
		getContentPane().setLayout(groupLayout);

	}
	
	private void setTabCheckBoxs(JPanel panel) {
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox(AULA1.getNome());
		panel.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox(AULA2.getNome());
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox(AULA3.getNome());
		panel.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox(AULA4.getNome());
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox(AULA5.getNome());
		panel.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox(AULA6.getNome());
		panel.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox(AULA7.getNome());
		panel.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox(AULA8.getNome());
		panel.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(AULA9.getNome());
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox(AULA10.getNome());
		panel.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox(AULA11.getNome());
		panel.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox(AULA12.getNome());
		panel.add(chckbxNewCheckBox_11);
		
	}
}
