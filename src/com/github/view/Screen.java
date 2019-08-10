package com.github.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Screen {

	JFrame tela;
	JMenu sair;
	JMenuBar barraMenu;
	JButton btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis, btnSete, btnOito, btnNove, btnZero, btnPonto,
			btnLimpar, btnOk, btnSinal;
	JLabel lblEntrada, lblConversao, lblSaidaCelsius, lblSaidaFah, lblSaidaKelvin, lblC, lblF, lblK;
	JTextField txtEntrada;
	JRadioButton rbCelsius, rbFahrenheit, rbKelvin;

	public Screen() {
		inicializarComponentes();
		inicializarLogica();
	}

	public void inicializarComponentes() {

		tela = new JFrame();
		barraMenu = new JMenuBar();
		sair = new JMenu("Sair");
		barraMenu.add(sair);

		//
		// Label
		//
		lblEntrada = new JLabel("Informe um valor");
		lblEntrada.setBounds(50, 20, 150, 30);

		lblConversao = new JLabel("Conversão");
		lblConversao.setBounds(50, 175, 150, 30);

		lblSaidaCelsius = new JLabel("00.0");
		lblSaidaCelsius.setBounds(50, 200, 150, 30);

		lblSaidaFah = new JLabel("00.0");
		lblSaidaFah.setBounds(50, 220, 150, 30);

		lblSaidaKelvin = new JLabel("00.0");
		lblSaidaKelvin.setBounds(50, 240, 150, 30);

		lblC = new JLabel("°C");
		lblC.setBounds(184, 200, 150, 30);

		lblF = new JLabel("°F");
		lblF.setBounds(184, 220, 150, 30);

		lblK = new JLabel("°K");
		lblK.setBounds(184, 240, 150, 30);

		//
		// TextField
		//
		txtEntrada = new JTextField();
		txtEntrada.setBounds(50, 50, 150, 30);

		//
		// RadioButton
		//
		rbCelsius = new JRadioButton("Celsius");
		rbCelsius.setBounds(45, 80, 70, 20);
		rbCelsius.setSelected(true);
		rbCelsius.setFocusPainted(false);

		rbFahrenheit = new JRadioButton("Fahrenheit");
		rbFahrenheit.setBounds(117, 80, 90, 20);
		rbFahrenheit.setFocusPainted(false);

		rbKelvin = new JRadioButton("Kelvin");
		rbKelvin.setBounds(45, 100, 90, 20);
		rbKelvin.setFocusPainted(false);

		//
		// Botões
		//
		btnOk = new JButton("Converter");
		btnOk.setBounds(50, 125, 150, 20);
		btnOk.setFocusPainted(false);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(50, 150, 150, 20);
		btnLimpar.setFocusPainted(false);

		tela.setJMenuBar(barraMenu);
		tela.add(lblEntrada);
		tela.add(txtEntrada);
		tela.add(lblConversao);
		tela.add(rbCelsius);
		tela.add(rbFahrenheit);
		tela.add(rbKelvin);
		tela.add(btnOk);
		tela.add(btnLimpar);
		tela.add(lblSaidaCelsius);
		tela.add(lblSaidaFah);
		tela.add(lblSaidaKelvin);
		tela.add(lblC);
		tela.add(lblF);
		tela.add(lblK);

		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor de Temperatura");
		tela.setSize(500, 350);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setVisible(true);
	}

	public void inicializarLogica() {

		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (txtEntrada.getText().isEmpty() && rbCelsius.isSelected() && lblSaidaCelsius.getText() == "00.0"
						&& lblSaidaFah.getText() == "00.0" && lblSaidaKelvin.getText() == "00.0") {
					JOptionPane.showMessageDialog(null, "Os campos já estão limpos.");
				} else {
					txtEntrada.setText("");
					rbCelsius.setSelected(true);
					rbFahrenheit.setSelected(false);
					rbKelvin.setSelected(false);
					lblSaidaCelsius.setText("00.0");
					lblSaidaFah.setText("00.0");
					lblSaidaKelvin.setText("00.0");
				}
			}
		});

		rbCelsius.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rbCelsius.setSelected(true);
				rbFahrenheit.setSelected(false);
				rbKelvin.setSelected(false);
			}
		});

		rbFahrenheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rbFahrenheit.setSelected(true);
				rbCelsius.setSelected(false);
				rbKelvin.setSelected(false);
			}
		});

		rbKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rbKelvin.setSelected(true);
				rbFahrenheit.setSelected(false);
				rbCelsius.setSelected(false);

			}
		});

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					double celsius, fahrenheit, kelvin;
					String c, f, k;

					if (rbCelsius.isSelected() == true) {
						//
						// Fahrenheit
						//
						celsius = Double.parseDouble(txtEntrada.getText());
						fahrenheit = 1.8 * celsius + 32;
						f = String.format("%.1f", fahrenheit).toString();
						lblSaidaFah.setText(f);

						//
						// Kelvin
						//
						kelvin = celsius + 273;
						k = String.format("%.1f", kelvin).toString();
						lblSaidaKelvin.setText(k);

						//
						// Celsius
						//
						c = String.format("%.1f", celsius).toString();
						lblSaidaCelsius.setText(c);

					} else if (rbFahrenheit.isSelected() == true) {
						//
						// Celsius
						//
						fahrenheit = Double.parseDouble(txtEntrada.getText());
						celsius = (fahrenheit - 32) / 1.8;
						c = String.format("%.1f", celsius).toString();
						lblSaidaCelsius.setText(c);

						//
						// Kelvin
						//
						kelvin = (fahrenheit - 32) * 5 / 9 + 273.15;
						k = String.format("%.1f", kelvin).toString();
						lblSaidaKelvin.setText(k);

						//
						// Fahrenheit
						//
						f = String.format("%.1f", fahrenheit).toString();
						lblSaidaFah.setText(f);

					} else {
						//
						// Celsius
						//
						kelvin = Double.parseDouble(txtEntrada.getText());
						celsius = (kelvin - 273.15);
						c = String.format("%.1f", celsius).toString();
						lblSaidaCelsius.setText(c);

						//
						// Fahrenheit
						//
						fahrenheit = (kelvin - 273.15) * 9 / 5 + 32;
						f = String.format("%.1f", fahrenheit).toString();
						lblSaidaKelvin.setText(f);

						//
						// Kelvin
						//
						k = String.format("%.1f", kelvin).toString();
						lblSaidaFah.setText(k);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Opa, algo está errado.");
				}
			}
		});
		sair.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}
}
