package letspaintapplication;

import java.awt.*;

/** A better whiteboard that lets you enter
 *  text in addition to freehand drawing.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */

public class Whiteboard extends SimpleWhiteboard {
  /**
	 * 
	 */
	private static final long serialVersionUID = -9178938546342466489L;
	protected FontMetrics fm;

  
  public Whiteboard() {
    super();
    Font font = new Font("Serif", Font.BOLD, 20);
    setFont(font);
    fm = getFontMetrics(font);
    //addKeyListener(new CharDrawer());
  }
  
  public Whiteboard(int w, int h)
  {
	  this();
	  setSize(w,h);
  }

 
}
