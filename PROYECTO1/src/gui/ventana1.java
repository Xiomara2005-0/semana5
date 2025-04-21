package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase.Empleado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcod;
	private JTextField txtnom;
	private JTextField txtsue;
	private JTextField txthex;
	private JButton btnNewButton;
	private JComboBox cboareal;
	private JComboBox cboafil;
	private JTextArea txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana1 frame = new ventana1();
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
	public ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 34, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Area Laboral:");
		lblNewLabel_2.setBounds(10, 56, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo:");
		lblNewLabel_3.setBounds(10, 81, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Horas EXTRA:");
		lblNewLabel_4.setBounds(10, 106, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Afiliación:");
		lblNewLabel_5.setBounds(10, 131, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtcod = new JTextField();
		txtcod.setBounds(81, 8, 86, 20);
		contentPane.add(txtcod);
		txtcod.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setBounds(81, 31, 86, 20);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		txtsue = new JTextField();
		txtsue.setBounds(81, 78, 86, 20);
		contentPane.add(txtsue);
		txtsue.setColumns(10);
		
		txthex = new JTextField();
		txthex.setBounds(81, 103, 86, 20);
		contentPane.add(txthex);
		txthex.setColumns(10);
		
		cboareal = new JComboBox();
		cboareal.setModel(new DefaultComboBoxModel(new String[] {"Administración", "Sistemas", "Marketing"}));
		cboareal.setBounds(81, 52, 84, 22);
		contentPane.add(cboareal);
		
		cboafil = new JComboBox();
		cboafil.setModel(new DefaultComboBoxModel(new String[] {"AFP", "SNP"}));
		cboafil.setBounds(81, 127, 86, 22);
		contentPane.add(cboafil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 343, 94);
		contentPane.add(scrollPane);
		
		txts = new JTextArea();
		scrollPane.setViewportView(txts);
		{
			btnNewButton = new JButton("Procesar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(249, 7, 89, 23);
			contentPane.add(btnNewButton);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String cod=txtcod.getText();
		String nom=txtnom.getText();
		String areal=cboareal.getSelectedItem().toString();
		double sue=Double.parseDouble(txtsue.getText());
		int he=Integer.parseInt(txthex.getText());
		int afilia=cboafil.getSelectedIndex();
		Empleado e1=new Empleado(cod, nom, areal, sue, he, afilia);
		Listado(e1);
	}
	void Imprimir(String s) {
		txts.append(s+"\n");
	}
	void Listado(Empleado e){
		Imprimir("El código es: "+e.getCod());
		Imprimir("El nombre es: "+e.getNom());
		Imprimir("El área laboral es: "+e.getAreal());
		Imprimir("Sueldo: "+e.getSue());
		Imprimir("Horas extras: "+e.getHe());
		if(e.getAfilia() == 0) {
			Imprimir("La afiliación es: AFP");
		}
		else {
			Imprimir("La afiliación es: SNP");
		}
		Imprimir("Pago por horas extra: "+e.montoHE());
		Imprimir("Descuento por ESSALUD: "+e.ESSALUD());
		if (e.getAfilia() == 0) {
			Imprimir("Descuento por AFP: "+e.AFP());
		}
		else {
			Imprimir("Descuento por SNP: "+e.SNP());
		}
		Imprimir("Sueldo bruto: "+e.suebruto());
		Imprimir("\nSueldo neto: "+e.SN());
	}
}
