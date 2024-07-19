   import javax.swing.*;
   import java.awt.event.*;
   import java.util.*;
   import java.sql.*;
   import java.awt.*;
   import javax.swing.table.*;

   class empidreport extends JFrame implements ActionListener
{
	JLabel l0,l1,l2;
	JButton b1,btnBack;
	JComboBox c1;
	Connection con;
	Statement st;
	ResultSet rs,rs1;
	String ids;
	static JTable table;
                   //String sub="";
	String[] columnnames={"Employee id","Employee name","Working days","Salary per day"," amount","Date"};
	String from;
	JFrame frame1;
	public empidreport()
	{
		l0=new JLabel("Fetching Employee Salary Information");
		l0.setForeground(Color.RED);
		l0.setFont(new Font("Serif",Font.BOLD,20));
		l1=new JLabel("Employee id");
		b1=new JButton("Submit");
		btnBack=new JButton("Home");
		l0.setBounds(100,50,350,40);
           		l1.setBounds(75,110,150,30);
	   	b1.setBounds(150,350,150,20);
		btnBack.setBounds(50,350,80,20);
	   	b1.addActionListener(this);
		btnBack.addActionListener(this);
	     	setTitle("Employee Salary Report ");
		setLayout(null);
	   	setVisible(true);
	   	setSize(500,500);
	   	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           		add(l0);
	   	add(l1);
	   	add(b1);
		add(btnBack);
           		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                                  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                                  
			st=con.createStatement();

			rs=st.executeQuery("select distinct(empid) from empsalary");
                                      		if(rs==null)
                                     		System.out.println("null");
                                  
			Vector v=new Vector();
                                  
			while(rs.next()){
                                  
                                  	     	ids=rs.getString("empid");
                                                       //sub=rs.getString("subjectname");
			 v.add(ids);	
                              

		}
	                	c1 =new JComboBox(v);
		c1.setBounds(225,110,150,50);
		add(c1);
		st.close();
		rs.close();

               }catch(Exception e){}  
		}
		public void actionPerformed(ActionEvent ae)
		{
                                                   if(ae.getSource()==b1)
			showTableData();
			if(ae.getSource()==btnBack)
			{
				new HomeScreen();
				setVisible(false);
				
				//btnUpdate.setEnabled(false);
			}

		 }
		public void showTableData()
		{
		  frame1=new JFrame("Employee Salary Result from Database Search");
		  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 		 frame1.setLayout(new BorderLayout());
		  DefaultTableModel model=new  DefaultTableModel();
		  model.setColumnIdentifiers(columnnames);
		  table = new JTable();
		  table.setModel(model);
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  //table.setFillsViewportHeight(true);
                                       //  table.getScrollableTracksViewportHeight();
		  JScrollPane scroll = new JScrollPane(table);
		  scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                  from = (String)c1.getSelectedItem();
		//int cid,bill;
		//String cname,bdate;
		  try
		  {
		   PreparedStatement pst=con.prepareStatement("select * from empsalary where empid='"+from+"' " );
	           rs=pst.executeQuery();

		   int i=0;
		// String fn,pe,lv,pk,fs,pc,ib;
		 int eid,workday,salperday,amt;
		 String empname,date;
                                      //fn=from;
		   while(rs.next())
		   {
		   		eid=rs.getInt(1);
		   		empname=rs.getString(2);
		   		workday=rs.getInt(3);
		   		salperday=rs.getInt(4);
		   		amt=rs.getInt(5);
		   		date=rs.getString(6);

		   		 model.addRow(new Object[]{eid,empname,workday,salperday,amt,date});		
		      i++;			      

                      }	 
                     if(i<1)
		      JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);

                      }catch(Exception e){
                    		      JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                             }
                       frame1.add(scroll);
		       frame1.setVisible(true);
		       frame1.setSize(400,300); 	


			}
  }
class empsalaryrep
{
  public static void main(String cp[])
  {
      new empidreport();
    }
}
