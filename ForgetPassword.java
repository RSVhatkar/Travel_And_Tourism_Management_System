import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class ForgetPassword extends JFrame implements ActionListener{

	JPanel p1;
	JLabel background,username,name,question,answer,password;
	JTextField usernametext,nametext,questiontext,answertext,passwordtext;
	JButton search,retrive,back;
	
	ForgetPassword()
	{
		setLayout(null);
		setBounds(350,250,850,380);
		
		getContentPane().setBackground(Color.white);
		
		p1=new JPanel();
		p1.setBounds(30,30,500,280);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon img=new ImageIcon("icons/forgotpassword.jpg");
		
		Image i=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(580,70,200,200);
		add(background);
		
		username=new JLabel("Username");
		username.setBounds(40,20,100,25);
		username.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(username);
		
		usernametext=new JTextField();
		usernametext.setBounds(220,20,150,25);
		usernametext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(usernametext);
		
		search=new JButton("Search");
		search.setBounds(380,20,100,25);
		search.setBackground(Color.GRAY);
		search.setForeground(Color.white);
		p1.add(search);
		search.addActionListener(this);
		
		name=new JLabel("Name");
		name.setBounds(40,60,100,25);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(name);
		
		nametext=new JTextField();
		nametext.setBounds(220,60,150,25);
		nametext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(nametext);
		
		question=new JLabel("Security Question");
		question.setBounds(40,100,150,25);
		question.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(question);
		
		questiontext=new JTextField();
		questiontext.setBounds(220,100,150,25);
		questiontext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(questiontext);
		
		answer=new JLabel("Answer");
		answer.setBounds(40,140,150,25);
		answer.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(answer);
		
		answertext=new JTextField();
		answertext.setBounds(220,140,150,25);
		answertext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(answertext);
		
		retrive=new JButton("Retrieve");
		retrive.setBounds(380,140,100,25);
		retrive.setBackground(Color.GRAY);
		retrive.setForeground(Color.white);
		p1.add(retrive);
		retrive.addActionListener(this);
		
		password=new JLabel("Password");
		password.setBounds(40,180,150,25);
		password.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(password);
		
		passwordtext=new JTextField();
		passwordtext.setBounds(220,180,150,25);
		passwordtext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(passwordtext);
		
		back=new JButton("Back");
		back.setBounds(150,230,100,25);
		back.setBackground(Color.GRAY);
		back.setForeground(Color.white);
		p1.add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==search)
		{
			String susername=usernametext.getText();
//			String sname=nametext.getText();
//			String squestion=questiontext.getText();
					
			try
			{
				Conn c=new Conn();
				String query="select * from account where username= '"+susername+"' ";
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					nametext.setText(rs.getString("name"));
					questiontext.setText(rs.getString("question"));
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else if(ae.getSource()==retrive)
		{
			String susername=usernametext.getText();
			String sanswer=answertext.getText();
			try
			{
				Conn c=new Conn();
				String query="select * from account where answer= '"+sanswer+"' AND username= '"+susername+"' ";
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					passwordtext.setText(rs.getString("password"));
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else
		{
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] args) {
		new ForgetPassword();

	}

}
