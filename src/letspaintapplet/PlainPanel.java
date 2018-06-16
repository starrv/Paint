package letspaintapplet;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;


public class PlainPanel extends JPanel
{
	private JToolBar toolBar;
	private JLabel firstLabel, label;
	public static final String DEFAULT_DOCUMENT_LABEL="untitled Document  ";
	
	public PlainPanel(Whiteboard w)
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBackground(Color.pink);
		toolBar=new JToolBar("Tools");
		firstLabel=new JLabel("File Name:");
		firstLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
		toolBar.add(firstLabel);
		label=new JLabel(DEFAULT_DOCUMENT_LABEL);
		label.setFont(new Font("Sans Serif", Font.BOLD, 14));
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setForeground(Color.white);
		toolBar.add(label);
		toolBar.add(new FontType(w));
		toolBar.add(new FontSize(w));
		toolBar.add(new FontStyle(w));
		toolBar.add(new Open_SavePanel(w, this));
		toolBar.addSeparator();
		add(toolBar);
		add(new JLabel());
	}
	
	public void changeDocumentLabel(String name)
	{
		label.setText(name+"  ");
	}
	
	public String getDocumentLabel()
	{
		return label.getText();
	}
	
	public JToolBar getToolBar()
	{
		return toolBar;
	}
}
