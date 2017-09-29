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
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProfessores = new JMenu("Professores");
		menuBar.add(mnProfessores);
		
		JMenuItem mntmInserirProfessor = new JMenuItem("Inserir Professor");
		mnProfessores.add(mntmInserirProfessor);
		
		JMenuItem mntmConsultaProfessor = new JMenuItem("Consulta Professor");
		mnProfessores.add(mntmConsultaProfessor);
		
		JMenu mnUnidadeCurricular = new JMenu("Unidade Curricular");
		menuBar.add(mnUnidadeCurricular);
		
		JMenuItem mntmInserirUnidCurricular = new JMenuItem("Inserir Unid. Curricular");
		mnUnidadeCurricular.add(mntmInserirUnidCurricular);
		
		JMenuItem mntmConsultaUnidCurricular = new JMenuItem("Consulta Unid. Curricular");
		mnUnidadeCurricular.add(mntmConsultaUnidCurricular);
		
		JMenu mnSalas = new JMenu("Salas");
		menuBar.add(mnSalas);
		
		JMenuItem mntmInserirSala = new JMenuItem("Inserir Sala");
		mnSalas.add(mntmInserirSala);
		
		JMenuItem mntmConsultaSala = new JMenuItem("Consulta Sala");
		mnSalas.add(mntmConsultaSala);
		
		JMenu mnDistribuicaoAutomatica = new JMenu("Distribui\u00E7\u00E3o Automatica");
		menuBar.add(mnDistribuicaoAutomatica);
		
		JMenuItem mntmExecutar = new JMenuItem("Executar");
		mnDistribuicaoAutomatica.add(mntmExecutar);
		
		JMenuItem mntmEditarDistribuicao = new JMenuItem("Editar Distribui\u00E7\u00E3o");
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
