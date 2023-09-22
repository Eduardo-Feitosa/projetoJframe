package br.com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.model.DAO.AlcoolDAO;
import br.com.model.entidades.Alcool;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alterar {

	private JFrame frame;
	private JTextField campoId;
	private JTextField campoLitros;
	private JTextField campoPreco;
	private JTextField campoValor;
	private JTextField campoTipo;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar window = new Alterar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Alterar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		campoId = new JTextField();
		campoId.setBounds(157, 60, 86, 20);
		frame.getContentPane().add(campoId);
		campoId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(123, 63, 24, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Liitros:");
		lblNewLabel_1.setBounds(109, 94, 38, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		campoLitros = new JTextField();
		campoLitros.setColumns(10);
		campoLitros.setBounds(157, 91, 86, 20);
		frame.getContentPane().add(campoLitros);
		
		JLabel lblNewLabel_2 = new JLabel("preco:");
		lblNewLabel_2.setBounds(109, 122, 38, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(157, 122, 86, 20);
		frame.getContentPane().add(campoPreco);
		campoPreco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("valor total:");
		lblNewLabel_3.setBounds(94, 156, 53, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		campoValor = new JTextField();
		campoValor.setBounds(157, 153, 86, 20);
		frame.getContentPane().add(campoValor);
		campoValor.setColumns(10);
		
		campoTipo = new JTextField();
		campoTipo.setBounds(157, 190, 86, 20);
		frame.getContentPane().add(campoTipo);
		campoTipo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("tipoCombustivel:");
		lblNewLabel_4.setBounds(48, 193, 92, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alcool a = new Alcool();
				a.setLitros(Double.valueOf(campoLitros.getText()));
				a.setPreco(Double.valueOf(campoPreco.getText()));
				a.setPreco(Double.valueOf(campoValor.getText()));
				a.setValorTotal(Double.valueOf(campoValor.getText()));
				String tip = campoTipo.getText();
				int id = Integer.valueOf(campoId.getText());
				
				new AlcoolDAO().alterarCompra(a, tip, id);
				
			}
		});
		btnNewButton.setBackground(new Color(51, 204, 102));
		btnNewButton.setBounds(303, 108, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("*Para excluir use apenas o id");
		lblNewLabel_5.setBounds(253, 63, 171, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		btnNewButton_1 = new JButton("Deletar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(campoId.getText());
				new AlcoolDAO().deletarCompra(id);
			}
			
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(303, 166, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
