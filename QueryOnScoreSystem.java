import java.util.ArrayList;
import java.util.List;

public class QueryOnScoreSystem {
	
	private static double[] point;
	private static double[] credit;
	private static String[] id2;
	private static String[] surName;
	private static String[] givenName;
	private static int j;
	private static List<String> result = new ArrayList<>();

	public static void doing()
	{
		
		
		String[] allTxt=numOfTxt.AllTxt();
		StoreRecords.dataFile(allTxt);
		String[] id=StoreRecords.studentID();
		String[] format=StoreRecords.format2();
		QuickSort.dataFile(format);
		String[] quick=QuickSort.quickSort(id, 0, id.length-1);
		String[] quickformat=new String[quick.length+2];
		quickformat[0]="a";
		quickformat[1]="b";
		for(int i=2;i<quick.length+2;i++)
		{
			quickformat[i]=quick[i-2];
		}
		StoreRecords.dataFile(quickformat);
		
		point=StoreRecords.point();
		credit=StoreRecords.Credits();
		id2=StoreRecords.studentID();
		surName=StoreRecords.surName();
		givenName=StoreRecords.givenName();
	}

	public static void BeginDataStudent()
	{
		int a=StoreRecords.point().length;
		int n=0;
		while(n<a)
		{
			n=DataStudent(n);
		}
	}
	
	public static int DataStudent(int num)
	{
		double gpa=0.0;
		double allCredit=0.0;
		double allpoint=0.0;
		allCredit=credit[num];
		allpoint=point[num]*allCredit;
		
		for(j=num+1;j<point.length;j++)
		{
			if(id2[num].equalsIgnoreCase(id2[j]))
			{
				allCredit=allCredit+credit[j];
				allpoint=allpoint+point[j]*credit[j];
			}
			else 
			{
				break;
			}
				
		}
		gpa=allpoint/allCredit;
		double get_double = (double)(Math.round(gpa*100)/100.0);
		String d= String.valueOf(get_double);
		String data=surName[num]+","+givenName[num]+","+id2[num]+","+d;
		result.add(data);
		return j;
	}
	
	public static String[] print()
	{
		
		String[] a=new String[result.size()+2];
		a[0]="a";
		a[1]="b";
		
		for(int i=0;i<result.size();i++)
		{
			a[i+2]=result.get(i);
		}
		return a;
	}
	
	public static String[] print2()
	{
		String[] a=new String[result.size()];
		
		for(int i=0;i<result.size();i++)
		{
			a[i]=result.get(i);
		}
		return a;
	}
	
}
