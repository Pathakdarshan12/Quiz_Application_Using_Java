import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
class Help implements ActionListener
{	
	JFrame frm;
	JLabel lab;	 
	JButton ok;

	mainCall mcall;

	 Help()
	 {
		frm = new JFrame("Help");
		frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container c = frm.getContentPane();
		c.setLayout(null);

	    lab = new JLabel("UNDER CONSTRUCTION");
		lab.setBounds(110,5,800,690);

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
 						frm.setVisible(false);
	  }
 
  }
