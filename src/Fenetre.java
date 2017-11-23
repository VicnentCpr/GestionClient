import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.freixas.jcalendar.JCalendar;

public class Fenetre extends JFrame {
	private Base base;
	private JList jlist;
	public Fenetre(String title,Base base) {
		super(title);
		jlist=new JList();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.base=base;
		this.setLayout(new GridLayout());
		actualiser();
		JPanel panel = new JPanel();
		panel.add(jlist);
		JButton bouton = new JButton("Ajouter Client");
		panel.add(bouton);
		
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				JTextField nom = new JTextField();
			    JTextField prenom = new JTextField();
			    JTextField email = new JTextField();
			    JTextField tel = new JTextField();

			      JPanel myPanel = new JPanel();
			      myPanel.setLayout(new GridLayout(2,2));
			      myPanel.add(new JLabel("nom:"));
			      myPanel.add(nom);
			      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			      myPanel.add(new JLabel("prenom:"));
			      myPanel.add(prenom);
			      myPanel.add(new JLabel("email:"));
			      myPanel.add(email);
			      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			      myPanel.add(new JLabel("téléphone:"));
			      myPanel.add(tel);

			      int result = JOptionPane.showConfirmDialog(null, myPanel, 
			               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
			      if(result == JOptionPane.OK_OPTION) {
			    	  	Client client = new Client(nom.getText(),prenom.getText(),email.getText(),tel.getText());
			    	  	base.ajouterClient(client);
			    	  	actualiser();
			    	  	
			      }
				
				
			}
		});
		
		
		JCalendar calendrier = new JCalendar();
		this.setCentre(new JLabel("eee"));
		this.setBasGauche(panel);
		this.add(panel);	
		this.setCalendrier(calendrier);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void actualiser() {
		jlist.setListData(base.selectClients().toArray());
		jlist.revalidate();
	}
	
	public void setCalendrier(JComponent component){
        GridBagConstraints contrainte = new GridBagConstraints(2,0,1,2,1,1, GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0), 1,1);
        add(component,contrainte);
    }
    public void setBasGauche(JComponent component){
        GridBagConstraints contrainte = new GridBagConstraints(0,1,1,2,1,1, GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0), 1,1);
        add(component,contrainte);
    }
    public void setHautGauche(JComponent component){
        GridBagConstraints contrainte = new GridBagConstraints(0,0,1,1,1,1, GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0), 1,1);
        add(component,contrainte);
    }
    public void setBasDroite(JComponent component){
        GridBagConstraints contrainte = new GridBagConstraints(2,2,1,1,1,1, GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0), 1,1);
        add(component,contrainte);
    }
    public void setCentre(JComponent component){
        GridBagConstraints contrainte = new GridBagConstraints(1,0,1,3,1,1, GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0), 1,1);
        add(component,contrainte);
    }    
}

