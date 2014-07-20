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
	private RingSystem model;
	private Investor investor;

	public CompanyListPanel( Investor inv, RingSystem mod ) throws IOException {
		model = mod;
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
}
