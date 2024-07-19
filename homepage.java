import javax.swing.*;
import java.awt.event.*;
 

class HomeScreen extends JFrame implements ActionListener
{
	JMenuBar mb;
	JMenu mnu1,mnu2,mnu3,mnu4;
	JMenuItem mi6,mi1,mi2,mi3,mi4,mi5,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15;
	JLabel background;
    ImageIcon img;
	public HomeScreen()
	{
		mb=new JMenuBar();
		mnu1=new JMenu("Patient");
		mnu2=new JMenu("Miscellaneous");
		mnu3=new JMenu("Reports");
		mnu4=new JMenu("Employee");
        
        img=new ImageIcon("clinic.jpg");
        background=new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,700);
        add(background);

		mi1=new JMenuItem("Patient description");
		mi2=new JMenuItem("Patient Prescription");
		mi3=new JMenuItem("Maintenance");
		mi4=new JMenuItem("Employee details");
		mi5=new JMenuItem("Salary");
		mi6=new JMenuItem("Maintenance Wise Person Responsible");
		mi7=new JMenuItem("Date wise Maintenance");
		mi8=new JMenuItem("Name wise Patient info");
		mi9=new JMenuItem("Date wise patient info");
		mi10=new JMenuItem("Name wise Employee info");
		mi11=new JMenuItem("ID wise Employee info");
		mi12=new JMenuItem("Prescription Number wise report");
		mi13=new JMenuItem("Prescription name wise report");
		mi14=new JMenuItem("ID wise employee salary");
		mi15=new JMenuItem("ID wise Patient info");

		
		mb.add(mnu1);
		mb.add(mnu2);
		mb.add(mnu4);
		mb.add(mnu3);
		mnu1.add(mi1);
		mnu1.add(mi2);
		mnu2.add(mi3);
		mnu4.add(mi4);
		mnu4.add(mi5);
		mnu3.add(mi6);
		mnu3.add(mi7);
		mnu3.add(mi8);
		mnu3.add(mi9);
		mnu3.add(mi10);
		mnu3.add(mi11);
		mnu3.add(mi12);
		mnu3.add(mi13);
		mnu3.add(mi14);
		mnu3.add(mi15);

		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		mi14.addActionListener(this);
		mi15.addActionListener(this);
        


		setJMenuBar(mb);
		setTitle("Homepage");
		setVisible(true);
		setBounds(0,0,900,1200);

	}
	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource()==mi15)
		{
			new pidreport();
			setVisible(false);
		}

		if(ae.getSource()==mi14)
		{
			new empidreport();
			setVisible(false);
		}
		if(ae.getSource()==mi13)
		{
			new prescnamerep();
			setVisible(false);
		}
		if(ae.getSource()==mi12)
		{
			new prescrep();
			setVisible(false);
		}
		if(ae.getSource()==mi11)
		{
			new empidreport();
			setVisible(false);
		}
		if(ae.getSource()==mi10)
		{
			new empreport();
			setVisible(false);
		}
		if(ae.getSource()==mi9)
		{
			new ppreport();
			setVisible(false);
		}
		if(ae.getSource()==mi8)
		{
			new preport();
			setVisible(false);
		}
		if(ae.getSource()==mi7)
		{
			new mmreport();
			setVisible(false);
		}
		if(ae.getSource()==mi6)
		{
			new mreport();
			setVisible(false);
		}
	  if(ae.getSource()==mi2)
	  {
	  	new Prescription();
	  	setVisible(false);
	  }
          
      if(ae.getSource()==mi1)
      {
      	new Patient();
      	setVisible(false);
      }
      if(ae.getSource()==mi3)
      {
      	new Maintainance();
      	setVisible(false);
      }
      if(ae.getSource()==mi4)
      {
      	new Employee1();
      	setVisible(false);
      }
      if(ae.getSource()==mi5)
      {
      	new Salary();
      	setVisible(false);
      }
	  }
	}

class HomepageDemo
{
	 public static void main(String[] cp) 
	{
		HomeScreen h=new HomeScreen();

	}
}
