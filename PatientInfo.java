import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class Patient extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb11,lb12,lb13;
    JTextField tf1,tf2,tf4,tf5,tf6,tf7,tf8;
    JTextArea ta;
    JButton b1,b2,b3,b4,b5;//b6;
    JRadioButton r1,r2;
    String output="";

    
    public Patient()
    {
    	setLayout(null);
    	lb1=new JLabel("Patient id");
    	lb2=new JLabel("Patient name");

    	lb3=new JLabel("Address");
    	lb4=new JLabel("Contact no.");
    	lb5=new JLabel("Date");
    	lb6=new JLabel("Time");
    	lb7=new JLabel("Age");
    	lb8=new JLabel("Gender");

    	lb9=new JLabel("(DD-MM-YYYY)");
    	lb11=new JLabel("(Fn-Mn-Ln)");
        lb12=new JLabel("Weight");

    	


    	tf1=new JTextField();
    	tf2=new JTextField();
    	ta=new JTextArea();
    	tf4=new JTextField();
    	
    	tf5=new JTextField();
    	tf6=new JTextField();
    	tf7=new JTextField();
    	tf8=new JTextField();
        lb13=new JLabel("in kg");


        java.util.Date d=new java.util.Date();
        tf5.setText(d.getDate()+"-"+(d.getMonth()+1)+"-"+"20"+(d.getYear()-100));
        tf5.setEnabled(false);

        


    	b1=new JButton("Insert");
        b2=new JButton("Update");
            	
        b3=new JButton("Delete");
            	
        b4=new JButton("Home");

        b5=new JButton("Show");
       // b6=new JButton("ok");
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        lb1.setBounds(50,100,100,30);
        lb2.setBounds(50,200,100,30);
        lb3.setBounds(50,300,100,30);
        lb4.setBounds(50,400,100,30);
        lb5.setBounds(50,500,100,30);
        lb6.setBounds(50,600,100,30);
        lb7.setBounds(50,700,100,30);
        lb8.setBounds(50,800,100,30);
        lb12.setBounds(50,900,100,30);
        lb9.setBounds(550,500,100,30);
        lb11.setBounds(550,200,100,30);
        lb13.setBounds(550,900,100,30);

        tf1.setBounds(200,100,200,30);
        tf2.setBounds(200,200,300,30);
        ta.setBounds(200,300,300,80);
        tf4.setBounds(200,400,300,30);
        tf5.setBounds(200,500,300,30);
        tf6.setBounds(200,600,300,30);
        tf7.setBounds(200,700,300,30);
        tf8.setBounds(200,900,300,30);
        r1.setBounds(150,800,100,30);
        r2.setBounds(250,800,100,30);
       
        b1.setBounds(50,950,100,30);
        b2.setBounds(150,950,100,30);
        b3.setBounds(250,950,100,30);
        b4.setBounds(350,950,100,30);
        b5.setBounds(450,100,100,30);
       // b6.setBounds(450,800,100,30);
        

        add(lb1);add(lb2);add(lb3);add(lb4);add(lb5);add(lb6);add(lb7);add(lb8);add(lb9);add(lb11);add(tf8);add(lb12);add(lb13);

        add(tf1);add(tf2);add(tf4);add(ta);add(tf5);add(tf6);add(tf7);

        add(b1);add(b2);add(b3);add(b4);add(b5);add(r1);add(r2);//add(b6);
        b1.addActionListener(this);
        b5.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setBounds(0,0,900,1200);
        setVisible(true);
        setTitle("Patient Description");
       // b1.addActionListener(this);	
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
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                Statement st=con.createStatement();

                int a=Integer.parseInt(tf1.getText());
                String b="'"+tf2.getText()+"'";
                String c="'"+ta.getText()+"'";
                
                String d="'"+tf4.getText()+"'";
                String e="'"+tf5.getText()+"'";
                String f1="'"+tf6.getText()+"'";

                int g=Integer.parseInt(tf7.getText());

                String h="";
                if(r1.isSelected())
                {
                	h="Male";
                }
                if(r2.isSelected())
                {
                	h="Female";
                }
                h="'"+h+"'";
                String i="'"+tf8.getText()+"'";
                String q="insert into patientinfo values("+a+","+b+","+c+","+d+","+e+","+f1+","+g+","+h+","+i+")";
                System.out.println(q);
                st.executeUpdate(q);
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
                
                String d="'"+tf4.getText()+"'";
                String e="'"+tf5.getText()+"'";
                String f1="'"+tf6.getText()+"'";
                int g=Integer.parseInt(tf7.getText());
                String h="";
                if(r1.isSelected())
                {
                	h="Male";
                }
                if(r2.isSelected())
                {
                	h="Female";
                }
                h="'"+h+"'";
                String i="'"+tf8.getText()+"'";
                    
            String q="update patientinfo set pname="+b+",address="+c+",contact="+d+",date="+e+",time="+f1+",age="+g+",gender="+h+",weight="+i+" where pid="+a+"";
            System.out.println(q);
            st.executeUpdate(q);
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




         	 if(ae.getSource()==b5)
        
		{
			try
			{
				int a=Integer.parseInt(tf1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
        	    Statement st=con.createStatement();
 	       	    ResultSet rs=st.executeQuery("select * from patientinfo where pid="+a+"");
 	       	    int flag=0;
        	    while(rs.next())
        	    {
        	    	flag=1;
        	    tf2.setText(rs.getString(2)+"");
        	    ta.setText(rs.getString(3)+"");
        	    tf4.setText(rs.getString(4)+"");
        	    tf5.setText(rs.getString(5)+"");
        	    tf6.setText(rs.getString(6)+"");
        	    tf7.setText(rs.getInt(7)+"");
                tf8.setText(rs.getString(9)+"");
        	    String p=rs.getString(8);
        	    String res="";
        	    if(p.equalsIgnoreCase("Male"))
        	    {
        	    	r1.setSelected(true);
        	    }
        	    if(p.equalsIgnoreCase("Female"))
        	    {
        	    	r2.setSelected(true);
        	    }

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
		
     if(ae.getSource()==b3)
     {
         try
        {
            int a=Integer.parseInt(tf1.getText());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            Statement st=con.createStatement();

            st.executeUpdate("delete from patientinfo where pid="+a+"");
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
    	
    }

}

class patientDemo
{
	public static void main(String[] cp) 
	{
		Patient p=new Patient();
	}
}