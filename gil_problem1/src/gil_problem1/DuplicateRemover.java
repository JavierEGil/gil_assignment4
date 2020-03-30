package gil_problem1;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;

public class DuplicateRemover {
	public ArrayList<String> uniqueWords = new ArrayList<String>();
	
	public void remove(String dataFile) {
		String temp1;
		String temp2;
		int count = 0;
		int i;
		boolean flag = true;
		
		try (Scanner input = new Scanner(Paths.get(dataFile))) {
			
			while (input.hasNext()) {
				if (count == 0) {
					uniqueWords.add(input.next());
					count++;
				}
				else {
					temp1 = input.next();
					flag = true;
					for (i = 0; i < uniqueWords.size() ; i++) {
						temp2 = uniqueWords.get(i);
						if (temp1.equalsIgnoreCase(temp2)) {
							flag = false;
						}
					}
					if (flag) {
						uniqueWords.add(temp1);
					}
				}
			}
			
		}
		catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();
			System.out.println("No such text file.");
		}
	}
	
	@SuppressWarnings("static-access")
	public void write(String outputFile) {
		int i;
		
		try (Formatter output = new Formatter(outputFile)) {
			for (i = 0; i < uniqueWords.size(); i++ ) {
				outputFile.format(uniqueWords.get(i));
			}
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
			System.out.println("File was not found.");
		}
	}
}
