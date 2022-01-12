import java.io.File;

public class numOfTxt {
	
	private static int txtNum;
	private static String path = "base";		
	private static File file = new File(path);
	private static String[] fy = file.list();
	private static int b=fy.length;
	private static String mm = path+"/";
	private static String[] data;
	public static void LineNumber()
	{
		
		int sum =0;
		for(int i=0;i<b;i++)
		{		
			
			String c= mm+fy[i];
			int def=Integer.parseInt(IoTest.io(c)[1]);
			sum=sum+def;
		}
		txtNum=sum;
	}
	
	public static String[] AllTxt() 
	{
		
		LineNumber();
		int m=2;
		String[] a = new String[txtNum+2];
		a[0]="a";
		a[1]="b";
		
		for(int i=0;i<b;i++)
		{					
			String c= mm+fy[i];
			String[] arr;
			arr=IoTest.io(c);
			String courseCredits=arr[0];
		
			for(int j=2;j<arr.length;j++)
			{
				a[m++]=(arr[j]+","+courseCredits);
				
			}
		}
		data=a;
		return a;
	}
	
	public static String[] AllTxt2() 
	{
		LineNumber();
		String[] AllTxt2=new String[txtNum];
		//System.out.println(txtNum);
		for(int i=0;i<txtNum;i++)
		{					
			AllTxt2[i]=data[i+2];
			//System.out.println(AllTxt2[i]);
		}
//		for(String test:AllTxt2) {System.out.println(test);}
//		System.out.println("------------------------------------------");
		return AllTxt2;
	}
 
}