import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener{

	JPanel p1,p2;
	JLabel background,heading,background1,text;
	JButton addpersonaldetails,updatepersonaldetails,viewpersonaldetails,deletepersonaldetails,checkpackage,bookpackage,viewpackage,viewhotels,bookhotel,viewbookedhotel,destinations,payment,calculator,notepad,about;
	String susername;
	
	Dashboard(String susername)
	{
		this.susername=susername;
		
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//setSize of frame if we don't know size of our screen
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0,0,2000,65);
		add(p1);
		
		ImageIcon img=new ImageIcon("icons/dashboard.png");
		
		Image i=img.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(5,0,70,70);
		p1.add(background);
		
		heading=new JLabel("Dashboard");
		heading.setBounds(80,10,300,40);
		heading.setFont(new Font("Tahoma",Font.PLAIN,30));
		heading.setForeground(Color.white);
		p1.add(heading);
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,65,300,900);
		p2.setBackground(new Color(0,0,102));
		add(p2);
		
		addpersonaldetails=new JButton("Add Personal Details");
		addpersonaldetails.setBounds(0,0,300,50);
		addpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		addpersonaldetails.setBackground(new Color(0,0,102));
		addpersonaldetails.setForeground(Color.white);
		addpersonaldetails.setMargin(new Insets(0,0,0,60));//top left bottom right . to set button text from left or from where you want to set 
		p2.add(addpersonaldetails);
		addpersonaldetails.addActionListener(this);
		
		updatepersonaldetails=new JButton("Update Personal Details");
		updatepersonaldetails.setBounds(0,50,300,50);
		updatepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		updatepersonaldetails.setBackground(new Color(0,0,102));
		updatepersonaldetails.setForeground(Color.white);
		updatepersonaldetails.setMargin(new Insets(0,0,0,30));
		p2.add(updatepersonaldetails);
		updatepersonaldetails.addActionListener(this);
		
		viewpersonaldetails=new JButton("View Details");
		viewpersonaldetails.setBounds(0,100,300,50);
		viewpersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewpersonaldetails.setBackground(new Color(0,0,102));
		viewpersonaldetails.setForeground(Color.white);
		viewpersonaldetails.setMargin(new Insets(0,0,0,130));
		p2.add(viewpersonaldetails);
		viewpersonaldetails.addActionListener(this);
		
		deletepersonaldetails=new JButton("Delete Personal Details");
		deletepersonaldetails.setBounds(0,150,300,50);
		deletepersonaldetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		deletepersonaldetails.setBackground(new Color(0,0,102));
		deletepersonaldetails.setForeground(Color.white);
		deletepersonaldetails.setMargin(new Insets(0,0,0,40));
		p2.add(deletepersonaldetails);
		deletepersonaldetails.addActionListener(this);
		
		checkpackage=new JButton("Check Package");
		checkpackage.setBounds(0,200,300,50);
		checkpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		checkpackage.setBackground(new Color(0,0,102));
		checkpackage.setForeground(Color.white);
		checkpackage.setMargin(new Insets(0,0,0,110));
		p2.add(checkpackage);
		checkpackage.addActionListener(this);
		
		bookpackage=new JButton("Book Package");
		bookpackage.setBounds(0,250,300,50);
		bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		bookpackage.setBackground(new Color(0,0,102));
		bookpackage.setForeground(Color.white);
		bookpackage.setMargin(new Insets(0,0,0,120));
		p2.add(bookpackage);
		bookpackage.addActionListener(this);
		
		viewpackage=new JButton("View Package");
		viewpackage.setBounds(0,300,300,50);
		viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewpackage.setBackground(new Color(0,0,102));
		viewpackage.setForeground(Color.white);
		viewpackage.setMargin(new Insets(0,0,0,120));
		p2.add(viewpackage);
		viewpackage.addActionListener(this);
		
		viewhotels=new JButton("View Hotels");
		viewhotels.setBounds(0,350,300,50);
		viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewhotels.setBackground(new Color(0,0,102));
		viewhotels.setForeground(Color.white);
		viewhotels.setMargin(new Insets(0,0,0,130));
		p2.add(viewhotels);
		viewhotels.addActionListener(this);
		
		bookhotel=new JButton("Book Hotel");
		bookhotel.setBounds(0,400,300,50);
		bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		bookhotel.setBackground(new Color(0,0,102));
		bookhotel.setForeground(Color.white);
		bookhotel.setMargin(new Insets(0,0,0,140));
		p2.add(bookhotel);
		bookhotel.addActionListener(this);
		
		viewbookedhotel=new JButton("View Booked Hotel");
		viewbookedhotel.setBounds(0,450,300,50);
		viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
		viewbookedhotel.setBackground(new Color(0,0,102));
		viewbookedhotel.setForeground(Color.white);
		viewbookedhotel.setMargin(new Insets(0,0,0,70));
		p2.add(viewbookedhotel);
		viewbookedhotel.addActionListener(this);
		
		destinations=new JButton("Destinations");
		destinations.setBounds(0,500,300,50);
		destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
		destinations.setBackground(new Color(0,0,102));
		destinations.setForeground(Color.white);
		destinations.setMargin(new Insets(0,0,0,130));
		p2.add(destinations);
		destinations.addActionListener(this);
		
		payment=new JButton("Payment");
		payment.setBounds(0,550,300,50);
		payment.setFont(new Font("Tahoma",Font.PLAIN,20));
		payment.setBackground(new Color(0,0,102));
		payment.setForeground(Color.white);
		payment.setMargin(new Insets(0,0,0,155));
		p2.add(payment);
		payment.addActionListener(this);
		
		calculator=new JButton("Calculator");
		calculator.setBounds(0,600,300,50);
		calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
		calculator.setBackground(new Color(0,0,102));
		calculator.setForeground(Color.white);
		calculator.setMargin(new Insets(0,0,0,145));
		p2.add(calculator);
		calculator.addActionListener(this);
		
		notepad=new JButton("Notepad");
		notepad.setBounds(0,650,300,50);
		notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
		notepad.setBackground(new Color(0,0,102));
		notepad.setForeground(Color.white);
		notepad.setMargin(new Insets(0,0,0,155));
		p2.add(notepad);
		notepad.addActionListener(this);
		
		about=new JButton("About");
		about.setBounds(0,700,300,50);
		about.setFont(new Font("Tahoma",Font.PLAIN,20));
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.white);
		about.setMargin(new Insets(0,0,0,175));
		p2.add(about);
		about.addActionListener(this);
		
		ImageIcon img1=new ImageIcon("icons/home.jpg");
		
		Image i2=img1.getImage().getScaledInstance(2000,1000,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew1=new ImageIcon(i2);
		
		background1=new JLabel("",imgnew1,JLabel.CENTER);
		background1.setBounds(0,0,2000,1000);
		add(background1);
		
		text=new JLabel("Travel and Tourism Management System");
		text.setBounds(400,70,1300,70);
		text.setFont(new Font("Raleway",Font.PLAIN,55));
		text.setForeground(Color.white);
		background1.add(text);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==addpersonaldetails)
		{
			new AddCustomer(susername);
		}
		else if(ae.getSource()==viewpersonaldetails)
		{
			new ViewCustomer(susername);
		}
		else if(ae.getSource()==updatepersonaldetails)
		{
			new UpdateCustomer(susername);
		}
		else if(ae.getSource()==checkpackage)
		{
			new CheckPackage();
		}
		else if(ae.getSource()==bookpackage)
		{
			new BookPackage(susername);
		}
		else if(ae.getSource()==viewpackage)
		{
			new ViewPackage(susername);
		}
		else if(ae.getSource()==viewhotels)
		{
			new CheckHotels();
		}
		else if(ae.getSource()==destinations)
		{
			new Destinations();
		}
		else if(ae.getSource()==bookhotel)
		{
			new BookHotel(susername);
		}
		else if(ae.getSource()==viewbookedhotel)
		{
			new ViewBookedHotel(susername);
		}
		else if(ae.getSource()==payment)
		{
			new Payment();
		}
		else if(ae.getSource()==calculator)
		{
			try
			{
				Runtime.getRuntime().exec("calc.exe"); //to get executable file of calculator Runtime class is used
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==notepad)
		{
			try
			{
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==about)
		{
			new About();
		}
		else if(ae.getSource()==deletepersonaldetails)
		{
			new DeleteDetails(susername);
		}
	}
	
	public static void main(String[] args) {
		new Dashboard("");

	}

}
