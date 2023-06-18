import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.*;
import javax.swing.*;
public class About extends JFrame implements ActionListener{

	JLabel about;
	TextArea area;
	String s;
	JButton back;
	
	About()
	{
		setBounds(600,200,500,550);
		setLayout(null);
		getContentPane().setBackground(Color.white);
			
		about=new JLabel("ABOUT");
		about.setBounds(200,10,100,40);
		about.setFont(new Font("Tahoma",Font.PLAIN,20));
		about.setForeground(Color.red);
		add(about);
		
		s="                                         About Projects          \n "
				+ "\nThe objective of the Travel and Tourism Management System "
				+ "\n project is to develop a system that automates the processes"
				+ " \n and activities of a travel and the purpose is to design a "
				+ "\n system using which one can perform all operations related to "
				+ "\n traveling.\n This application will help in accessing the information related "
				+ "\n to the travel to the particular destination with great ease. "
				+ "\n The users can track the information related to their tours with"
				+ " \n great ease through this application. The travel agency information "
				+ "\n can also be obtained through this application."
				+ "\n Advantages of Project: "
				+ "\n Gives accurate information "
				+ "\n Simplifies the manual work "
				+ "\n It minimizes the documentation related work "
				+ "\n Provides up to date information"
				+ " \n Friendly Environment by providing warning messages."
				+ " \n travelers details can be provided"
				+ " \n booking confirmation notification";
		
		area=new TextArea(s,10,40,Scrollbar.VERTICAL);  //parameter 10 rows 40 col
		area.setBounds(20,100,450,300);
		area.setEditable(false);
		add(area);
		
		back=new JButton("Back");
		back.setBounds(200,420,100,25);
		add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}
	
	public static void main(String[] args) {
		new About();

	}

}
