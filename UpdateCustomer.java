import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;
public class UpdateCustomer extends JFrame implements ActionListener{

	JLabel text,username,usernamel,id,number,name,namel,gender,country,address,phone,email,background;
	JTextField numbertext,countrytext,addresstext,phonetext,emailtext,idtext,gendertext;
	JButton update,back;
	String susername;
	
	UpdateCustomer(String susername)
	{
		this.susername=susername;
		
		setLayout(null);
		setBounds(500,200,850,550);
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("UPDATE CUSTOMER DETAILS");
		text.setBounds(50,0,300,25);
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(text);
		
		username=new JLabel("Username");
		username.setBounds(30,50,150,25);
		add(username);
		
		usernamel=new JLabel();
		usernamel.setBounds(220,50,150,25);
		add(usernamel);
		
		id=new JLabel("Id");
		id.setBounds(30,90,150,25);
		add(id);
		
		idtext=new JTextField();
		idtext.setBounds(220,90,150,25);
		add(idtext);
		
		number=new JLabel("Number");
		number.setBounds(30,130,150,25);
		add(number);
		
		numbertext=new JTextField();
		numbertext.setBounds(220,130,150,25);
		add(numbertext);
		
		name=new JLabel("Name");
		name.setBounds(30,170,150,25);
		add(name);
		
		namel=new JLabel();
		namel.setBounds(220,170,150,25);
		add(namel);
		
		gender=new JLabel("Gender");
		gender.setBounds(30,210,150,25);
		add(gender);
		
		gendertext=new JTextField();
		gendertext.setBounds(220,210,150,25);
		add(gendertext);
		
		country=new JLabel("Country");
		country.setBounds(30,250,150,25);
		add(country);
		
		countrytext=new JTextField();
		countrytext.setBounds(220,250,150,25);
		add(countrytext);
		
		address=new JLabel("Address");
		address.setBounds(30,290,150,25);
		add(address);
		
		addresstext=new JTextField();
		addresstext.setBounds(220,290,150,25);
		add(addresstext);
		
		phone=new JLabel("Phone");
		phone.setBounds(30,330,150,25);
		add(phone);
		
		phonetext=new JTextField();
		phonetext.setBounds(220,330,150,25);
		add(phonetext);
		
		email=new JLabel("Email");
		email.setBounds(30,370,150,25);
		add(email);
		
		emailtext=new JTextField();
		emailtext.setBounds(220,370,150,25);
		add(emailtext);
		
		update=new JButton("Update");
		update.setBounds(70,430,100,25);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(230,430,100,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/newcustomer.jpg");
		
		Image i=img.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(400,100,450,420);
		add(background);
		
		try
		{
			Conn c=new Conn();
			String query="select * from customer where username= '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernamel.setText(rs.getString("username"));
				idtext.setText(rs.getString("id"));
				numbertext.setText(rs.getString("number"));
				namel.setText(rs.getString("name"));
				gendertext.setText(rs.getString("gender"));
				countrytext.setText(rs.getString("country"));
				addresstext.setText(rs.getString("address"));
				phonetext.setText(rs.getString("phone"));
				emailtext.setText(rs.getString("email"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//to fetch username and name
		try
		{
			Conn c=new Conn();
			String query="select * from account where username= '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernamel.setText(rs.getString("username"));
				namel.setText(rs.getString("name"));
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
		if(ae.getSource()==update)
		{
			String usernames=usernamel.getText();
			String sid=idtext.getText();
			String snumber=numbertext.getText();
			String sname=namel.getText();
			String sgender=gendertext.getText();
			String scountry=countrytext.getText();
			String saddress=addresstext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="update customer set id= '"+sid+"',number= '"+snumber+"' ,name= '"+sname+"' ,gender= '"+sgender+"',country= '"+scountry+"',address= '"+saddress+"',phone= '"+sphone+"',email= '"+semail+"' where username= '"+susername+"' ";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Customer details updated succesfully");
				setVisible(false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("");

	}

}
