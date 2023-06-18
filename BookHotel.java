import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class BookHotel extends JFrame implements ActionListener{
	
	JLabel background,text,username,usernameval,selecthotel,totalpersons,noofdays,acnonac,food,id,idval,number,numberval,phone,phoneval,totalprice,totalpriceval;
	Choice selecthotelchoice,acnonacchoice,foodchoice;
	JTextField totalpersonstext,noofdaystext;
	String susername;
	JButton checkprice,bookhotel,back;
	int cost,room,foodint;

	BookHotel(String susername)
	{
		this.susername=susername;
		
		setBounds(350,200,1100,600);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("BOOK HOTEL");
		text.setBounds(100,10,200,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		username=new JLabel("Username");
		username.setBounds(40,70,100,20);
		username.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(username);
		
		usernameval=new JLabel();
		usernameval.setBounds(250,70,200,20);
		usernameval.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(usernameval);
		
		selecthotel=new JLabel("Select Hotel");
		selecthotel.setBounds(40,110,150,20);
		selecthotel.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(selecthotel);
		
		selecthotelchoice=new Choice();
		selecthotelchoice.setBounds(250,110,200,20);
		selecthotelchoice.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(selecthotelchoice);
		
		try
		{
			Conn c=new Conn();
			String query="select * from hotel";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				selecthotelchoice.add(rs.getString("name"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		totalpersons=new JLabel("Total Persons");
		totalpersons.setBounds(40,150,150,25);
		totalpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(totalpersons);
		
		totalpersonstext=new JTextField("1");
		totalpersonstext.setBounds(250,150,200,25);
		totalpersonstext.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(totalpersonstext);
		
		noofdays=new JLabel("No. of Days");
		noofdays.setBounds(40,190,150,25);
		noofdays.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(noofdays);
		
		noofdaystext=new JTextField("1");
		noofdaystext.setBounds(250,190,200,25);
		noofdaystext.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(noofdaystext);
		
		acnonac=new JLabel("AC / Non-AC");
		acnonac.setBounds(40,230,150,25);
		acnonac.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(acnonac);
		
		acnonacchoice=new Choice();
		acnonacchoice.setBounds(250,230,200,20);
		acnonacchoice.setFont(new Font("Tahoma",Font.PLAIN,16));
		acnonacchoice.add("AC");
		acnonacchoice.add("Non AC");
		add(acnonacchoice);
		
		food=new JLabel("Food");
		food.setBounds(40,270,150,25);
		food.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(food);
		
		foodchoice=new Choice();
		foodchoice.setBounds(250,270,150,25);
		foodchoice.setFont(new Font("Tahoma",Font.PLAIN,16));
		foodchoice.add("Yes");
		foodchoice.add("No");
		add(foodchoice);
		
		id=new JLabel("ID");
		id.setBounds(40,310,150,25);
		id.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(id);
		
		idval=new JLabel();
		idval.setBounds(250,310,150,25);
		idval.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(idval);
		
		number=new JLabel("Number");
		number.setBounds(40,350,150,25);
		number.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(number);
		
		numberval=new JLabel();
		numberval.setBounds(250,350,150,25);
		numberval.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(numberval);
		
		phone=new JLabel("Phone");
		phone.setBounds(40,390,150,25);
		phone.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(phone);
		
		phoneval=new JLabel();
		phoneval.setBounds(250,390,200,25);
		phoneval.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(phoneval);
		
		totalprice=new JLabel("Total Price");
		totalprice.setBounds(40,430,150,25);
		totalprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(totalprice);
		
		totalpriceval=new JLabel();
		totalpriceval.setBounds(250,430,150,25);
		totalpriceval.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(totalpriceval);
		
		try
		{
			Conn c=new Conn();
			String query="select * from customer where username = '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernameval.setText(rs.getString("username"));
				idval.setText(rs.getString("id"));
				numberval.setText(rs.getString("number"));
				phoneval.setText(rs.getString("phone"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		checkprice=new JButton("Check Price");
		checkprice.setBounds(60,490,120,25);
		checkprice.setBackground(Color.black);
		checkprice.setForeground(Color.white);
		add(checkprice);
		checkprice.addActionListener(this);
		
		bookhotel=new JButton("Book Hotel");
		bookhotel.setBounds(200,490,120,25);
		bookhotel.setBackground(Color.black);
		bookhotel.setForeground(Color.white);
		add(bookhotel);
		bookhotel.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(340,490,120,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/book.jpg");
		Image i=img.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(500,50,600,400);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==checkprice)
		{
			try
			{
				Conn c=new Conn();
				String query="select * from hotel where name= '"+selecthotelchoice.getSelectedItem()+"' ";
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					cost=Integer.parseInt(rs.getString("costperperson"));
					room=Integer.parseInt(rs.getString("acroom"));
					foodint=Integer.parseInt(rs.getString("foodincluded"));
				}
				int sperson=Integer.parseInt(totalpersonstext.getText());
				int sdays=Integer.parseInt(noofdaystext.getText());
				String ac=acnonacchoice.getSelectedItem();
				String food=foodchoice.getSelectedItem();
				
				if(sperson>0  && sdays>0)
				{
					int total=0;
					if(ac.equals("AC"))
					{
						total = total + room; //cost per person
					}
					if(food.equals("Yes"))
					{
						total = total + foodint; //cost per person
					}
					total = total + cost; //cost per person
					
					total = total * Integer.parseInt(totalpersonstext.getText()) * Integer.parseInt(noofdaystext.getText()); //calculating total price for persons and how many days they are going to halt
				
					totalpriceval.setText("Rs "+total);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid number");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==bookhotel)
		{
			try
			{
				String query="insert into bookhotel values('"+usernameval.getText()+"','"+selecthotelchoice.getSelectedItem()+"','"+totalpersonstext.getText()+"','"+noofdaystext.getText()+"','"+acnonacchoice.getSelectedItem()+"','"+foodchoice.getSelectedItem()+"','"+idval.getText()+"','"+numberval.getText()+"','"+phoneval.getText()+"','"+totalpriceval.getText()+"')";
				Conn c=new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Hotel Booked Successfully...!!!");
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
		new BookHotel("");

	}

}
