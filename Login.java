import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener{

	JLabel background,username,password,text;
	JTextField usernametext;
	JPasswordField passwordtext;
	JButton login,signup,forgetpassword;
	
	Login()
	{
		setVisible(true);
		setSize(900,400);
		setLocation(350,200);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		JPanel p1=new JPanel();
		p1.setBackground(new Color(131,193,233));
		p1.setBounds(0,0,400,400);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon img=new ImageIcon("icons/login.png");
		
		Image i=img.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(100,120,200,200);
		p1.add(background);
		
		JPanel p2=new JPanel();
		p2.setBounds(400,30,450,300);
		p2.setLayout(null);
		add(p2);
		
		username=new JLabel("Username");
		username.setBounds(60,20,100,25);
		username.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(username);
		
		usernametext=new JTextField();
		usernametext.setBounds(60,60,300,30);
		usernametext.setBorder(BorderFactory.createEmptyBorder());//to remove boreder of textfield
		p2.add(usernametext);
		
		password=new JLabel("Password");
		password.setBounds(60,110,100,25);
		password.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(password);
		
		passwordtext=new JPasswordField();
		passwordtext.setBounds(60,150,300,30);
		passwordtext.setBorder(BorderFactory.createEmptyBorder());//to remove border of textfield
		p2.add(passwordtext);
		
		login=new JButton("Login");
		login.setBounds(60,200,130,30);
		login.setBackground(new Color(133,193,233));
		login.setForeground(Color.white);
		login.setBorder(new LineBorder(new Color(133,193,233)));
		p2.add(login);
		login.addActionListener(this);
		
		signup=new JButton("Signup");
		signup.setBounds(230,200,130,30);
		signup.setBackground(new Color(133,193,233));
		signup.setForeground(Color.white);
		signup.setBorder(new LineBorder(new Color(133,193,233)));
		p2.add(signup);
		signup.addActionListener(this);
		
		forgetpassword=new JButton("Forget Password");
		forgetpassword.setBounds(130,250,130,30);
		forgetpassword.setBackground(new Color(133,193,233));
		forgetpassword.setForeground(Color.white);
		forgetpassword.setBorder(new LineBorder(new Color(133,193,233)));
		p2.add(forgetpassword);
		forgetpassword.addActionListener(this);
		
		text=new JLabel("Trouble in login...");
		text.setBounds(300,250,150,20);
		text.setForeground(Color.red);
		p2.add(text);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==login)
		{
			String susername=usernametext.getText();
			String spassword=passwordtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="select * from account where username= '"+susername+"' and password= '"+spassword+"' ";
				ResultSet rs=c.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Loading(susername);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect username or password");
					usernametext.setText("");
					passwordtext.setText("");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==signup)
		{
			setVisible(false);
			new Signup();
		}
		else if(ae.getSource()==forgetpassword)
		{
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
		new Login();

	}

}
