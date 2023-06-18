import java.awt.Choice;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;
public class BookPackage extends JFrame implements ActionListener{

	JLabel background,text,username,usernameval,selectpackage,totalperson,id,idlbl,number,numberlbl,phone,phonelbl,price,pricelbl;
	Choice packagechoice;
	JTextField totalpersontext;
	String susername;
	JButton checkprice,bookpackage,back;
	
	BookPackage(String susername)
	{
		this.susername=susername;
		
		setBounds(350,200,1100,500);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("BOOK PACKAGE");
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
		
		selectpackage=new JLabel("Select Package");
		selectpackage.setBounds(40,110,150,20);
		selectpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(selectpackage);
		
		packagechoice=new Choice();
		packagechoice.setBounds(250,110,200,20);
		packagechoice.add("Gold Package");
		packagechoice.add("Silver Package");
		packagechoice.add("Bronze Package");
		add(packagechoice);
		
		totalperson=new JLabel("Total Person");
		totalperson.setBounds(40,150,150,25);
		totalperson.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(totalperson);
		
		totalpersontext=new JTextField("1");
		totalpersontext.setBounds(250,150,150,25);
		add(totalpersontext);
		
		id=new JLabel("ID");
		id.setBounds(40,190,150,25);
		id.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(id);
			
		idlbl=new JLabel();
		idlbl.setBounds(250,190,200,20);
		idlbl.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(idlbl);
		
		number=new JLabel("Number");
		number.setBounds(40,230,150,25);
		number.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(number);
		
		numberlbl=new JLabel();
		numberlbl.setBounds(250,230,150,25);
		numberlbl.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(numberlbl);
		
		phone=new JLabel("Phone");
		phone.setBounds(40,270,150,25);
		phone.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(phone);
		
		phonelbl=new JLabel();
		phonelbl.setBounds(250,270,150,25);
		phonelbl.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(phonelbl);
		
		price=new JLabel("Total Price");
		price.setBounds(40,310,150,25);
		price.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(price);
		
		pricelbl=new JLabel();
		pricelbl.setBounds(250,310,150,25);
		pricelbl.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(pricelbl);
		
		try
		{
			Conn c=new Conn();
			String query="select * from customer where username= '"+susername+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				usernameval.setText(rs.getString("username"));
				idlbl.setText(rs.getString("id"));
				numberlbl.setText(rs.getString("number"));
				phonelbl.setText(rs.getString("phone"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		checkprice=new JButton("Check Price");
		checkprice.setBounds(60,380,120,25);
		checkprice.setBackground(Color.black);
		checkprice.setForeground(Color.white);
		add(checkprice);
		checkprice.addActionListener(this);
		
		bookpackage=new JButton("Book Package");
		bookpackage.setBounds(200,380,120,25);
		bookpackage.setBackground(Color.black);
		bookpackage.setForeground(Color.white);
		add(bookpackage);
		bookpackage.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(340,380,120,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/bookpackage.jpg");
		
		Image i=img.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(550,50,500,300);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==checkprice)
		{
			String spackage=packagechoice.getSelectedItem();
			int cost=0;
			if(spackage.equals("Gold Package"))
			{
				cost += 12000;
			}
			else if(spackage.equals("Silver Package"))
			{
				cost += 25000;
			}
			else
			{
				cost += 32000;
			}
			
			int sperson=Integer.parseInt(totalpersontext.getText());
			
			cost *= sperson;
			pricelbl.setText("Rs "+ cost);
		}
		else if(ae.getSource()==bookpackage)
		{
			try
			{
				String susername=usernameval.getText();
				String spackage=packagechoice.getSelectedItem();
				String stotalpersons=totalpersontext.getText();
				String sid=idlbl.getText();
				String snumber=numberlbl.getText();
				String sphone=phonelbl.getText();
				String sprice=pricelbl.getText();
				
				Conn c=new Conn();
				String query="insert into bookpackage values('"+susername+"','"+spackage+"','"+stotalpersons+"','"+sid+"','"+snumber+"','"+sphone+"','"+sprice+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Package Booked Successfully...!!!");
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
		new BookPackage("");

	}

}
