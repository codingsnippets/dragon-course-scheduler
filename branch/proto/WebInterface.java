import java.applet.*;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class WebInterface extends Applet {
	private static final long serialVersionUID = 5658430163469490054L;

	public void init() {
		final UserHistory x = new UserHistory();
		add(x);
		setVisible(true);
		setSize(800, 550);
		
		//action listener when submit is clicked in user history
		x.addComponentListener(new ComponentListener() {
			public void componentHidden(ComponentEvent arg0) {
				ClassSelection y = new ClassSelection(x.passSession());
				remove(x);
				add(y);
				//Set Size of frame and center
				Toolkit tk = Toolkit.getDefaultToolkit();  
				int xSize = ((int) tk.getScreenSize().getWidth());  
				int ySize = (int) ((int) tk.getScreenSize().getHeight()*(0.80));  
				setSize(xSize/2,ySize);
				repaint();
			}

			public void componentMoved(ComponentEvent arg0) {}

			public void componentResized(ComponentEvent arg0) {}

			public void componentShown(ComponentEvent arg0) {}
			
		});
	}

}
