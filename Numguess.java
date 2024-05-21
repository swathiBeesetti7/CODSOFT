import java.util.*;

public class Numguess {
    private static final int min_range = 1;
    private static final int max_range = 100;
    private static final int Total_rounds = 3;
    private static final int Tot_attempts = 10;

    public static void main (String[] args){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int Final_score = 0;

        System.out.println("Please enter your name : ");
        String name = sc.nextLine();
        System.out.println("Hello " + name + "! , This is NUMBER GUESSING GAME");
        System.out.printf("Total Rounds: %d %n",Total_rounds);
        System.out.printf("Total attempts per each round: %d %n%n",Tot_attempts);

        for(int i=1 ; i <= Total_rounds ; i++){
            int number = rnd.nextInt(max_range) + min_range;
            int attempts = 0;

            System.out.printf("Round %d: %nGuess the number between the %d and %d in %d attempts.%n",i,min_range,max_range,Tot_attempts);

            while (attempts < Tot_attempts){
                System.out.println("Enter your guess " + name + ": " );
                int guess = sc.nextInt();
                attempts+=1;

                if(guess == number ){
                    int score = Tot_attempts - attempts;
                    Final_score += score;
                    System.out.printf("Hurray!! number guessed successfully. %nAttempts = %d %nRound score = %d %n%n",attempts,score);
                    break;
                }

                else if (guess < number){
                    System.out.printf("NO! ,The number is greater than %d. Attempts left = %d. %n",guess,Tot_attempts-attempts);
                }

                else if (guess > number){
                    System.out.printf("NO! ,The number is less than %d. Attempts left = %d. %n",guess,Tot_attempts-attempts);
                }
            }

            if (attempts == Tot_attempts){
                System.out.printf("\nRound = %d %n",i);
                System.out.println("Attempts = 0");
                System.out.printf("The number is : %d  %nTry again :))) %n%n",number);

            }
        }

        System.out.printf("Game over! Your Final score: %d",Final_score );
        sc.close();
    }
}
