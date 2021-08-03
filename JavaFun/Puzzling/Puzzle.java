import java.util.ArrayList;
import java.util.Random;

public class Puzzle {

    public ArrayList<Integer> getTenRolls(){
        // return an array with 10 random numbers between 1 and 20 inclusive
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Random randomMachine = new Random();  // instance of random class
        int max = 20;
        int i = 0;
        while (i < 10){
            int randomNum = randomMachine.nextInt(max) + 1;  // generate ranodm num in range[0, 19] + 1
            nums.add(randomNum);
            i += 1;
        }
        return nums; 
    }

    public char getRandomLetter() {
        char[] alphabet = new char[26];
        // generate array with all 26 letters of the alphabet
        for (char c = 'a'; c <= 'z'; c++){
            alphabet[c - 'a'] = c; 
        }

        // generate random index between 0 - 25
        Random randomMachine = new Random(); // instance of random class
        int max = 26;
        int index = randomMachine.nextInt(max); // generate ranodm num in range[0, 25]

        // return random letter
        return alphabet[index];
    }

    public String generatePassword() {
        // generate a random string of eight characters
        String password = "";
        int i = 0;
        while (i < 8){
            password += getRandomLetter();
            i += 1;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int passwordNum) {
        ArrayList<String> passwordSet = new ArrayList<String>();
        
        int i = 0;
        while (i < passwordNum){
            String password = generatePassword();
            passwordSet.add(password);
            i += 1;
        }
        return passwordSet;
    }    
}
