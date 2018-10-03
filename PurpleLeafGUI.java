import java.awt.BorderLayout;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class PurpleLeafGUI extends JFrame{
	
	JEditorPane browser = new JEditorPane();
	
	public PurpleLeafGUI() {	
		BorderLayout layout = new BorderLayout();
		
		setLayout(layout);
		setTitle("PurpleLeaf");
		setExtendedState(MAXIMIZED_BOTH);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*
		 * BROWSER
		 */		
		browser.setEditable(false);
		
		try {
			browser.setPage("https://www.google.com/");
		} catch (IOException e) {
			System.out.println("Flascher Link");
			e.printStackTrace();
		}
		browser.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent event) {
				HyperlinkEvent.EventType typ = event.getEventType();

				if (typ == HyperlinkEvent.EventType.ACTIVATED) {					
						openLink(event.getURL().toString());					
				}
			}
		});
			
		/*
		 * menübar
		 */
		JMenuBar menubar = new JMenuBar();
		menubar.setSize(1000, 25);
		
		/*
		 * Buttons
		 */
		JButton back = new JButton("⇚");
		JButton forward = new JButton("⇛");
		
		JButton F5 = new JButton("↻");	
		F5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				openLink(browser.getPage().toString());			
			}
		});
		
		/*
		 * adressbar
		 */
		JTextField adressbar = new JTextField();
		adressbar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) { }
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					openLink(adressbar.getText());
				}
				
			}
		});
		adressbar.setFocusAccelerator('s');
		adressbar.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				adressbar.selectAll();
				
			}
		});
		
		adressbar.setFocusAccelerator('s');
		adressbar.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				adressbar.selectAll();
				
			}
		});
		
		/*
		 * Menü
		 */		
		JMenu options = new JMenu("≡");
		JMenuItem neuertab = new JMenuItem("Neuer Tab");
		options.add(neuertab);
		
		/*
		 * Scrollbar
		 */
		JScrollPane bar = new JScrollPane(browser);	
				
		menubar.add(back);
		menubar.add(forward);
		menubar.add(F5);
		menubar.add(adressbar);
		menubar.add(options);
		
		add(menubar, BorderLayout.PAGE_START);
		add(bar , BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void openLink(String link) {
		try {
			
			if(link.startsWith("https://")) {
				browser.setPage(link);
			}else {
				browser.setPage("https://" + link);
				setTitle("PurpleLeaf - " + link);			}
			setTitle("PurpleLeaf - " + browser.getPage().toString());
			
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(browser, "Seite Nicht Gefunden", "Error 404", JOptionPane.OK_CANCEL_OPTION);			
		}
	}
}
