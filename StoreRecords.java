
public class StoreRecords
{
	private static String[] storeIO;
	private static int storeIO_length;
	
	public static int leng()
	{
		storeIO_length=storeIO.length-2;

		return storeIO_length;
	}
	
	public static String[] dataFile(String[] a)
	{ 	
		storeIO = a;
		leng();
		return storeIO;
	}
	 
	public static String courseName()	//get the course name from the file
	{
		String[] b = storeIO[0].split(",");
		String courseName = new String();
		courseName=b[0];
		return courseName;
	}
	public static int courseCredits() 	//get the course credits from the file
	{
		String[] b =storeIO[0].split(",");
		int courseCredits=Integer.parseInt(b[1]);		//transfer the String data type to integer.
		return courseCredits;
	}
	  
	public static int studentNumber()	//get the student number from the file
	{
		int studentNumber=Integer.parseInt(storeIO[1]);
		return studentNumber;
	}
	  
	public static String[] surName()	//get students' surname from the file
	{
		String[] surName=new String[storeIO_length]; 
		
		for(int i=0;i<storeIO_length;i++)
		{

			String[] b = storeIO[i + 2].split(",");
			surName[i]=b[0];
		}
		return surName;
	}
	  
	public static String[] givenName()		//get students' given name from the file
	{
		String[] givenName=new String[storeIO_length];
		for(int i=0;i<storeIO_length;i++)
		{
			String[] b = storeIO[i + 2].split(",");
			givenName[i]=b[1];
		}
		return givenName;
	}
	  
	public static String[] studentID()		//get students' ID from the file
	{
		String[] studentID=new String[storeIO_length];
		for(int i=0;i<studentID.length;i++)
		{
			String[] b = storeIO[i + 2].split(",");
			studentID[i]=b[2];
		}
		return studentID;
	}
	  
	public static String[] score()		//get students' score from the file
	{
		int[] score=new int[storeIO_length];
		for(int i=0;i<score.length;i++)
		{
			String[] b = storeIO[i + 2].split(",");
			score[i] = (int) Math.round(Double.parseDouble(b[3]));;
		}
		String[] score1 = new String[storeIO_length];
	 	for (int b = 0;b < score1.length; b++) 
	 	{
	 		score1[b] = String.valueOf(score[b]);
	 	}
	 	return score1;
	}
	  
	public static String[] Grade()		//get students' grade from the file
	{
		String[] Grade=new String[storeIO_length];
		String[] a=score();
		int[] score = new int[Grade.length];
		
		for(int i = 0; i < Grade.length; i++)
		{
			score[i] = Integer.parseInt(a[i]);
		}
		
		for(int i=0;i<storeIO_length;i++)
		{
			Grade[i]=GradeChoose(score[i]);
		}
	   
		return Grade;
	}

	public static String[] format()	//Return to the appropriate format
	{
		String[] a=surName();
		String[] b=givenName();
		String[] c=studentID();
		String[] d=score();
		String[] e=Grade();
		String[] overall = new String[a.length];
		for(int i = 0; i < overall.length; i++)
		{
			overall[i] = a[i]+","+b[i]+"                 \t"
			+c[i]+"      \t"+d[i]+"            \t"+e[i];
		}
		return overall;
	}
	public static String[] format2()	//Return to the appropriate format
	{
		String[] a=surName();
		String[] b=givenName();
		String[] c=studentID();
		String[] d=score();
		String[] e=course();
		double[] f=Credits();
		double[] g=point();
		String[] overall = new String[a.length];
		
		for(int i = 0; i < overall.length; i++)
		{
			overall[i] = a[i]+","+b[i]+","+c[i]+","+d[i]+","+e[i]+","+f[i]+","+g[i];
		}
		return overall;
	}
	public static String[] format5()	//Return to the appropriate format
	{
		String[] a=Grade();
		String[] b=course();
		String[] overall = new String[a.length];
		for(int i = 0; i < overall.length; i++)
		{
			overall[i] = a[i]+"\t"+b[i];
		}
		return overall;
	}
	
	public static String[] GPA() 
	{
		String[] GPA=new String[storeIO_length];
		for(int i=0;i<storeIO_length;i++)
		{
			String[] b = storeIO[i + 2].split(",");
			GPA[i]=b[3];
		}
		
		return GPA;
	}
	public static double[] DoubleGPA()
	{
		double[] doubleGPA=new double[storeIO_length];
		String[] GPA=GPA();
		for(int i=0;i<storeIO_length;i++)
		{
			doubleGPA[i]=Double.parseDouble(GPA[i]);
		}
		return doubleGPA;
	}

	public static String GradeChoose(int a)
	{
		if(93<=a&&a<=100) 	  {return "A+";}
		else if(88<=a&&a<=92) {return "A";}
		else if(83<=a&&a<=87) {return "A-";}
		else if(78<=a&&a<=82) {return "B+";}
		else if(72<=a&&a<=77) {return "B";}
		else if(68<=a&&a<=71) {return "B-";}
		else if(63<=a&&a<=67) {return "C+";}
		else if(58<=a&&a<=62) {return "C";}
		else if(53<=a&&a<=57) {return "C-";}
		else if(50<=a&&a<=52) {return "D";}
		else if(40<=a&&a<=49) {return "F";}
		else {return "O";}
	}
	
	public static String[] course()
	{
		String[] course=new String[storeIO_length];
		for(int i=0;i<course.length;i++)
		{
			String[] b = storeIO[i + 2].split(",");
			course[i]=b[4];
		}
		return course;
	}
	
	
	public static double[] point()
	{
		double[] cpa=new double[storeIO_length];
		int[] score = new int[storeIO_length];
		String[] a=score();
		for(int i = 0; i < storeIO_length; i++)
		{
			score[i] = Integer.parseInt(a[i]);
		}
		
		for(int i=0;i<storeIO_length;i++)
		{
			cpa[i]=CPAChoose(score[i]);
		}
	   
		return cpa;
		
		
	}
	public static double CPAChoose(int a)
	{
		if(93<=a&&a<=100) 	  {return 4.0;}
		else if(88<=a&&a<=92) {return 3.7;}
		else if(83<=a&&a<=87) {return 3.3;}
		else if(78<=a&&a<=82) {return 3.0;}
		else if(72<=a&&a<=77) {return 2.7;}
		else if(68<=a&&a<=71) {return 2.3;}
		else if(63<=a&&a<=67) {return 2.0;}
		else if(58<=a&&a<=62) {return 1.7;}
		else if(53<=a&&a<=57) {return 1.3;}
		else if(50<=a&&a<=52) {return 1.0;}
		else if(40<=a&&a<=49) {return 0.0;}
		else {return 0.0;}
	}

	public static double[] Credits()
	{
		double[] Credits=new double[storeIO_length];
		for(int i=0;i<storeIO_length;i++)
		{
			String[] b = storeIO[i + 2].split(",");
			Credits[i]= Double.parseDouble(b[5]);
		}
		
		return Credits;
	}
}