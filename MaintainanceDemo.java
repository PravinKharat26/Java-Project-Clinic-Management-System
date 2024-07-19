import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import java.util.*;


class Maintainance extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
    JTextField tf1,tf2,tf3,tf4;
    JTextArea ta;
    JButton b1,b2,b3,b4,b5;

    public Maintainance()

    {
    	setLayout(null);
    	lb1=new JLabel("Maintenance Number");
    	lb2=new JLabel("Date");
    	lb3=new JLabel("Description");
    	lb4=new JLabel("Person Responsible");
    	lb5=new JLabel("Amount");
    	lb6=new JLabel("(DD-MM-YYYY)");

    	tf1=new JTextField();
    	tf2=new JTextField();
    	tf3=new JTextField();
    	tf4=new JTextField();
    	ta=new JTextArea();

    	b1=new JButton("Insert");
        b2=new JButton("Update");
            	
        b3=new JButton("Delete");
            	
        b4=new JButton("Home");

        b5=new JButton("Show");

        lb1.setBounds(50,100,150,30);
        lb2.setBounds(50,200,100,30);
        lb3.setBounds(50,300,100,30);
        lb4.setBounds(50,400,150,30);
        lb5.setBounds(50,500,100,30);
        lb6.setBounds(300,200,100,30);

        tf1.setBounds(200,100,100,30);
        tf2.setBounds(200,200,100,30);
        tf3.setBounds(200,400,100,30);
        tf4.setBounds(200,500,100,30);
        ta.setBounds(200,300,300,80);

        b1.setBounds(50,600,100,30);
        b2.setBounds(150,600,100,30);
        b3.setBounds(250,600,100,30);
        b4.setBounds(350,600,100,30);
        b5.setBounds(300,100,100,30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        

        //java.util.Date d=new java.util.Date();
        //tf2.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
       //  tf2.setEnabled(false);


        add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);

        add(tf1);add(tf2);add(tf3);add(tf4);add(ta);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);


        setBounds(0,0,900,1200);
        setTitle("Maintenance");
        setVisible(true);

        
        
   
    }
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==b5)
        {
            try
            {
             
             int a=Integer.parseInt(tf1.getText());
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from maintainance where maintainanceno="+a+"");
                int flag=0;
                while(rs.next())
                {
                    flag=1;
                tf2.setText(rs.getString(2)+"");
                ta.setText(rs.getString(3)+"");
                tf3.setText(rs.getString(4)+"");
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
                System.out.println(e);
            }
        }

        if(ae.getSource()==b1)
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
                int e=Integer.parseInt(tf4.getText());

                st.executeUpdate("insert into maintainance values("+a+","+b+","+c+","+d+","+e+")");
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
                int e=Integer.parseInt(tf4.getText());

                
            st.executeUpdate("update maintainance set date="+b+",description="+c+",personresponsible="+d+",amount="+e+" where maintainanceno="+a+" ");
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

            st.executeUpdate("delete from maintainance where maintainanceno="+a+"");
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
     
    }	
}
class MainDemo
{
	public static void main(String[] cp) 
	{
		Maintainance m=new Maintainance();
	}
}