package chynoweth_p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		DuplicateRemover DuplicateRemover = new DuplicateRemover();
		FileInputStream dataFile = new FileInputStream("problem1.txt");
		DuplicateRemover.remove(dataFile);
		FileOutputStream outputFile = new FileOutputStream("unique_words.txt");
		DuplicateRemover.write(outputFile);
	}
}
