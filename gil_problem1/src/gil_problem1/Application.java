package gil_problem1;

public class Application {

	public static void main(String[] args) {
		
		
		
		DuplicateRemover DuplicateRemover = new DuplicateRemover();
		
		DuplicateRemover.remove("problem1.txt");
		
		DuplicateRemover.write("unique_words.txt");
		
		
		
	}

}
