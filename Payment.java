import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Payment extends JFrame implements ActionListener{

	JLabel background;
	JButton pay,back;
	
	Payment()
	{
		setBounds(500,200,800,600);
		setLayout(null);
		
		ImageIcon img=new ImageIcon("icons/paytm.jpeg");
		Image i=img.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(0,0,800,600);
		add(background);
		
		pay=new JButton("Pay");
		pay.setBounds(420,0,80,40);
		background.add(pay);
		pay.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(520,0,80,40);
		background.add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==pay)
		{
			setVisible(false);
			new Paytm();
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Payment();

	}

}
