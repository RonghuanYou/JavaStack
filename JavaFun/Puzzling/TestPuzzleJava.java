import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava {
    public static void main(String[] args) {
        Puzzle generator = new Puzzle();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        // print a random letter in 26 letters
        System.out.println(generator.getRandomLetter());

        // print random password
        System.out.println(generator.generatePassword());
        
        // print password set with 5 size
        System.out.println(generator.getNewPasswordSet(5));
    }
}
