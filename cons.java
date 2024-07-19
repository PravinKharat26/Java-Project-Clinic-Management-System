class demo
{
	public demo()
	{
		System.out.println("Constructor");
	}
	public void disp()
	{
		System.out.println("In disp");

	}
}

class ddemo
{
	public static void main(String[] cp) 
	{
		demo d=new demo();
		d.disp();
	}
}