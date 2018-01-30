import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Word Ladder: " + WordLadder.getShortestLadder("code","date"));

    }
}
