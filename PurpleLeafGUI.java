import java.awt.BorderLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;


public class PurpleLeafGUI extends JFrame{
	
	
	public PurpleLeafGUI() {	
		BorderLayout layout = new BorderLayout();
		
		setLayout(layout);
		setTitle("PurpleLeaf");
		setExtendedState(MAXIMIZED_BOTH);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		System.out.println();
		
		JEditorPane browser = new JEditorPane();
		browser.setBounds(0, 25, 1000, 1000);
		
		browser.setEditable(false);
		
		/*
		 * menübar
		 */
		JMenuBar menubar = new JMenuBar();
		menubar.setSize(1000, 25);
		
		/*
		 * Buttons
		 */
		JButton back = new JButton("BACK");
		JButton forward = new JButton("FORWARD");
		JButton F5 = new JButton("RELOAD");	
		
		/*
		 * adressbar
		 */
		JTextField adressbar = new JTextField();
		
		/*
		 * Menü
		 */
	
		
		JMenu options = new JMenu("Einstellungen");
		JMenuItem neuertab = new JMenuItem("Neuer Tab");
		options.add(neuertab);
		
		/*
		 * Scrollbar
		 */
		JScrollPane scrollbar = new JScrollPane(browser);
		add(scrollbar);
		
		
		
		menubar.add(back);
		menubar.add(forward);
		menubar.add(F5);
		menubar.add(adressbar);
		menubar.add(options);
		
		add(menubar, BorderLayout.PAGE_START);
		
		add(browser, BorderLayout.CENTER);
		
		setVisible(true);
	}
}
