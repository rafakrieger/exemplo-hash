package br.com.senac.login.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senac.login.controller.UsuarioController;
import br.com.senac.login.model.vo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(16, 17, 132, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSenha.setBounds(16, 79, 98, 34);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 22));
		textField.setBounds(110, 17, 301, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 22));
		passwordField.setBounds(110, 79, 301, 34);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setNome(textField.getText());
				usuario.setSenha(passwordField.getPassword());
				UsuarioController usuarioController = new UsuarioController();
				String message = "";
				try {
					message = usuarioController.entrar(usuario);
				} catch (NoSuchAlgorithmException e1) {					
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, message);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 24));
		btnNewButton.setBounds(117, 168, 211, 53);
		contentPane.add(btnNewButton);
	}
}
