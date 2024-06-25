import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
class Exam	implements ActionListener
{	
	JFrame frm;
	JLabel lab;	 
	JButton ok;

	mainCall mcall;

	 Exam()
	 {
		frm = new JFrame("Instructions");
		frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container c = frm.getContentPane();
		c.setLayout(null);

	    lab = new JLabel(new ImageIcon("instru.gif"));
		lab.setBounds(110,5,850,690);

		ok = new JButton("Ok");
		ok.setBounds(850,660,60,30);  
		ok.addActionListener(this);

		c.add(lab);
		c.add(ok);
		frm.setVisible(true);
		frm.setSize(1100,750);
	  }

	  public void actionPerformed(ActionEvent e)
	  {
				if(e.getSource() == ok)
						mcall = new mainCall();		 
						frm.setVisible(false);
	  }

   	public static void main(String[] args) 
	{
		 Exam  estart = new Exam(); 
	}
}
