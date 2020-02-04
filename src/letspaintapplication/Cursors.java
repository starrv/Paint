package letspaintapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Cursors extends JPanel implements ActionListener, KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5217787022390475320L;
	private JButton textCursor, drawCursor, pointerCursor,eraseCursor, paintCursor, paintAllCursor, eraseAllCursor, buttonSelected;
	private Whiteboard w;
	private JLabel title;
	
	
	public Cursors(Whiteboard w)
	{
		setName("Colors");
		setLayout(new FlowLayout());
		title=new JLabel("Tools: ");
		title.setFont(new Font("Sans Serif", Font.BOLD, 20));
		add(title);
		setOpaque(true);
		textCursor=new JButton("text");
		textCursor.addActionListener(this);
		textCursor.setOpaque(true);
		
		drawCursor=new JButton("draw");
		drawCursor.addActionListener(this);
		drawCursor.setOpaque(true);
		
		pointerCursor=new JButton("pointer");
		pointerCursor.addActionListener(this);
		pointerCursor.setOpaque(true);
		
		eraseCursor=new JButton("erase");
		eraseCursor.addActionListener(this);
		eraseCursor.setOpaque(true);
		
		paintCursor=new JButton("paint");
		paintCursor.addActionListener(this);
		paintCursor.setOpaque(true);
		
		paintAllCursor=new JButton("paint all");
		paintAllCursor.addActionListener(this);
		paintAllCursor.addKeyListener(this);
		paintAllCursor.setOpaque(true);
		
		eraseAllCursor=new JButton("erase all");
		eraseAllCursor.addActionListener(this);
		eraseAllCursor.setOpaque(true);
		
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
			buttonSelected.setBackground(new Color(238,238,238));	
			Cursor c=new Cursor(Cursor.TEXT_CURSOR);
			w.setCursor2(c);
			w.setButtonSelected("text");
			buttonSelected=textCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="draw")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setCursor2(createPencilCursor());
			//w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
			w.setButtonSelected("draw");
			buttonSelected=drawCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="pointer")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			Cursor c=new Cursor(Cursor.DEFAULT_CURSOR);
			w.setCursor2(c);		
			w.setButtonSelected("pointer");
			buttonSelected=pointerCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="erase")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setCursor2(createEraserCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("erase");
			buttonSelected=eraseCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="paint")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setCursor2(createPaintBrushCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("paint");
			buttonSelected=paintCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="paint all")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setCursor2(createPaintBrushCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("paint all");
			buttonSelected=paintAllCursor;
			buttonSelected.setBackground(Color.blue);
		}
		else if(event.getActionCommand()=="erase all")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setCursor2(createEraserCursor());
			//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
			w.setButtonSelected("erase all");
			buttonSelected=eraseAllCursor;
			buttonSelected.setBackground(Color.blue);
		}
	}
	public Cursor createPaintBrushCursor()
	{
		
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("brush.png"));
		//image.getGraphics().setColor(w.getBackground());
		Point hotSpot=new Point(0,0);
		Cursor c=toolkit.createCustomCursor(image, hotSpot, "brush");
	  	return c;
	}
	
	public Cursor createPencilCursor()
	{
	  	Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("pencil.png"));
		//image.getGraphics().setColor(w.getBackground());
		Point hotSpot=new Point(0,0);
		Cursor c=toolkit.createCustomCursor(image, hotSpot, "pencil");
	  	return c;
	}
	
	public Cursor createEraserCursor()
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	  	Image image=toolkit.getImage(Cursors.class.getClassLoader().getResource("erase.png"));
	  	//image.getGraphics().setColor(w.getBackground());
	  	Point hotSpot=new Point(0,0);
	  	Cursor c=toolkit.createCustomCursor(image, hotSpot, "eraser");
	  	return c;
	}


	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(event.getKeyCode()==KeyEvent.VK_ENTER) {
				if(event.getComponent().equals(textCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					Cursor c=new Cursor(Cursor.TEXT_CURSOR);
					w.setCursor2(c);
					w.setButtonSelected("text");
					buttonSelected=textCursor;
					buttonSelected.setBackground(Color.blue);
				}
				else if(event.getComponent().equals(drawCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					w.setCursor2(createPencilCursor());
					//w.setCursor2(new Cursor(Cursor.CROSSHAIR_CURSOR));
					w.setButtonSelected("draw");
					buttonSelected=drawCursor;
					buttonSelected.setBackground(Color.blue);
				}
				else if(event.getComponent().equals(pointerCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					Cursor c=new Cursor(Cursor.DEFAULT_CURSOR);
					w.setCursor2(c);		
					w.setButtonSelected("pointer");
					buttonSelected=pointerCursor;
					buttonSelected.setBackground(Color.blue);
				}
				else if(event.getComponent().equals(eraseCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					w.setCursor2(createEraserCursor());
					//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
					w.setButtonSelected("erase");
					buttonSelected=eraseCursor;
					buttonSelected.setBackground(Color.blue);
				}
				else if(event.getComponent().equals(paintCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					w.setCursor2(createPaintBrushCursor());
					//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
					w.setButtonSelected("paint");
					buttonSelected=paintCursor;
					buttonSelected.setBackground(Color.blue);
				}
				else if(event.getComponent().equals(eraseCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					w.setCursor2(createPaintBrushCursor());
					//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
					w.setButtonSelected("paint all");
					buttonSelected=paintAllCursor;
					buttonSelected.setBackground(Color.blue);
				}
				else if(event.getComponent().equals(eraseAllCursor))
				{
					buttonSelected.setBackground(new Color(238,238,238));	
					w.setCursor2(createEraserCursor());
					//w.setCursor2(new Cursor(Cursor.HAND_CURSOR));
					w.setButtonSelected("erase all");
					buttonSelected=eraseAllCursor;
					buttonSelected.setBackground(Color.blue);
				}
		}
		
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
