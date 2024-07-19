import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class Prescription extends JFrame  implements ActionListener
{

 JLabel lb1,lb2,lb3,lb4,lb5,lb6;
 JTextField tf1,tf2,tf3,tf4,tf5;
 JTextArea ta;
 JButton b1,b2,b3,b4,b5;

 public Prescription()
 {
    setLayout(null);
    lb1=new JLabel("Prescription Number");
    lb2=new JLabel("Patient name");
    lb3=new JLabel("Patient id");
    lb4=new JLabel("Date");
    lb5=new JLabel("Prescribed Medication");
    lb6=new JLabel("Fees");

    tf1=new JTextField();
    tf2=new JTextField();
    tf3=new JTextField();
    tf4=new JTextField();
    ta=new JTextArea();
    tf5=new JTextField();

    b1=new JButton("Insert");
    b2=new JButton("Update");
    b3=new JButton("Delete");
    b4=new JButton("Home");
    b5=new JButton("Show");


   lb1.setBounds(50,100,200,30);
   lb2.setBounds(50,200,100,30);
   lb3.setBounds(50,300,100,30);
   lb4.setBounds(50,400,100,30);
   lb5.setBounds(50,500,200,30);
   lb6.setBounds(50,850,100,30);


   tf1.setBounds(200,100,100,30);
   tf2.setBounds(200,200,300,30);
   tf3.setBounds(200,300,100,30);
   tf4.setBounds(200,400,100,30);

   ta.setBounds(200,500,300,300);
   tf5.setBounds(200,850,100,30);

   b1.setBounds(50,950,100,30);
   b2.setBounds(150,950,100,30);
   b3.setBounds(250,950,100,30);
   b4.setBounds(350,950,100,30);


   b5.setBounds(350,100,100,30);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);

    java.util.Date d=new java.util.Date();
    tf4.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
    tf4.setEnabled(false);



    add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);

    add(b1);add(b2);add(b3);add(b4);add(b5);
    add(tf1);add(tf2);add(tf4);add(ta);add(tf3);add(tf5);

    setTitle("Patient's Prescription");
    setBounds(0,0,900,1200);
    setVisible(true);
    

 


 }
 public void actionPerformed(ActionEvent ae)
 {
 	 if(ae.getSource()==b1)
        
        {
            try
            {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                Statement st=con.createStatement();

                int a=Integer.parseInt(tf1.getText());
                String b="'"+tf2.getText()+"'";
                int c=Integer.parseInt(tf3.getText());
                
                String d="'"+tf4.getText()+"'";
                String e="'"+ta.getText()+"'";
                String f1="'"+tf5.getText()+"'";


                st.executeUpdate("insert into prescription values("+a+","+b+","+c+","+d+","+e+","+f1+")");
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
                int c=Integer.parseInt(tf3.getText());
                
                String d="'"+tf4.getText()+"'";
                String e="'"+ta.getText()+"'";
                String f1="'"+tf5.getText()+"'";
                 
                st.executeUpdate("update prescription set  patientname="+b+",patientid="+c+",date="+d+",prescmedicine="+e+",fees="+f1+" where prescid="+a+"");
                st.close();
                con.close();

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
     		
     		Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                Statement st=con.createStatement();

                int a=Integer.parseInt(tf1.getText());

                st.executeUpdate("delete from prescription where prescid="+a+"");

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
     	try
     	{
          Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                Statement st=con.createStatement();

                int a=Integer.parseInt(tf1.getText());

               ResultSet rs=st.executeQuery("select * from prescription where prescid="+a+"");
               int flag=0;
        	    while(rs.next())
        	    {
        	    	flag=1;
        	    tf2.setText(rs.getString(2)+"");
        	    tf3.setText(rs.getInt(3)+"");
        	    tf4.setText(rs.getString(4)+"");
        	    ta.setText(rs.getString(5)+"");
        	    tf5.setText(rs.getString(6)+"");
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
     		System.out.println(e);
     	}
     }
        
 }


 


}

class prescDemo
{
	public static void main(String[] cp) 
	{
	  Prescription ps=new Prescription();	
	}
}