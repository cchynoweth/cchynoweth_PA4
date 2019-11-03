package chynoweth_p2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		DuplicateCounter DuplicateCounter = new DuplicateCounter();
		FileInputStream dataFile = new FileInputStream("problem2.txt");
		DuplicateCounter.count(dataFile);
		FileOutputStream outputFile = new FileOutputStream("unique_word_counts.txt");
		DuplicateCounter.write(outputFile);
	}
}
