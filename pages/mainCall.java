import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
 
class mainCall implements ActionListener 
{
	 JMenuBar mbar;
	 JMenu OnLine,User,Administrator,Help,Login;
	 JMenuItem Logout,Exit,asUser,asAdmin;
	 JMenuItem Exam,Registration,QuesMask;
	 JMenuItem AddQues,DelQues,ScoreCard;
	 JMenuItem HelpTopics,About;
	 JFrame fram;
	 JLabel pic;
	
	 ExamFrame exm; 					///////// Object of the Exam frame 
	 loginForm lgfrm;
	 Registration regis;
	 ScoreCard scobj;
	 addQues adq;
	 delQues delq;
	 About abt;
	 Help hlp;

	 mainCall()
	 {		 
 		fram = new JFrame("Online Exam");
		fram.setResizable(true);
		fram.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container con = fram.getContentPane();		
		mbar = new JMenuBar();
		con.setLayout(null);
		fram.setJMenuBar(mbar);
		
////////////////////////////////////////////   menu's on the menu bar
		OnLine	= new JMenu("Online");
		User	= new JMenu("User");
		Administrator 	= new JMenu("Administrator");
		Help = new JMenu("Help");

		OnLine.setMnemonic('O');
		User.setMnemonic('U');
		Administrator.setMnemonic('A');
		Help.setMnemonic('H');

////////////////////////////////////////////  menu items in the OnLine Menu 
		asUser = new JMenuItem("As User");	// sub menu of Login
		   asUser.addActionListener(this);
        asAdmin = new JMenuItem("As Administrator");     // sub menu of Login
		   asAdmin.addActionListener(this);
			
		Login = new JMenu("Login");
		   Login.addActionListener(this);
		Logout= new JMenuItem("Logout");
		   Logout.addActionListener(this);
		Exit = new JMenuItem("Exit");
           Exit.addActionListener(this);

////////////////////////////////////////////  menu in the User Menu
		Exam= new JMenuItem("Exam");
		   Exam.addActionListener(this);
		Registration= new JMenuItem("Registration");
		   Registration.addActionListener(this);
		QuesMask = new JMenuItem("Marked Ques");
		   QuesMask.addActionListener(this);

////////////////////////////////////////////  menu in the Administrator Menu
		AddQues= new JMenuItem("Add Ques");
		   AddQues.addActionListener(this);
		DelQues = new JMenuItem("Del Ques");
		    DelQues.addActionListener(this);
		ScoreCard= new JMenuItem("ScoreCard");
		    ScoreCard.addActionListener(this);
		
////////////////////////////////////////////  menu in the Help Menu
		HelpTopics= new JMenuItem("HelpTopics");
		   HelpTopics.addActionListener(this);
		About= new JMenuItem("About");
		   About.addActionListener(this);

////////////////////////////////////////////  setting keyboard keys
			asUser.setAccelerator(KeyStroke.getKeyStroke('U',Event.CTRL_MASK));
			asAdmin.setAccelerator(KeyStroke.getKeyStroke('A',Event.CTRL_MASK));
			Logout.setAccelerator(KeyStroke.getKeyStroke('L',Event.CTRL_MASK));
			Exit.setAccelerator(KeyStroke.getKeyStroke('X',Event.CTRL_MASK));
														
			Exam.setAccelerator(KeyStroke.getKeyStroke('E',Event.CTRL_MASK));
			Registration.setAccelerator(KeyStroke.getKeyStroke('R',Event.CTRL_MASK));
			QuesMask.setAccelerator(KeyStroke.getKeyStroke('M',Event.CTRL_MASK));

			AddQues.setAccelerator(KeyStroke.getKeyStroke('I',Event.CTRL_MASK));
			DelQues.setAccelerator(KeyStroke.getKeyStroke('D',Event.CTRL_MASK));
			ScoreCard.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK));

			HelpTopics.setAccelerator(KeyStroke.getKeyStroke('H',Event.CTRL_MASK));																				
			About.setAccelerator(KeyStroke.getKeyStroke('B',Event.CTRL_MASK));		
			
///////////////////////////////////////////////  adding menu items on the OnLine Menu 
		OnLine.add(Login);
			Login.add(asUser);
			Login.add(asAdmin);
		OnLine.add(Logout);
		OnLine.add(Exit);
				
///////////////////////////////////////////////  adding menu items on the User Menu 
		User.add(Exam);
		User.add(Registration);
	//	User.add(QuesMask);

///////////////////////////////////////////////  adding menu items on the Administrator Menu 
		Administrator.add(AddQues);
		Administrator.add(DelQues);
//		Administrator.add(ScoreCard);

///////////////////////////////////////////////  adding menu items on the Help Menu 
		Help.add(HelpTopics);
		Help.add(About);
	
///////////////////////////////////////////////  adding menu on the MenuBar 
		mbar.add(OnLine);
		mbar.add(User);
		mbar.add(Administrator);
		mbar.add(Help);

///////////////////////////////////////////////  setting a background image
		pic = new JLabel("ONLINE EXAMINATION");//new ImageIcon("final.gif"));
		Container cn =fram.getContentPane();
		cn.setLayout(new FlowLayout());
 		fram.getContentPane().add(pic); 
	
		Logout.setEnabled(false);
		Exam.setEnabled(false);
		Registration.setEnabled(false);
		QuesMask.setEnabled(false);
		AddQues.setEnabled(false);
		DelQues.setEnabled(false);
		ScoreCard.setEnabled(false); 		 

		fram.setVisible(true);
		fram.setSize(1100,750);		 
	}				  	
  
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == Exit)
		{
				System.exit(0);
		}

		if(e.getSource() == Logout)
		{
				Logout.setEnabled(false);
				Exam.setEnabled(false);
				Registration.setEnabled(false);
				QuesMask.setEnabled(false);
				AddQues.setEnabled(false);
				DelQues.setEnabled(false);
				ScoreCard.setEnabled(false); 		 
		}

		if (e.getSource() == Exam)
		{
				exm  = new ExamFrame();
		}

		if (e.getSource() == asUser)
		{
			 int power;
				lgfrm = new loginForm();
				 // power = lgfrm.getpower();
				  //	  if(power == 0)
					//   {
						Logout.setEnabled(true);
						Exam.setEnabled(true);
					//	Registration.setEnabled(true);
						ScoreCard.setEnabled(true); 	
					  // }
		}

		if(e.getSource() == asAdmin)
		{
				  int power;
				  lgfrm = new loginForm();
				//  power = lgfrm.getpower();
				  //   if(power == 0)
					// {
						Logout.setEnabled(true);
						Exam.setEnabled(true);
						Registration.setEnabled(true);
						QuesMask.setEnabled(true);
						AddQues.setEnabled(true);
						DelQues.setEnabled(true);
					    ScoreCard.setEnabled(true); 
				   // }		
		}

		if (e.getSource() == Registration)
		{
					regis = new Registration();
		}
 
		if(e.getSource() == AddQues)
		{
				adq = new addQues();
		 }

		if (e.getSource() == DelQues)
		{
				delq = new delQues();
		}

		if (e.getSource() == HelpTopics)
		{
				hlp = new Help();
		}
		
		if (e.getSource() == About)
		{
				abt = new About();
		}
	}	

  
  	public static void main(String[] args) 
	{
	    mainCall mcall = new mainCall(); 
 	}
	
}

