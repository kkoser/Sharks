import javax.swing.table.AbstractTableModel;


public class InvestorTableModel extends AbstractTableModel {
	
	private Investor investor;
	
	InvestorTableModel( Investor inv ) {
		this.investor = inv;
	}
	
	public String getColumnName(int column) {
        switch( column ) {
        case 0:
        	return "Company";
        case 1:
        	return "Categories";
        case 2:
        	return "Value";
        }
        
        return "";
    }
	
	public boolean isCellEditable(int row, int column) {
        return false;
    }

	@Override
	public int getRowCount() {
		return this.investor.getCompanies().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Company comp = investor.getCompanies().get( rowIndex );
		switch( columnIndex ) {
		case 0:
			return comp.getName();
		case 1:
			String str = "";
			for( String cat : comp.getCategories() ) {
				str += cat + ", ";
			}
			return str;
		case 2:
			return comp.getValue();
		}
		
		return new Object();
	}

}
