import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class CompanyListPanel extends JPanel {
	private JTable table;
	private InvestorTableModel tableModel;
	private Investor investor;
	private RingSystem model = new RingSystem();
	private JLabel moneyLabel;
	private JTextArea hintLabel;

	public CompanyListPanel( Investor inv ) throws IOException {
		investor = inv;
		
		setLayout(null);
		
		table = new JTable();
		tableModel = new InvestorTableModel( investor );
		table.setModel( tableModel );
		table.setSize(513,670);
		table.setLocation(447, 100);
		table.setOpaque(false);
		table.setEnabled(false);
		table.setRowHeight(30);
		this.add(table, BorderLayout.LINE_END);
		
		JButton nextMonth = new JButton("Next Month");
		nextMonth.setOpaque(false);
		nextMonth.setContentAreaFilled(false);
		nextMonth.setLocation(120, 700);
		nextMonth.setSize(150, 40);
		add(nextMonth);
		// @todo add button action to display PresentationPane
		nextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					toNextMonth();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("FUCK");
					e1.printStackTrace();
				}
			}
		});
		
		JLabel nameLabel = new JLabel(investor.getName());
		nameLabel.setLocation(150, 50);
		nameLabel.setSize(150,50);
		add(nameLabel);
		
		moneyLabel = new JLabel("Capital: $" + investor.getMoney());
		moneyLabel.setLocation(125, 100);
		moneyLabel.setSize(150, 150);
		add(moneyLabel);
		
		hintLabel = new JTextArea();
		hintLabel.setLocation(50, 200);
		hintLabel.setSize(300, 400);
		hintLabel.setLineWrap(true);
		hintLabel.setOpaque(false);
		hintLabel.setEditable(false);
		hintLabel.setWrapStyleWord(true);
		add(hintLabel);
		
		IPanel bg = new IPanel("images/tableBackground_1_1.png");
		this.add(bg);
		setSize(bg.getSize());
	}
	
	public void toNextMonth() throws IOException {
		ScreenManager.getInstance().displayPresentation();
	}
	
	public void update() {
		model.updateTable();
		investor.updateCompanies(model);
		moneyLabel.setText("Capital: $" + String.format("%.2f", investor.getMoney()));
		
		//update the hint list with who did well and poorly last month
		String bestCat = RingSystem.categories[0];
		String worstCat = RingSystem.categories[0];
		for(String s : RingSystem.categories ) {
			if( model.getProfit(s) > model.getProfit(bestCat) ) {
				bestCat = s;
			}
			else if( model.getProfit(s) < model.getProfit(worstCat) ) {
				worstCat = s;
			}
		}
		
		String text = "TEST";
		switch( (int) (Math.random() * 2) ) {
		case 0:
			text = "It looks like " + bestCat + " is really taking off this month! On the other hand, the world seems to have turned on " + worstCat + ".";
			break;
		case 1:
			text = "The next hot thing is " + bestCat + "! They seem to be replacing " + worstCat + " everywhere!";
		}
		
		hintLabel.setText( text );
	}
}
