import javax.swing.JLabel;

public class SelectedSchedule extends ClassSelection {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		Label1 = new JLabel("Currently Viewing: " + activeTerm.toString() + " Term");
		super.init();
	}
}
