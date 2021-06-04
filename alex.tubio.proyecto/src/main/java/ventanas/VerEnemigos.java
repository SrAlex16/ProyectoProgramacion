package ventanas;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

public class VerEnemigos extends JFrame {
	private byte numeroAleatorioZombies;
	private byte numeroAleatorioGoblins;

	public VerEnemigos() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.LIGHT_GRAY);
		this.setUndecorated(true); //para quitar el borde de arriba de la ventana
		this.setSize(630, 815);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);	
		
		//imagen aleatoria
		Random ran = new Random();
		numeroAleatorioZombies = (byte) ran.nextInt(5);
		numeroAleatorioGoblins = (byte) ran.nextInt(6);
		String strZombies=numeroAleatorioZombies+"";
		String strGoblins=numeroAleatorioGoblins+"";
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 40, 376, 191, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 24, 337, 0, 251, 0, 166, 27, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		
		JTextArea textoZombiesGifs = new JTextArea();
		textoZombiesGifs.setBackground(Color.LIGHT_GRAY);
		textoZombiesGifs.setEditable(false);
		textoZombiesGifs.setForeground(Color.BLACK);
		textoZombiesGifs.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 15));
		textoZombiesGifs.setText("TIPO:   Zombie\r\nVIDA:   250\r\nATAQUE:   25\r\nNIVEL: 2");
		GridBagConstraints gbc_textoZombiesGifs = new GridBagConstraints();
		gbc_textoZombiesGifs.insets = new Insets(0, 0, 5, 5);
		gbc_textoZombiesGifs.fill = GridBagConstraints.BOTH;
		gbc_textoZombiesGifs.gridx = 1;
		gbc_textoZombiesGifs.gridy = 1;
		getContentPane().add(textoZombiesGifs, gbc_textoZombiesGifs);
		
		JLabel gifZombieAleatorio = new JLabel("");
		gifZombieAleatorio.setForeground(Color.LIGHT_GRAY);
		gifZombieAleatorio.setIcon(new ImageIcon(VerEnemigos.class.getResource("/zombies/"+strZombies+".gif")));
		GridBagConstraints gbc_gifZombieAleatorio = new GridBagConstraints();
		gbc_gifZombieAleatorio.insets = new Insets(0, 0, 5, 5);
		gbc_gifZombieAleatorio.gridx = 2;
		gbc_gifZombieAleatorio.gridy = 1;
		getContentPane().add(gifZombieAleatorio, gbc_gifZombieAleatorio);
		
		JTextArea textoGoblinsGifs = new JTextArea();
		textoGoblinsGifs.setBackground(Color.LIGHT_GRAY);
		textoGoblinsGifs.setForeground(Color.BLACK);
		textoGoblinsGifs.setText("TIPO:   Goblin\r\nVIDA:   200\r\nATAQUE:   30\r\nNIVEL: 1");
		textoGoblinsGifs.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 15));
		textoGoblinsGifs.setEditable(false);
		GridBagConstraints gbc_textoGoblinsGifs = new GridBagConstraints();
		gbc_textoGoblinsGifs.insets = new Insets(0, 0, 5, 5);
		gbc_textoGoblinsGifs.fill = GridBagConstraints.BOTH;
		gbc_textoGoblinsGifs.gridx = 1;
		gbc_textoGoblinsGifs.gridy = 3;
		getContentPane().add(textoGoblinsGifs, gbc_textoGoblinsGifs);
		
		JLabel gifGoblinAleatorio = new JLabel("");
		gifGoblinAleatorio.setForeground(Color.LIGHT_GRAY);
		gifGoblinAleatorio.setIcon(new ImageIcon(VerEnemigos.class.getResource("/goblins/"+strGoblins+".gif")));
		GridBagConstraints gbc_gifGoblinAleatorio = new GridBagConstraints();
		gbc_gifGoblinAleatorio.insets = new Insets(0, 0, 5, 5);
		gbc_gifGoblinAleatorio.gridx = 2;
		gbc_gifGoblinAleatorio.gridy = 3;
		getContentPane().add(gifGoblinAleatorio, gbc_gifGoblinAleatorio);
		
		JTextArea textoDragonGifs = new JTextArea();
		textoDragonGifs.setBackground(Color.LIGHT_GRAY);
		textoDragonGifs.setForeground(Color.BLACK);
		textoDragonGifs.setText("TIPO:   Dragon\r\nVIDA:   300\r\nATAQUE:   50\r\nNIVEL: 3");
		textoDragonGifs.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 15));
		textoDragonGifs.setEditable(false);
		GridBagConstraints gbc_textoDragonGifs = new GridBagConstraints();
		gbc_textoDragonGifs.insets = new Insets(0, 0, 5, 5);
		gbc_textoDragonGifs.fill = GridBagConstraints.BOTH;
		gbc_textoDragonGifs.gridx = 1;
		gbc_textoDragonGifs.gridy = 5;
		getContentPane().add(textoDragonGifs, gbc_textoDragonGifs);
		
		JLabel gifDragon = new JLabel("");
		gifDragon.setForeground(Color.LIGHT_GRAY);
		gifDragon.setIcon(new ImageIcon(VerEnemigos.class.getResource("/dragon/dragon.gif")));
		GridBagConstraints gbc_gifDragon = new GridBagConstraints();
		gbc_gifDragon.insets = new Insets(0, 0, 5, 5);
		gbc_gifDragon.gridx = 2;
		gbc_gifDragon.gridy = 5;
		getContentPane().add(gifDragon, gbc_gifDragon);
		
		
	}
}
