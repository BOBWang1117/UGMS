
public class UGMSTest
{
	public static void main(String[] args) {
		
		UGMS.databaseName();	//get the database name of the project 
		do
		{
			IoTest.io(UGMS.filename());	//Read the information in the file
			IoTest.storeIO();
			
			
			String[] a=IoTest.storeIO();
			StoreRecords.dataFile(a);
			
			
			UGMS.sortingField_1();	//sort the data
			UGMS.sortingField_2();	//choose the sorting ways
			
			UGMS.statisticsReports();
			//make a statistics report
			//StoreRecords.cpa();
		}
		while (UGMS.judgment().equals("Y"));
		QueryOnScoreSystem.doing();
		
		numOfTxt.AllTxt2();
		QueryOnScoreSystem.BeginDataStudent();
		UGMS.SearchGradesByStudent();
		UGMS.SortingOnGPA();
		UGMS.SurnameSearching();
		UGMS.RangingQueryOnGPA();
		
	}
	
	
}