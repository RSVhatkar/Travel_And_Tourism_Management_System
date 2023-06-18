import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class Signup extends JFrame implements ActionListener{

	JPanel p1;
	JLabel username,name,password,securityquestions,answer,background;
	JTextField usernametext,nametext,answertext;
	JPasswordField passwordtext;
	Choice securityquestionschoice;
	JButton create,back;
	
	Signup()
	{
		setLayout(null);
		setBounds(350,200,900,360);
		
		getContentPane().setBackground(Color.white);
		
		p1=new JPanel();
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		p1.setBackground(new Color(133,193,233));
		add(p1);
		
		username=new JLabel("Username");
		username.setBounds(50,20,125,25);
		username.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(username);
		
		usernametext=new JTextField();
		usernametext.setBounds(190,20,180,25);
		usernametext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(usernametext);
		
		name=new JLabel("Name");
		name.setBounds(50,60,125,25);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(name);
		
		nametext=new JTextField();
		nametext.setBounds(190,60,180,25);
		nametext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(nametext);
		
		password=new JLabel("Password");
		password.setBounds(50,100,125,25);
		password.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(password);
		
		passwordtext=new JPasswordField();
		passwordtext.setBounds(190,100,180,25);
		passwordtext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(passwordtext);
		
		securityquestions=new JLabel("Security Questions");
		securityquestions.setBounds(50,140,125,25);
		securityquestions.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(securityquestions);
		
		securityquestionschoice=new Choice();
		securityquestionschoice.setBounds(190,140,180,25);
		securityquestionschoice.add("Fav character from the Boyz");
		securityquestionschoice.add("Fav Marvel superhero");
		securityquestionschoice.add("Your lucky number");
		securityquestionschoice.add("Your childhood superhero");
		p1.add(securityquestionschoice);
		
		answer=new JLabel("Answer");
		answer.setBounds(50,180,180,25);
		answer.setFont(new Font("Tahoma",Font.PLAIN,14));
		p1.add(answer);
		
		answertext=new JTextField();
		answertext.setBounds(190,180,180,25);
		answertext.setBorder(BorderFactory.createEmptyBorder());
		p1.add(answertext);
		
		create=new JButton("Create");
		create.setBounds(80,250,100,30);
		create.setFont(new Font("Tahoma",Font.PLAIN,14));
		create.setBackground(Color.white);
		create.setForeground(new Color(133,193,233));
		p1.add(create);
		create.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(250,250,100,30);
		back.setBackground(Color.white);
		back.setForeground(new Color(133,193,233));
		p1.add(back);
		back.addActionListener(this);
		
		ImageIcon img=new ImageIcon("icons/signup.png");
		
		Image i=img.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(580,50,250,250);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==create)
		{
			String susername=usernametext.getText();
			String sname=nametext.getText();
			String spassword=passwordtext.getText();
			String squestion=securityquestionschoice.getSelectedItem();
			String sanswer=answertext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="insert into account values('"+susername+"','"+sname+"','"+spassword+"','"+squestion+"','"+sanswer+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Account created successfully");
				
				setVisible(false);
				new Login();
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
		new Signup();

	}

}
