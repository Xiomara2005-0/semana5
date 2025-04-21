package caso1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBase;
	private JTextField txtAltura;
	private JTextArea txtS;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese base");
		lblNewLabel.setBounds(5, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ingrese altura");
		lblNewLabel_1.setBounds(5, 55, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		txtS = new JTextArea();
		txtS.setBounds(5, 80, 419, 170);
		contentPane.add(txtS);
		
		txtBase = new JTextField();
		txtBase.setBounds(89, 8, 86, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(89, 52, 86, 20);
		contentPane.add(txtAltura);
		
		btnNewButton = new JButton("Procesar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(335, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(335, 51, 89, 23);
		contentPane.add(btnBorrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		double base=Double.parseDouble(txtBase.getText());
		double altura=Double.parseDouble(txtAltura.getText());
		Triangulo t = new Triangulo(base, altura);
		Listado(t);
		t.setBase(1.1*t.getBase());
		t.setAltura(0.8*t.getAltura());
		Listado(t);
	}
	void Imprimir(String s) {
		txtS.append(s+"\n");
	}
	void Imprimir() {
		txtS.append("---------------------------------\n");
	}
	
	void Listado(Triangulo t) {
		Imprimir("La base es: "+ t.getBase());
		Imprimir("La altura es: "+ t.getAltura());
		Imprimir("El área es: "+ t.area());
		Imprimir();
	}
}
