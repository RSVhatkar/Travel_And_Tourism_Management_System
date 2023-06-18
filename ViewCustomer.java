import java.awt.Color;
import java.awt.event.*;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;
public class ViewCustomer extends JFrame implements ActionListener{

	JLabel background,background1,username,usernameval,id,idval,number,numberval,name,nameval,gender,genderval,country,countryval,address,addressval,phone,phoneval,email,emailval;
	JButton back;
	String susername;
	
	ViewCustomer(String susername)
	{
		this.susername=susername;
		
		setBounds(450,180,870,625);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		username=new JLabel("Username");
		username.setBounds(30,50,150,25);
		add(username);
		
		usernameval=new JLabel();
		usernameval.setBounds(220,50,150,25);
		add(usernameval);
		
		id=new JLabel("Id");
		id.setBounds(30,110,150,25);
		add(id);
		
		idval=new JLabel();
		idval.setBounds(220,110,150,25);
		add(idval);
		
		number=new JLabel("Number");
		number.setBounds(30,170,150,25);
		add(number);
		
		numberval=new JLabel();
		numberval.setBounds(220,170,150,25);
		add(numberval);
		
		name=new JLabel("Name");
		name.setBounds(30,230,150,25);
		add(name);
		
		nameval=new JLabel();
		nameval.setBounds(220,230,150,25);
		add(nameval);
		
		gender=new JLabel("Gender");
		gender.setBounds(30,290,150,25);
		add(gender);
		
		genderval=new JLabel();
		genderval.setBounds(220,290,150,25);
		add(genderval);
		
		country=new JLabel("Country");
		country.setBounds(500,50,150,25);
		add(country);
		
		countryval=new JLabel();
		countryval.setBounds(690,50,150,25);
		add(countryval);
		
		address=new JLabel("Address");
		address.setBounds(500,110,150,25);
		add(address);
		
		addressval=new JLabel();
		addressval.setBounds(690,110,150,25);
		add(addressval);
		
		phone=new JLabel("Phone");
		phone.setBounds(500,170,150,25);
		add(phone);
		
		phoneval=new JLabel();
		phoneval.setBounds(690,170,150,25);
		add(phoneval);
		
		email=new JLabel("Email");
		email.setBounds(500,230,150,25);
		add(email);
		
		emailval=new JLabel();
		emailval.setBounds(690,230,150,25);
		add(emailval);
		
		back=new JButton("Back");
		back.setBounds(350,350,100,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/viewall.jpg");
		
		Image i=img.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(20,400,600,200);
		add(background);
		
		ImageIcon img1=new ImageIcon("icons/viewall.jpg");
		
		Image i1=img1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew1=new ImageIcon(i1);
		
		background1=new JLabel("",imgnew1,JLabel.CENTER);
		background1.setBounds(600,400,600,200);
		add(background1);
		
		try
		{
			Conn c=new Conn();
			String query="select * from customer where username= '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernameval.setText(rs.getString("username"));
				idval.setText(rs.getString("id"));
				numberval.setText(rs.getString("number"));
				nameval.setText(rs.getString("name"));
				genderval.setText(rs.getString("gender"));
				countryval.setText(rs.getString("country"));
				addressval.setText(rs.getString("address"));
				phoneval.setText(rs.getString("phone"));
				emailval.setText(rs.getString("email"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}
	
	public static void main(String[] args) {
		new ViewCustomer("");

	}

}
