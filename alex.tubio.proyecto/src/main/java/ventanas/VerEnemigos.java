package ventanas;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;

public class VerEnemigos extends JFrame{
	public VerEnemigos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(630, 815);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VerEnemigos.class.getResource("/gifs/boss.gif")));
		getContentPane().add(lblNewLabel);
		
		
	}
}
