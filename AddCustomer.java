import java.awt.Color;
import java.awt.event.*;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;
public class AddCustomer extends JFrame implements ActionListener{

	JLabel username,usernamel,id,number,name,namel,gender,country,address,phone,email,background;
	JComboBox idcombo;
	JTextField numbertext,countrytext,addresstext,phonetext,emailtext;
	JRadioButton male,female;
	JButton add,back;
	String susername;
	
	AddCustomer(String susername)
	{
		this.susername=susername;
		
		setLayout(null);
		setBounds(450,200,850,550);
		getContentPane().setBackground(Color.white);
		
		username=new JLabel("Username");
		username.setBounds(30,50,150,25);
		add(username);
		
		usernamel=new JLabel();
		usernamel.setBounds(220,50,150,25);
		add(usernamel);
		
		id=new JLabel("Id");
		id.setBounds(30,90,150,25);
		add(id);
		
		String idvalue[]= {"Passport","Adhar Card","Pan Card","Ration Card"};
		idcombo=new JComboBox(idvalue);
		idcombo.setBounds(220,90,150,25);
		idcombo.setBackground(Color.white);
		add(idcombo);
		
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
		
		male=new JRadioButton("Male");
		male.setBounds(220,210,70,25);
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(300,210,70,25);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
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
		
		add=new JButton("Add");
		add.setBounds(70,430,100,25);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add(add);
		add.addActionListener(this);
		
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
		background.setBounds(400,40,450,420);
		add(background);
		
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
		if(ae.getSource()==add)
		{
			String usernames=usernamel.getText();
			String sid=(String) idcombo.getSelectedItem();
			String snumber=numbertext.getText();
			String sname=namel.getText();
			String sgender=null;
			if(male.isSelected())
			{
				sgender="Male";
			}
			else
			{
				sgender="Female";
			}
			String scountry=countrytext.getText();
			String saddress=addresstext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="insert into customer values('"+usernames+"','"+sid+"','"+snumber+"','"+sname+"','"+sgender+"','"+scountry+"','"+saddress+"','"+sphone+"','"+semail+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Customer details added succesfully");
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
		new AddCustomer("");

	}

}
