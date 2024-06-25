import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

class Table implements ActionListener
{
	  JFrame frm;
	  JTable tbl;
	  DbConnection db;
	  DisplayTableModel tblModel;
	  private boolean ALLOW_ROW_SELECTION = true;
      private boolean DEBUG = false;
	  int selectedRow;
	  public int m;
	  ExamFrame ef;
	  public int f;

	  Table(final int markarray[],ExamFrame ef1)
	  {
	      
		 ef=ef1;
 		frm = new JFrame();
		f=1;
	  	db = new DbConnection();
 
  // for(int y=0;y<10;y++)	 System.out.print(" "+markarray[y]);
 
		int counter=0;
	//	int m=0;
	//	int store[] = new int[10];

		 
	
		for(int y=0;y<10;y++)	
		{
			if(markarray[y] != 0)
			{
	//			store[m] = counter+1;
		//		temp[counter] = markarray[y];
				counter++;
			}
		}
	  // for(int y=0;y<10;y++)	 System.out.println(store[y]);

		String []columnNames = {"Ques No.","Question"};
		Object [][] data = new Object[counter][2];

		for(int p=0;p<counter;p++)
		{
			int count=1;					
			try 
			 {
				db.r = db.s.executeQuery("select * from qbank");    	
				
				while(count <= markarray[p])								 ///////////////////traversing in the database 
				{									 
					count++;
					db.r.next();								
 				}			
			   data[p][0] = new Integer(f);//markarray[p]);
			   //db.r.getInt("qno"));	
			   f++;
			   data[p][1] = new String(db.r.getString("ques"));			   
			 }
			 catch(Exception e) 
					{	
						e.printStackTrace();		
					}		 
	   	  }	 		 

 	     tblModel = new DisplayTableModel(data,columnNames);
	//	tblModel.addMouseListener(this);
       	 tbl = new JTable(tblModel);
//		tbl.addActionListener(this);
        tbl.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tbl.setRowHeight(20);		

////////////////
	tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (ALLOW_ROW_SELECTION)
		{ // true by default
            ListSelectionModel rowSM = tbl.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() 
																		{
															                public void valueChanged(ListSelectionEvent e) 
																			{
																	                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
																		                    if (lsm.isSelectionEmpty()) 
																							{
																		                        System.out.println("No rows are selected.");
																		                    }
																							else 
																							{
																		                    //    selectedRow = lsm.getMinSelectionIndex();
																							      selectedRow =tbl.getSelectedRow();
																		                   //     System.out.println("Row " + selectedRow + " is now selected.");
																								//ef.numgenerator(markarray[selectedRow ]);
																								///ef.repaint();
																								//ef.validate();
																							//	System.out.println(""+markarray[selectedRow ]);
																							  m = markarray[selectedRow];
																							 	frm.setVisible(false);
																								ef.numgenerator(selectedRow);
     																			    }
															                }
																		});
 	}

////////////
	 	JScrollPane scrollPane = new JScrollPane(tbl);
	//	 frm.getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setBounds(150,130,700,150);
		frm.getContentPane().add(scrollPane);
		  frm.pack();
		  frm.setSize(700,300);
		  frm.setVisible(true);
     }
  
			public int getdata()
			{
				 return m;
		    }
/*  
          if (DEBUG) 
		  {
            table.addMouseListener(new MouseAdapter() 
			   {
					public void mouseClicked(MouseEvent e) 
					{
						System.out.println("Madhur Sarupria");
							System.out.println(""+selectedRow);	
		//				printDebugData(tbl);
					 }
               });
		  }
	*/
		public void actionPerformed(ActionEvent me)
	    {	
	//	   javax.swing.table.TableModel model = tbl.getModel();
	//	   System.out.print("  " + model.getValueAt(selectedRow,1));
	//		System.out.println(""+markarray[selectedRow]);
	    System.out.println("king");
   	   System.out.println("madhur =  " + tblModel.getValueAt(selectedRow,0));
//			frm.setVisible(false);
 		}
  	
/*	
		private void printDebugData(JTable table) 
		{
			int numRows = table.getRowCount();
			int numCols = table.getColumnCount();
			javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

////////////////	  
	public static void main(String[] args) 
	{
			new Table();
	}
*/	 
	
}

 class DisplayTableModel extends AbstractTableModel 
	{
        String[] columnNames;
        
        Object[][] data;

		public DisplayTableModel(Object [][] tableData , String [] colHeadings){
        
 			columnNames = colHeadings;
            data = tableData;
        }
		 public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int x) {
            return getValueAt(0, x).getClass();
        }

	  }