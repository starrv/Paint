package letspaintapplication;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Display extends JFrame implements WindowListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5657371353338627325L;
	private static Whiteboard whiteboard;
	private static Clip clip;
	private int width=1350;
	private int height=500;
	
	private URL getResource(String file)
	{
		return getClass().getClassLoader().getResource(file);
	}
	
	public Display()
	{
		//setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		setSize(width, height);
		setTitle("Paint");
		URL url = getResource("PaintIcon.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(url));
		setLayout(new BorderLayout());
		setFont(new Font("Sans Serif", Font.BOLD, 20));
		whiteboard=new Whiteboard();
		whiteboard.setBorder(new LineBorder(Color.black));
		add(whiteboard, BorderLayout.CENTER);
		FontTools fontTools=new FontTools(whiteboard);
		add(fontTools, BorderLayout.EAST);
		PlainPanel panel=new PlainPanel(whiteboard);
		add(panel,BorderLayout.NORTH);
		DrawTools drawTools=new DrawTools(whiteboard);
		add(drawTools,BorderLayout.WEST);
		Cursors cursors=new Cursors(whiteboard);
		add(cursors,BorderLayout.SOUTH);
		setBackground(Color.pink);
		setVisible(true);
		addWindowListener(this);
		whiteboard.eraseAll();//this.setIgnoreRepaint(true);
		//Functions.Functions.printMessage(whiteboard.getIgnoreRepaint()+" to ignore repaint");
		//playMusic();
	}

	public static void playMusic()
	{
		URL url=null;
		try 
		{
			url=Display.class.getClassLoader().getResource("PaintSong.wav");
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	       // JOptionPane.showMessageDialog(null, "Music started");
		} 
		catch(Exception ex) 
		{
	    	Functions.printMessage(ex.getMessage());
	        JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	}
	
	public static void stopMusic()
	{
		if(clip!=null)
			clip.stop();
		//JOptionPane.showMessageDialog(null,"music stopped");
	}
	//C:/Users/Owner/workspace1/Paint/src/paint/Maid with the Flaxen Hair.mp3
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent event) 
	{
		// TODO Auto-generated method stub
		stopMusic();
		System.exit(0);
		//JOptionPane.showMessageDialog(this, "music stopped");
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		stopMusic();
		System.exit(0);
		//JOptionPane.showMessageDialog(this, "music stopped");
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

