import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*; 
import javax.swing.BorderFactory; 
import javax.swing.Timer; 
import java.util.Calendar.*;
import java.util.Date;

public class ExamFrame implements ActionListener 
{
	 public int quesarray[];			 ///////////////////////////////////for storing the numbers generating for the questions
	 int currques; 
	 int mques;
	 public int answers[] ;				////////////////////////for storing the answers which were selected
	 public int markarray[];
	 public int dbans[];
	 public int temp[];
  
	JFrame frm;
	JPanel qpan1;
	JLabel header1,header2;
	JLabel qno;
	JTextArea ques,anstxt1,anstxt2,anstxt3,anstxt4;
	JButton ok,next,prev,mark,quit,tt;
	JRadioButton option1,option2,option3,option4;
	JRadioButton mrk;
	ButtonGroup bgrp;
	JPanel radiopan;
	JLabel o1,o2,o3,o4;
 	JLabel timerTextFld;
  
   	Font f; 
	Random rnd;
	Calendar cal;

	DbConnection dbc;		/////////// Object for the Database Connection
	Table marktable;
	ScoreCard sc;
	 
	ExamFrame()
	{	 		
 		quesarray  = new int[10];
		answers  = new int[10];
 		markarray = new int[10]; 
		dbans = new int[10];
		temp = new int[50];  
		
		rnd = new Random();
		currques = 0;
		mques=0;
		 int m1=0;
		 for(int m=0;m<50;m++)
		  {
			  int num = Math.abs(1+rnd.nextInt(30));				///////////////generating a random number
					temp[m] = num;
		  }		


			for (int j=0;j<50 ; )
			{

				for (int k=0;k<10 ;k++ )
				{
					if (quesarray[k] != temp[j])
					{
						break;
					}
					else
					continue;
				}
                  quesarray[m1]=temp[j];
				    j++;
				   m1++;
				   if(m1>=10)
				   break;
			}
	

		frm = new JFrame("Online Exam");
		frm.setResizable(true);
		frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container c =  frm.getContentPane();
		c.setLayout(null);	   	 

////////////////////////////////////////////// setting the two header for the frame which are fixed 
		f=new Font("Bookman Old Style",Font.BOLD,24);
		header1 = new JLabel("Kaveri Collage PUNE");//new ImageIcon("somaiya.gif"));               
		header1.setForeground(Color.black);
		header1.setFont(f);
		header1.setBounds(130,50,800,50);		
		
		f= new Font ("Monotype Corsiva",Font.BOLD ,22);
		header2 = new JLabel(new ImageIcon("mcsa.gif"));																		//Online Examination For MCSA "); 
		header2.setBounds(130,130,800,40);
		header2.setForeground(Color.red);
		header2.setFont(f);
		header2.setBorder (BorderFactory.createEmptyBorder (2,3, 5, 1));

////////////////////////////////////////////// adding the headers to the container
		c.add(header1);
		c.add(header2);

//////////////////////////////////////////////  setting up the connection with database		 		 
		dbc = new DbConnection();																	  
//		marktable = new Table();
		
///////////////////////////////////////////// setting the qno and question in to a panel
		qpan1 = new JPanel();		 
		f = new Font("Bookman Old Style",Font.PLAIN,18);
		qno = new JLabel("Qno ");			 
	//	qno.setText("Qno    " + currques+1);
		qno.setFont(f);
		qno.setForeground(Color.blue);
		qpan1.add(qno);
		qpan1.setBounds(80,190,60,30);
		c.add(qpan1);				/////////qno & ques are added to the conatiner
				
		try
		{
		f = new Font("Times New Roman",Font.BOLD,17);
 		ques = new JTextArea(10,20);
				 
		ques.setFont(f);
		ques.setForeground(Color.black);
		ques.setEditable(false);
		ques.setLineWrap(true);
		ques.setAutoscrolls(true);
		ques.setBackground(Color.lightGray);
		ques.setBounds(160,190,750,65);
		ques.setToolTipText("Question to be Attempted");
		
		c.add(ques);				/////////adding the ques to the container directly not to the panel

		 }
		 catch(Exception ex)
		 {
				ex.printStackTrace();
		}
	
/////////////////////////////////////// adding a,b,c,d in front of options

		f = new Font("Bookman Old Style",Font.PLAIN,18);
		o1 = new JLabel("( A )");
		o1.setFont(f);
		o1.setForeground(Color.blue);
		o1.setBounds(100,280,60,30);

		o2 = new JLabel("( B )");
		o2.setFont(f);
		o2.setForeground(Color.blue);
		o2.setBounds(100,315,60,30);

		o3 = new JLabel("( C )");
		o3.setFont(f);
		o3.setForeground(Color.blue);
		o3.setBounds(100,350,60,30);

		o4 = new JLabel("( D )");
		o4.setFont(f);
		o4.setForeground(Color.blue);
		o4.setBounds(100,385,60,30);
		
		c.add(o1);
		c.add(o2);
		c.add(o3);
		c.add(o4);
		
////////////////////////////////////////// CheckBox are created and added in the container 
		
		bgrp = new ButtonGroup();	
		
		f = new Font("Bookman Old Style",Font.PLAIN,16);
		option1 = new JRadioButton();
		option1.setFont(f);
		option1.setForeground(Color.black);
				
		option2 = new JRadioButton();
		option2.setFont(f);
		option2.setForeground(Color.black);
		
		option3 = new JRadioButton();		
		option3.setFont(f);
		option3.setForeground(Color.black);
		
		option4 = new JRadioButton();
		option4.setFont(f);	
		option4.setForeground(Color.black);
		 		 
		option1.setBounds(150,282,20,20);
		option2.setBounds(150,322,20,20);
		option3.setBounds(150,362,20,20);
		option4.setBounds(150,402,20,20);
 
		bgrp.add(option1);
		bgrp.add(option2);
		bgrp.add(option3);
    		bgrp.add(option4);

		//c.add(bgrp);
		c.add(option1);	  
		c.add(option2);	  
		c.add(option3);	  
		c.add(option4);	  

//////////////////////////////////////////////////////////////////////// creating the text boxes for options
		anstxt1 = new JTextArea(10,15);
		anstxt2 = new JTextArea(10,15);
		anstxt3 = new JTextArea(10,15);
		anstxt4 = new JTextArea(10,15);

    	f = new Font("Times New Roman",Font.BOLD,17);
		anstxt1.setFont(f);
		anstxt1.setForeground(Color.black);
		anstxt1.setEditable(false);	
		anstxt1.setLineWrap(true);
		anstxt1.setAutoscrolls(true);
		anstxt1.setBackground(Color.lightGray);
		anstxt1.setBounds(170,280,700,30);
		anstxt1.setToolTipText("Option1");

		anstxt2.setFont(f);
		anstxt2.setForeground(Color.black);
		anstxt2.setEditable(false);
		anstxt2.setLineWrap(true);
		anstxt2.setAutoscrolls(true);
		anstxt2.setBackground(Color.lightGray);
		anstxt2.setBounds(170,320,700,30);
		anstxt2.setToolTipText("Option2");

		anstxt3.setFont(f);
		anstxt3.setForeground(Color.black);
		anstxt3.setEditable(false);
		anstxt3.setLineWrap(true);
		anstxt3.setAutoscrolls(true);
		anstxt3.setBackground(Color.lightGray);
		anstxt3.setBounds(170,360,700,30);
		anstxt3.setToolTipText("Option3");

		anstxt4.setFont(f);
		anstxt4.setForeground(Color.black);
		anstxt4.setEditable(false);
		anstxt4.setLineWrap(true);
		anstxt4.setAutoscrolls(true);
		anstxt4.setBackground(Color.lightGray);
		anstxt4.setBounds(170,400,700,30);
		anstxt4.setToolTipText("Option4");
			
		c.add(anstxt1);
		c.add(anstxt2);
		c.add(anstxt3);
		c.add(anstxt4);
	 
		if(currques==0 && currques<10)			numgenerator(currques);									/////////////////////// random question for the first time

//////////////////////////////////////////////////////////////////////// creating and adding Buttons in the container	
		
		mrk = new JRadioButton("Mark");		//,new ImageIcon("mark.gif"));
		mrk.setForeground(Color.black);
		mrk.setBounds(135,552,55,30);
		mrk.addActionListener(this);
		mrk.setToolTipText("Attempt Later");
		c.add(mrk);
		
		prev = new JButton("  Previous ",new ImageIcon("previous.gif"));	 
		prev.setForeground(Color.black);
		prev.setBounds(195,550,95,37);
		prev.addActionListener(this);
		prev.setToolTipText("Previous Question");
		c.add(prev);

		mark = new JButton("Mark",new ImageIcon("mark.gif"));
		mark.setForeground(Color.black);
		mark.setBounds(660,550,95,37);
		mark.addActionListener(this);
		mark.setToolTipText("Marked Questions");
		c.add(mark);

		ok = new JButton("  Ok  ",new ImageIcon("ok.gif"));
		ok.setForeground(Color.black);
		ok.setBounds(300,550,95,37);
		ok.addActionListener(this);
		ok.setToolTipText("OK");
		c.add(ok);
		
		next = new JButton(" Next ",new ImageIcon("next.gif"));
		next.setForeground(Color.black);
		next.setBounds(405,550,95,37);
		next.addActionListener(this);
		next.setToolTipText("Next");
		c.add(next);								  

		quit = new JButton("Quit",new ImageIcon("quit.gif"));
		quit.setForeground(Color.black);
		quit.setBounds(760,550,95,37);
		quit.addActionListener(this);
		quit.setToolTipText("Submit");
		c.add(quit);

  ///////////////////////////////////////////////////////////////////////

		timerTextFld = new JLabel("  ");        
        timerTextFld.setBackground(Color.white);
		timerTextFld.setForeground(Color.red);
        timerTextFld.setFont(f); 
        timerTextFld.setToolTipText("Time Remaining in exam");
		timerTextFld.setBounds(820,140,120,50);
        c.add(timerTextFld);
        
		Timer t = new Timer(1000, new timerListener());
        t.start();

		
 		frm.setSize(1100,750);
		frm.setVisible(true);
   	
	}			
	

