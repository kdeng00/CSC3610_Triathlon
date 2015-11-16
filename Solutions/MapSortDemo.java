package maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MapSortDemo
{
	
	
	
	private static Map<Integer, String> sortThis(Map<Integer, String> unsorted)
	{
		List<String> list = new ArrayList<String>(unsorted.values());
		
		
		Collections.sort(list, new Comparator<String>() 
				{

					@Override
					public int compare(String o1, String o2) {
						return o1.compareTo(o2);
					}
				});
		
		Map<Integer, String> sorted = new HashMap<Integer, String>();
		int j = 0;
		for (Iterator<String> it = list.iterator(); it.hasNext();) 
		{
			sorted.put(j, it.next());
			j++;
		}
		
		return sorted;
	}
	public static Map<Integer, String>swap(Map<Integer,String> unsorted, Map<Integer, String> sorted, int array[], int arIn[])
	{
		
		List<Map.Entry<Integer, String>> lisp = new ArrayList<Map.Entry<Integer, String>>(sorted.entrySet());
		
		
		int i = 0;
		Map<Integer, String> newThis = new HashMap<Integer, String>();
		for (Iterator<Map.Entry<Integer, String>> jam = lisp.iterator(); jam.hasNext();)
		{
			Map.Entry<Integer, String> entry = jam.next();
			
			int iterate = 0;
			
			while (true)
			{
				
				if (unsorted.get(array[iterate]) == (entry.getValue()))
				{
					
					newThis.put(array[iterate], entry.getValue());
					arIn[i] = array[iterate];
					i++;
					break;
				}

				else
					iterate++;		
			}
		}
		return newThis;
	}
	public static void slast(Map<Integer, String> newNew, int[] orderOrderInTheCourt)
	{
		for (int i = 0; i < newNew.size(); i++)
		{
			System.out.println("Key: " + orderOrderInTheCourt[i] + " Value: " + newNew.get(orderOrderInTheCourt[i]));
		}
		
	}
	public static void printThis(Map<Integer, String> pam)
	{
		Set<Integer> keys = pam.keySet();
		Iterator<Integer> itKeys = keys.iterator();
		int arrayKeys[] = new int[pam.size()];
		
		int i = 0;
		while (itKeys.hasNext())
		{
			arrayKeys[i] = (int) itKeys.next();
			i++;
		}
		
		for (int j = 0; j < pam.size(); j++)
		{
			System.out.println("Key: " + arrayKeys[j] + " Value: " + pam.get(arrayKeys[j]));
		}
		
		
	}
	public static void main(String[] args)
	{
		Map<Integer, String> test = new HashMap<Integer, String>();
		int ar[] = {4, 343, 8, 2, 3, 7, 1000};
		int arIn[] = new int[ar.length];
		
		test.put(4, "Glad");
		test.put(343, "Fad");
		test.put(8, "Manny");
		test.put(2, "Ace");
		test.put(3, ""+4);
		test.put(7, ""+2);
		test.put(1000, ""+7);
		
		System.out.println("Unsorted Map: ");
		printThis(test);
		
		Map<Integer, String> sorted = sortThis(test);
		
		Map<Integer, String> real = swap(test, sorted, ar, arIn);
		System.out.println("\nNew Sorted: ");

		slast(real, arIn);
		
	}
}
