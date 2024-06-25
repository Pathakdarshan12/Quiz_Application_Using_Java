import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Registration implements ActionListener, KeyListener
{

   JFrame frm;
   Container c;

   static int ypos=90;
   JLabel lemail,lpswd,lreconfirm_pswd,lfname,llname,ldob,lgender,ladd,lstate,lzip,ledu,lquali,lhsc,lssc,lalt_email,lhint_ques,lhint_ans;
   JLabel format,title,lssc_tot,lhsc_tot;
   JTextField email,fname,lname,zip,quali,add,hsc,ssc,alt_email,hint_ques,hint_ans;
   JTextField hsc_tot,ssc_tot;
   JPasswordField pswd,repswd;
   
   JComboBox day;
   JComboBox mnth;
   JComboBox yr;
   JComboBox edu;
   JComboBox state;

   JRadioButton male;
   JRadioButton female;
   ButtonGroup gender;

   JDialog mesg; 

   JButton submit, cancel,reset;



   DbConnection conn;

   String temp = "";
   String temp1 = "";
   String temp2= "";
   String temp3 = "";


   
	Registration()
	{
	     conn=new   DbConnection();
         int xpos =100;
		 int incr=20;
		 
		
		 frm=new JFrame ("Registration");
         c=frm.getContentPane();
		 c.setLayout(null);
	
		
	// Labels	
					
        title=new JLabel("Sign Up:");
		title.setSize(100,20);
		title.setLocation(50,50);


		lemail=new JLabel ("**Login:");
		lemail.setSize(100,20);
		lemail.setLocation(xpos,ypos);

		lpswd=new JLabel ("**Password:");
		lpswd.setSize(100,20);
		ypos=ypos+incr;
		lpswd.setLocation(xpos,ypos);

		

		lreconfirm_pswd=new JLabel ("**Confirm Password:");
		lreconfirm_pswd.setSize(100,20);
				ypos=ypos+incr;
		lreconfirm_pswd.setLocation(xpos,ypos);

		

		lfname=new JLabel ("**First Name:");
    	lfname.setSize(100,20);
				ypos=ypos+incr;
		lfname.setLocation(xpos,ypos);

		llname=new JLabel ("**Last Name:");
    	llname.setSize(100,20);
				ypos=ypos+incr;
		llname.setLocation(xpos,ypos);

		ldob=new JLabel ("**Date Of Birth:");
		ldob.setSize(100,20);
				ypos=ypos+incr;
		ldob.setLocation(xpos,ypos);

				
		ladd=new JLabel ("**Address:");
		ladd.setSize(100,20);
				ypos=ypos+incr;
		ladd.setLocation(xpos,ypos);


        lstate=new JLabel ("State:");
    	lstate.setSize(100,20);
				ypos=ypos+incr;
		lstate.setLocation(xpos,ypos);

		lzip=new JLabel ("**Zip code:"); 
		lzip.setSize(100,20);
				ypos=ypos+incr;
		lzip.setLocation(xpos,ypos);


		lgender=new JLabel ("**Gender:");
		lgender.setSize(100,20);		
				ypos=ypos+incr;
		lgender.setLocation(xpos,ypos);


		

		
		ledu=new JLabel ("Education:");
		ledu.setSize(100,20);
				ypos=ypos+incr;
		ledu.setLocation(xpos,ypos);

		lquali=new JLabel ("**Qualifying Exam:");
		lquali.setSize(100,20);
				ypos=ypos+incr;
		lquali.setLocation(xpos,ypos);

		lhsc=new JLabel ("**HSC Marks:");
		lhsc.setSize(100,20);
				ypos=ypos+incr;
		lhsc.setLocation(xpos,ypos);

		lssc=new JLabel ("**SSC Marks:");
		lssc.setSize(100,20);
				ypos=ypos+incr;
		lssc.setLocation(xpos,ypos);

        lalt_email=new JLabel ("Alternate email:"); 	
		lalt_email.setSize(100,20);
				ypos=ypos+incr;
		lalt_email.setLocation(xpos,ypos);

		lhint_ques=new JLabel ("**Hint Question:");
		lhint_ques.setSize(100,20);
				ypos=ypos+incr;
		lhint_ques.setLocation(xpos,ypos);

		lhint_ans= new JLabel ("**Hint Answer:");
		lhint_ans.setSize(100,20);
				ypos=ypos+incr;
		lhint_ans.setLocation(xpos,ypos);

        xpos=300;
		ypos=100;
		incr=20;


  
		
//Text Boxes
	email=new JTextField (30);
		email.setSize(150,20);
		email.setLocation(xpos,ypos);

		pswd=new JPasswordField (30);
		pswd.setSize(150,20);
				ypos=ypos+incr;
				pswd.setEchoChar('*');
		pswd.setLocation(xpos,ypos);

		repswd=new JPasswordField (30);
		repswd.setSize(150,20);
				ypos=ypos+incr;
				repswd.setEchoChar('*');
		repswd.setLocation(xpos,ypos);

		fname=new JTextField (30);
		fname.setSize(150,20);
				ypos=ypos+incr;
		fname.setLocation(xpos,ypos);

		lname=new JTextField (30);
		lname.setSize(150,20);
				ypos=ypos+incr;
		lname.setLocation(xpos,ypos);

		
		//dob field
		
 
		 day= new JComboBox ();

       for (int i=1;i<=31 ;i++ )
       {
		    day.addItem(""+i);
       }
          

		day.setSize(40,20);
		ypos=ypos+incr;
		day.setLocation(xpos,ypos);

		 mnth= new JComboBox ();

       for (int i=1;i<=12 ;i++ )
       {
		    mnth.addItem(""+i);
       }
          

		mnth.setSize(40,20);
		mnth.setLocation(xpos+40,ypos);


		 yr= new JComboBox ();

       for (int i=1977;i<=1985 ;i++ )
       {
		    yr.addItem(""+i);
       }
          

		yr.setSize(60,20);
		yr.setLocation(xpos+100,ypos);		

		format=new JLabel ("(dd/mm/yyyy)");
		format.setSize(100,20);
		format.setLocation(xpos+180,ypos);		

//**********************************************

		add=new JTextField (30);
		add.setSize(150,20);
				ypos=ypos+incr;
		add.setLocation(xpos,ypos);


		//state
		
		state=new JComboBox ();
		state.addItem("Please Select One");
		state.addItem("Andhra Pradesh");
		state.addItem("Arunachal Pradesh");
		state.addItem("Assam");
		state.addItem("Bihar");
		state.addItem("Goa");
		state.addItem("Gujarat");
		state.addItem("Haryana");
		state.addItem("Himachal Pradesh");
		state.addItem("J&K");
		state.addItem("Karnataka");
		state.addItem("Kerala");
		state.addItem("Madhya Pradesh");
		state.addItem("Maharashtra");
		state.addItem("Manipur");
		state.addItem("Meghalaya");
		state.addItem("Mizoram");
		state.addItem("Orissa");
		state.addItem("Punjab");
		state.addItem("Rajasthan");
		state.addItem("Tamil Nadu");
		state.addItem("Uttar Pradesh");
		state.addItem("West Bengal");


		state.setSize(150,20);
				ypos=ypos+incr;
		state.setLocation(xpos,ypos);

		
		zip=new JTextField (6);
		zip.setSize(150,20);
				ypos=ypos+incr;
		zip.setLocation(xpos,ypos);

		
       
	   

	    male= new JRadioButton ("Male",false);
        		ypos=ypos+incr;
				male.setSize(60,20);
     		    male.setLocation(xpos,ypos);
				
		female=new JRadioButton("Female",false);
				female.setSize(60,20);
	       	   female.setLocation(xpos+60,ypos);

			   gender=new ButtonGroup();
			   gender.add(male);
			   gender.add(female);

		edu=new JComboBox ();
		edu.addItem("Please Select One");
		edu.addItem("High School Grad");
		edu.addItem("Voc/Tech School");
		edu.addItem("Bachelor in Arts");
		edu.addItem("Bachelor in Science");
		edu.addItem("Bachelor in Commerce");
		edu.addItem("Bachelor in Comp Sci.");
		edu.addItem("Post Graduate");
		edu.addItem("Some Other");


		edu.setSize(150,20);
				ypos=ypos+incr;
		edu.setLocation(xpos,ypos);

		quali=new JTextField (30);
		quali.setSize(150,20);
				ypos=ypos+incr;
		quali.setLocation(xpos,ypos);

		
		//hsc
		hsc=new JTextField (15);
		hsc.setSize(30,20);
				ypos=ypos+incr;
		hsc.setLocation(xpos,ypos);


		lhsc_tot=new JLabel("Total:");
		lhsc_tot.setSize(70,20);
		lhsc_tot.setLocation(xpos+40,ypos);
		
		hsc_tot=new JTextField(15);
		hsc_tot.setSize(30,20);
		hsc_tot.setLocation(xpos+80,ypos);


      //ssc
		ssc=new JTextField (15);
		ssc.setSize(30,20);
				ypos=ypos+incr;
		ssc.setLocation(xpos,ypos);

				
		lssc_tot=new JLabel("Total:");
		lssc_tot.setSize(70,20);
		lssc_tot.setLocation(xpos+40,ypos);
		
		ssc_tot=new JTextField(15);
		ssc_tot.setSize(30,20);
		ssc_tot.setLocation(xpos+80,ypos);

		
		
		alt_email=new JTextField (30);
		alt_email.setSize(150,20);
				ypos=ypos+incr;
		alt_email.setLocation(xpos,ypos);

		hint_ques=new JTextField (30);
		hint_ques.setSize(150,20);
				ypos=ypos+incr;
		hint_ques.setLocation(xpos,ypos);


		hint_ans= new JTextField (30);
		hint_ans.setSize(150,20);
				ypos=ypos+incr;
		hint_ans.setLocation(xpos,ypos); 

//Buttons

       submit=new JButton("Sign Me Up");
	   submit.addActionListener(this);
	   submit.setSize(100,30);
	   submit.setLocation(120,470);

	   
	   reset=new JButton("Reset");
	   reset.addActionListener(this);
	   reset.setSize(80,30);
	   reset.setLocation(250,470);
	   

   	   cancel=new JButton("Cancel");
	   cancel.addActionListener(this);
	   cancel.setSize(80,30);
	   cancel.setLocation(350,470);

	   
	   
	   
	   hsc.addKeyListener(this);
   	   ssc.addKeyListener(this);
   	   hsc_tot.addKeyListener(this);
   	   ssc_tot.addKeyListener(this);


	   
        c.add(title);
		c.add(lemail);		c.add(email);
		c.add(lpswd);		c.add(pswd);
		c.add(lreconfirm_pswd);		c.add(repswd);
		c.add(lfname);		c.add(fname);
		c.add(llname);		c.add(lname);
		c.add(ldob);	   c.add(day); c.add(mnth);c.add(yr);c.add(format);
		c.add(lemail);		c.add(email);
		c.add(ladd);	c.add(add);
		c.add(lstate);		c.add(state);
		c.add(lzip);		c.add(zip);
		c.add(lgender);		c.add(male);c.add(female);
		c.add(ledu);		c.add(edu);
		c.add(lquali);		c.add(quali);
		c.add(lhsc);		c.add(hsc); c.add(lhsc_tot); c.add(hsc_tot);
		c.add(lssc);		c.add(ssc); c.add(lssc_tot); c.add(ssc_tot);
		c.add(lalt_email);	c.add(alt_email);
		c.add(lhint_ques);	c.add(hint_ques);
      	c.add(lhint_ans);	c.add(hint_ans);
    	c.add(cancel);      c.add(submit);
		c.add(reset);

         

		frm.setSize(1100,750);
		frm.setVisible(true);

    }

//key listener
	
	public void keyPressed (KeyEvent e)
		{	
	

			
         }


	 public void keyTyped (KeyEvent e)
		{
		    
			



		       
         }

   public void keyReleased (KeyEvent e)
		{
  	             
				 
				 //check for hsc -numeric entry

				  if (e.getSource()==hsc)
				  {
				     int i=hsc.getText().length();
                     char chk = e.getKeyChar();
			    		   
			          if (!Character.isDigit(chk))
			          {
			     				
								if (i==0 )
								{
									temp="";
								}
								else
								  temp=hsc.getText().substring(0,i-1);
				        }
			            else
				                temp=temp+String.valueOf(chk);
				 hsc.setText(temp);	
                } 


 				 //check for hsc_tot1 -numeric entry

             if (e.getSource()==hsc_tot)
			 {
				 
				 int j=hsc_tot.getText().length();
                 char chk1 = e.getKeyChar();
			    		   
			     if (!Character.isDigit(chk1))
			     {
			     				
								if (j==0 )
								{
									temp1="";
								}
								else
								  temp1=hsc_tot.getText().substring(0,j-1);
				 }
			  else
				          temp1=temp1+String.valueOf(chk1);
				 hsc_tot.setText(temp1);	

              }
    				 //check for ssc -numeric entry

              if (e.getSource()==ssc)
			  {
				 
				 int k=ssc.getText().length();
                char chk2 = e.getKeyChar();
			    		   
			   if (!Character.isDigit(chk2))
			   {
			     				
								if (k==0 )
								{
									temp2="";
								}
								else
								  temp2=ssc.getText().substring(0,k-1);
				 }
			  else
				                temp2=temp2+String.valueOf(chk2);
				 ssc.setText(temp2);	

              }
			
			

 				 //check for ssc_tot -numeric entry

			 if (e.getSource()==ssc_tot)
		     {
				 	
				 int l=ssc_tot.getText().length();
                char chk3 = e.getKeyChar();
			    		   
			   if (!Character.isDigit(chk3))
			   {
			     				
								if (l==0 )
								{
									temp3="";
								}
								else
								  temp3=ssc_tot.getText().substring(0,l-1);
				 }
			  else
				                temp3=temp3+String.valueOf(chk3);
				 ssc_tot.setText(temp3);	

            }



         }



	public void actionPerformed (ActionEvent e)
	{
		  
  if (e.getSource()==submit)
  {
				



	            String em=email.getText();
				String ps =pswd.getText().trim();
			    String reps = repswd.getText();
				String sfname=fname.getText();
				String slname=lname.getText();
				String szip=zip.getText();
                String squali=quali.getText();
                String sadd=add.getText();
				String salt_email=alt_email.getText();
				String shint_ques=hint_ques.getText();
				String shint_ans=hint_ans.getText();
               	String gen;

				if (male.isSelected())
				{
					 gen= "Male";
				}
				else
					 gen="Female";


                String sday =(String)day.getSelectedItem();
                String smonth=(String)mnth.getSelectedItem();
				String syear=(String)yr.getSelectedItem();
				String sdob=sday+"/"+smonth+"/"+syear;


				String sedu=(String)edu.getSelectedItem();
				String sstate=(String)state.getSelectedItem();
                
				String ss= ssc.getText();
				String ss_tot=ssc_tot.getText();
				String hs=hsc.getText();
				String hs_tot=hsc_tot.getText();









			 if(pswd.getText().trim().equals("")  || email.getText().trim().equals("")  || hsc.getText().trim().equals("") || hsc_tot.getText().trim().equals("") ||ssc.getText().trim().equals("") ||ssc_tot.getText().trim().equals("") ||
		     repswd.getText().trim().equals("")  ||fname.getText().trim().equals("")  || lname.getText().trim().equals("")  ||add.getText().trim().equals("")  ||zip.getText().trim().equals("")  ||quali.getText().trim().equals("")  ||hint_ques.getText().trim().equals("")  ||
		    hint_ans.getText().trim().equals("") || male.getText().trim().equals("") )
				{
									
									 JOptionPane.showMessageDialog(null, "Field marked with ** cannot be null!", "NULL Entry Error!", JOptionPane.ERROR_MESSAGE); 

				}


				//pswd n repswd same check

				
				
				else if (!ps.equals(reps))
				{
					
			
						JOptionPane.showMessageDialog(null, "Confirm & Reconfirm Pswd should be same!", "Password Mismatch", JOptionPane.ERROR_MESSAGE); 
			            pswd.setText("");
						pswd.requestFocus();	 


				}



    else
    {
    //integer entry
				  int flag=0;

				//check for ssc
				for (int i=0;i< ss.length() ;i++ )
				{
					
					char chk= ss.charAt(i);
					if (!Character.isDigit(chk))
					{
		                  flag=1;									

					}
				}

				//check for ssc total

				for (int i=0;i< ss_tot.length() ;i++ )
				{
					
					char chk= ss_tot.charAt(i);
					if (!Character.isDigit(chk))
					{
		                  flag=1;									
					}
				}

				//check for hsc


				for (int i=0;i< hs.length() ;i++ )
				{
					
					char chk= hs.charAt(i);
					if (!Character.isDigit(chk))
					{
		                  flag=1;									
					}
				}

				//chk 4 hsc_tot

				for (int i=0;i< hs_tot.length() ;i++ )
				{
					
					char chk= hs_tot.charAt(i);
					if (!Character.isDigit(chk))
					{
		                  flag=1;									
					}
				}

				if (flag==1)
				{
 					    JOptionPane.showMessageDialog(null, "Only Numeric Values allowed", "Not a Valid entry!", JOptionPane.ERROR_MESSAGE); 

				}


				//****************************************************

             //check if hsc or ssc total values less than the given marks

 if (flag != 1)
 {
 
              try
			 {


  
				int s= Integer.parseInt(ss);
				int s_tot=Integer.parseInt(ss_tot);

				if (s > s_tot)
				{
 					JOptionPane.showMessageDialog(null, "SSC marks Greater than Total", "INVALID!", JOptionPane.ERROR_MESSAGE); 
				}

            
   				int h= Integer.parseInt(hs);
				int h_tot=Integer.parseInt(hs_tot);

				if (h > h_tot)
				{
 					JOptionPane.showMessageDialog(null, "HSC marks Greater than Total", "INVALID!", JOptionPane.ERROR_MESSAGE); 
				}


              }catch (Exception e2)
			   {
					e2.printStackTrace();
				}
 }  //end of else
}


//insert into table


           try{


                 conn.s.execute("insert into registration values( '"+em+"','"+ps+"',' "+sfname+" ',' "+slname+" ',' "+sdob+" ',' "+sadd+" ',' "+sstate+" ',' "+szip+" ',' "+gen+" ',' "+sedu+" ',' "+squali+" ',' "+hs+" ',' "+hs_tot+" ',' "+ss+" ',' "+ss_tot+" ',' "+salt_email+" ',' "+shint_ques+" ',' "+shint_ans+" ') ");
                 conn.s.execute("insert into login values( '"+em+"','"+ps+"') ");
//				 conn.r.rowUpdated();

			 }
			  catch(SQLException e1)
			  {
					System.out.println(e1.getMessage());
			  }	


              	
			         



   }

		  if (e.getSource()==reset)
		  {




                email.setText(" " );
				pswd.setText(" " );
				repswd.setText(" " );
				fname.setText(" " );
				lname.setText(" " );
				day.setSelectedIndex(0);mnth.setSelectedIndex(0);yr.setSelectedIndex(0);
			
				
					
				male.setSelected(false);
				female.setSelected(false);
				
				
				  
				add.setText(" ");
				state.setSelectedIndex(0);
				zip.setText(" " );
				edu.setSelectedIndex(0);
				quali.setText(" " );
				hsc.setText(" " ); hsc_tot.setText(" " );
				ssc.setText(" " );ssc_tot.setText(" " );
				alt_email.setText(" " );
				hint_ques.setText(" " );
				hint_ans.setText(" " ); 




		  }



		  if (e.getSource()==cancel)
		  {
               frm.setVisible(false);
          }

	}


	public static void main (String args[])
	{
		new Registration();
	}
 };






