package letspaintapplet;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Display1 extends JApplet implements ActionListener
{
	private static BufferedImage image;
	private Whiteboard whiteboard;
	private static Clip clip;
	private static AudioClip audioClip;
	private PlainPanel panel;
	private JButton playMusicButton, stopMusicButton;
	
	public void init()
	{
		//setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		setSize(1350, 500);
		showStatus("Loading....please wait");
		
		//setBackground(Color.orange);
		setLayout(new BorderLayout());
		whiteboard=new Whiteboard();
		whiteboard.setBorder(new LineBorder(Color.black));
		add(whiteboard, BorderLayout.CENTER);
		FontTools fontTools=new FontTools(whiteboard);
		add(fontTools, BorderLayout.EAST);
		panel=new PlainPanel(whiteboard);
		add(panel,BorderLayout.NORTH);
		DrawTools drawTools=new DrawTools(whiteboard);
		add(drawTools,BorderLayout.WEST);
		Cursors cursors=new Cursors(whiteboard);
		add(cursors,BorderLayout.SOUTH);
		playMusicButton=new JButton("play music");
		addPlayMusicButton();
		stopMusicButton=new JButton("stop music");
		addStopMusicButton();
	}
	
	public static void playMusic()
	{
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/wamp/www/cmp342/Paint/bin/paint/maid with the flaxen hair.au").getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	        //JOptionPane.showMessageDialog(null, "Music started");
	    } catch(Exception ex) {
	        JOptionPane.showMessageDialog(null,"Error with reading/playing sound.  Error message: "+ex.getMessage());
	    }
	}
	
	public static void stopMusic()
	{
		if(clip!=null)
			clip.stop();
		//JOptionPane.showMessageDialog(null,"music stopped");
	}
	 public void addPlayMusicButton()
	 {
		 playMusicButton.addActionListener(this);
		 panel.getToolBar().add(playMusicButton);
	 }
	 
	 public void addStopMusicButton()
	 {
		 stopMusicButton.addActionListener(this);
		 panel.getToolBar().add(stopMusicButton);
	 }
	//C:/Users/Owner/workspace1/Paint/src/paint/Maid with the Flaxen Hair.mp3

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand()=="play music")
		{
			audioClip=getAudioClip(getCodeBase(), "letspaintapplet/maid with the flaxen hair.au");
			audioClip.loop();
		}
		else if(event.getActionCommand()=="stop music")
		{
			if(audioClip!=null)
			{
				audioClip.stop();
			}
		}
	}
}
