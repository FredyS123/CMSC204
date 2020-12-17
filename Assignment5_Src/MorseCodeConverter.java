import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	private static MorseCodeTree morseCode = new MorseCodeTree();
	
	static String printTree() {
        ArrayList<String> arrayListTree = new ArrayList<>();
        arrayListTree = morseCode.toArrayList();
        String string = "";
        for (String letter : arrayListTree) {
            string += letter + " ";
        }
        return string;
    }
	
	public static String convertToEnglish(String code){
		
		String[] letters;
		String[] word = code.split(" / ");
		String decryptedWord = "";

		for(String temp: word) {
			letters = temp.split(" ");
			for(String tempLetter: letters) {
				decryptedWord += morseCode.fetch(tempLetter);
			}

			decryptedWord += " ";
			
		}
		return decryptedWord.trim();
	}
	
	 static String convertToEnglish(File codeFile) throws FileNotFoundException {

	        String Morse = null;
	        String English;

			Scanner scanner = new Scanner(codeFile);

	        while (scanner.hasNext()) {
	            Morse += scanner.nextLine() + "\n";
	            scanner.close();
	        }

	        English = convertToEnglish(Morse);
	        return English;
	    }
}
