package br.senai.jandira.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.senai.jandira.Arquivo;

import java.awt.Font;

public class FrameArquivo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Arquivo arquivo = null;
	public String caminho;
	private JPanel contentPane;

	
	
	public FrameArquivo() {
		this.arquivo = new Arquivo();
		this.caminho = "C:\\Users\\21276437\\Desktop\\sla\\arquivo.txt";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manipula\u00E7\u00E3o de Arquivo texto :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 41, 188, 14);
		contentPane.add(lblNewLabel);

	

		JButton btnlimpar = new JButton("LIMPAR");
		btnlimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnlimpar.setBounds(109, 212, 89, 23);
		contentPane.add(btnlimpar);

		JButton btnsair = new JButton("SAIR");
		btnsair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsair.setBounds(208, 212, 89, 23);
		contentPane.add(btnsair);

		JScrollPane scrollconteudo = new JScrollPane();
		scrollconteudo.setBounds(10, 66, 334, 135);
		contentPane.add(scrollconteudo);
		
		JTextPane textconteudo = new JTextPane();
		scrollconteudo.setViewportView(textconteudo);
		
	
		
		JButton btngravar = new JButton("GRAVAR");
		btngravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textoArquivo = arquivo.ler(caminho);
				String texto = textconteudo.getText();
			
				
				if (arquivo.escrever(caminho, texto)) {
					//Mensagem de sucesso !
					JOptionPane.showMessageDialog(null, "Dado gravado com sucesso !!","GRAVAÇÃO", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else {
					//Mensagem de erro !
					JOptionPane.showMessageDialog(null, "Erro ao gravar dados ","GRAVAÇÃO", JOptionPane.INFORMATION_MESSAGE);
					textconteudo.setText("");
					
				}
				
			
			}
		});
		btngravar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btngravar.setBounds(10, 212, 89, 23);
		contentPane.add(btngravar);

	}
}
