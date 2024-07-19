import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Employee1 extends JFrame implements ActionListener 
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField tf1,tf2,tf3,tf4;
	JTextArea ta;
	JButton b1,b2,b3,b4,b5;
	public Employee1()
	{
		setLayout(null);
		lb1=new JLabel("Employee Id");
		lb2=new JLabel("Name:");
		lb3=new JLabel("Address");
		lb4=new JLabel("Contact Number");
		lb5=new JLabel("Aadhar Number");
		lb6=new JLabel("(first name-middle name-last name)");

	    tf1=new JTextField();
	    tf2=new JTextField();
	    ta=new JTextArea();
	    tf3=new JTextField();
	    tf4=new JTextField();

	    b1=new JButton("Insert");
	    b2=new JButton("Update");
	    b3=new JButton("Delete");
	    b4=new JButton("Home");

	    b5=new JButton("show");

	    lb1.setBounds(50,100,150,30);
        lb2.setBounds(50,200,100,30);
        lb3.setBounds(50,300,100,30);
        lb4.setBounds(50,450,150,30);
        lb5.setBounds(50,550,150,30);
        lb6.setBounds(550,200,300,30);

        tf1.setBounds(200,100,100,30);
        tf2.setBounds(200,200,300,30);
        tf3.setBounds(200,450,300,30);
        tf4.setBounds(200,550,300,30);
        ta.setBounds(200,300,300,100);

        b1.setBounds(50,650,100,30);
        b2.setBounds(150,650,100,30);
        b3.setBounds(250,650,100,30);
        b4.setBounds(350,650,100,30);
        b5.setBounds(350,100,100,30);

        add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);
        add(tf1);add(tf2);add(tf3);add(tf4);add(ta);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);


        setBounds(0,0,900,1200);
        setTitle("Employee details");
        setVisible(true);

       
        

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b4)
		{
			new HomeScreen();
			setVisible(false);
		}
		if(ae.getSource()==b1)
		{
			try
			{

				int a=Integer.parseInt(tf1.getText());
				String b="'"+tf2.getText()+"'";
				String c="'"+ta.getText()+"'";
				
				String d="'"+tf3.getText()+"'";
				String e="'"+tf4.getText()+"'";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        	    Statement st=con.createStatement();

        	    st.executeUpdate("insert into employee values("+a+","+b+","+c+","+d+","+e+")");
        	    st.close();
        	    con.close();
        	    JFrame f=new JFrame();
        	    JOptionPane.showMessageDialog(f,"Record inserted Succesfully");

        	

			}
			catch(Exception e)
			{
             System.out.println(e);
			}
		}
		if(ae.getSource()==b2)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			Statement st=con.createStatement();

                int a=Integer.parseInt(tf1.getText());
				String b="'"+tf2.getText()+"'";
				String c="'"+ta.getText()+"'";
				
				String d="'"+tf3.getText()+"'";
				String e="'"+tf4.getText()+"'";
				
			st.executeUpdate("update employee set name="+b+",Address="+c+",contactno="+d+",aadharno="+e+" where Empid="+a+" ");
			con.close();
			st.close();
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Record updated Succesfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
    if(ae.getSource()==b3)
    {
    	try
    	{
    		int a=Integer.parseInt(tf1.getText());
		    Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			Statement st=con.createStatement();

			st.executeUpdate("delete from employee where Empid="+a+"");
			st.close();
			con.close();
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Record deleted Succesfully");




    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    if(ae.getSource()==b5)
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        	    Statement st=con.createStatement();
 	       	    ResultSet rs=st.executeQuery("select * from employee where Empid="+a+"");
 	       	    int flag=0;
        	    while(rs.next())
        	    {
        	    	flag=1;
        	    tf2.setText(rs.getString(2)+"");
        	    ta.setText(rs.getString(3)+"");
        	    tf3.setText(rs.getInt(4)+"");
        	    tf4.setText(rs.getInt(5)+"");
        	    }
        	    if(flag==0)
        	    {
        	    	JFrame f=new JFrame();
        	    	JOptionPane.showMessageDialog(f,"Record not found");
        	    }
        	    rs.close();
        	    st.close();
        	    con.close();
        	     

			}
			catch(Exception e)
			{
				
				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Record not found");

			}
		}
		


}
}

class empDemo
{
	public static void main(String[] cp) 
	{
		Employee1 e=new Employee1();
	}
}