package dbProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Intro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 5768946808535782396L;
	
	private JPanel container,control;
	private IntroPanel imgPanel;
	private JButton signIn,exit ;
	private DBCInformation DBCI= new DBCInformation();
	
	public Intro() {
		
		this.setTitle("Data Base Project");
		this.setSize(960,540);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		
		imgPanel = new IntroPanel();
		container.add(imgPanel,BorderLayout.CENTER);
		
		control = new JPanel();
		control.setLayout(new GridLayout(1,2));
		signIn = new JButton("Sign In");
		signIn.setBackground(Color.GRAY);
		signIn.addActionListener(this);
		control.add(signIn);
		exit =new JButton("Exit");
		exit.setBackground(Color.GRAY);
		exit.addActionListener(this);
		control.add(exit);
		container.add(control,BorderLayout.SOUTH);
		
		this.setContentPane(container);
	}
	
	public void showWin(){this.setVisible(true);}
	
	public void deleteWin(){this.setVisible(false);}
	
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()== signIn){
			System.out.println("[MSG] The app is getting information to sign in ...");
			DialogDBC DBC = new DialogDBC(null, "Database connection error", true);
			DBCI = DBC.showDBCInformation();
			JOptionPane.showMessageDialog(null, DBCI.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
			while(DBC.isVisible() == true){
				try {
					Thread.sleep(0);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.deleteWin();
		}
		if(arg0.getSource() == exit){
			System.out.println("[MSG] The app is quitting ...");
			this.deleteWin();
			System.exit(0);
		}
	}
	
	public DBCInformation getDBCInformation(){return DBCI;}
}
