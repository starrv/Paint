package letspaintapplet;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Cursors extends JPanel implements ActionListener, KeyListener
{
	private JButton textCursor, drawCursor, pointerCursor,eraseCursor, paintCursor, paintAllCursor, eraseAllCursor, buttonSelected;
	private Whiteboard w;
	private JLabel title;
	
	
	public Cursors(Whiteboard w)
	{
		setName("Colors");
		setLayout(new FlowLayout());
		setBackground(Color.pink);
		title=new JLabel("Tools: ");
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(title);
		textCursor=new JButton("text");
		textCursor.setBackground(Color.black);
		textCursor.setForeground(Color.white);
		textCursor.addActionListener(this);
		drawCursor=new JButton("draw");
		drawCursor.setBackground(Color.black);
		drawCursor.setForeground(Color.white);
		drawCursor.addActionListener(this);
		pointerCursor=new JButton("pointer");
		pointerCursor.setBackground(Color.black);
		pointerCursor.setForeground(Color.white);
		pointerCursor.addActionListener(this);
		eraseCursor=new JButton("erase");
		eraseCursor.setBackground(Color.black);
		eraseCursor.setForeground(Color.white);
		eraseCursor.addActionListener(this);
		paintCursor=new JButton("paint");
		paintCursor.setBackground(Color.black);
		paintCursor.setForeground(Color.white);
		paintCursor.addActionListener(this);
		paintAllCursor=new JButton("paint all");
		paintAllCursor.setBackground(Color.black);
		paintAllCursor.setForeground(Color.white);
		paintAllCursor.addActionListener(this);
		paintAllCursor.addKeyListener(this);
		eraseAllCursor=new JButton("erase all");
		eraseAllCursor.setBackground(Color.black);
		eraseAllCursor.setForeground(Color.white);
		eraseAllCursor.addActionListener(this);
		this.w=w;
		add(textCursor);
		add(drawCursor);
		add(pointerCursor);
		add(eraseCursor);
		add(paintCursor);
		add(paintAllCursor);
		add(eraseAllCursor);
		buttonSelected=pointerCursor;
		buttonSelected.setBackground(Color.blue);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="text")
		{
			buttonSelected.setBackground(Color.black);
			Cursor c=new Cursor(Cursor.TEXT_CURSOR);
			w.setCursor2(c);
			w.setButtonSelected("text");
			buttonSelected=textCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="draw")
		{
			buttonSelected.setBackground(Color.black);
			//w.setCursor2(createPencilCursor());
			w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("draw");
			buttonSelected=drawCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="pointer")
		{
			buttonSelected.setBackground(Color.black);
			Cursor c=new Cursor(Cursor.DEFAULT_CURSOR);
			w.setCursor2(c);		
			w.setButtonSelected("pointer");
			buttonSelected=pointerCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="erase")
		{
			buttonSelected.setBackground(Color.black);
			//w.setCursor2(createEraserCursor());
			w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("erase");
			buttonSelected=eraseCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="paint")
		{
			buttonSelected.setBackground(Color.black);
			w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("paint");
			buttonSelected=paintCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="paint all")
		{
			buttonSelected.setBackground(Color.black);
			w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("paint all");
			buttonSelected=paintAllCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="erase all")
		{
			buttonSelected.setBackground(Color.black);
			w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("erase all");
			buttonSelected=eraseAllCursor;
			buttonSelected.setBackground(Color.blue);
		}
	}
	
	public Cursor createPencilCursor()
	  {
		  	Toolkit toolkit=Toolkit.getDefaultToolkit();
		  	Image image=toolkit.getImage("paint/pencil.jpg");
		  	//image.getGraphics().setColor(w.getBackground());
		  	Point hotSpot=new Point(0,0);
		  	Cursor c=toolkit.createCustomCursor(image, hotSpot, "pencil");
		  	return c;
	  }
	
	public Cursor createEraserCursor()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage("paint/erase.jpg");
	  	//image.getGraphics().setColor(w.getBackground());
	  	Point hotSpot=new Point(0,0);
	  	Cursor c=toolkit.createCustomCursor(image, hotSpot, "eraser");
	  	return c;
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
