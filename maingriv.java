//GRIEVANCE RESOLVER

//Accepting Name,Age,Locality,Grievance


import java.awt.*;
import java.awt.event.*;
import java.io.*;



class grievance extends Frame implements ActionListener,ItemListener
{
	Label l1,l2,intro,l6,name,age,locality;
	TextField tf,tname,tage;
	List l,l3,l4,l5;
	Button b1,b2;
	Checkbox road, water, light, other;
	CheckboxGroup cg;
	
	
	grievance()    //constructor
	{
		setLayout(new FlowLayout());
		
	
        	setBackground(Color.GREEN);
		l1 = new Label("SAMADHAN");
		//l1.setBounds(80,30,120,40);
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
		l1.setForeground(Color.BLUE);
		add(l1);
		


		name = new Label("Enter your name: ");
		name.setFont(new Font("Arial", Font.BOLD, 14));
        	name.setForeground(Color.MAGENTA);
		add(name);

		tname = new TextField(15);
  		tname.setBackground(Color.LIGHT_GRAY);
        	tname.setForeground(Color.BLACK);
      		add(tname);

		age = new Label("Enter your age: ");
		age.setFont(new Font("Arial", Font.BOLD, 14));
        	age.setForeground(Color.MAGENTA);
		add(age);

		tage = new TextField(15);
		tage.setBackground(Color.LIGHT_GRAY);
        	tage.setForeground(Color.BLACK);
		add(tage);


		locality = new Label("Choose your Locality: ");
		locality.setFont(new Font("Arial", Font.BOLD, 14));
        	locality.setForeground(Color.MAGENTA);
		add(locality);
		l = new List(4);
		l.add("Mumbai");
		l.add("Navi Mumbai");
		l.add("Mumbai Suburban");
		l.add("South Bombay");
		add(l);
		l2 = new Label();
		b1 = new Button("VALIDATE");
		b1.addActionListener(this);
		b1.setFont(new Font("Arial", Font.BOLD, 14));
        	b1.setBackground(Color.BLUE);
        	b1.setForeground(Color.WHITE);

		add(b1);
		add(l2);

		cg = new CheckboxGroup();
		road = new Checkbox("Road",cg,false);
		water = new Checkbox("Water",cg,false);
		light = new Checkbox("Light",cg,false);
		other = new Checkbox("Other",cg,false);

		add(road);
		add(water);
		add(light);
		add(other);
		tf = new TextField(15);
		tf.setBackground(Color.LIGHT_GRAY);
        	tf.setForeground(Color.BLACK);
		tf.setVisible(false);

		l3 = new List(4);
		l3.add("Potholes");
		l3.add("Disfiguring");
		l3.add("Poor Sidewalks");
		l3.setVisible(false);

		l4 = new List(4);
		l4.add("Polluted Water Supply");
		l4.add("Bare Water Bodies");
		l4.add("Poor Pump Facilities");
		
		l4.setVisible(false);
		
		l5 = new List(3);
		l5.add("Frequent Power Cuts");
		l5.add("Low Visibility StreetLights");
		l5.add("Drastic Voltage Hits");
		l5.setVisible(false);
		
		add(l3);
		add(l4);
		add(l5);
		add(tf);

		b2 = new Button("Submit");
		b2.setFont(new Font("Arial", Font.BOLD, 14));
        	b2.setBackground(Color.BLUE);
        	b2.setForeground(Color.WHITE);

		add(b2);

		road.addItemListener(this);
		water.addItemListener(this);
		light.addItemListener(this);
		other.addItemListener(this);
		b2.addActionListener(this);

		l6 = new Label();
		add(l6);    //to display submit
			
		addWindowListener(new MyWindowAdapter());
	
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(l.getSelectedItem() == "Mumbai")
		{
			l2.setText("You have chosen: Mumbai");
				
		}
		if(l.getSelectedItem() == "Navi Mumbai")
		{
			l2.setText("You have chosen: NaviMumbai");
				
		}
		if(l.getSelectedItem() == "Mumbai Suburban")
		{
			l2.setText("You have chosen: Mumbai Suburban");
							
		}
		if(l.getSelectedItem() == "South Bombay")
		{
			l2.setText("You have chosen: South Bombay");
					
		}
		else
		{
			l2.setText("Please enter a valid input Field");
		}

		try
		{
			String submit = ae.getActionCommand();
			if(submit.equals("Submit"))
			{
				FileWriter fw = new FileWriter("GrievanceResolver.txt");
				int a = Integer.parseInt(tage.getText());
				if(a <= 18)
				{
					l6.setText("Minor cannot punch in a grievances");
				}				
				else
				{
					fw.write(l.getSelectedItem() + " " + tname.getText() + " " + tage.getText() + " " + cg.getSelectedCheckbox().getLabel() +" " +  l3.getSelectedItem() + " " + l4.getSelectedItem() + " " + l5.getSelectedItem() + tf.getText());
					fw.close();
					l6.setText("DETAILS PUNCHED");
					System.out.println("DETAILS PUNCHED");
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("DETAILS LOST!");
		}
		

	}

		public void itemStateChanged(ItemEvent ie)
		{
			String s1 = cg.getSelectedCheckbox().getLabel();
			if(s1.equals("Road"))
			{
				l4.setVisible(false);
				l5.setVisible(false);
				tf.setVisible(false);
				l3.setVisible(true);
				
			}
			if(s1.equals("Water"))
			{
				l3.setVisible(false);
				l5.setVisible(false);
				tf.setVisible(false);
				l4.setVisible(true);
			}
			if(s1.equals("Light"))
			{
				l3.setVisible(false);
				l4.setVisible(false);
				tf.setVisible(false);
				l5.setVisible(true);
				
			}
			if(s1.equals("Other"))
			{
				
				l3.setVisible(false);
				l4.setVisible(false);
				l5.setVisible(false);
				tf.setVisible(true);
			}
		}

}





class homepage extends Frame implements ActionListener,ItemListener
{
	
	homepage()
	{

		addWindowListener(new MyWindowAdapter());
	}
	public void itemStateChanged(ItemEvent ie)
	{	
	}
	public void actionPerformed(ActionEvent ae)
	{
		
	}
}

class login extends Frame implements ActionListener,ItemListener
{
	Button back, proceed;
	Label username,password,repassword,mssg;
	TextField user,pass,repass;

	login()
	{
		setLayout(new FlowLayout());
		setBackground(Color.YELLOW);
		back = new Button("BACK");
		back.setFont(new Font("Arial", Font.BOLD, 14));
        	back.setBackground(Color.BLUE);
        	back.setForeground(Color.WHITE);

		username = new Label("Enter Username: ");
		username.setFont(new Font("Arial", Font.BOLD, 14));
        	username.setForeground(Color.MAGENTA);
		user = new TextField(15);
		user.setBackground(Color.LIGHT_GRAY);
        	user.setForeground(Color.BLACK);
		add(username);
		add(user);
		
		password = new Label("Enter Password: ");
		password.setFont(new Font("Arial", Font.BOLD, 14));
        	password.setForeground(Color.MAGENTA);
		pass = new TextField(15);
		pass.setBackground(Color.LIGHT_GRAY);
        	pass.setForeground(Color.BLACK);
		add(password);
		add(pass);

		repassword = new Label("Enter Re-Enter Password: ");
		repassword.setFont(new Font("Arial", Font.BOLD, 14));
        	repassword.setForeground(Color.MAGENTA);
		repass = new TextField(15);
		repass.setBackground(Color.LIGHT_GRAY);
        	repass.setForeground(Color.BLACK);
		add(repassword);
		add(repass);


		proceed = new Button("PROCEED");
		proceed.setFont(new Font("Arial", Font.BOLD, 14));
        	proceed.setBackground(Color.BLUE);
        	proceed.setForeground(Color.WHITE);
		proceed.addActionListener(this);
		add(proceed);
		mssg = new Label();
		mssg.setFont(new Font("Arial", Font.BOLD, 14));
        	mssg.setForeground(Color.MAGENTA);
		add(mssg);

		addWindowListener(new MyWindowAdapter());
	}
	public void itemStateChanged(ItemEvent ie)
	{	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() == "BACK")
		{
			maingriv m = new maingriv();
			m.setTitle("Grievance Resolver");
			m.setSize(1000,1000);
			m.setVisible(true);
		}
		if(ae.getActionCommand() == "PROCEED")
		{
			if(pass.getText().equals(repass.getText()))
			{
				grievance s = new grievance(); 
				s.setVisible(true);
				s.setTitle("Grievance");
				s.setSize(1000,1000);
				
			}
			else
			{
				mssg.setText("Password doesn't match");
			}
		}
	}
}

class aboutus extends Frame implements ActionListener,ItemListener
{
	Button back;
	Label ltitle,labout;
	aboutus()
	{

		setLayout(null);
		setBackground(Color.CYAN);
		ltitle = new Label("ABOUT US");
		back = new Button("BACK");
		ltitle.setFont(new Font("Times New Roman", Font.ITALIC, 45));
		ltitle.setForeground(Color.BLUE);
		ltitle.setBounds(650,10,300,100);


	

		
		labout=new Label("Introducing the new BMC App - SAMADHAN, designed to make reporting potholes, manhole issues, leakages and other public area problems easier for citizens. Users can simply open the app, take a picture of the issue, add the location tag and their contact details and submit the request. Our nearest BMC quarters will address the 			issue within an hour, and for more significant problems like restructuring the whole road, requests will be processed within 3 days with actions taken within 2 weeks. To 	ensure personal documents submission, users can head to their nearest BMC quarters. They can also view the number of problems filed in their area and report unsatisfactory outputs on the app itself.");


		labout.setBounds(50,100,1290,150);
		back.setBounds(630,500,300,70);

        	back.setBackground(Color.BLUE);
        	back.setForeground(Color.WHITE);
		back.setBounds(630,300,300,70);
		


		add(ltitle);
		add(labout);
		//add(labout1);
		add(back);
		back.addActionListener(this);
		addWindowListener(new MyWindowAdapter());
	}
	public void itemStateChanged(ItemEvent ie)
	{	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() == "BACK")
		{
			maingriv m = new maingriv();
			m.setTitle("Grievance Resolver");
			m.setSize(1000,1000);
			m.setVisible(true);
		}
	}
}




