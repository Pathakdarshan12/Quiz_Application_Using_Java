import javax.swing.*;
import java.awt.*;

class About 
{
 	   JFrame frm;
	   JLabel about;

	   About()
	   {
	   frm = new JFrame("About OnLine Exam");
		frm.setResizable(true);
	//	frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container c =  frm.getContentPane();
		c.setLayout(null);

		about = new JLabel("UNDER CONSTRUCTION");
		about.setBounds(230,100,600,350);
		
		c.add(about);
		frm.setVisible(true);
		frm.setSize(1100,750);
}

 

}
