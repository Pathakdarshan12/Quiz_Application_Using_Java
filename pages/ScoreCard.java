import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ScoreCard implements ActionListener
{	 
	//////////////////////  Object of the ExamFrame Class
	/////////////////////	for calculating the score by using the quesarray[],answers[]markarray[]
	JFrame frm;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton ok;
 	DbConnection db;
	JLabel head;
	Font f;
	
	ScoreCard()
	{
 			frm = new JFrame("Score Card");
			frm.setResizable(true);
			frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			Container c = frm.getContentPane();
			c.setLayout(null);
			f=new Font("Bookman Old Style",Font.BOLD,18);
			
			head = new JLabel("Score Card");
			head.setFont(f);
			head.setBounds(230,20,100,45);
			lab1 = new JLabel(new ImageIcon("pic1.gif"));
			lab1.setBounds(30,70,265,45);
			lab2 = new JLabel(new ImageIcon("pic2.gif"));
			lab2.setBounds(30,100,270,45);
			lab3 = new JLabel(new ImageIcon("pic3.gif"));
			lab3.setBounds(30,130,270,45);
			lab4 = new JLabel(new ImageIcon("pic4.gif"));
			lab4.setBounds(30,160,270,45);
			lab5 = new JLabel(new ImageIcon("pic5.gif"));
			lab5.setBounds(30,190,270,45);
			lab6 = new JLabel("Total Time Taken                    :");
		//	lab6.setBounds(30,220,170,25);
			lab7 = new JLabel(new ImageIcon("pic6.gif")); 
			lab7.setBounds(30,220,270,45);
			
			ok =  new JButton("Ok");
			ok.setBounds(400,300,75,25);
			ok.addActionListener(this);

			l1 = new JLabel("  ");
			l1.setBounds(360,70,60,25);
			l2 = new JLabel("  ");
			l2.setBounds(360,100,60,25);
			l3 = new JLabel("  ");
			l3.setBounds(360,130,60,25);
			l4 = new JLabel("  ");
			l4.setBounds(360,160,60,25);
			l5 = new JLabel("  ");
			l5.setBounds(360,190,60,25);
			l6 = new JLabel("  ");
	//		l6.setBounds(320,220,60,25);
			l7 = new JLabel("  ");
			l7.setBounds(360,220,60,25);

			c.add(head);
			c.add(lab1);
			c.add(lab2);
			c.add(lab3);
			c.add(lab4);
			c.add(lab5);
		//	c.add(lab6);
			c.add(lab7);
			c.add(ok);
			c.add(l1);
			c.add(l2);
			c.add(l3);
			c.add(l4);
			c.add(l5);
		//	c.add(l6);
			c.add(l7);

			
			frm.setLocation(200,220);
			frm.setSize(600,400);
			frm.setVisible(true);	
	 }
	
	
	public void result(int que[],int ans[],int mrk[],int dban[]) 
	{	
		int correct=0;
		int incorrect=0;
		int marked=0;

			for (int i=0;i<10 ;i++ )
			{ 
		 	   if(ans[i] == dban[i])	
			      correct++;		  
			   else if(ans[i] !=0)
			      incorrect++;

			   if(mrk[i]!=0)	marked++;
			}	
      
			  l1.setText("10");
			  l2.setText(""+(correct+incorrect));
			  l3.setText(""+correct);
			  l4.setText(""+incorrect);
			  l5.setText(""+marked);
		//	  l6.setText(""+0);
			  l7.setText(""+(correct*2-incorrect));
       
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource() == ok)
//			frm.setVisible(false);  			 
			System.exit(0);
	}

	public static void main(String[] args) 
	{
	     new ScoreCard();
 	}
 
 }  