/*
 * Jonathan Brown
 * CSCE 247
 * 2/20/21
 */
package Library;

import java.util.*;

import java.util.HashMap;

import java.util.Map.Entry;

public class Library {
	// Books HashMap
	HashMap<String,Integer> Books = new HashMap<String,Integer>();
	// Library Object
	private static Library library;
	
	public Library()
	{
	}
	
	public static Library getInstance()
	{
		if(library==null)
		{
			System.out.print("Creating Our Library. Time to begin Reading");
			library = new Library();
		}
		
		return library;
	}
	public boolean checkoutBook(String Bookname)
	{
		int n = 0;
		if(Books.containsKey(Bookname))
		{
			
			if(Books.get(Bookname)==1)
			{
				Books.remove(Bookname);
			}
			else
				 n = Books.get(Bookname);
			n= n-1;
				Books.replace( Bookname,n);
			
			return true;
		}
		else
		{
			System.out.print("Sorry "+ Bookname +" is not in Stock");
			return false;
		}
	}
	// checks the Books in Library
	public boolean checkInBook(String Bookname, int numToAdd)
	{
		if(Books.containsKey(Bookname))
		{
			//  adds to number of books
			Books.replace(Bookname, numToAdd+1);
			return true;
		}
		else
		{
			// adds books to library
			Books.put(Bookname,numToAdd);
			return false;
		}
	}
	
	//creates iterator and iterartes the HashMap
	public void displayBooks()
	{
		
		Iterator<Entry<String,Integer>> iterator =  Books.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<String,Integer> entry = iterator.next();
			System.out.print(entry.getKey()+" ");
			System.out.println(entry.getValue());
		}
		
	}
}
