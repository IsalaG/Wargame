package War;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Menu() {
		this.setSize(1000, 800);
		this.setTitle("Wargames");
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton newP = new JButton("Nouvelle Partie");
		newP.setPreferredSize(new Dimension(300, 30));
		JButton charP = new JButton("Charger Partie");
		charP.setPreferredSize(new Dimension(300, 30));
		JButton opt = new JButton("Options");
		opt.setPreferredSize(new Dimension(300, 30));

		// Les Panels contenant les boutons
		JPanel cell1 = new JPanel();
	    cell1.setPreferredSize(new Dimension(300, 40));
	    cell1.setOpaque(false);
	    JPanel cell3 = new JPanel();
	    cell3.setPreferredSize(new Dimension(300, 40));  
	    cell3.setOpaque(false);  
	    JPanel cell5 = new JPanel();
	    cell5.setPreferredSize(new Dimension(300, 40));  
	    cell5.setOpaque(false);
	   
	    // Séparation entre les boutons 
	    JPanel cell2 = new JPanel();
	    cell2.setPreferredSize(new Dimension(300, 20));  
	    cell2.setOpaque(false);
	    JPanel cell4 = new JPanel();
	    cell4.setPreferredSize(new Dimension(300, 20)); 
	    cell4.setOpaque(false);
	    
	    //Le conteneur principal
	    JPanel content = new Panneau();
	    content.setPreferredSize(new Dimension(300, 120));

	    // On rend tout transparent
	    content.setOpaque(false);
	    
	    //On définit le layout manager
	    content.setLayout(new GridBagLayout());        

	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();      

	    // cell1 et bouton nouvelle partie
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    cell1.add(newP);
	    content.add(cell1, gbc);

	    // cell2 séparation
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell2, gbc);
	    
	    // cell 3 et bouton charger partie
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    cell3.add(charP);
	    content.add(cell3, gbc);
	    
	 // cell2 séparation
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell4, gbc);
	    
	 // cell 3 et bouton charger partie
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    cell5.add(opt);
	    content.add(cell5, gbc);

	    //On ajoute le conteneur

	    this.setContentPane(content);
		this.setVisible(true);
	}

}
