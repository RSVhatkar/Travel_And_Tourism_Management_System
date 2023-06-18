import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class ViewBookedHotel extends JFrame implements ActionListener{

	JLabel background,text,username,usernameval,hotelname,hotelnameval,person,personval,totaldays,totaldaysval,acnonac,acnonacval,foodincluded,foodincludedval,id,idval,number,numberval,phone,phoneval,price,priceval;
	JButton back;
	String susername;
	
	ViewBookedHotel(String susername)
	{
		this.susername=susername;
		
		setBounds(400,200,1000,600);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("VIEW BOOKED HOTEL DETAILS");
		text.setBounds(60,0,400,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		username=new JLabel("Username");
		username.setBounds(30,50,150,25);
		add(username);
		
		usernameval=new JLabel();
		usernameval.setBounds(220,50,150,25);
		add(usernameval);
		
		hotelname=new JLabel("Hotel Name");
		hotelname.setBounds(30,90,150,25);
		add(hotelname);
		
		hotelnameval=new JLabel();
		hotelnameval.setBounds(220,90,150,25);
		add(hotelnameval);
		
		person=new JLabel("Total Persons");
		person.setBounds(30,130,150,25);
		add(person);
		
		personval=new JLabel();
		personval.setBounds(220,130,150,25);
		add(personval);
		
		totaldays=new JLabel("Total Days");
		totaldays.setBounds(30,170,150,25);
		add(totaldays);
		
		totaldaysval=new JLabel();
		totaldaysval.setBounds(220,170,150,25);
		add(totaldaysval);
		
		acnonac=new JLabel("AC / Non-AC");
		acnonac.setBounds(30,210,150,25);
		add(acnonac);
		
		acnonacval=new JLabel();
		acnonacval.setBounds(220,210,150,25);
		add(acnonacval);
		
		foodincluded=new JLabel("Food included?");
		foodincluded.setBounds(30,250,150,25);
		add(foodincluded);
		
		foodincludedval=new JLabel();
		foodincludedval.setBounds(220,250,150,25);
		add(foodincludedval);
		
		id=new JLabel("ID");
		id.setBounds(30,290,150,25);
		add(id);
		
		idval=new JLabel();
		idval.setBounds(220,290,150,25);
		add(idval);
		
		number=new JLabel("Number");
		number.setBounds(30,330,150,25);
		add(number);
		
		numberval=new JLabel();
		numberval.setBounds(220,330,150,25);
		add(numberval);
		
		phone=new JLabel("Phone");
		phone.setBounds(30,370,150,25);
		add(phone);
		
		phoneval=new JLabel();
		phoneval.setBounds(220,370,150,25);
		add(phoneval);
		
		price=new JLabel("Total Cost");
		price.setBounds(30,410,150,25);
		add(price);
		
		priceval=new JLabel();
		priceval.setBounds(220,410,150,25);
		add(priceval);
		
		back=new JButton("Back");
		back.setBounds(130,460,100,25);
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
			String query="select * from bookhotel where username= '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernameval.setText(rs.getString("username"));
				hotelnameval.setText(rs.getString("name"));
				personval.setText(rs.getString("persons"));
				totaldaysval.setText(rs.getString("days"));
				acnonacval.setText(rs.getString("ac"));
				foodincludedval.setText(rs.getString("food"));
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
		new ViewBookedHotel("");

	}

}
