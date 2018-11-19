package view.mainWindow;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class toolbar_nord extends JToolBar {
    private JButton Bnew = new JButton("Nuovo");
    private JButton Bdel = new JButton("Elimina");
    private JButton Bmod = new JButton("Modifica");
    private JButton Bview = new JButton("Visualizza");
    
	public toolbar_nord() {
		super();
	    setRollover(true);
	    add(Bnew);
	    add(Bdel);
	    add(Bmod);
	    add(Bview);
	}
	
	 public void addListener(ActionListener lsnnewB){
		 Bnew.addActionListener(lsnnewB);
		 Bdel.addActionListener(lsnnewB);
		 Bmod.addActionListener(lsnnewB);
		 Bview.addActionListener(lsnnewB);
	 }

}
