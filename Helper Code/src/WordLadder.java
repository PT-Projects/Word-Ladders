import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class WordLadder {

	private static ArrayList<ArrayList<String>> queue = new ArrayList();
	private static ArrayList<String> finalLadder = null;
	private static ArrayList<String> usedWords = new ArrayList<>();

	/**
	 * Returns the shortest ladder from startWord to endWord using "dictionary.txt" as the lexicon. If no
     * ladder exists, null is returned.
     * @param startWord the start word
     * @param endWord the end word
	 * @return the shortest ladder or null if none are found
	 */
	public static ArrayList<String> getShortestLadder(String startWord, String endWord) throws FileNotFoundException {

        Lexicon dict = new Lexicon(new File("dictionary.txt"));

        ArrayList<String> newLadder = new ArrayList<>();

        newLadder.add(startWord);

		queue.add(newLadder);

		while (!queue.isEmpty()){

			ArrayList<String> deQueue = queue.get(0);
			queue.remove(0);

			String deQueueLast = deQueue.get(deQueue.size()-1);

			if (deQueueLast.equals(endWord)){
				finalLadder = deQueue;
				return finalLadder;
			}

			else{

				ArrayList<String> similarWords = dict.getOneLetterAwayWords(deQueueLast);

				for (String similarWord: similarWords){
					if (!usedWords.contains(similarWord)){
						ArrayList<String> deQueueCopy = (ArrayList<String>) deQueue.clone();
						deQueueCopy.add(similarWord);
						queue.add(deQueueCopy);
						usedWords.add(similarWord);
					}
				}

			}

		}

		return finalLadder;

	}
}
