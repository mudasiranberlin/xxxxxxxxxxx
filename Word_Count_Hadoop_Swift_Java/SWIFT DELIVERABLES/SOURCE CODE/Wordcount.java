import java.util.*;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class Wordcount
 {
    public static void main(String[] args) throws IOException
      {
        Scanner inputfile;
	try
      	{
         	inputfile = new Scanner(new File(args[0]));
		
            	
		inputfile.useDelimiter("[^a-zA-Z0-9\\-\']+");
      	}

	catch (IOException e)
      	{
	 System.err.println(e);
	 return;
      	}

      	int words = 0;
        Map<String, Integer> wordCounts = new TreeMap<String, Integer>();
        while (inputfile.hasNext())
		 {
         		String next = inputfile.next().toLowerCase();
			next.replaceAll("[^a-zA-Z]","");
			words++;
            		if (!wordCounts.containsKey(next)) 
				{
                			wordCounts.put(next, 1);
            			} 
			else 
			{
                		wordCounts.put(next, wordCounts.get(next) + 1);
            		}
        	}

	System.out.println("Total number of words: " + words);

        System.out.println("Total number of unique words = " + wordCounts.size());
	        
        for (String word : wordCounts.keySet()) 
		{
        		int count = wordCounts.get(word);
        		if (count >= 1)
                	System.out.println(count + "\t" + word);
			
        	}
	System.out.println("-------------------------------------------------");
    }
}
