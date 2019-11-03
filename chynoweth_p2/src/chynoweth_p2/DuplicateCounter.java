package chynoweth_p2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
	
	static HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

	void count(FileInputStream dataFile) throws IOException {
		Scanner inFS = new Scanner(dataFile);
		
		// while loop goes as long as there is more to be scanned in
		while(inFS.hasNext()) {
			// scan in the word
			String word = inFS.next();
			// create Integer count, set to the value of word in the HashMap
			// if count is null (word is not in map), put the word with a value 1
			// if count is not null (word IS in map), put the word with count + 1
			// (so that the value of the word in the map is incremented)
			Integer count = wordCounter.get(word);
			if (count == null) {
				wordCounter.put(word, 1);
			} else {
				wordCounter.put(word, count + 1);
			}
		}
		// cleanup
		inFS.close();
		dataFile.close();
	}
	
	void write(FileOutputStream outputFile) throws IOException {
		PrintWriter outFS = new PrintWriter(outputFile);
		outFS.println(wordCounter);
		
		//cleanup
		outFS.flush();
		outputFile.close();
	}
}
