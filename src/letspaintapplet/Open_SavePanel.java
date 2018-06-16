package letspaintapplet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;



public class Open_SavePanel extends JPanel implements ActionListener
{
	
	private JButton[] JButtonBox;
	private Whiteboard w;
	private File saveFile, openFile;
	private PlainPanel panel;
	
	public Open_SavePanel(Whiteboard w, PlainPanel panel)
	{
		this.w=w;
		setBackground(Color.black);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addButtons();
		this.panel=panel;
	}
	
	private void addButtons()
	{
		String[] labels={"new file", "save as", "open file", "save", "delete", "undo", "print"};
		JButtonBox=new JButton[labels.length];
		for(int i=0; i<labels.length;i++)
		{
			JButtonBox[i]=new JButton(labels[i]);
			JButtonBox[i].setBackground(Color.black);
			JButtonBox[i].setForeground(Color.white);
			JButtonBox[i].addActionListener(this);
			add(JButtonBox[i]);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("new file"))
		{
			w.eraseAll();
			panel.changeDocumentLabel(PlainPanel.DEFAULT_DOCUMENT_LABEL);
			JOptionPane.showMessageDialog(null, "new file created");
			saveFile=null;
			openFile=null;
		}
		else if(event.getActionCommand().equals("save as"))
		{
			saveAs();
			/*JFileChooser saveFileDialog = new JFileChooser(new File("C:/Users/Owner/Downloads/document1.jpg"));
			saveFileDialog.showSaveDialog(this);*/
		}
		else if(event.getActionCommand().equals("open file"))
		{
			openFile();
		}
		else if(event.getActionCommand().equals("save"))
		{
			save();
		}
		else if(event.getActionCommand().equals("play music"))
		{
			//Display1.playMusic();
		}
		else if(event.getActionCommand().equals("stop music"))
		{
			//Display1.stopMusic();
		}
		else if(event.getActionCommand().equals("delete"))
		{
			delete();
		}
		else if(event.getActionCommand().equals("undo"))
		{
			w.undo();
		}
		else if(event.getActionCommand().equals("print"))
		{
			PrinterJob pj=PrinterJob.getPrinterJob();
			//PageFormat pf = pj.pageDialog(pj.defaultPage());
			//pj.defaultPage(pf);
			//
			if (pj.printDialog())
			{
				try {pj.print();}
			    catch (PrinterException exc)
			    {
			       JOptionPane.showMessageDialog(findParentFrame(), "Print error.  Error Message: "+exc);
			    }
			 }  
		}
	}
	
	
	private void saveAs()
	{
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG Images", "jpg");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    chooser.setFileHidingEnabled(true);
	    chooser.setSelectedFile(new File(panel.getDocumentLabel()));
	    int returnVal = chooser.showSaveDialog(findParentFrame());
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	File file = chooser.getSelectedFile();
	    	if(isJPGFile(file.getName())!=true)
	    	{
	    		String fileName=file.getPath()+".jpg";
		    	file=new File(fileName);
	    	}
	    	int answer=0;
	    	if(!file.exists())
	    	{
	    		saveFile=file;
	    		openFile=saveFile;
	    		panel.changeDocumentLabel(openFile.getName());
		    	BufferedImage image = w.getImage();
		    	try 
		    	{
		    	   ImageIO.write(image, "jpg", file);  // ignore returned boolean
		    	   JOptionPane.showMessageDialog(findParentFrame(), "File saved");
		    	} catch(IOException e) 
		    	{
		    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + file.getPath()+".");
		    	}
		    	catch(IllegalArgumentException e) 
		    	{
		    	 JOptionPane.showMessageDialog(findParentFrame(), "Nothing to save thus far " + file.getPath()+".");
		    	}
		    }
	    	else{
	    		answer=JOptionPane.showConfirmDialog(findParentFrame(), "The file "+file.getPath()+" already exists.  Do you wish to overwrite?");
	    		if(answer==JOptionPane.YES_OPTION)
		    	{
	    			saveFile=file;
	    			openFile=saveFile;
	    			panel.changeDocumentLabel(openFile.getName());
			    	BufferedImage image = w.getImage();
			    	try 
			    	{
			    	   ImageIO.write(image, "jpg", file);  // ignore returned boolean
			    	   JOptionPane.showMessageDialog(findParentFrame(), "File saved");
			    	} catch(IOException e) 
			    	{
			    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + file.getPath()+".");
			    	}
		    	}
		    	else
		    	{
		    		saveAs();
		    	}	    	
	    	}
	    }
	}
	private boolean isJPGFile(String fileName)
	{
		String extension="";
		for(int i=fileName.length()-4; i<fileName.length(); i++)
		{
			extension +=fileName.charAt(i);
		}
		//JOptionPane.showMessageDialog(null,"Extension of "+fileName+" is "+extension);
		if(extension.equals(".jpg"))
		{
		//	JOptionPane.showMessageDialog(null,fileName+ " is JPG file");
			return true;
		}
		else
		{
		//	JOptionPane.showMessageDialog(null,fileName+" is not JPG file");
			return false;
		}
	}
	
	private void delete()
	{
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG Images", "jpg");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    chooser.setFileHidingEnabled(true);
	    int returnVal = chooser.showDialog(findParentFrame(), "delete");
	    if(returnVal==JFileChooser.APPROVE_OPTION)
	    {
	    	File fileToBeDeleted=chooser.getSelectedFile();
	    	if(!(openFile.equals(fileToBeDeleted)) &&fileToBeDeleted.exists() && fileToBeDeleted.delete()==true)
	    	{
	    		JOptionPane.showMessageDialog(findParentFrame(), "file has been deleted");
	    	}
	    	else
	    	{
	    		JOptionPane.showMessageDialog(findParentFrame(), "file could not be deleted");
	    	}
	    }
	}
	
	private void save()
	{
		if(saveFile!=null)
		{
			BufferedImage image = w.getImage();
	    	try 
	    	{
	    	   ImageIO.write(image, "gif", saveFile);  // ignore returned boolean
	    	   JOptionPane.showMessageDialog(findParentFrame(), "File saved");
	    	} catch(IOException e) 
	    	{
	    	 JOptionPane.showMessageDialog(findParentFrame(), "Write error for " + saveFile.getPath()+".");
	    	}
		}
		else
		{
			saveAs();
		}
    }

	private void openFile()
	{
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & GIF Images", "jpg", "gif");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    int returnVal = chooser.showOpenDialog(findParentFrame());
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	    	File file = chooser.getSelectedFile();
	    	openFile=file;
	    	saveFile=openFile;
	    	panel.changeDocumentLabel(openFile.getName());
	    	BufferedImage image=null;
	    	try {
				image=ImageIO.read(openFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(findParentFrame(), "Read error for "+openFile+".");
			}
	    	w.getGraphics().drawImage(image, 0, 0, w);
	    	w.saveOpenedImage(image);
	    	JOptionPane.showMessageDialog(findParentFrame(), "File opened");
	    }
	}
	
	 private Frame findParentFrame()
	 { 
		    Container c = this; 
		    while(c != null){ 
		      if (c instanceof Frame) 
		        return (Frame)c; 

		      c = c.getParent(); 
		    } 
		    return (Frame)null; 
	} 
}
