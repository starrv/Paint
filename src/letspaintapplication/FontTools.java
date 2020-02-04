package letspaintapplication;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FontTools extends JPanel implements ActionListener, MouseMotionListener, KeyListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4011362814260279589L;
	private JButton green, yellow, orange, blue, black, white, red, pink, lightGray, darkGray, magenta, cyan, buttonSelected, chocolate1, peach1;
	//private Graphics buffer;
	//private Image image;
	private Color chocolate, peach;
	private Whiteboard w;
	private JLabel title;
	
	public FontTools(Whiteboard w)
	{
		addMouseMotionListener(this);
		setLayout(new GridLayout(0,1));
		this.w=w;
		title=new JLabel("Font Colors:");
		title.setFont(new Font("Sans Serif", Font.BOLD, 20));
		add(title);
		setOpaque(true);
		setBackground(Color.white);
		
		orange=new JButton("orange");
	    orange.addActionListener(this);
	    orange.addKeyListener(this);
	    orange.setOpaque(true);
	    
	    blue=new JButton("blue");
	    blue.addActionListener(this);
	    blue.addKeyListener(this);
	    blue.setOpaque(true);
	    
	    black=new JButton("black");
	    black.addActionListener(this);
	    black.addKeyListener(this);
	    black.setOpaque(true);
	    
		green=new JButton("green");
	    green.addActionListener(this);
	    green.addKeyListener(this);
	    green.setOpaque(true);
	    
	    yellow=new JButton("yellow");
	    yellow.addActionListener(this);
	    yellow.addKeyListener(this);
	    yellow.setOpaque(true);
	    
	    white=new JButton("white");
	    white.addActionListener(this);
	    white.addKeyListener(this);
	    white.setOpaque(true);
	    
	    red=new JButton("red");
	    red.addActionListener(this);
	    red.addKeyListener(this);
	    red.setOpaque(true);
	    
	    darkGray=new JButton("dark gray");
	    darkGray.addActionListener(this);
	    darkGray.addKeyListener(this);
	    darkGray.setOpaque(true);
	    
	    lightGray=new JButton("light gray");
	    lightGray.addActionListener(this);
	    lightGray.addKeyListener(this);
	    lightGray.setOpaque(true);
	    
	    pink=new JButton("pink");
	    pink.addActionListener(this);
	    pink.addKeyListener(this);
	    pink.setOpaque(true);
	    
	    magenta=new JButton("magenta");
	    magenta.addActionListener(this);
	    magenta.addKeyListener(this);
	    magenta.setOpaque(true);
	    
	    cyan=new JButton("cyan");
	    cyan.addActionListener(this);
	    cyan.addKeyListener(this);
	    cyan.setOpaque(true);
	    
	    chocolate=new Color(125,30,45,50);
	    chocolate1=new JButton("chocolate");
	    chocolate1.addActionListener(this);
	    chocolate1.addKeyListener(this);
	    chocolate1.setOpaque(true);
	    
	    peach=new Color(25,100,95,25);
	    peach1=new JButton("peach");
	    peach1.addActionListener(this);
	    peach1.addKeyListener(this);
	    peach1.setOpaque(true);
	    
	    add(green);
	    add(yellow);
	    add(orange);
	    add(blue);
	    add(black);
	    add(pink);
	    add(red);
	    add(lightGray);
	    add(darkGray);
	    add(magenta);
	    add(cyan);
	    add(white);
	    add(chocolate1);
	    add(peach1);
	    buttonSelected=black;
	    buttonSelected.setBackground(Color.black);
	    setVisible(true);  
	}
	
	public FontTools(Whiteboard w, int x, int y)
	{
		this(w);
		setSize(x,y);
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="green")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.green);
			buttonSelected=green;
			green.setBackground(Color.green);
		}
		else if(event.getActionCommand()=="yellow")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.yellow);
			buttonSelected=yellow;
			yellow.setBackground(Color.yellow);	
		}
		else if(event.getActionCommand()=="orange")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.orange);
			buttonSelected=orange;
			orange.setBackground(Color.orange);
		}
		else if(event.getActionCommand()=="blue")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.blue);
			buttonSelected=blue;
			blue.setBackground(Color.blue);
			
		}
		else if(event.getActionCommand()=="black")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.black);
			buttonSelected=black;
			black.setBackground(Color.black);
		}
		else if(event.getActionCommand()=="light gray")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.lightGray);
			buttonSelected=lightGray;
			lightGray.setBackground(Color.lightGray);
		}
		else if(event.getActionCommand()=="dark gray")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.darkGray);
			buttonSelected=darkGray;
			darkGray.setBackground(Color.darkGray);
		}
		else if(event.getActionCommand()=="red")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.red);
			buttonSelected=red;
			red.setBackground(Color.red);
		}
		else if(event.getActionCommand()=="pink")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.pink);
			buttonSelected=pink;
			pink.setBackground(Color.pink);
		}
		else if(event.getActionCommand()=="magenta")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.magenta);
			buttonSelected=magenta;
			magenta.setBackground(Color.magenta);
		}
		else if(event.getActionCommand()=="cyan")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.cyan);
			buttonSelected=cyan;
			cyan.setBackground(Color.cyan);
		}
		else if(event.getActionCommand()=="white")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(Color.white);
			buttonSelected=white;
			white.setBackground(Color.white);
		}		
		else if(event.getActionCommand()=="chocolate")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(chocolate);
			buttonSelected=chocolate1;
			chocolate1.setBackground(chocolate);
		}
		else if(event.getActionCommand()=="peach")
		{
			buttonSelected.setBackground(new Color(238,238,238));	
			w.setFontColor(peach);
			buttonSelected=peach1;
			peach1.setBackground(peach);
		}
	}
	

	@Override
	public void mouseDragged(MouseEvent event)
	{
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) 
	{
		// TODO Auto-generated method stub
		if(event.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(event.getComponent().equals(green))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.green);
				buttonSelected=green;
				green.setBackground(Color.green);
			
			}
			else if(event.getComponent().equals(yellow))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.yellow);
				buttonSelected=yellow;
				yellow.setBackground(Color.yellow);		
			}
			else if(event.getComponent().equals(orange))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.orange);
				buttonSelected=orange;
				orange.setBackground(Color.orange);
			}
			else if(event.getComponent().equals(blue))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.blue);
				buttonSelected=blue;
				blue.setBackground(Color.blue);
				
			}
			else if(event.getComponent().equals(black))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.black);
				buttonSelected=black;
				black.setBackground(Color.black);
			}
			else if(event.getComponent().equals(lightGray))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.lightGray);
				buttonSelected=lightGray;
				lightGray.setBackground(Color.lightGray);
			}
			else if(event.getComponent().equals(darkGray))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.darkGray);
				buttonSelected=darkGray;
				darkGray.setBackground(Color.darkGray);
			}
			else if(event.getComponent().equals(red))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.red);
				buttonSelected=red;
				red.setBackground(Color.red);
			}
			else if(event.getComponent().equals(pink))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.pink);
				buttonSelected=pink;
				pink.setBackground(Color.pink);
			}
			else if(event.getComponent().equals(magenta))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.magenta);
				buttonSelected=magenta;
				magenta.setBackground(Color.magenta);
			}
			else if(event.getComponent().equals(cyan))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.cyan);
				buttonSelected=cyan;
				cyan.setBackground(Color.cyan);
			}
			else if(event.getComponent().equals(white))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(Color.white);
				buttonSelected=white;
				white.setBackground(Color.white);
			}		
			else if(event.getComponent().equals(chocolate1))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(chocolate);
				buttonSelected=chocolate1;
				chocolate1.setBackground(chocolate);
			}
			else if(event.getComponent().equals(peach1))
			{
				buttonSelected.setBackground(new Color(238,238,238));	
				w.setFontColor(peach);
				buttonSelected=peach1;
				peach1.setBackground(peach);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
