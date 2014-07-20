import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PresentationPanel extends JPanel {
	
	private Investor investor;
	private Company[] companies;
	private JTextArea[] pitchTexts;
	private JTextArea balance;
	
	public PresentationPanel(Investor inv) throws IOException {
		investor = inv;
		companies = new Company[4];
		pitchTexts = new JTextArea[4];
		
		balance = new JTextArea();
		balance.setText("$" + inv.getMoney());
		balance.setSize(100, 25);
		balance.setLocation(285, 675);
		balance.setEditable(false);
		balance.setHighlighter(null);
		balance.setFont(new Font("Arial", Font.BOLD, 14));
		balance.setOpaque(false);
		balance.setForeground(Color.BLACK);
		this.add(balance);

		setLayout(null);

		int buttonXStart = 300;
		int buttonYPos = 550;
		int buttonSeparation = 100;
		int buttonWidth = 80;
		int buttonHeight = 30;

		JButton[] investButtons = new JButton[4];

		for(int i = 0; i < 4; i++) {
			pitchTexts[i] = new JTextArea();
		}
		pitchTexts[0].setLocation(217, 392);
		pitchTexts[1].setLocation(291, 213);
		pitchTexts[2].setLocation(533, 213);
		pitchTexts[3].setLocation(605, 392);
		
		for(int i = 0; i < 4; i++) {
			if(companies[i] == null) {
				companies[i] = CompanyGenerator.generate();
			}
			
			String pitch = companies[i].getPitch();
			JTextArea textArea = new JTextArea(pitch);
			pitchTexts[i].setFont(new Font("Arial", Font.PLAIN, 14));
			pitchTexts[i].setHighlighter(null);
			pitchTexts[i].setSize(183, 83);
			pitchTexts[i].setLineWrap(true);
			pitchTexts[i].setOpaque(false);
			pitchTexts[i].setEditable(false);
			pitchTexts[i].setWrapStyleWord(true);
			this.add(pitchTexts[i]);
			
			investButtons[i] = new JButton("Invest");
			investButtons[i].setSize(buttonWidth, buttonHeight);
			investButtons[i].setLocation(buttonXStart + buttonSeparation * i, buttonYPos);
			investButtons[i].setBackground(Color.WHITE);
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
		finishButton.setForeground(Color.BLACK);
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

		IPanel image = new IPanel("images/actualPitchBackground.png");
		this.add(image);
	}
	
	public void regenerateCompanies() {
		for(int i = 0; i < 4; i++) {
			companies[i] = CompanyGenerator.generate();
			pitchTexts[i].setText(companies[i].getPitch());
		}
	}
	
	private void onButtonPress(int i) throws IOException {
		Company comp = companies[i];
		String s = (String)JOptionPane.showInputDialog("How much would you like to invest?\n" + comp.getName() + " is currently worth " + comp.getValue());
		double investment = Double.parseDouble(s);
		//if(amount <= 0) return;
		comp.investMoney(investment);
		investor.setMoney( investor.getMoney() - investment);
		DecimalFormat df = new DecimalFormat("#.##");
		balance.setText( "$" + df.format(investor.getMoney()) );
		investor.getCompanies().add(comp);
	}

}
