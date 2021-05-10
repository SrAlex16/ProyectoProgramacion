package ventanasCasillas;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import ventanas.Mapa;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Casilla1 extends JFrame{
	Mapa mapa;
	public Casilla1() {
		
		this.setSize(884, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Juego");
		this.setResizable(true);
		getContentPane().setLayout(null);
		
		JButton mostrarMapa = new JButton("Ver el mapa");
		mostrarMapa.setFont(new Font("Ink Free", Font.BOLD, 15));
		mostrarMapa.setBackground(Color.GRAY);
		mostrarMapa.setBounds(10, 459, 158, 47);
		mostrarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(mostrarMapa);
		
		JLabel lblNewLabel = new JLabel("Te encuentras en una mazmorra. A tu derecha tienes un pasillo con unas escaleras que bajan, y a la izquierda otro pasillo que lleva a dos habitaciones distintas.\r\n\u00BFQu\u00E9 quieres hacer?");
		lblNewLabel.setBounds(10, 11, 846, 221);
		getContentPane().add(lblNewLabel);
		
		JButton mostrarMapa_1 = new JButton("Ir a la derecha");
		mostrarMapa_1.setFont(new Font("Ink Free", Font.BOLD, 15));
		mostrarMapa_1.setBackground(Color.GRAY);
		mostrarMapa_1.setBounds(242, 459, 158, 47);
		getContentPane().add(mostrarMapa_1);
		
		JButton btnIrALa = new JButton("Ir a la izquierda");
		btnIrALa.setFont(new Font("Ink Free", Font.BOLD, 15));
		btnIrALa.setBackground(Color.GRAY);
		btnIrALa.setBounds(459, 459, 158, 47);
		getContentPane().add(btnIrALa);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setToolTipText("Vas a la habitaci\u00F3n anterior");
		btnVolver.setFont(new Font("Ink Free", Font.BOLD, 15));
		btnVolver.setBackground(Color.GRAY);
		btnVolver.setBounds(698, 459, 158, 47);
		getContentPane().add(btnVolver);
		
		//TODO hacer que esto funcione
		if(mostrarMapa.equals(mostrarMapa.getActionCommand())) {
			mapa=new Mapa();
			System.out.println("esto es para ver si la funcion esta bien");
		}else {
			System.out.println("claramente no funciona");
		}
		
		this.setVisible(true);
		//TODO Poner la casilla en la que te encuentras
	}
}
