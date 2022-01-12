
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class IoTest 
{

	private static String[] IO_Streams;
 
	public static String[] io(String name)	//read data from the specific file
	{
		File f = new File(name);
		if (f.isFile()) 
		{
			FileReader fr=null;
			try 
			{
				fr = new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				int a= getTotalLines(f);
				IO_Streams=new String[a];
				for(int i=0;i<a;i++)
				{
					IO_Streams[i]=br.readLine();
				}
				br.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else	//when our system cannot find the file
		{
			System.out.println("File does not exist !");
			System.exit(0);
		}
		return IO_Streams;
	}
 
	private static int getTotalLines(File file) throws IOException 
	{
		FileReader in = new FileReader(file);
		LineNumberReader reader = new LineNumberReader(in);
		String s = reader.readLine();
		int lines = 0;
		while (s != null)
		{
			lines++;
			s = reader.readLine();
		}
		reader.close();
		in.close();
		return lines;
	}
 
	public static String[] storeIO()
	{
		String[] store;
		store=IO_Streams;
		return store;
	}
}