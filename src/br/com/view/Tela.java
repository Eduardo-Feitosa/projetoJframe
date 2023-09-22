package br.com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.model.DAO.AlcoolDAO;
import br.com.model.DAO.GasolinaDAO;
import br.com.model.entidades.Alcool;
import br.com.model.entidades.Gasolina;


public class Tela {

	private JFrame frame;
	private JTextField campoLitros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
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
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 552, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		campoLitros = new JTextField();
		campoLitros.setBounds(128, 95, 99, 34);
		frame.getContentPane().add(campoLitros);
		campoLitros.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Litros:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 95, 49, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione tipo de combústivel:Gasolina ou Álcool.");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(69, 140, 360, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sistema de Compra de Combústiveis");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(114, 23, 334, 32);
		frame.getContentPane().add(lblNewLabel_2);
		JLabel resultado = new JLabel("Preço");
		resultado.setFont(new Font("Times New Roman", Font.BOLD, 27));
		resultado.setBounds(128, 244, 293, 91);
		frame.getContentPane().add(resultado);
		
		JRadioButton campoAlcool = new JRadioButton("A");
		campoAlcool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alcool a = new Alcool();
				a.setLitros(Double.valueOf(campoLitros.getText()));
				a.comprar();
				new AlcoolDAO().cadastrarCompra(a);
				resultado.setText(""+a.imprimir().toString());
			}
		});
		campoAlcool.setBounds(114, 192, 33, 23);
		frame.getContentPane().add(campoAlcool);
		
		JRadioButton campoGasolina = new JRadioButton("G");
		campoGasolina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gasolina g = new Gasolina();
				g.setLitros(Double.valueOf(campoLitros.getText()));
				g.comprar();
				new GasolinaDAO().cadastrarCompra(g);
				resultado.setText(""+g.imprimir().toString());
			}
		});
		campoGasolina.setBounds(69, 191, 41, 23);
		frame.getContentPane().add(campoGasolina);
		
		
	}
}
