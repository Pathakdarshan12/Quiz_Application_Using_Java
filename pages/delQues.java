import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.*;

public class delQues implements ActionListener
{
	static JFrame win = new JFrame("Delete Question");
	Container content;
	Font f;
 	ResultsModel model;
	JTable table;
	JScrollPane resultpane;
	JLabel qnum;
	JTextField ques;
	JButton del,cancel;
	JOptionPane opane;
 	
	DbConnection db;
	
	delQues()
	{
		win.setSize(1100,750);
		db = new DbConnection();
		//connectivity
		try
		{
		  	db.r = db.s.executeQuery("select qno,ques from qbank");
			
			//For creating jtable
			model = new ResultsModel();
			table = new JTable(model);			
			model.setResultSet(db.r);
			table.setAutoResizeMode(5);
			resultpane = new JScrollPane(table);
			
		}
		 		catch(SQLException e1)
		{
			System.err.println(e1);
		}

		content = win.getContentPane();
		content.setLayout(null);
 
 		resultpane.setBounds(150,130,700,150);
 		resultpane.validate();

		
		f = new Font("Times New Roman",Font.BOLD,17); 
 		
		qnum = new JLabel(new ImageIcon("delques.gif"));
		qnum.setFont(f);
		qnum.setBounds(190,375,260,30);  	  
		content.add(qnum);
		

		ques = new JTextField(15);
		ques.setBounds(455,375,90,25);
		content.add(ques);

		del = new JButton("Delete");
		del.addActionListener(this);
		del.setBounds(565,375,90,30);
		content.add(del);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setBounds(665,375,90,30);
		content.add(cancel);

		content.add(resultpane);
//		content.add(dpan);
		win.setVisible(true);
	}

	public void actionPerformed(ActionEvent e2)
	{
			if(e2.getSource()==del)
			{
//				String n = table.getValueAt(1,1);
				//	table.setSelectionMode(0);
				//	table.getColumnSelectionAllowed();
				//	int nn = table.getSelectedColumn();
//					System.out.println(" "+n);
			    try{
			       int b = opane.showConfirmDialog(null, "Are you sure you want to Delete the Question ? !", "delete", opane.YES_NO_OPTION,opane.QUESTION_MESSAGE );
				    if(b==0)
			         {
					    int x = Integer.parseInt(ques.getText());
//                     System.out.println(""+x);
                       db.s.executeUpdate("delete from qbank where qno= "+x+" ");
				     }	
			   }
			   catch(Exception ep)
			   {
					ep.printStackTrace();
			   }
			}
			if(e2.getSource()==cancel)
			{
				win.setVisible(false);
			}
	}

	//for extracting datas from table
	class ResultsModel extends AbstractTableModel
	{
		String[]  colname = new String[0];
		Vector dataRows = new Vector();

		public void setResultSet(ResultSet result)
		{
			try
			{ 
				ResultSetMetaData metadata = result.getMetaData();
				int col = metadata.getColumnCount();
				colname = new String[col];

				//get column names
				for(int i=0;i<col;i++)
					colname[i] = metadata.getColumnLabel(i+1);
				
				//get all rows
				dataRows = new Vector();
				String[] rowdata;
				while(result.next())
				{
					rowdata = new String[col];
					for(int i=0;i<col;i++)
					{
						rowdata[i] = result.getString(i+1);
					}
					dataRows.addElement(rowdata);
				}
				fireTableChanged(null);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		public int getColumnCount()
		{
			return colname.length;
		}

		public int getRowCount()
		{
			if (dataRows == null)
			{
				return 0;
			}
			else
			{
				return dataRows.size();
			}
		}

		public Object getValueAt(int row, int col)
		{
			return ((String[])(dataRows.elementAt(row)))[col];
		}

		public String getColumnName(int col)
		{
			return colname[col] == null ? "No name" : colname[col];
		}
	};


	public static void main(String[] args) 
	{
		
		win.setBounds(0,0,1100,750);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new delQues();
	}
}
