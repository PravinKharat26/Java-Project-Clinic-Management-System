import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Salary extends JFrame implements ActionListener

{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JButton b1,b2,b3,b4,b5,b6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;

  public Salary()
  {
  	setLayout(null);
   lb1=new JLabel("Employee ID");
   lb2=new JLabel("Employee name");
   lb3=new JLabel("Working days");
   lb4=new JLabel("Salary per day");
   lb5=new JLabel("Amount");
   lb6=new JLabel("Date");
   lb7=new JLabel("(DD/MM/YYYY)");

   tf1=new JTextField();
   tf2=new JTextField();
   tf3=new JTextField();
   tf4=new JTextField();
   tf5=new JTextField();
   tf6=new JTextField();

   b1=new JButton("Insert");
   b2=new JButton("Update");
   b3=new JButton("Delete");
   b4=new JButton("Home");
   b5=new JButton("Compute");
   b6=new JButton("Show");

   lb1.setBounds(50,100,100,30);
   lb2.setBounds(50,200,100,30);
   lb3.setBounds(50,300,100,30);
   lb4.setBounds(50,400,100,30);
   lb5.setBounds(50,500,100,30);
   lb6.setBounds(50,600,100,30);
   lb7.setBounds(290,600,100,30);

   tf1.setBounds(150,100,100,30);
   tf2.setBounds(150,200,300,30);
   tf3.setBounds(150,300,100,30);
   tf4.setBounds(150,400,100,30);
   tf5.setBounds(150,500,100,30);
   tf6.setBounds(150,600,100,30);


   b1.setBounds(50,700,100,30);
   b2.setBounds(150,700,100,30);
   b3.setBounds(250,700,100,30);
   b4.setBounds(350,700,100,30);

   b5.setBounds(300,400,100,30);
   b6.setBounds(300,100,100,30);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
   b6.addActionListener(this);


   add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);add(lb7);
   add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);add(tf6);

   add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);

   setVisible(true);
   setBounds(0,0,900,1200);
   setTitle("Salary");




  }
  public void actionPerformed(ActionEvent ae)
  {
  	 if(ae.getSource()==b6)
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        	    Statement st=con.createStatement();
 	       	    ResultSet rs=st.executeQuery("select * from empsalary where empid="+a+"");
 	       	    int flag=0;
        	    while(rs.next())
        	    {
        	    	flag=1;
        	    tf2.setText(rs.getString(2)+"");
        	    tf3.setText(rs.getString(3)+"");
        	    tf4.setText(rs.getInt(4)+"");
        	    tf5.setText(rs.getInt(5)+"");
        	    tf6.setText(rs.getString(6)+"");

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
		

  	if(ae.getSource()==b1)
  	{
  		try
  		{

                int a=Integer.parseInt(tf1.getText());
				String b="'"+tf2.getText()+"'";
				int c=Integer.parseInt(tf3.getText());
				
				int d=Integer.parseInt(tf4.getText());
				int e=Integer.parseInt(tf5.getText());
				String f1="'"+tf6.getText()+"'";
  			Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            Statement st=con.createStatement();
            st.executeUpdate("insert into empsalary values ("+a+","+b+","+c+","+d+","+e+","+f1+")");
				


				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Record inserted successfully");


			st.close();
			con.close();



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
           int a=Integer.parseInt(tf1.getText());
				String b="'"+tf2.getText()+"'";
				int c=Integer.parseInt(tf3.getText());
				
				int d=Integer.parseInt(tf4.getText());
				int e=Integer.parseInt(tf5.getText());
				String f1="'"+tf6.getText()+"'";
  			Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            Statement st=con.createStatement();
            st.executeUpdate("update empsalary set empname="+b+",workingdays="+c+",salaryperday="+d+",Amount="+e+",date="+f1+" where empid="+a+"" );
				


				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Record Updated successfully");


			st.close();
			con.close();


 
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

            st.executeUpdate("delete from empsalary where empid="+a+"");
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

   if(ae.getSource()==b4)
   {
   	new HomeScreen();
   	setVisible(false);
   }


  	
    if(ae.getSource()==b5)
    {
      	/*Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        Statement st=con.createStatement();*/

    	int a=Integer.parseInt(tf3.getText());
    	int b=Integer.parseInt(tf4.getText());

    	int c=b*a;

    	tf5.setText(c+"");

    	//st.close();
    	//con.close();
    }
   }

    
}




class EmpSalary

{
	public static void main(String[] cp) 
	{
		Salary s=new Salary();
	}
}