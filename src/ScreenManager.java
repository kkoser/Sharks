import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ScreenManager {
	private static ScreenManager instance = null;
	
	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private CompanyListPanel listPanel;
	private PresentationPanel presPanel;
	private Investor investor;

	protected ScreenManager() {
		frame = new JFrame("Sharks");
		frame.setSize(1000,800);
	}
	
	public static ScreenManager getInstance() {
		if( instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}
	
	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}
	
	public void displayCompanyList() throws IOException {
		if( listPanel == null ) {
			listPanel = new CompanyListPanel( investor );
			frame.add(listPanel);
		}
		listPanel.setVisible(true);
		
		if( presPanel != null)
			presPanel.setVisible( false );
	}
	
	public void displayPresentation() throws IOException {
		if( presPanel == null) {
			presPanel = new PresentationPanel( investor );
			frame.add(presPanel);
		}
		presPanel.setVisible(true);

		if( listPanel != null )
			listPanel.setVisible(false);
	}
}
