import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Lexicon {
    // instance fields

    private ArrayList<String> lexiconList;

    /**
     * creates a new empty lexicon
     */
    public Lexicon() {
        lexiconList = new ArrayList<>();
    }

    /**
     * creates a lexicon with words read in from a file
     * @param fileName the name of the file to read the words from
     * @throws FileNotFoundException if the file does not exist
     */
    public Lexicon(File fileName) throws FileNotFoundException {

        lexiconList = new ArrayList<>();

        Scanner in = new Scanner(fileName);

        while (in.hasNextLine()){
            add(in.nextLine());
        }

    }

    /**
     * adds a word to the lexicon
     * @param word the word to be added to the lexicon
     */
    public void add(String word) {
        lexiconList.add(word);
    }

    /**
     * return true if the word is in the lexicon,false otherwise
     * @param word the word to be checked for in the dictionary
     * @return true if the word is in the lexicon, false otherwise
     */
    public boolean contains(String word) {
        return lexiconList.contains(word);
    }

    /**
     * returns true if the lexicon is empty false otherwise
     * @return true if the lexicon is empty
     */
    public boolean isEmpty() {
        return lexiconList.isEmpty();
    }

    /**
     * returns the size of the lexicon
     * @return the size of the lexicon
     */
    public int size() {
        return lexiconList.size();
    }

    /**
     * returns an arraylist with words one letter away from the word given
     * @param word the word to compare the other words to
     * @return the arraylist with words one letter away
     */
	public ArrayList<String> getOneLetterAwayWords(String word)	{

	    ArrayList<String> similarList = new ArrayList<>();

	    int checked = 0;

	    for (String compare: lexiconList){
	        if (compare.length() == word.length()){

                for (int x = 0; x < word.length(); x++){

                    char[] compareChars = compare.toCharArray();
                    char[] wordChars = word.toCharArray();

                    if (compareChars[x] == wordChars[x]){
                        checked++;
                    }

                }

                if (checked >= word.length() - 1){
	                similarList.add(compare);
                }
                checked = 0;

            }
        }

        return similarList;

	}

    /**
     * returns a string representation of the lexicon
     * @return the string representation
     */
    public String toString() {
        return lexiconList.toString();
    }

}
