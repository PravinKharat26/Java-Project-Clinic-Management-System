import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class login2 extends JFrame implements ActionListener
{
	JLabel lb1,lb2;
	JTextField tf1;
	JPasswordField tf2;																								
	JButton b1,b2;

	public login2()
	{
		setLayout(null);
		lb1=new JLabel("Username:");
		lb2=new JLabel("Password:");
		tf1=new JTextField();
		tf2=new JPasswordField();
		b1=new JButton("Login");
		b2=new JButton("Cancel");

		lb1.setBounds(50,100,100,30);
		tf1.setBounds(150,100,100,30);
		lb2.setBounds(50,200,100,30);
		tf2.setBounds(150,200,100,30);
		b1.setBounds(50,300,100,30);
		b2.setBounds(200,300,100,30);

		add(lb1);add(lb2);add(tf1);add(tf2);add(b1);add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);

		setBounds(0,0,900,1200);
		setTitle("login screen");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
      if(ae.getSource()==b1)
      {
        String a=tf1.getText();
        String b=tf2.getText();


        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        	Statement st=con.createStatement();
        	ResultSet rs=st.executeQuery("select * from login2");
             int flag=0;

             while(rs.next())
             {
               String x=rs.getString(1);
               String y=rs.getString(2);

               if(x.equals(a) && y.equals(b))
               {
               	flag=1;
               	break;
               }


             }
             JFrame f=new JFrame();
             if(flag==1)
             {
             	JOptionPane.showMessageDialog(f,"Login Successful");
                new HomeScreen();
                setVisible(false);
             }
             else
             {
             	JOptionPane.showMessageDialog
             	(f,"Login failed");
             }

        }
        catch(Exception e)
        {}
      }
      if(ae.getSource()==b2)
      	System.exit(0);
	}
    
}
class userlogin2
{
	public static void main(String[] cp) 
	{
		login2 lg=new login2();
	}
}