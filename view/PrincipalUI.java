package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
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
	public PrincipalUI() {
		setTitle("Sistema de Distribui\u00E7\u00E3o de Salas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProfessores = new JMenu("Professores");
		mnProfessores.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnProfessores);
		
		JMenuItem mntmInserirProfessor = new JMenuItem("Inserir Professor");
		mntmInserirProfessor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmInserirProfessor.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				InserirProfessorUI inserirProfessorUI = new InserirProfessorUI();
				contentPane.add(inserirProfessorUI, 0);
				inserirProfessorUI.setVisible(true);
			}
		});
		mnProfessores.add(mntmInserirProfessor);
		
		JMenuItem mntmConsultaProfessor = new JMenuItem("Consulta Professor");
		mntmConsultaProfessor.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmConsultaProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProfessorUI consultaProfessorUI = new ConsultaProfessorUI();
				contentPane.add(consultaProfessorUI,0);
				consultaProfessorUI.setVisible(true);				
			}
		});
		mnProfessores.add(mntmConsultaProfessor);
		
		JMenu mnUnidadeCurricular = new JMenu("Unidade Curricular");
		mnUnidadeCurricular.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnUnidadeCurricular);
		
		JMenuItem mntmInserirUnidCurricular = new JMenuItem("Inserir Unid. Curricular");
		mntmInserirUnidCurricular.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmInserirUnidCurricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirUnidadeCurricularUI inserirUnidadeCurricularUI = new InserirUnidadeCurricularUI();
				contentPane.add(inserirUnidadeCurricularUI,0);
				inserirUnidadeCurricularUI.setVisible(true);
			}
		});
		mnUnidadeCurricular.add(mntmInserirUnidCurricular);
		
		JMenuItem mntmConsultaUnidCurricular = new JMenuItem("Consulta Unid. Curricular");
		mntmConsultaUnidCurricular.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmConsultaUnidCurricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaUnidadeCurricularUI consultaUnidadeCurricularUI = new ConsultaUnidadeCurricularUI();
				contentPane.add(consultaUnidadeCurricularUI,0);
				consultaUnidadeCurricularUI.setVisible(true);
			}
		});
		mnUnidadeCurricular.add(mntmConsultaUnidCurricular);
		
		JMenu mnSalas = new JMenu("Salas");
		mnSalas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnSalas);
		
		JMenuItem mntmInserirSala = new JMenuItem("Inserir Sala");
		mntmInserirSala.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmInserirSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InserirSalaUI salaUI = new InserirSalaUI();
				contentPane.add(salaUI,0);
				salaUI.setVisible(true);
			}
		});
		mnSalas.add(mntmInserirSala);
		
		JMenuItem mntmConsultaSala = new JMenuItem("Consulta Sala");
		mntmConsultaSala.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmConsultaSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaSalaUI consultaSalaUI = new ConsultaSalaUI();
				contentPane.add(consultaSalaUI,0);
				consultaSalaUI.setVisible(true);
			}
		});
		mnSalas.add(mntmConsultaSala);
		
		JMenu mnDistribuicaoAutomatica = new JMenu("Distribui\u00E7\u00E3o Automatica");
		mnDistribuicaoAutomatica.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnDistribuicaoAutomatica);
		
		JMenuItem mntmInserirDados = new JMenuItem("Inserir Dados");
		mntmInserirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				///>>>>>
				
				
				
				
			}
		});
		mntmInserirDados.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnDistribuicaoAutomatica.add(mntmInserirDados);
		
		JMenuItem mntmEditarDistribuicao = new JMenuItem("Editar Distribui\u00E7\u00E3o");
		mntmEditarDistribuicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				////>>>>>>
				
				
			}
		});
		mntmEditarDistribuicao.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnDistribuicaoAutomatica.add(mntmEditarDistribuicao);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 422, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 217, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
