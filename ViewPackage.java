import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class ViewPackage extends JFrame implements ActionListener{

	JLabel background,text,username,usernameval,packagee,packageval,person,personval,id,idval,number,numberval,phone,phoneval,price,priceval;
	JButton back;
	String susername;
	
	ViewPackage(String susername)
	{
		this.susername=susername;
		
		setBounds(450,200,900,450);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("VIEW PACKAGE DETAILS");
		text.setBounds(60,0,300,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		username=new JLabel("Username");
		username.setBounds(30,50,150,25);
		add(username);
		
		usernameval=new JLabel();
		usernameval.setBounds(220,50,150,25);
		add(usernameval);
		
		packagee=new JLabel("Package");
		packagee.setBounds(30,90,150,25);
		add(packagee);
		
		packageval=new JLabel();
		packageval.setBounds(220,90,150,25);
		add(packageval);
		
		person=new JLabel("Total Persons");
		person.setBounds(30,130,150,25);
		add(person);
		
		personval=new JLabel();
		personval.setBounds(220,130,150,25);
		add(personval);
		
		id=new JLabel("ID");
		id.setBounds(30,170,150,25);
		add(id);
		
		idval=new JLabel();
		idval.setBounds(220,170,150,25);
		add(idval);
		
		number=new JLabel("Number");
		number.setBounds(30,210,150,25);
		add(number);
		
		numberval=new JLabel();
		numberval.setBounds(220,210,150,25);
		add(numberval);
		
		phone=new JLabel("Phone");
		phone.setBounds(30,250,150,25);
		add(phone);
		
		phoneval=new JLabel();
		phoneval.setBounds(220,250,150,25);
		add(phoneval);
		
		price=new JLabel("Price");
		price.setBounds(30,290,150,25);
		add(price);
		
		priceval=new JLabel();
		priceval.setBounds(220,290,150,25);
		add(priceval);
		
		back=new JButton("Back");
		back.setBounds(130,360,100,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/bookedDetails.jpg");
		
		Image i=img.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(450,20,500,400);
		add(background);
		
		try
		{
			Conn c=new Conn();
			String query="select * from bookpackage where username= '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernameval.setText(rs.getString("username"));
				packageval.setText(rs.getString("package"));
				personval.setText(rs.getString("persons"));
				idval.setText(rs.getString("id"));
				numberval.setText(rs.getString("number"));
				phoneval.setText(rs.getString("phone"));
				priceval.setText(rs.getString("price"));
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
		new ViewPackage("");

	}

}
