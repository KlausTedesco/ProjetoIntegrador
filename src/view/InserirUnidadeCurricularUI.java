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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class InserirUnidadeCurricularUI extends JInternalFrame {
	private JTextField jtfUnidadeCurricular;
	private JTextField jtfCurso;
	private JTextField jtfCargaHorariaCurso;
	private JTextField jtfDataInicial;
	private JTextField jtfDataFinal;
	private JTextField jtfNumeroAlunos;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirUnidadeCurricularUI frame = new InserirUnidadeCurricularUI();
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
	public InserirUnidadeCurricularUI() {
		setTitle("Inserir Unidade Curricular");
		setClosable(true);
		setBounds(100, 100, 548, 350);
		
		JPanel jpDadosUnidCurricular = new JPanel();
		jpDadosUnidCurricular.setBorder(new TitledBorder(null, "Dados da Unidade Curricular", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnLimpar = new JButton("Limpar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpDadosUnidCurricular, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
							.addComponent(btnLimpar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpDadosUnidCurricular, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLimpar)
						.addComponent(btnSalvar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblUnidadeCurricular = new JLabel("Unidade Curricular: ");
		
		jtfUnidadeCurricular = new JTextField();
		jtfUnidadeCurricular.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		
		jtfCurso = new JTextField();
		jtfCurso.setColumns(10);
		
		JLabel lblFaseSemestre = new JLabel("Fase/Semestre:");
		
		JComboBox jcbFaseSemestre = new JComboBox();
		jcbFaseSemestre.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		
		JLabel lblCargaHoraria = new JLabel("Carga horaria:");
		
		jtfCargaHorariaCurso = new JTextField();
		jtfCargaHorariaCurso.setColumns(10);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		
		jtfDataInicial = new JTextField();
		jtfDataInicial.setColumns(10);
		
		JLabel lblDataFinal = new JLabel("Data final:");
		
		jtfDataFinal = new JTextField();
		jtfDataFinal.setColumns(10);
		
		JLabel lblNumeroAlunos = new JLabel("Numero de alunos: ");
		
		jtfNumeroAlunos = new JTextField();
		jtfNumeroAlunos.setColumns(10);
		
		JLabel lblEquipamentos = new JLabel("Equipamentos: ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSelecionarProfessor = new JButton("Selecionar Professor");
		GroupLayout gl_jpDadosUnidCurricular = new GroupLayout(jpDadosUnidCurricular);
		gl_jpDadosUnidCurricular.setHorizontalGroup(
			gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblUnidadeCurricular)
									.addComponent(lblCurso)
									.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
										.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(jcbFaseSemestre, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblFaseSemestre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING, false)
											.addComponent(jtfCargaHorariaCurso, 0, 0, Short.MAX_VALUE)
											.addComponent(lblCargaHoraria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
											.addComponent(jtfDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblDataInicial))
										.addGap(18)
										.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
											.addComponent(jtfDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblDataFinal)))
									.addComponent(jtfUnidadeCurricular)
									.addComponent(jtfCurso)
									.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
									.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jtfNumeroAlunos, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(lblNumeroAlunos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(lblEquipamentos))))
						.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
							.addGap(166)
							.addComponent(btnSelecionarProfessor)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_jpDadosUnidCurricular.setVerticalGroup(
			gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
					.addComponent(lblUnidadeCurricular)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtfUnidadeCurricular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCurso)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtfCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFaseSemestre)
						.addComponent(lblCargaHoraria)
						.addComponent(lblDataInicial)
						.addComponent(lblDataFinal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(jcbFaseSemestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfCargaHorariaCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroAlunos)
						.addComponent(lblEquipamentos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfNumeroAlunos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelecionarProfessor)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jpDadosUnidCurricular.setLayout(gl_jpDadosUnidCurricular);
		getContentPane().setLayout(groupLayout);

	}
}
