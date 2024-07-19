   import javax.swing.*;
   import java.awt.event.*;
   import java.util.*;
   import java.sql.*;
   import java.awt.*;
   import javax.swing.table.*;

   class pidreport extends JFrame implements ActionListener
{
	JLabel l0,l1,l2;
	JButton b1,btnBack;
	JComboBox c1;
	Connection con;
	Statement st;
	ResultSet rs,rs1;
	String ids;
	static JTable table;
                   String sub="";
	String[] columnnames={"patient id","Patient name","Address","contact","date","time","Age","Gender","weight in kg"};
	String from;
	JFrame frame1;
	public pidreport()
	{
		l0=new JLabel("Fetching Patient Information");
		l0.setForeground(Color.RED);
		l0.setFont(new Font("Serif",Font.BOLD,20));
		l1=new JLabel("Patient id");
		b1=new JButton("Submit");
		btnBack=new JButton("Home");
		l0.setBounds(100,50,350,40);
           		l1.setBounds(75,110,150,30);
	   	b1.setBounds(150,350,150,20);
		btnBack.setBounds(50,350,80,20);
	   	b1.addActionListener(this);
		btnBack.addActionListener(this);
	     	setTitle("Patient Report ");
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

			rs=st.executeQuery("select distinct(pid) from patientinfo");
                                      		if(rs==null)
                                     		System.out.println("null");
                                  
			Vector v=new Vector();
                                  
			while(rs.next()){
                                  
                                  	     	ids=rs.getString("pid");
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
		  frame1=new JFrame("Patient Result from Database Search");
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
		   PreparedStatement pst=con.prepareStatement("select * from patientinfo where pid='"+from+"' " );
	           rs=pst.executeQuery();

		   int i=0;
		 String pname,add,con,date,time,gender,weight;
		 int pid,age;
		 
                                     // pid=from;
		   while(rs.next())
		   {
		   		pid=rs.getInt(1);
		   		pname=rs.getString(2);
		   		add=rs.getString(3);
		   		con=rs.getString(4);
		   		date=rs.getString(5);
		   		time=rs.getString(6);
		   		age=rs.getInt(7);
		   		gender=rs.getString(8);
		   		weight=rs.getString(9);

		      model.addRow(new Object[]{pid,pname,add,con,date,time,age,gender,weight});		
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
class pidwiswRep
{
  public static void main(String cp[])
  {
      new pidreport();
    }
}
