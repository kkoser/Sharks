import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
			if(companies[i] == null) {
				companies[i] = CompanyGenerator.generate();
			}
			
			String pitch = companies[i].getPitch();
			JTextArea textArea = new JTextArea(pitch);
			textArea.setHighlighter(null);
			textArea.setSize(183, 83);
			textArea.setLineWrap(true);
			textArea.setOpaque(false);
			textArea.setEditable(false);
			textArea.setWrapStyleWord(true);
			this.add(textArea);
			
			if(i == 0) {
				textArea.setLocation(217, 392);
			}
			
			if(i == 1) {
				textArea.setLocation(291, 213);
			}
			
			if(i == 2) {
				textArea.setLocation(533, 213);
			}
			if(i == 3) {
				textArea.setLocation(605, 392);
			}
			
			investButtons[i] = new JButton("Invest");
			investButtons[i].setSize(buttonWidth, buttonHeight);
			investButtons[i].setLocation(buttonXStart + buttonSeparation * i, buttonYPos);
			investButtons[i].setOpaque(false);
			investButtons[i].setContentAreaFilled(false);
			this.add(investButtons[i]);
			
			final int iHack = i;
			investButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						onButtonPress(iHack);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		
		JButton finishButton = new JButton("Finished Investing!");
		finishButton.setSize(200, 30);
		finishButton.setLocation(400, 610);
		finishButton.setBackground(Color.RED);
		this.add(finishButton);
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ScreenManager.getInstance().displayCompanyList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		IPanel image = new IPanel("images/pitchBackground_2_1.png");
		this.add(image);
	}
	
	public void regenerateCompanies() {
		for(int i = 0; i < 4; i++) {
			companies[i] = CompanyGenerator.generate();
		}
	}
	
	private void onButtonPress(int i) throws IOException {
		Company comp = companies[i];
		String s = (String)JOptionPane.showInputDialog("How much would you like to invest?\n" + comp.getName() + " is currently worth " + comp.getValue());
		double investment = Double.parseDouble(s);
		//if(amount <= 0) return;
		comp.investMoney(investment);
		investor.setMoney( investor.getMoney() - investment);
		investor.getCompanies().add(comp);
	}

}
