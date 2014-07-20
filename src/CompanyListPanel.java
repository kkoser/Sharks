import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class CompanyListPanel extends JPanel {
	private JTable table;
	private InvestorTableModel tableModel;
	private Investor investor;
	private RingSystem model = new RingSystem();

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
		
		
		JLabel moneyLabel = new JLabel("Capital: $" + investor.getMoney());
		moneyLabel.setLocation(125, 100);
		moneyLabel.setSize(150, 150);
		add(moneyLabel);
		
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
	}
}
