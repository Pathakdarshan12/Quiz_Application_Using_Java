import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class  addQues	implements ActionListener
{
		JFrame frm;
		JTextField qno,ans;
		JTextArea ques,op1,op2,op3,op4;
		JButton submit,cancel;
		JLabel head,nolab,queslab,answer;
		JLabel op1lab,op2lab,op3lab,op4lab;
		JOptionPane opane;
		Font f;
		int count,x;

		DbConnection conn;

	 addQues()
	 {
		frm = new JFrame("Question");
		Container c = frm.getContentPane();
		c.setLayout(null);
		conn = new DbConnection();
		count=0;

		head = new JLabel(new ImageIcon("addques.gif"));
		head.setBounds(420,50,215,43);		
		 
		f = new Font("Times New Roman",Font.BOLD,17); 		
 
 	///////////////////////  ques number label and textfield	
		nolab = new JLabel(new ImageIcon("qno.gif"));
		nolab.setBounds(90,140,90,35);
			
		qno = new JTextField(15);				 
		qno.setFont(f);
		qno.setForeground(Color.black);
		qno.setBounds(200,144,100,25);

	//////////////////////  ques label and text area 	
		
		queslab = new JLabel(new ImageIcon("ques.gif"));
		queslab.setBounds(90,190,90,35);
		
		ques = new JTextArea(20,25);
		ques.setFont(f);
		ques.setForeground(Color.black);
		ques.setEditable(true);
		ques.setLineWrap(true);
		ques.setAutoscrolls(true); 
		ques.setBounds(200,190,550,95);
		
   ///////////////////////  option label and textarea

		op1lab = new JLabel(new ImageIcon("op1.gif"));
		op1lab.setBounds(90,300,90,35);

		op1 = new JTextArea(10,12);
		op1.setFont(f);
		op1.setForeground(Color.black);
		op1.setEditable(true);
		op1.setLineWrap(true);
		op1.setAutoscrolls(true); 
		op1.setBounds(200,300,550,55);
	//////////////////////
		op2lab = new JLabel(new ImageIcon("op2.gif"));
		op2lab.setBounds(90,370,90,35);

		op2 = new JTextArea(10,12);
		op2.setFont(f);
		op2.setForeground(Color.black);
		op2.setEditable(true);
		op2.setLineWrap(true);
		op2.setAutoscrolls(true); 
		op2.setBounds(200,370,550,55);

//////////////////////
		op3lab = new JLabel(new ImageIcon("op3.gif"));
		op3lab.setBounds(90,440,90,35);

		op3 = new JTextArea(10,12);
		op3.setFont(f);
		op3.setForeground(Color.black);
		op3.setEditable(true);
		op3.setLineWrap(true);
		op3.setAutoscrolls(true); 
		op3.setBounds(200,440,550,55);

//////////////////////
		op4lab = new JLabel(new ImageIcon("op4.gif"));
		op4lab.setBounds(90,510,90,35);

		op4 = new JTextArea(10,12);
		op4.setFont(f);
		op4.setForeground(Color.black);
		op4.setEditable(true);
		op4.setLineWrap(true);
		op4.setAutoscrolls(true); 
		op4.setBounds(200,510,550,55);

 //////////////////////

		answer = new JLabel(new ImageIcon("ans.gif"));
 		answer.setBounds(90,585,90,35);
			
		ans = new JTextField(15);				 
		ans.setFont(f);
		ans.setForeground(Color.black);
		ans.setBounds(200,590,100,25);

///////////////////////
		submit = new JButton("Submit");
	 	submit.setForeground(Color.black);
		submit.setBounds(350,650,95,30);
		submit.addActionListener(this);
		c.add(submit);

		cancel = new JButton("Cancel");
	 	cancel.setForeground(Color.black);
		cancel.setBounds(450,650,95,30);
		cancel.addActionListener(this);
		c.add(cancel);

//////////////////////////////

		c.add(head);
		c.add(nolab);
		c.add(qno);

		c.add(queslab);
		c.add(ques);

		c.add(op1lab);
		c.add(op1);
		c.add(op2lab);
		c.add(op2);
		c.add(op3lab);
		c.add(op3);
		c.add(op4lab);
		c.add(op4);

		 c.add(answer);
		 c.add(ans);

		frm.setSize(1100,750);
		frm.setVisible(true);

		
		try{
				conn.r = conn.s.executeQuery("select * from qbank");
		 		
				while(conn.r.next())
				{	 				
					 x = conn.r.getInt("qno");
					count++;
//					int temp = x;
				}
			 }
			  catch(Exception e1)
			  {
					e1.printStackTrace();
			  }	
//			  System.out.println(" " +count+" "+x);
				qno.setText(""+(count+1));
	 }

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == submit)
		{
			
			 if (ques.getText().trim().equals("") || op1.getText().trim().equals("") || op2.getText().trim().equals("") 
			      || op3.getText().trim().equals("")|| op4.getText().trim().equals("") || ans.getText().trim().equals(""))
			 {
			   JOptionPane.showMessageDialog(null,"Field cannot be null!");
			 }
			 
			 else
			 {
			 
			 try{
					 	conn.s.execute( "insert into qbank values ( ' "+qno.getText()+" ',' "+ques.getText()+" ',' "+op1.getText()+" ',' "+op2.getText()+" ',' "+op3.getText()+" ',' "+op4.getText()+" ', "+ans.getText()+" )");
						conn.r.rowUpdated();
  					}
			 catch(Exception e2)
			  {
					System.out.println(e2.getMessage());
			   }	

			    JOptionPane.showMessageDialog(null,"New record has been added!");
			//qno.setText(" ");
			ques.setText(" ");
			op1.setText(" ");
			op2.setText(" ");
			op3.setText(" ");
			op4.setText(" ");
			ans.setText("  ");
	        int b = opane.showConfirmDialog(frm, "Want to add another question ? !", "Add", opane.YES_NO_OPTION,opane.QUESTION_MESSAGE );
			if(b==0)
			{
				//count=count+1;
				String c = qno.getText();
			//	System.out.println(""+c);
			   int n = Integer.parseInt(c);
				qno.setText(""+(n+1));				
			}
			else
			  frm.setVisible(false);						
 
           } //end of else
		}

		if (e.getSource() == cancel)
		{
				frm.setVisible(false);
		}
	}
 
  	public static void main(String[] args) 
	{	 
		new addQues();
 	}
 
}
