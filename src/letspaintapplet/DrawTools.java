package letspaintapplet;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class DrawTools extends JPanel implements ActionListener, MouseMotionListener
{
	private JButton green, yellow, orange, blue, black, white, red, pink, lightGray, darkGray, magenta, cyan, chocolate1, peach1, buttonSelected;
	//private Graphics buffer;
	//private Image image;
	private Color chocolate, peach;
	private Whiteboard w;
	private JLabel title;
	
	public DrawTools(Whiteboard w)
	{
		addMouseMotionListener(this);
		setLayout(new GridLayout(0,1));
		this.w=w;
		setBackground(Color.pink);
		title=new JLabel("Draw Colors:");
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(title);
		orange=new JButton("orange");
		orange.setBackground(Color.black);
		orange.setForeground(Color.white);
	    orange.addActionListener(this);
	    blue=new JButton("blue");
	    blue.setBackground(Color.black);
		blue.setForeground(Color.white);
	    blue.addActionListener(this);
	    black=new JButton("black");
	    black.setBackground(Color.black);
		black.setForeground(Color.white);
	    black.addActionListener(this);
		green=new JButton("green");
		green.setBackground(Color.black);
		green.setForeground(Color.white);
	    green.addActionListener(this);
	    yellow=new JButton("yellow");
	    yellow.setBackground(Color.black);
		yellow.setForeground(Color.white);
	    yellow.addActionListener(this);
	    white=new JButton("white");
		white.setBackground(Color.black);
		white.setForeground(Color.white);
	    white.addActionListener(this);
	    red=new JButton("red");
		red.setBackground(Color.black);
		red.setForeground(Color.white);
	    red.addActionListener(this);
	    darkGray=new JButton("dark gray");
		darkGray.setBackground(Color.black);
		darkGray.setForeground(Color.white);
	    darkGray.addActionListener(this);
	    lightGray=new JButton("light gray");
		lightGray.setBackground(Color.black);
		lightGray.setForeground(Color.white);
	    lightGray.addActionListener(this);
	    pink=new JButton("pink");
		pink.setBackground(Color.black);
		pink.setForeground(Color.white);
	    pink.addActionListener(this);
	    magenta=new JButton("magenta");
		magenta.setBackground(Color.black);
		magenta.setForeground(Color.white);
	    magenta.addActionListener(this);
	    cyan=new JButton("cyan");
		cyan.setBackground(Color.black);
		cyan.setForeground(Color.white);
	    cyan.addActionListener(this);
	    chocolate=new Color(125,30,45,50);
	    chocolate1=new JButton("chocolate");
	    chocolate1.setBackground(Color.black);
	    chocolate1.setForeground(Color.white);
	    chocolate1.addActionListener(this);
	    peach=new Color(225,200,195,25);
	    peach1=new JButton("peach");
	    peach1.setBackground(Color.black);
	    peach1.setForeground(Color.white);
	    peach1.addActionListener(this);
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
	    setVisible(true);  
	}
	
	public DrawTools(Whiteboard w, int x, int y)
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
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.green);
			buttonSelected=green;
			green.setBackground(Color.green);
		
		}
		else if(event.getActionCommand()=="yellow")
		{
			buttonSelected.setBackground(Color.black);
			w.setDrawColor(Color.yellow);
			buttonSelected=yellow;
			yellow.setBackground(Color.yellow);			
		}
		if(event.getActionCommand()=="orange")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.orange);
			buttonSelected=orange;
			orange.setBackground(Color.orange);
		}
		else if(event.getActionCommand()=="blue")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.blue);
			buttonSelected=blue;
			blue.setBackground(Color.blue);
			
		}
		if(event.getActionCommand()=="black")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.black);
			buttonSelected=black;
			black.setBackground(Color.black);
		}
		if(event.getActionCommand()=="light gray")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.lightGray);
			buttonSelected=lightGray;
			lightGray.setBackground(Color.lightGray);
		}
		if(event.getActionCommand()=="dark gray")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.darkGray);
			buttonSelected=darkGray;
			darkGray.setBackground(Color.darkGray);
		}
		if(event.getActionCommand()=="red")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.red);
			buttonSelected=red;
			red.setBackground(Color.red);
		}
		if(event.getActionCommand()=="pink")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.pink);
			buttonSelected=pink;
			pink.setBackground(Color.pink);
		}
		if(event.getActionCommand()=="magenta")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.magenta);
			buttonSelected=magenta;
			magenta.setBackground(Color.magenta);
		}
		if(event.getActionCommand()=="cyan")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.cyan);
			buttonSelected=cyan;
			cyan.setBackground(Color.cyan);
		}
		if(event.getActionCommand()=="white")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(Color.white);
			buttonSelected=white;
			white.setBackground(Color.white);
			white.setForeground(Color.black);
		}
		if(event.getActionCommand()=="chocolate")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(chocolate);
			buttonSelected=chocolate1;
			buttonSelected.setBackground(chocolate);
		}
		if(event.getActionCommand()=="peach")
		{
			buttonSelected.setBackground(Color.black);
			if(buttonSelected.equals(white))
			{
				buttonSelected.setForeground(Color.white);
			}
			w.setDrawColor(peach);
			buttonSelected=peach1;
			buttonSelected.setBackground(peach);
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
	
}
