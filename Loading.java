import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class Loading extends JFrame implements Runnable{

	Thread thread;
	JLabel text,loading,username;
	JProgressBar progress;
	String susername;
	
	public void run()
	{
		try
		{
			for(int i=1;i<=101;i++)
			{
				int max=progress.getMaximum();//max value is 100
				int currentvalue=progress.getValue();//gets current value
				
				if(currentvalue < max) //101 < 100
				{
					progress.setValue(progress.getValue()+1);
				}
				else
				{
					setVisible(false);
					new Dashboard(susername);
				}
				Thread.sleep(50);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	Loading(String susername)
	{
		this.susername=susername;
		
		thread=new Thread(this);
		
		setLayout(null);
		setBounds(500,200,650,400);
		getContentPane().setBackground(Color.white);
		
		text=new JLabel("Travel and Tourism Application");
		text.setBounds(50,20,600,40);
		text.setFont(new Font("Raleway",Font.PLAIN,35));
		text.setForeground(Color.blue);
		add(text);
		
		progress=new JProgressBar();
		progress.setBounds(150,100,300,35);
		progress.setStringPainted(true);//will disp 0% and that text
		add(progress);
		
		loading=new JLabel("Loading, please wait...");
		loading.setBounds(230,130,200,30);
		loading.setFont(new Font("Raleway",Font.BOLD,16));
		loading.setForeground(Color.red);
		add(loading);
		
		username=new JLabel("Welcome "+susername);
		username.setBounds(20,310,400,40);
		username.setFont(new Font("Raleway",Font.BOLD,16));
		username.setForeground(Color.red);
		add(username);
		
		thread.start(); //calls run()
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Loading("");

	}

}
