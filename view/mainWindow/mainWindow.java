package view.mainWindow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class mainWindow extends JFrame {
	private jpanel_west_infoUtente westJP;
	private jpanel_center_contactTable centerJP;
	private toolbar_nord toolb;
	private editorPersona editFrame;
	private editorPersona MVFrame;

	public mainWindow(String _nomeutente, String _nome, String _cognome) {
		super("Rubrica di: " + _nomeutente); 
		westJP=new jpanel_west_infoUtente(_nomeutente, _nome, _cognome);
		centerJP=new jpanel_center_contactTable();
		toolb=new toolbar_nord();
		editFrame= new editorPersona();
		MVFrame= new editorPersona();  

		Container cont = this.getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(toolb,BorderLayout.NORTH);
		cont.add(centerJP,BorderLayout.CENTER);
		cont.add(westJP,BorderLayout.WEST);

		setSize(1000,600);
		this.setLocationRelativeTo(null);
	}
	
	public void updateContactTable(String[][] newVal){
		centerJP.cleanrowTable();
		centerJP.insertrowTable(newVal);
	}
	
	public void ClearContactTable() {
		centerJP.cleanrowTable();
	}
	
	public void addMainWindowListener(ActionListener actionL){
		toolb.addListener(actionL);
	}
	
	public void addEditFrameListener(ActionListener actionL){
		editFrame.addListener(actionL);
	}
	
	public void addModifyViewListener(ActionListener actionL){
		MVFrame.addListener(actionL);
	}
	
	public void setVisibleEditFrame(Boolean b){
		editFrame.setVisible(b);
	}
	
	public String[] getFieldEditPersona() {
		return editFrame.getField();
	}
	
	public void showMessageDialog(String mss) {
		JOptionPane.showMessageDialog(this,mss,"Alert",JOptionPane.WARNING_MESSAGE);
	}
	
	public void cleanFieldEditPersona() {
		editFrame.cleanField();
	}
	
	public boolean isrowtbleselected() {
		return centerJP.isrowselected();
	}
	
	public String[] getDataSelTable() {
		return centerJP.getDataSelRow();
	}
	
	public void cleanFieldMVPersona() {
		MVFrame.cleanField();
	}
	
	public void setVisibleMVPersona(Boolean b){
		MVFrame.setVisible(b);
	}
	
	public void setFieldMVPersona(String[] datip) {
		MVFrame.setField(datip);
	}
	
	public void setFieldEditableMVPersona(boolean value){
		MVFrame.setFieldEditable(value);
	}
	
	public void setMVPButtonsave(boolean value){
		MVFrame.EnableSaveButton(value);
	}
	
	public String[] getFieldMVPersona() {
		return MVFrame.getField();
	}
	
	public void setMVPersonaID(int ID){
		MVFrame.setIDcontactModify(ID);
	}
	
	public int getMVPersonaID(){
		return MVFrame.getIDcontactModify();
	}

}
