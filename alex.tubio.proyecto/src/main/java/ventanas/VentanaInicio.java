package ventanas;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaInicio extends JPanel{
	public VentanaInicio() {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{2164, 1, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea textoInicio = new JTextArea("Hola, bienvenido a Goblins & Zombies. \n \u00BFCu\u00E1l es tu nombre?");
		textoInicio.setEditable(false);
		textoInicio.setLineWrap(true);
		textoInicio.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		GridBagConstraints gbc_textoInicio = new GridBagConstraints();
		gbc_textoInicio.anchor = GridBagConstraints.WEST;
		gbc_textoInicio.fill = GridBagConstraints.VERTICAL;
		gbc_textoInicio.insets = new Insets(0, 0, 5, 0);
		gbc_textoInicio.gridx = 0;
		gbc_textoInicio.gridy = 0;
		add(textoInicio, gbc_textoInicio);
		
		
	}
	
}
