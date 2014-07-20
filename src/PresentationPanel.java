import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PresentationPanel extends JPanel {
	
	private Investor investor;
	private Company[] companies;
	
	public PresentationPanel(Investor inv) throws IOException {
		investor = inv;
		companies = new Company[4];

		setLayout(null);

		int buttonXStart = 300;
		int buttonYPos = 560;
		int buttonSeparation = 100;
		int buttonWidth = 80;
		int buttonHeight = 30;

		JButton[] investButtons = new JButton[4];

		for(int i = 0; i < 4; i++) {
			companies[i] = CompanyGenerator.generate();
			
			investButtons[i] = new JButton("Invest");
			investButtons[i].setSize(buttonWidth, buttonHeight);
			investButtons[i].setLocation(buttonXStart + buttonSeparation * i, buttonYPos);
			investButtons[i].setOpaque(false);
			investButtons[i].setContentAreaFilled(false);
			this.add(investButtons[i]);
			
			final int iHack = i;
			investButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onButtonPress(iHack);
				}
			});
		}

		IPanel image = new IPanel("images/pitchBackground_1_1.png");
		this.add(image);
	}
	
	private void onButtonPress(int i) {
		
	}

}
