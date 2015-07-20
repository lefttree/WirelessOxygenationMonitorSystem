package com.example.wirelesstest;




public class MockData {
	
	private static int signal1;
	private static int signal2;
	
	public void setSignal1(int xx){
		//signal1 = xx;
		signal1 = xx;
	}
	public void setSignal2(int xx){
		signal2 = xx;
	}
	// x is the day number, 0 , 1, 2, 3
	// y is randomly generated
	public static Point getDataFromReceiver1(int x)
	{
		return new Point(x, signal1);
	}
	public static Point getDataFromReceiver2(int x)
	{
		return new Point(x, signal2);
	}
	
	
	/*
	private static int generateRandomData(int y)
	{
		//Random random = new Random();
		//return random.nextInt(40);
		return y;
	}
	*/
}
