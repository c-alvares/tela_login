package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.ProcessUser;

public class LoginView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel label1, label2;
	private JTextField email, password;
	private JButton enter/*, submit*/;

	LoginView() {
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.pink);
		setContentPane(panel);
		setLayout(null);

		label1 = new JLabel("Email:");
		label1.setFont(new Font("Calibri", Font.BOLD, 14));
		label1.setBounds(98, 11, 46, 14);

		email = new JTextField();
		email.setBounds(98, 34, 226, 20);

		label2 = new JLabel("Senha:");
		label2.setFont(new Font("Calibri", Font.BOLD, 14));
		label2.setBounds(98, 65, 46, 14);

		password = new JTextField();
		password.setBounds(98, 90, 226, 20);

		enter = new JButton("Entrar");
		enter.setFont(new Font("Calibri", Font.BOLD, 13));
		enter.setBounds(134, 160, 163, 23);
		

		enter.addActionListener(this);

		/*
		submit = new JButton("Cadastrar");
		submit.setFont(new Font("Calibri", Font.BOLD, 13));
		submit.setBounds(134, 204, 163, 23);
		*/
		
		panel.add(label1);
		panel.add(email);
		panel.add(label2);
		panel.add(password);
		panel.add(enter);
		//panel.add(submit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter) {
			int index = ProcessUser.emailCheck(email.getText());
			if (index != -1) {
				if (ProcessUser.passwordCheck(index, password.getText())) {
					JOptionPane.showMessageDialog(this, "Login efetuado com Sucesso");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Falha no login");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Usu?rio n?o localizado");
			}
		}
	}

	public static void main(String[] args) {
		ProcessUser.load();
		LoginView view = new LoginView();
		view.setVisible(true);

	}
}