   public void actionPerformed(ActionEvent e)
	{
	try{
	 	if ( e.getSource() == next)
		{									   			
			option1.setSelected(false);
	 		option2.setSelected(false);
			option3.setSelected(false);
			option4.setSelected(false);
 			mrk.setSelected(false);
 				if(prev.isEnabled() == false)		prev.setEnabled(true);
 
			currques++;
			if(currques<10)		numgenerator(currques);	 
			int selectedoption=answers[currques];

				if(	 selectedoption == 1)
					option1.setSelected(true);
				else if(	 selectedoption ==2 )
					option2.setSelected(true);	
				else if(	 selectedoption ==3 )
					option3.setSelected(true);	
				else if(	 selectedoption ==4 )
					option4.setSelected(true);				
		}		

	   if ( e.getSource() == ok)
	   {			
			int selectedans=0;
 			if(prev.isEnabled() == false)		prev.setEnabled(true);
			if(currques != 9 && next.isEnabled() == false)		next.setEnabled(true);

			if(option1.isSelected() == true)
				selectedans = 1;
			else if (option2.isSelected() == true)
				selectedans = 2;
			else if(	option3.isSelected() == true)
				selectedans = 3;
			else if(option4.isSelected() == true)
				selectedans = 4;
		  
				answers[currques] = selectedans;
				markarray[currques] = 0;
 				currques++;
		 if(currques ==10)   	ok.setEnabled(false);
		 if (selectedans == 0)		JOptionPane.showMessageDialog(frm, "Choose Any One Option to Proceed !!", "Alert", JOptionPane.ERROR_MESSAGE); 	
		 else if(currques <10)		numgenerator(currques);	 
		  
			frm.repaint();
			option1.revalidate();
			option2.revalidate();
			option3.revalidate();
			option4.revalidate();

			option1.repaint();
			option2.repaint();
			option3.repaint();
			option4.repaint();
			

			option1.setSelected(false);
 			option2.setSelected(false);
 			option3.setSelected(false);
 			option4.setSelected(false);
 			mrk.setSelected(false);
	   }

	   if(e.getSource() == prev)
		{				
			option1.setSelected(false);
	 		option2.setSelected(false);
			option3.setSelected(false);
			option4.setSelected(false);
 			mrk.setSelected(false);
			
			if(next.isEnabled() == false)		next.setEnabled(true);
 		
			if (currques>0 && currques<=10)
			  {
				currques = currques - 1;
				prev.setEnabled(true);
				numgenerator(currques);			 
			  }
		   	 
			if (currques ==0)	prev.setEnabled(false);		
			else prev.setEnabled(true);

		   if(currques<=9)     	ok.setEnabled(true);
			int selectedoption=answers[currques];
				if(	 selectedoption == 1)
					option1.setSelected(true);
				else if(	 selectedoption ==2 )
					option2.setSelected(true);	
				else if(	 selectedoption ==3 )
					option3.setSelected(true);	
				else if(	 selectedoption ==4 )
					option4.setSelected(true);				
	    }		

	   if(e.getSource() == mrk)					   //////////////////  for the radio button
	   {
			option1.setSelected(false);
	 		option2.setSelected(false);
			option3.setSelected(false);
			option4.setSelected(false);
 			mrk.setSelected(false);

			if(next.isEnabled() == false)		next.setEnabled(true);
			if(prev.isEnabled() == false)		prev.setEnabled(true);

			markarray[mques] = quesarray[currques];	
 			currques++;
			mques++;
			if(currques <10)		numgenerator(currques);
	    }

		if(e.getSource() == mark)					////////////////// to veiw all the questions
		{
 		/*
			int tt=0;
					for(int z=0;z<10;z++)
					{
						if(answers[z] != 0)
						 {
							tt=quesarray[z] ;
							  for(int pp=0;pp<10;pp++)
							   {
									if( markarray[pp] == tt)
									    markarray[pp] =0;
							   }
						 }
				    }
			*/
				marktable = new Table(markarray,this);	
		}	

		if(e.getSource() == quit)
		{
			option1.setSelected(false);
	 		option2.setSelected(false);
			option3.setSelected(false);
			option4.setSelected(false);
 			mrk.setSelected(false);

			 int b = JOptionPane.showConfirmDialog(frm, " Click OK to Submit , CANCEL to Continue  ", "Submit", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
			 	if( b == 0)
				 {
					sc = new ScoreCard();
					sc.result(quesarray,answers,markarray,dbans);
		//			System.exit(0);	
				 }
   	    }      
	}
	  catch(ArrayIndexOutOfBoundsException e5)
		{
			e5.printStackTrace();	
		}
 }
 
 //////////////////////////////////////////function for generating a random number
		public void numgenerator(int curr)
		{
			int count=1;	////////////for rows of a database			  
	 		int qnum=curr+1;
			String quest1=null;
			String opti1=null;
			String opti2=null;
			String opti3=null;
			String opti4=null;
			int answer =0;			 
			
 			qno.setText("Qno "+qnum);
			try
				{
					dbc.r = dbc.s.executeQuery("select * from qbank");    						 
			 				
							if (curr == 9)		next.setEnabled(false); 						
				  		 	
							if(curr <10 )
						    {	 					 
			 				 	int temp = quesarray[curr];
								while(count <= temp)								 ///////////////////traversing in the database 
								{									 
									count++;
									dbc.r.next();								
 								}
								
								 qnum = dbc.r.getInt("qno");
 								 quest1 = dbc.r.getString("ques");					 
								 opti1 = dbc.r.getString("opt1");							 
								 opti2 = dbc.r.getString("opt2");						 
								 opti3 = dbc.r.getString("opt3");						 
								 opti4 = dbc.r.getString("opt4");							 
								 answer = dbc.r.getInt("ans");							 
								 dbans[curr] = answer;

								ques.setText(quest1);							////////////////////////setting the text on to the label
								anstxt1.setText(opti1);
								anstxt2.setText(opti2);
								anstxt3.setText(opti3);
								anstxt4.setText(opti4);
 
								count=1;
								dbc.r.close();
								dbc.r = dbc.s.executeQuery("select * from qbank");
			   	            }
			   }
 				catch(Exception e4)
				{
						e4.printStackTrace();
				}	 			    
		}  ////////end of numgenerator


class timerListener implements ActionListener
 {        
	   int NumberOfQuestions = 10;
//	   float timePerQues = (60*30*2)/59 ;
       int secondsCounter = (int)(25 * NumberOfQuestions);
       int initTimerVal = secondsCounter;
       int warningCounterLimit = (int)(secondsCounter/4);
	   boolean ended = false;

        	
	   
	   public void actionPerformed(ActionEvent ae)
	   {       
           int hrs = (int)(secondsCounter/3600);
           int min = (int)(secondsCounter/60 - hrs*60);
           int sec = (int)(secondsCounter - hrs*3600 - min*60);
           --secondsCounter;
           
           if (ended == true)
               return;
           
           if (secondsCounter <= 0)
		   {
               ended = true;
               
               // timer expired.
               Object[] options = { "OK"};
           
               int option = JOptionPane.showOptionDialog(null, "Press OK to mark exam", "Time Limit Expired!!!", 
                           JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                           null, options, options[0]);
                           
              // markAnswers();
                 
           }  

           
           // change colour based on time remaining
           if (secondsCounter <= warningCounterLimit)
		   {
               timerTextFld.setBackground(Color.red);
               timerTextFld.setForeground(Color.white);
//			   System.out.println("Error !!");
           }
               
 
           // update timer value
           timerTextFld.setText(hrs + "h:" + min + "m:" + sec + "s");
//			System.out.println(hrs + "h:" + min + "m:" +sec + "s");
           
       }
       
   
  }
 
 }///////////// end of MainFrame
 
  
