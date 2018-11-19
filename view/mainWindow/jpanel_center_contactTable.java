package view.mainWindow;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class jpanel_center_contactTable extends JPanel {
	
	private JTable table;
	private String[] columnHeaders = {"Nome", "Cognome", "Telefono"};
	
	public jpanel_center_contactTable() {
		this.setPreferredSize(new Dimension(600, 600));
        table= new JTable(new DefaultTableModel(columnHeaders,0));
        table.setPreferredSize(new Dimension(600,600));
        table.setFillsViewportHeight(true);
        JScrollPane jsp= new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(590,530));
		this.add(jsp);
	}
	
	public void insertrowTable(String[][] newVal) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0;i<newVal.length;i++) {
			model.addRow(newVal[i]);
		}
	}
	
	public void cleanrowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
	
	public boolean isrowselected() {
		return table.getSelectionModel().isSelectionEmpty();
	}
	
	public String[] getDataSelRow() {
		String[] s=new String[3];
		s[0]=(String)table.getValueAt(table.getSelectedRow(),0);
		s[1]=(String)table.getValueAt(table.getSelectedRow(),1);
		s[2]=(String)table.getValueAt(table.getSelectedRow(),2);
		return s;
	}
	
	public int CountRows() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		return model.getRowCount();
	}
		
}
