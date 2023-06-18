import javax.swing.*;
import java.awt.event.*;
public class Paytm extends JFrame implements ActionListener{

	JEditorPane pane; //it is similar to textarea
	JScrollPane sp; //to add scrollbar
	JButton back;
	
	Paytm()
	{
		setBounds(500,200,800,600);
		
		pane=new JEditorPane();
		pane.setEditable(false);
		
		//to add paytm link
		try
		{
			pane.setPage("https://paytm.com/rent-payment"); //to load the paytm page
		}
		catch(Exception e)
		{
			pane.setContentType("text/html"); 
			pane.setText("<html> Could not load, Error 404 </html>");
		}
		
		sp=new JScrollPane(pane);
		getContentPane().add(sp); //adds scroll bar
		
		back=new JButton("Back");
		back.setBounds(610,20,80,40);
		pane.add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Payment();
	}
	
	public static void main(String[] args) {
		new Paytm();

	}

}
