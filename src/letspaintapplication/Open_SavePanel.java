package letspaintapplication;

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
import java.util.StringTokenizer;



public class Open_SavePanel extends JPanel implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7095649893394083458L;
	/**
	 * 
	 */
	private JButton[] JButtonBox;
	private Whiteboard w;
	private File saveFile, openFile;
	private PlainPanel panel;
	
	public Open_SavePanel(Whiteboard w, PlainPanel panel)
	{
		this.w=w;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		addButtons();
		this.panel=panel;
	}
	
	private void addButtons()
	{
		String[] labels={"new file", "save as", "open file", "save", "delete", "undo", "print", "play music", "stop music"};
		JButtonBox=new JButton[labels.length];
		for(int i=0; i<labels.length;i++)
		{
			JButtonBox[i]=new JButton(labels[i]);
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
			Display.playMusic();
		}
		else if(event.getActionCommand().equals("stop music"))
		{
			Display.stopMusic();
		}
		else if(event.getActionCommand().equals("delete"))
		{
			delete();
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
			        catch (PrinterException exc) {
			            JOptionPane.showMessageDialog(findParentFrame(), "Print error.  Error Message: "+exc);
			         }
			     }      
		}
		
		else if(event.getActionCommand().equals("undo"))
		{
			w.undo();
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
	    	if(isJPGFile(removeWhiteSpace(file.getName()))!=true)
	    	{
	    		String fileName=removeWhiteSpace(file.getPath())+".jpg";
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
	
	private String removeWhiteSpace(String fileName)
	{
		String newFileName="";
		char curr;
		for(int i=0; i<fileName.length(); i++)
		{
			curr=fileName.charAt(i);
			if(curr==' ')
			{
				continue;
			}
			newFileName+=curr;
		}
		return newFileName;
	}
	
	private boolean isJPGFile(String fileName)
	{
		System.out.println("File name:"+fileName);
		StringTokenizer tokenizer=new StringTokenizer(fileName,".");
		String extension="";
		while(tokenizer.hasMoreTokens())
		{
			extension=tokenizer.nextToken();
			//System.out.println("extension: "+extension);
		}
		/*for(int i=fileName.length()-4; i<fileName.length(); i++)
		{
			extension +=fileName.charAt(i);
		}*/
		//JOptionPane.showMessageDialog(null,"Extension of "+fileName+" is "+extension);
		if(extension.equalsIgnoreCase("jpg"))
		{
			//System.out.println(fileName+ " is a JPG file because '"+extension+"' is equal to 'jpg'");
			return true;
		}
		else
		{
			//System.out.println(fileName+ " is not a JPG file because '"+extension+"' is not equal to 'jpg'");
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
				JOptionPane.showMessageDialog(findParentFrame(), "Read error for "+openFile+".  Error message: "+e.getMessage());
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
