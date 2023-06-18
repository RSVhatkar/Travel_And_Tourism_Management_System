import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class CheckPackage extends JFrame{

	JLabel gold,daynight,airport,citytour,daily,drinks,island,english,book,summer,price,background;
	
	CheckPackage()
	{
		setBounds(400,200,900,600);
		
		String package1[]= {"GOLD PACKAGE","6 Days and 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft Drinks Free","Full Day 3 Island Cruise","English Speaking Guide","BOOK PACKAGE","SUMMER SPECIAL","Rs 12000/-","package1.jpg"};
		
		String package2[]= {"SILVER PACKAGE","5 Days and 6 Nights","Toll Free","Entrance Free Tickets","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari","Cruise with Dinner","BOOK NOW","WINTER SPECIAL","Rs 24000/-","package2.jpg"};
		
		String package3[]= {"BRONZE PACKAGE","6 Days and 5 Nights","Return Airfare","Horse Riding","River Rafting","Hard Drinks Free","Daily Buffet","BBQ Dinner","BOOK NOW","WINTER SPECIAL","Rs 32000/-","package3.jpg"};
		
		JTabbedPane tab=new JTabbedPane(); //used to create tab
		
		JPanel p1=createPackage(package1);				
		tab.addTab("Package1",null,p1);//1st arg is text u want 2nd is icon 3rd is panel
		
		JPanel p2=createPackage(package2);
		tab.addTab("Package2",null,p2);
		
		JPanel p3=createPackage(package3);
		tab.addTab("Package3",null,p3);
		
		
		add(tab);
		
		setVisible(true);
	}
	
	public JPanel createPackage(String pack[])
	{
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.white);
		
		gold=new JLabel(pack[0]);
		gold.setBounds(50,5,300,30);
		gold.setForeground(Color.yellow);
		gold.setFont(new Font("Tahoma",Font.BOLD,30));
		p1.add(gold);
		
		daynight=new JLabel(pack[1]);
		daynight.setBounds(30,60,300,30);
		daynight.setForeground(Color.red);
		daynight.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(daynight);
		
		airport=new JLabel(pack[2]);
		airport.setBounds(30,110,300,30);
		airport.setForeground(Color.blue);
		airport.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(airport);
		
		citytour=new JLabel(pack[3]);
		citytour.setBounds(30,160,300,30);
		citytour.setForeground(Color.red);
		citytour.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(citytour);
		
		daily=new JLabel(pack[4]);
		daily.setBounds(30,210,300,30);
		daily.setForeground(Color.blue);
		daily.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(daily);
		
		drinks=new JLabel(pack[5]);
		drinks.setBounds(30,260,300,30);
		drinks.setForeground(Color.red);
		drinks.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(drinks);
		
		island=new JLabel(pack[6]);
		island.setBounds(30,310,300,30);
		island.setForeground(Color.blue);
		island.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(island);
		
		english=new JLabel(pack[7]);
		english.setBounds(30,360,300,30);
		english.setForeground(Color.red);
		english.setFont(new Font("Tahoma",Font.BOLD,20));
		p1.add(english);
		
		book=new JLabel(pack[8]);
		book.setBounds(60,430,300,30);
		book.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(book);
		
		summer=new JLabel(pack[9]);
		summer.setBounds(80,480,300,30);
		summer.setForeground(Color.magenta);
		summer.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(summer);
		
		price=new JLabel(pack[10]);
		price.setBounds(500,480,300,30);
		price.setForeground(Color.cyan);
		price.setFont(new Font("Tahoma",Font.BOLD,25));
		p1.add(price);
		
		ImageIcon img=new ImageIcon("icons/"+pack[11]);
		
		Image i=img.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(350,20,500,300);
		p1.add(background);
		
		return p1;
	}
	
	public static void main(String[] args) {
		new CheckPackage();

	}

}
