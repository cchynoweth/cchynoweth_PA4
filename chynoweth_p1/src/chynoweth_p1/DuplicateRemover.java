package chynoweth_p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class DuplicateRemover {
	
	static HashSet<String> uniqueWords = new HashSet<String>();
	
	void remove(FileInputStream dataFile) throws IOException {
		Scanner inFS = new Scanner(dataFile);
		
		HashSet<String> repeatedWords = new HashSet<String>();
		// while loop goes as long as dataFile has more words
		while (inFS.hasNext()) {
			// scan in next word
			String word = inFS.next();
			// if neither uniqueWords nor repeatedWords contains the word,
			// 		add the word to uniqueWords
			// else, remove the word (because word is no longer unique)
			//		and add the word to repeatedWords
			//		(so that it won't be added to uniqueWords again)
			if (!uniqueWords.contains(word) && !repeatedWords.contains(word)) {
				uniqueWords.add(word);
			} else {
				uniqueWords.remove(word);
				repeatedWords.add(word);
			}
		}
		
		//cleanup
		inFS.close();
		dataFile.close();
	}
	
	void write(FileOutputStream outputFile) throws IOException {
		PrintWriter outFS = new PrintWriter(outputFile);
		outFS.println(uniqueWords);
		
		// cleanup
		outFS.flush();
		outputFile.close();
	}
}
