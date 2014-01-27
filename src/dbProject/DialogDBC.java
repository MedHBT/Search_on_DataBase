package dbProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogDBC extends JDialog {

	private static final long serialVersionUID = 2962904306712418163L;
	
	private DBCInformation DBCI = new DBCInformation();
	//private boolean sendData ;
	private JLabel LabelAddressServer,LabelPortServer,LabelDataBaseName,LabelUser,LabelPassword;
	private JTextField TextFieldPortServer,TextFieldAddressServer,TextFieldDataBaseName,TextFieldUser,TextFieldPassword;
	
	public DialogDBC(JFrame parent, String title, boolean modal){
		//On appelle le construteur de JDialog correspondant
		super(parent, title, modal);
		//On spécifie une taille
		this.setSize(500, 300);
		//La position
		this.setLocationRelativeTo(null);
		//La boîte ne devra pas être redimensionnable
		this.setResizable(false);

		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
		//this.setVisible(true);
	}
	
	public DBCInformation showDBCInformation(){
		//this.sendData =false;
		this.setVisible(true);
		return this.DBCI;
	}
	
	public void initComponent(){
		
	    //Les informations sur le serveur
	    JPanel panServerInfo = new JPanel();
	    //panServerInfo.setBackground(Color.white);
	    panServerInfo.setPreferredSize(new Dimension(220,200));
	    TextFieldAddressServer = new JTextField();
	    TextFieldAddressServer.setPreferredSize(new Dimension(100, 25));
	    panServerInfo.setBorder(BorderFactory.createTitledBorder("The Server Information"));
	    LabelAddressServer = new JLabel("The Server Address :");
	    panServerInfo.add(LabelAddressServer);
	    panServerInfo.add(TextFieldAddressServer);
	    TextFieldPortServer = new JTextField();
	    TextFieldPortServer.setPreferredSize(new Dimension(100, 25));
	    panServerInfo.setBorder(BorderFactory.createTitledBorder("The Port Address"));
	    LabelPortServer = new JLabel("The Port Address :");
	    panServerInfo.add(LabelPortServer);
	    panServerInfo.add(TextFieldPortServer);
	    TextFieldDataBaseName = new JTextField();
	    TextFieldDataBaseName.setPreferredSize(new Dimension(100, 25));
	    LabelDataBaseName = new JLabel("The DataBase Name :");
	    panServerInfo.add(LabelDataBaseName);
	    panServerInfo.add(TextFieldDataBaseName);
	    
	    
	    //L'utilisateur
	    JPanel panUserInfo = new JPanel();
	    //panUser.setBackground(Color.white);
	    panUserInfo.setPreferredSize(new Dimension(220, 200));
	    panUserInfo.setBorder(BorderFactory.createTitledBorder("User Information:"));
	    TextFieldUser = new JTextField();
	    TextFieldUser.setPreferredSize(new Dimension(100, 25));
	    LabelUser = new JLabel("The User Identification:");
	    panUserInfo.add(LabelUser);
	    panUserInfo.add(TextFieldUser);
	    TextFieldPassword =new JTextField();
	    TextFieldPassword.setPreferredSize(new Dimension(100,25));
	    LabelPassword =new JLabel("The User password :");
	    panUserInfo.add(LabelPassword);
	    panUserInfo.add(TextFieldPassword);
	    
	    
	    JPanel content = new JPanel();
	    //content.setBackground(Color.white);
	    content.add(panServerInfo);
	    content.add(panUserInfo);
	    
	    JPanel control = new JPanel();
	    control.setLayout(new GridLayout(1,2));
	    
	    JButton okBouton = new JButton("OK");
	    okBouton.setBackground(Color.gray);
	    
	    okBouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		System.out.println("[MSG] The app is saving information to sign in ...");
	    		DBCI.setAddressServer(TextFieldAddressServer.getText());
	    		DBCI.setPortServer(TextFieldPortServer.getText());
	    		DBCI.setDataBaseName(TextFieldDataBaseName.getText());
	    		DBCI.setUser(TextFieldUser.getText());
	    		DBCI.setPassword(TextFieldPassword.getText());
	    		setVisible(false);
	    	}     
	    });

	    JButton cancelBouton = new JButton("Cancel");
	    cancelBouton.setBackground(Color.GRAY);
	    cancelBouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		System.out.println("[MSG] The app is quitting ...");
	    		setVisible(false);
	    		System.exit(4);
	    	}
	    });

	    control.add(okBouton);
	    control.add(cancelBouton);
	    
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);				
	}
}