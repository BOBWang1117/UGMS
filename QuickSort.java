

public class QuickSort
{
	
	private static String[] data;
	
	public static String[] dataFile(String[] arr) 
	{
		String[] storeIO = arr;
		data = new String[storeIO.length];
		for (int a = 0; a < storeIO.length; a++) 
		{
			data[a] = storeIO[a];
		}
		return data;
	}
	
	 
	public static String[] quickSort(String[] arr, int left, int right) // quick sort method
	{
		String[] a = data;
		
		if (left > right) 
		{
			return null;
		}
		int base = left;
		int i = left;
		int j = right;
		
		while(i != j)
		{
			while (arr[j].compareTo(arr[base]) >=0 && i < j)
			{
				j--;
			}
			while (arr[i].compareTo(arr[base])<=0  && i < j)
			{
				i++;
			}
			String temp = arr[i];
			String temp1 = a[i];
			
			arr[i] = arr[j];
			a[i] = a[j];
			
			arr[j] = temp;
			a[j] = temp1;
		}
		
		String str = arr[left];
		String str1 = a[left];
			
		arr[left] = arr[i];
		a[left] = a[i];
			
		arr[i] = str;
		a[i] = str1;
		
		quickSort(arr,left,i - 1);
		quickSort(arr, j + 1,right);
		
		return a;
	}
}