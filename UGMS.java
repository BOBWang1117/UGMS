
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UGMS {
	
	private static String[] sortingMethod;
	private static String dataInput;
	private static String[] print=QueryOnScoreSystem.print();
	private static String[] print2=QueryOnScoreSystem.print2();
	private static String[] sortingGPA;
	private static String[] sortingGPA2;
	
	@SuppressWarnings("resource")
 	public static void databaseName() 
	{
		System.out.println("Please enter the database filename:    (PS:the filename of the database is base)");
		Scanner getdatabase = new Scanner(System.in);
		dataInput = getdatabase.next().toLowerCase();
	}
 
	public static String filename()
	{
		String a =  dataInput;
		System.out.println("Please choose the course code first:");
		@SuppressWarnings("resource")
		Scanner getInputUserName=new Scanner(System.in);
		String userInput=getInputUserName.next().toUpperCase();
		String userName = a + "//"+ userInput + ".txt";		//obtain the complete address of the file
		return userName;
	}

	public static String judgment()		// Determine whether you need to continue reading the file
	{
		@SuppressWarnings("resource")
		Scanner getResult=new Scanner(System.in);
		String result=getResult.next().toUpperCase();
		if(result.equals("Y")) {	}
		else if(result.equals("N"))
		{
			System.out.println("Searching");
//			System.out.println("Exit program.");
//			System.exit(0);
		}
		else 
		{
			System.out.println("Please correctly input \"Y\" or \"N\"\nExit program");
			System.exit(0);
		}
		return result;
	}
	public static void input() 
	{
		System.out.println("CourseCode: " +StoreRecords.courseName());
		System.out.println("Credit:  " +StoreRecords.courseCredits());
		System.out.println("Number of Students:   " +StoreRecords.studentNumber());
		System.out.println("Name"+"                    \t"+"ID"+"                       \t"+"Score"+"          \t"+"Grade");
		System.out.println("------------------\t        -------------------\t        -------\t        -------");
	}
 
	public static void sortingField_1()
	{
		
		QuickSort.dataFile(StoreRecords.format());
		System.out.println("Please choose the sorting field:  ");
		System.out.println(" (1) Surname; (2) ID; (3) Score; (4) Grade");
		@SuppressWarnings("resource")
		Scanner sortingField=new Scanner(System.in);
		String fieldResult = sortingField.next();
	 	int length = StoreRecords.surName().length - 1;
	 	switch(fieldResult) 
	 	{
	 	 case "1":
	 		String[] a = QuickSort.quickSort(StoreRecords.surName(), 0, length);
	 		sortingMethod = a;
	 		break;
	 	 case "2":
	 		String[] b = QuickSort.quickSort(StoreRecords.studentID(), 0, length);
	 		sortingMethod = b;
	 		break;
	 	 case "3":
	 	 case "4":   
	 		String[] c = QuickSort.quickSort(StoreRecords.score(), 0, length);
	 		sortingMethod = c;
	 		break;
	 	 default:
	 		System.out.println("Please correctly input suitable option\nExit program");
	 		System.exit(0);
	 	}
	}
	public static void sortingField_2() 
	{
	  System.out.println("Please choose the sorting ways:" );	
	  System.out.println("(A)scending order; (D)escending order");
	  @SuppressWarnings("resource")
	  Scanner sortingWays=new Scanner(System.in);
	  String waysResult=sortingWays.next().toUpperCase();
	  switch(waysResult) 
	  {
	   case "A":
		  input();
		  for(String str : sortingMethod) 
		  {
			  System.out.println(str);
		  }
		  break;
	   case "D":
		  input();
		  for (int i = sortingMethod.length; i > 0; i--) 	//descending order method
		  {
			  System.out.println(sortingMethod[i - 1]);
		  }
		  break;
	   default:
		  System.out.println("Please correctly input suitable option\nExit program");
		  System.exit(0);
	  }
	}

	public static void statisticsReports() 
	{
		System.out.println();
		System.out.println("Course Code: " + StoreRecords.courseName());
		System.out.println("Credit: " + StoreRecords.courseCredits());
	  
		String[] getScore = StoreRecords.score();
		int[] getNum = new int[getScore.length];
		for (int i = 0; i < getNum.length; i++) 
		{
			getNum[i] = Integer.parseInt(getScore[i]);
		}
		int max = getNum[0];	//get the maximum score
		int min = getNum[0];	//get the minimum score
		int sum = 0;

		for(int i = 0; i < getNum.length; i++) 
		{
			if (getNum[i] > max) {max = getNum[i];}
			if (getNum[i] < min) {min = getNum[i];}
			if (getNum[i] >= 93) {}
			sum = sum + getNum[i];
		}
		System.out.println();
		int A_p=0,A=0,A_m=0;
		int B_p=0,B=0,B_m=0;
		int C_p=0,C=0,C_m=0;
		int D  =0,F=0,O=0;
		for(int i=0;i<getNum.length;i++)
		{	
			int a=getNum[i];
			if(93<=a&&a<=100)		{A_p++;}
			else if(88<=a&&a<=92)	{A++;}
			else if(83<=a&&a<=87) 	{A_m++;}
			else if(78<=a&&a<=82) 	{B_p++;}
			else if(72<=a&&a<=77) 	{B++;}
			else if(68<=a&&a<=71) 	{B_m++;}
			else if(63<=a&&a<=67) 	{C_p++;}
			else if(58<=a&&a<=62)	{C++;}
			else if(53<=a&&a<=57)	{C_m++;}
			else if(50<=a&&a<=52)	{D++;}
			else if(40<=a&&a<=49) 	{F++;}
			else {O++;}
		}
		System.out.println("Course Grade Statistics: ");
		System.out.printf("A+: %d\n",A_p);
		System.out.printf("A : %d\n",A);
		System.out.printf("A-: %d\n",A_m);
		System.out.printf("B+: %d\n",B_p);
		System.out.printf("B : %d\n",B);
		System.out.printf("B-: %d\n",B_m);
		System.out.printf("C+: %d\n",C_p);
		System.out.printf("C : %d\n",C);
		System.out.printf("C-: %d\n",C_m);
		System.out.printf("D : %d\n",D);
		System.out.printf("F : %d\n",F);
		System.out.printf("O : %d\n",O);
		
		double average = (double) sum / getNum.length;
		System.out.printf("The  average  score:  %.1f\n", average);
		System.out.printf("The  highest  score:  %d\n", max);
		System.out.printf("The  lowest  score:  %d\n",min);
		System.out.println("\nDo you have another score report?\n"
			    + "Press \"Y\" for Yes and \"N\" for No.\r");
	  
  }
	
	public static void SearchGradesByStudent()
	{
		print=QueryOnScoreSystem.print();
		print2=QueryOnScoreSystem.print2();
		
		String[] b=numOfTxt.AllTxt();
		//for(String aaa:b) {System.out.println("aaa t "+aaa);}
		StoreRecords.dataFile(print);
		String[] c=StoreRecords.studentID();
		StoreRecords.dataFile(b);
		String[] d=StoreRecords.format5();
		String[] f=StoreRecords.studentID();
		System.out.print("Please input the student ID: ");
		@SuppressWarnings("resource")
		Scanner Id=new Scanner(System.in); 
		String inputId=Id.next().toUpperCase();
		int result=binarySearch(c,inputId);
		if(result!=-1)
		{
			String[] aa =print[result].split(",");
			for(int i=0;i<d.length;i++)
			{
				if(f[i].equals(inputId))
				{
					System.out.println(d[i]);
				}
			}
			System.out.println("GPA: "+aa[3]);
		}
		else 
		{
			System.out.println("We don't have this student id");
		}
				
	}
	
	public static int binarySearch(String[] arr,String a)
	{
			int index = 0;
			int start = 0;
			int end =arr.length;
			int i=0;
			for (i = 0; i < arr.length; i++){ 
				
				index = (start + end) / 2;
				if(arr.length - 1 == i)
				{
					System.out.println();
				}
				else if (arr[index].compareTo(a)<0)
				{
					start = index;
				}
				else if (arr[index].compareTo(a)>0)
				{
					end = index;
				}
				else
				{
					break;
				}
			}
			
			if(end == i) return -1;
			else return index+2;
		
	}
	
	public static void SortingOnGPA()
	{
		System.out.println();
		System.out.println();
		//System.out.println(print[1]);
		
		for(int i=0;i<print.length;i++)
		{
			//System.out.println("print   "+print[i]);
		}
		
		System.out.println("Sorting On GPA: \n");
		StoreRecords.dataFile(print);
		String[] gpa=StoreRecords.GPA();
		//for(String test:print) {System.out.println(test);}
		QuickSort.dataFile(print2);
		sortingGPA = QuickSort.quickSort(gpa, 0, gpa.length-1);
		//System.out.println("0 "+sortingGPA[0]);
		
		sortingGPA2=new String[sortingGPA.length+2];
	
		sortingGPA2[0]="a";
		sortingGPA2[1]="b";
		System.arraycopy(sortingGPA, 0, sortingGPA2, 2, sortingGPA.length);
		StoreRecords.dataFile(sortingGPA2);
		String[] surName=StoreRecords.surName();
		String[] givenName=StoreRecords.givenName();
		String[] studentID=StoreRecords.studentID();
		String[] GPA=StoreRecords.GPA();
		String[] Ascending=new String[GPA.length];
		String[] Dscending=new String[GPA.length];
		System.out.println("Please choose the sorting ways: \n(A)scending order; (D)escending order");
		@SuppressWarnings("resource")
		Scanner chooseInput=new Scanner(System.in);
		String choose = chooseInput.nextLine().toUpperCase();
		
		System.out.println("ID"+"             "+"\t"+"       "+"\t"+"   Name"+"                       "+"\t"+"GPA");
		System.out.println("------------------"+"\t"+"   -------------------"+"\t"+"        -------"+"\t");
		for(int i = 0; i < GPA.length; i++)
		{
			String print=studentID[i]+"     "+"\t"+"   "+surName[i]+","+givenName[i]+"              "+"\t"+GPA[i];
			Ascending[i]=print;
		}
		for(int i=0;i<GPA.length;i++)
		{
			Dscending[i]=Ascending[GPA.length-1-i];
		}
		switch(choose)
		{
			case "A":for(String out:Ascending) {System.out.println(out);}break;
				
			case "D":for(String out:Dscending) {System.out.println(out);}break;
			
			default:
		 		System.out.println("Please correctly input suitable option\nExit program");
		 		System.exit(0);
		}
		
		
	}
	
	public static void SurnameSearching()
	{
		System.out.println();
		System.out.println();
		System.out.println("Please input the student surname: ");
		@SuppressWarnings("resource")
		Scanner surname=new Scanner(System.in); 
		String InputSurname=surname.nextLine();
		//long start=System.currentTimeMillis();
		StoreRecords.dataFile(sortingGPA2);
		
		String[] surName=StoreRecords.surName();
		String[] givenName=StoreRecords.givenName();
		String[] id=StoreRecords.studentID();
		String[] gpa=StoreRecords.GPA();

		List<String> containID = new ArrayList<>();
		List<String> GPA = new ArrayList<>();
		List<String> Name = new ArrayList<>();
		int m=0;
		for(int i=0;i<id.length;i++)
		{
			String a=id[i];
			String b=gpa[i];
			if(surName[i].contains(InputSurname))
			{
				m++;
				String result=surName[i]+" "+givenName[i]+" "+id[i];
				Name.add(result);
				containID.add(a);
				GPA.add(b);
			}	
		}
		System.out.printf("%d records found in UGMS:\n",m);
		System.out.println();
		String[] allTxt=numOfTxt.AllTxt();
		StoreRecords.dataFile(allTxt);
		String[] a=StoreRecords.surName();
		String[] c=StoreRecords.studentID();
		String[] d=StoreRecords.course();
		String[] e=StoreRecords.Grade();
		for(int i=0;i<containID.size();i++)
		{
			System.out.println(Name.get(i));
			for(int j=0;j<a.length;j++)
			{
				if(containID.get(i).equals(c[j]))
				{
					System.out.println(d[j]+" "+e[j]);
				}
			}
			System.out.println("GPA: "+GPA.get(i));
			System.out.println();
		}
//		long end=System.currentTimeMillis(); 
//		System.out.println("程序运行时间： "+(end-start)+"ms"); 
	}
	
	public static void RangingQueryOnGPA()
	{
		System.out.println();
		System.out.println();
		System.out.println("Please input your ranging query condition on GPA: ");
		@SuppressWarnings("resource")
		Scanner GPA=new Scanner(System.in); 
		String InputGPA=GPA.nextLine();
		System.out.println();
		
		StoreRecords.dataFile(sortingGPA2);
		String[] e=StoreRecords.surName();
		String[] b=StoreRecords.givenName();
		String[] c=StoreRecords.studentID();
		double[] d=StoreRecords.DoubleGPA();
		List<String> resultlist = new ArrayList<>();
		List<String> resultlist2 = new ArrayList<>();
		int j=0;
		if(InputGPA.contains(">")) 
		{
			String[] a = InputGPA.split(">");
			double result=Double.parseDouble(a[1]);
			for(int i=0;i<d.length;i++)
			{
				if(result<d[i])
				{
					j++;
					resultlist.add(e[i]+" "+b[i]+" "+c[i]);
					resultlist2.add(Double.toString(d[i]));
				}
			}
			if(j==0)
			{
				System.out.printf("There is no GPA larger than %.2f",result);
			}
			else
			{
				System.out.printf("There are %d students satisfying the condition: \n\n",j);
			}
			for(int i=0;i<resultlist.size();i++)
			{
				System.out.println(resultlist.get(i));
				System.out.println(resultlist2.get(i));
			}
			
			
		}
		else if(InputGPA.contains("<"))
		{
			String[] a = InputGPA.split("<");
			double result=Double.parseDouble(a[1]);
			for(int i=0;i<d.length;i++)
			{
				if(result>d[i])
				{
					j++;
					resultlist.add(e[i]+" "+b[i]+" "+c[i]);
					resultlist2.add(Double.toString(d[i]));
				}
			}
			if(j==0)
			{
				System.out.printf("There is no GPA less than %.2f",result);
			}
			else
			{
				System.out.printf("There are %d students satisfying the condition: \n\n",j);
			}
			for(int i=0;i<resultlist.size();i++)
			{
				System.out.println(resultlist.get(i));
				System.out.println(resultlist2.get(i));
			}
			
			
		}
		else if(InputGPA.contains("="))
		{
			String[] a = InputGPA.split("=");
			double result=Double.parseDouble(a[1]);
			for(int i=0;i<d.length;i++)
			{
				if(result==d[i])
				{
					j++;
					resultlist.add(e[i]+" "+b[i]+" "+c[i]);
					resultlist2.add(Double.toString(d[i]));
				}
			}
			if(j==0)
			{
				System.out.printf("There is no GPA equal to %.2f",result);
			}
			else
			{
				System.out.printf("There are %d students satisfying the condition: \n\n",j);
			}
			for(int i=0;i<resultlist.size();i++)
			{
				System.out.println(resultlist.get(i));
				System.out.println(resultlist2.get(i));
			}
		}
		else
		{
			System.out.println("Please input a right format!");
		}
			
	}
}
