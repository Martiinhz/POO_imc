package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Logica;
import Class.PersonaVO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textDocumento;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textPeso;
	private JTextField textTalla;
	JButton btnRegistrar,btnListaPersonas,btnCalcularIMC;
	JTextArea textArea;
	Logica miLogica;

	public Ventana() {
		miLogica=new Logica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 200, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CALCULAR IMC");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblNewLabel.setBounds(333, 11, 204, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Básicos");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(36, 73, 134, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Documento:");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(36, 114, 93, 20);
		contentPane.add(lblNewLabel_2);
		
		textDocumento = new JTextField();
		textDocumento.setBounds(118, 116, 134, 20);
		contentPane.add(textDocumento);
		textDocumento.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre:");
		lblNewLabel_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(262, 114, 93, 20);
		contentPane.add(lblNewLabel_2_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(318, 116, 340, 20);
		contentPane.add(textNombre);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Edad:");
		lblNewLabel_2_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(673, 114, 31, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
		textEdad = new JTextField();
		textEdad.setBounds(708, 116, 51, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datos IMC");
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(36, 177, 134, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Peso:");
		lblNewLabel_2_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(36, 224, 44, 20);
		contentPane.add(lblNewLabel_2_2);
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(90, 226, 134, 20);
		contentPane.add(textPeso);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Altura:");
		lblNewLabel_2_2_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblNewLabel_2_2_1.setBounds(280, 224, 44, 20);
		contentPane.add(lblNewLabel_2_2_1);
		
		textTalla = new JTextField();
		textTalla.setColumns(10);
		textTalla.setBounds(338, 226, 134, 20);
		contentPane.add(textTalla);
		
		JLabel etiResultado = new JLabel("Resultado:");
		etiResultado.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		etiResultado.setBounds(36, 267, 134, 25);
		contentPane.add(etiResultado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 313, 767, 203);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);

		btnRegistrar.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		btnRegistrar.setBounds(262, 527, 134, 23);
		contentPane.add(btnRegistrar);
		
		btnListaPersonas = new JButton("Consultar Lista");
		btnListaPersonas.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		btnListaPersonas.setBounds(420, 527, 134, 23);
		btnListaPersonas.addActionListener(this);
		contentPane.add(btnListaPersonas);
		
		btnCalcularIMC = new JButton("Calcular Promedio IMC");
		btnCalcularIMC.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		btnCalcularIMC.setBounds(575, 527, 204, 23);
		btnCalcularIMC.addActionListener(this);
		contentPane.add(btnCalcularIMC);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			PersonaVO miPersona=new PersonaVO();
			miPersona.setDocumento(textDocumento.getText());
			miPersona.setNombre(textNombre.getText());
			miPersona.setEdad(Integer.parseInt(textEdad.getText()));
			miPersona.setPeso(Double.parseDouble(textPeso.getText()));
			miPersona.setAltura(Double.parseDouble(textTalla.getText()));
			String resp=miLogica.RegistrarPersonas(miPersona);
			textArea.setText(resp);
		}
		
		if(e.getSource()==btnListaPersonas) {
			String res=miLogica.consultarListaPersona();
			textArea.setText(res);
		}
		
		if(e.getSource()==btnCalcularIMC) {
			String res=miLogica.consultarPromedio();
			textArea.setText(res);
	}
}
}
