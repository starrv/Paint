package letspaintapplet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FontSize extends JPanel implements ItemListener
{
	
	private Whiteboard w;
	private JComboBox<String> fontSizeList;
	//private JButton[] JButtonBox;
	//private JButton buttonSelected;
	private String[] JLabels;
	private JLabel label;
	
	public FontSize(Whiteboard w)
	{
		this.w=w;
		setBackground(Color.pink);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		label=new JLabel("Font Size: ");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		//add(label);
		addLabels();
		fontSizeList=new JComboBox<String>(JLabels);
		fontSizeList.setBackground(Color.black);
		fontSizeList.setForeground(Color.white);
		fontSizeList.addItemListener(this);
		fontSizeList.setSelectedIndex(2);
		add(fontSizeList);
		//w.setFontSize(Integer.parseInt(JLabels[2]));
		//addButtons();
		//buttonSelected=JButtonBox[1];
		//System.out.println(JButtonBox[1]);
		//buttonSelected.setBackground(Color.orange);
	}
	
	private void addLabels()
	{
		JLabels=new String[34];
		for(int i=0; i<JLabels.length; i++)
		{
			//System.out.println("Add Label "+i);
			JLabels[i]=Integer.toString(8+2*i);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		// TODO Auto-generated method stub
		for(int i=0; i<JLabels.length; i++)
		{
			if(event.getItem().equals(JLabels[i]))
			{
				System.out.println(JLabels[i]);
				w.setFontSize(Integer.parseInt(JLabels[i]));
			}
		}
		
	}
	
	/*private void addButtons()
	{
		JButtonLabels=new String[32];
		for(int i=0; i<JButtonLabels.length; i++)
		{
			System.out.println("Add Label "+i);
			JButtonLabels[i]=Integer.toString(8+2*i);
		}
		JButtonBox=new JButton[JButtonLabels.length];
		for(int i=0; i<JButtonLabels.length; i++)
		{
			System.out.println("Add button "+i);
			JButtonBox[i]=new JButton(JButtonLabels[i]);
			JButtonBox[i].setBackground(Color.black);
			JButtonBox[i].setForeground(Color.white);
			JButtonBox[i].addActionListener(this);
			add(JButtonBox[i]);	
		}	
	}*/
	
	
	/*private int getIndex(String buttonName)
	{
		for(int i=0; i<JButtonBox.length; i++)
		{
			if(JButtonBox[i].getText().equals(buttonName))
			{
				return i;
			}
		}
		return -1;
	}*/

	/*@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		for(int i=0; i<JButtonLabels.length;i++)
		{
			if(event.getActionCommand().equals(JButtonBox[i].getText()))
			{
				buttonSelected.setBackground(Color.black);
				w.setFontSize(Integer.parseInt(JButtonBox[i].getText()));
				buttonSelected=JButtonBox[i];
				buttonSelected.setBackground(Color.orange);
			}
		}
	}*/

}