//main class

class maingriv extends Frame implements ActionListener
{
	Button login,homepage,aboutus,grievance;
	Label l1;

	maingriv()
	{
		
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		l1 = new Label("SAMADHAN");
		add(l1);
		l1.setFont(new Font("Times New Roman", Font.ITALIC, 45));
		l1.setForeground(Color.BLUE);
		l1.setBounds(650,10,300,200);
		
		


		login = new Button("LOGIN");
		login.setFont(new Font("Arial", Font.BOLD, 14));
        	login.setBackground(Color.PINK);
        	login.setForeground(Color.WHITE);
		login.setBounds(630,300,300,70);
		add(login);
		login.addActionListener(this);
		

		
		grievance = new Button("GRIEVANCE");
		grievance .setFont(new Font("Arial", Font.BOLD, 14));
        	grievance .setBackground(Color.PINK);
        	grievance .setForeground(Color.WHITE);
		grievance.setBounds(630,400,300,70);
		add(grievance);
		grievance.addActionListener(this);
		


		aboutus = new Button("ABOUTUS");
		aboutus.setFont(new Font("Arial", Font.BOLD, 14));
        	aboutus.setBackground(Color.PINK);
        	aboutus.setForeground(Color.WHITE);
		aboutus.setBounds(630,500,300,70);
		add(aboutus);
		aboutus.addActionListener(this);

		addWindowListener(new MyWindowAdapter());

	}

	
	public void actionPerformed(ActionEvent ae)
	{
		String link = ae.getActionCommand();
		if(link.equals("GRIEVANCE"))
		{
			grievance s = new grievance(); 
			s.setVisible(true);
			s.setTitle("Grievance");
			s.setSize(1000,1000);
		}
		/*if(link.equals("HOMEPAGE"))
		{
			homepage h = new homepage();
			h.setVisible(true);
			h.setTitle("Homepage");
			h.setSize(1000,1000);
			
		}	*/
		if(link.equals("LOGIN"))
		{
			login l = new login();
			l.setVisible(true);
			l.setTitle("Login");
			l.setSize(1000,1000);
			
		}	
		if(link.equals("ABOUTUS"))
		{
			aboutus a = new aboutus();
			a.setVisible(true);
			a.setTitle("About Us");
			a.setSize(1000,1000);
		}	
	}

	public static void main(String[] args)
	{
		maingriv m = new maingriv();
		m.setTitle("Grievance Resolver");
		m.setSize(1000,1000);
		m.setVisible(true);
	}
}



class MyWindowAdapter extends WindowAdapter
{
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}