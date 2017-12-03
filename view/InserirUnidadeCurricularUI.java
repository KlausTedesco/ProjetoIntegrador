package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import controller.UnidadeCurricularController;
import model.UnidadeCurricular;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class InserirUnidadeCurricularUI extends JInternalFrame {
	private JTextField jtfUnidadeCurricular;
	private JTextField jtfCurso;
	private JTextField jtfDataInicial;
	private JTextField jtfDataFinal;
	private JTextField jtfNumeroAlunos;
	private JTextField jtfEquipamentos;
	private UnidadeCurricular unidadeCurricularParaEdicao;
	private JComboBox jcbFaseSemestre;
	private JComboBox jcbCargaHorariaCurso;
	private int posicaoParaEdicao;

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
		setBounds(1, 1, 548, 325);
		
		JLabel lblFaseSemestre = new JLabel("Fase/Semestre:");
		lblFaseSemestre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jcbFaseSemestre = new JComboBox();
		jcbFaseSemestre.setModel(new DefaultComboBoxModel(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
		
		JLabel lblCargaHoraria = new JLabel("Carga horaria:");
		lblCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jcbCargaHorariaCurso = new JComboBox();
		jcbCargaHorariaCurso.setModel(new DefaultComboBoxModel(new Integer[] {35, 70, 140, 280}));
		
		JPanel jpDadosUnidCurricular = new JPanel();
		jpDadosUnidCurricular.setBorder(new TitledBorder(null, "Dados da Unidade Curricular", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (unidadeCurricularParaEdicao == null){
						UnidadeCurricular unidadeCurricular = new UnidadeCurricular();
						unidadeCurricular.setCodigoUnidade(jtfUnidadeCurricular.getText());
						unidadeCurricular.setNomeCurso(jtfCurso.getText());
						unidadeCurricular.setFaseCurso((Integer)jcbFaseSemestre.getSelectedItem());
						unidadeCurricular.setEquipamentos(jtfEquipamentos.getText());
						unidadeCurricular.setCargaHorariaMateria((Integer)jcbCargaHorariaCurso.getSelectedItem());
						try{
							unidadeCurricular.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataInicial.getText()));
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null,"Data de inicio invalida");
						}
						try {
							unidadeCurricular.setDataFinal(new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataFinal.getText()));
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null,"Data de final invalida");
						}
						unidadeCurricular.setnAlunos(Integer.parseInt(jtfNumeroAlunos.getText()));
					
						try {
							new UnidadeCurricularController().salvar(unidadeCurricular);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Erro ao salvar");
						}
						JOptionPane.showMessageDialog(null, "Unidade curricular cadastrada com sucesso");
					}else{
						unidadeCurricularParaEdicao.setCodigoUnidade(jtfUnidadeCurricular.getText());
						unidadeCurricularParaEdicao.setNomeCurso(jtfCurso.getText());
						unidadeCurricularParaEdicao.setFaseCurso((Integer)jcbFaseSemestre.getSelectedItem());
						unidadeCurricularParaEdicao.setEquipamentos(jtfEquipamentos.getText());
						unidadeCurricularParaEdicao.setCargaHorariaMateria((Integer)jcbCargaHorariaCurso.getSelectedItem());
						try {
							unidadeCurricularParaEdicao.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataInicial.getText()));
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null,"Data de inicio invalida");
						}
						try {
							unidadeCurricularParaEdicao.setDataFinal(new SimpleDateFormat("dd/MM/yyyy").parse(jtfDataFinal.getText()));
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null,"Data de final invalida");
						}
						unidadeCurricularParaEdicao.setnAlunos(Integer.parseInt(jtfNumeroAlunos.getText()));
												
						try {
							new UnidadeCurricularController().editar(unidadeCurricularParaEdicao);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Erro ao editar");
						}
						JOptionPane.showMessageDialog(null, "Unidade curricular editada com sucesso");
					}
					jtfUnidadeCurricular.setText("");
					jtfCurso.setText("");
					jcbFaseSemestre.setSelectedItem("");
					jcbCargaHorariaCurso.setSelectedItem("");
					jtfDataInicial.setText("");
					jtfDataFinal.setText("");
					jtfNumeroAlunos.setText("");
					jtfEquipamentos.setText("");
				
				
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfUnidadeCurricular.setText("");
				jtfCurso.setText("");
				jcbFaseSemestre.setSelectedItem("");
				jcbCargaHorariaCurso.setSelectedItem("");
				jtfDataInicial.setText("");
				jtfDataFinal.setText("");
				jtfNumeroAlunos.setText("");
				jtfEquipamentos.setText("");
			}
		});
		
		JButton btnConsultarUnidadesCurriculares = new JButton("Consultar unidades curriculares cadastradas");
		btnConsultarUnidadesCurriculares.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarUnidadesCurriculares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaUnidadeCurricularUI consultaUnidadeCurricularUI = new ConsultaUnidadeCurricularUI();
				getParent().add(consultaUnidadeCurricularUI,0);
				consultaUnidadeCurricularUI.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jpDadosUnidCurricular, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
							.addGap(16))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarUnidadesCurriculares)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLimpar)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpDadosUnidCurricular, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnLimpar)
						.addComponent(btnConsultarUnidadesCurriculares))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblUnidadeCurricular = new JLabel("Unidade Curricular: ");
		lblUnidadeCurricular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jtfUnidadeCurricular = new JTextField();
		jtfUnidadeCurricular.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jtfCurso = new JTextField();
		jtfCurso.setColumns(10);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jtfDataInicial = new JTextField();
		jtfDataInicial.setColumns(10);
		
		JLabel lblDataFinal = new JLabel("Data final:");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jtfDataFinal = new JTextField();
		jtfDataFinal.setColumns(10);
		
		JLabel lblNumeroAlunos = new JLabel("Numero de alunos: ");
		lblNumeroAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jtfNumeroAlunos = new JTextField();
		jtfNumeroAlunos.setColumns(10);
		
		JLabel lblEquipamentos = new JLabel("Equipamentos: ");
		lblEquipamentos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		jtfEquipamentos = new JTextField();
		jtfEquipamentos.setColumns(10);
		
		GroupLayout gl_jpDadosUnidCurricular = new GroupLayout(jpDadosUnidCurricular);
		gl_jpDadosUnidCurricular.setHorizontalGroup(
			gl_jpDadosUnidCurricular.createParallelGroup(Alignment.LEADING)
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
									.addComponent(jcbCargaHorariaCurso, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
							.addComponent(jtfEquipamentos, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpDadosUnidCurricular.createSequentialGroup()
							.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(jtfNumeroAlunos, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNumeroAlunos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(lblEquipamentos)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(jtfDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcbCargaHorariaCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroAlunos)
						.addComponent(lblEquipamentos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpDadosUnidCurricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfNumeroAlunos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtfEquipamentos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jpDadosUnidCurricular.setLayout(gl_jpDadosUnidCurricular);
		getContentPane().setLayout(groupLayout);
		
		}
		public UnidadeCurricular getUnidadeCurricularParaEdicao() {
			return unidadeCurricularParaEdicao;
		}

		public void setUnidadeCurricularParaEdicao(UnidadeCurricular unidadeCurricularParaEdicao) {
			this.unidadeCurricularParaEdicao = unidadeCurricularParaEdicao;
			preencherCamposParaEdicao();
		}
		
		public int getPosicaoParaEdicao() {
			return posicaoParaEdicao;
		}

		public void setPosicaoParaEdicao(int posicaoParaEdicao) {
			this.posicaoParaEdicao = posicaoParaEdicao;
		}

		public void preencherCamposParaEdicao(){
			if (unidadeCurricularParaEdicao != null){
				jtfUnidadeCurricular.setText(unidadeCurricularParaEdicao.getCodigoUnidade());
				jtfCurso.setText(unidadeCurricularParaEdicao.getNomeCurso());
				jcbFaseSemestre.setSelectedItem(unidadeCurricularParaEdicao.getFaseCurso());
				jcbCargaHorariaCurso.setSelectedItem(unidadeCurricularParaEdicao.getCargaHorariaMateria());
				jtfDataInicial.setText(new SimpleDateFormat("dd/MM/yyyy").format(unidadeCurricularParaEdicao.getDataInicio()));
				jtfDataFinal.setText(new SimpleDateFormat("dd/MM/yyyy").format(unidadeCurricularParaEdicao.getDataFinal()));
				jtfNumeroAlunos.setText(unidadeCurricularParaEdicao.getnAlunos()+"");
				jtfEquipamentos.setText(unidadeCurricularParaEdicao.getEquipamentos());
			}
		}
}
