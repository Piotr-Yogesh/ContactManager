import java.text.DecimalFormat;
import java.util.Scanner;

public class GuessGame {


    public static void main(String[] args){

        System.out.println("guess a number from 1-10");
        double guessedNum = Math.floor(Math.random()*10);
        int guessInt = (int)guessedNum;
        DecimalFormat format = new DecimalFormat("0.#");
        Scanner sc = new Scanner(System.in);
        int userGuess = sc.nextInt();
        if(guessInt == userGuess){
            System.out.println("good guess "+guessInt+" was the correct guess");
        }else{
            System.out.println("you guessed wrong, you're guess was "+ userGuess);
            System.out.println("the correct guess was " + guessInt);
        }

    }
}