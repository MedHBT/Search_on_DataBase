package dbProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuEditor extends JMenuBar{

	private static final long serialVersionUID = -8145111834818872769L;
	
	private JMenuItem signOut,exit,apropos;
	
	private boolean signOutBoolean =false;

	public MenuEditor(final MainWindow MW) {
		
		JMenu MenuFile = new JMenu("File");
		
		signOut = new JMenuItem("sign out");
		signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("[MSG] The app is sign out ...");
				signOutBoolean = true;
				MW.deleteWin();
			}
		});
		
		exit = new JMenuItem("exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("[MSG] The app is quiting ...");
				System.exit(0);
			}
		});
		
		MenuFile.add(signOut);
		MenuFile.addSeparator();
		MenuFile.add(exit);
		
		this.add(MenuFile);
		
		JMenu MenuHelp = new JMenu("Help");
		
		apropos = new JMenuItem("About us");
		apropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"A software developed by Haddad Amine and Ben taieb Med Hassine"
						+ "Hassine", "Data Base v1.0", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		MenuHelp.add(apropos);
		
		this.add(MenuHelp);
	}
	
	public JMenuItem getNewFile(){return signOut;}
	public JMenuItem getExit(){return exit;}
	public JMenuItem getapropos(){return apropos;}
	
	public void setSignOutBoolean(boolean signOutBoolean ){this.signOutBoolean=signOutBoolean;}
	public boolean getSignOutBoolean(){return signOutBoolean;}
}
