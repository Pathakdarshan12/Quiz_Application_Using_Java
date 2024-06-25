import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginForm implements ActionListener
{
	JFrame frm;
	JLabel login,usr,pass,newusr;
	JPasswordField password;
	public JTextField usrname;
	JButton submit,cancel,register;
	JOptionPane	opane;
	Font f;
	String name,passwd;
	String nm;
	int pow;

	Registration reg;
	ExamFrame exms;
	DbConnection connect;

	loginForm()
	{
		frm = new JFrame ("Login");
		frm.setResizable(true);
		frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container con = frm.getContentPane();
		con.setLayout(null);

		 opane = new JOptionPane();
		 connect = new DbConnection();
		 pow=0;
//////////////////////////////////////////creating the label , textfields , buttons
		f = new Font("Monotype Corsiva",Font.PLAIN ,22);
		login = new JLabel("Login");
		login.setFont(f);
		login.setForeground(Color.red);
		login.setBounds(180,20,120,30);
		con.add(login);

		f = new Font("Times New Roman",Font.BOLD,17);

		usr = new JLabel("User Name");
		usr.setFont(f);
		usr.setForeground(Color.black);
		usr.setBounds(90,70,120,30);

		pass = new JLabel("Password");
		pass.setFont(f);
		pass.setForeground(Color.black);
		pass.setBounds(90,100,100,30);

		con.add(usr);
		con.add(pass);

///////////////////////

		usrname = new JTextField(15);
		usrname.setFont(f);
		usrname.setForeground(Color.black);
		usrname.setBounds(195,73,150,20);

		password = new JPasswordField(8);
		password.setFont(f);
		password.setForeground(Color.black);
		password.setBounds(195,103,150,20);

		con.add(usrname);
		con.add(password);

/////////////////////////

		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setFont(f);
		submit.setForeground(Color.black);
		submit.setBounds(125,163,90,25);

		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setFont(f);
		cancel.setForeground(Color.black);
		cancel.setBounds(225,163,90,25);

		con.add(submit);
		con.add(cancel);

////////////////////////////

		newusr = new JLabel("New User !");
		newusr.setFont(f);
		newusr.setForeground(Color.red);
		newusr.setBounds(360,137,120,30);

		register = new JButton("Register");
		register.addActionListener(this);
		register.setFont(f);
		register.setForeground(Color.black);
		register.setBounds(350,163,100,25);

		con.add(newusr);
		con.add(register);

///////////////////////
		frm.setLocation(270,340);
		frm.setSize(490,250);
		frm.setVisible(true);
	}

	String getName() {
		return	nm;
	  }

	public void actionPerformed(ActionEvent eve)
	{
	int flag=0;
	nm = usrname.getText();
	String pwd = password.getText();
		if (eve.getSource() == submit)
		{
				try{
							connect.r = connect.s.executeQuery("select name,password from login");

							while (connect.r.next())
							{


//								System.out.println(connect.r.getString("name"));
								if ( (connect.r.getString("name").equals(nm) == true) && (connect.r.getString("password").equals(pwd) == true ))
								{
								/*	if(connect.r.getBoolean("admin") == true)
									{
										 pow=1;
									}
								  */  flag=1;
									break;
								}
							 }
					   }
					   catch(Exception e)
						{
							e.printStackTrace();
						}
				if(flag == 1)
				{
		 				f = new Font("Monotype Corsiva",Font.PLAIN ,22);
						opane.setFont(f);
						opane.setForeground(Color.blue);
						opane.showMessageDialog(frm, "   Successfully Logined !!", "Login", opane.INFORMATION_MESSAGE);
						exms = new ExamFrame();
						frm.setVisible(false);
	 				 }
				 else
				 {
					 int b = opane.showConfirmDialog(frm, "Login Failed , Try Again !", "Login", opane.YES_NO_OPTION,opane.QUESTION_MESSAGE );

							if( b == 0)
							{
 							  usrname.setText("");
							  password.setText("");
							  register.nextFocus();
							}
						  else
						    frm.setVisible(false);
				  }
		}

		if (eve.getSource() == cancel)
		{
			   frm.setVisible(false);
		}

		if(eve.getSource() == register)
		{
				reg = new Registration();
		}
	}

	int getpower()
	{
			return pow;
	}
	public static void main(String[] args)
	{
			new loginForm();
	}

}
