package assignments.BookCricketgame;

import assignments.BookCricketgame.Player;
import java.util.Scanner;

import javax.print.event.PrintJobListener;

public class BookCricketgame {
    private Player p1;
    private Player p2;

    public void welcome() {
        System.out.println("Welcome to BookCricketGame !!");
    }

    public void rules() {
        System.out.println("Rules for the Game :\n**Assume a book of 300 pages");
        System.out.println("1. Player1 opens the book to read a page number (example 87)(randomly generated");
        System.out.println(
                "2. If the page number is 87->87%7(%7 results in score between 0-6)= 3 should be addad to the score");
        System.out.println(
                "3. player 1 continues and keeps adding to the score untill page number results in a zero score");
        System.out.println("4. Player 2 starts the game and tries to beat the score of Player 1");
        System.out.println("5. In case of a tie, check the number of turns(player with lesser turns is winner)");
        System.out.println("Show the winner of the game.");
    }

    private void line() {
        System.out.println(
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void createGame() {
        p1 = new Player();
        p2 = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 To Start Game And 0 For Exit : ");
        // to stop or start game
        if (sc.nextInt() == 0)
            return;

        System.out.println("Enter Player 1 Name : ");
        p1.setName(sc.next());
        System.out.println("Enter Player 2 Name : ");
        p2.setName(sc.next());
        startGame();
    }

    private void startGame() {
        line();
        // for player 1
        System.out.println("Player : " + p1.getName());
        Scanner sc = new Scanner(System.in);
        int tempInp;
        do {
            System.out.println("Enter 1 to open the book : ");
            tempInp = sc.nextInt();
            if (tempInp == 1) {
                // book opened
                tempInp = (int) (Math.random() * 300);// as random returns value between 0.00 t0 1.00
                System.out.print("Page Number " + tempInp + "      ");
                tempInp %= 7;
                p1.setScore(tempInp + p1.getScore());
                p1.setRounds(p1.getRounds() + 1);
                System.out.print("Point : " + tempInp + "      ");
                System.out.println("Score " + p1.getScore());
            }

        } while (tempInp != 0);
        System.out.println(p1.getName() + " Total Score : " + p1.getScore());
        System.out.println(p1.getName() + " Takes " + p1.getRounds() + " rounds\n\n");

        // for player 2
        System.out.println("Player : " + p2.getName() + " Needs " + (p1.getScore() + 1) + " Score In " + p1.getRounds()
                + " Rounds To Win MATCH");
        int roundsLeft = p1.getRounds();
        do {
            System.out.println("Enter 1 to open the book : ");
            tempInp = sc.nextInt();
            if (tempInp == 1) {
                roundsLeft--;
                // book opened
                tempInp = (int) (Math.random() * 300);// as random returns value between 0.00 t0 1.00
                System.out.print("Page Number " + tempInp + "      ");
                tempInp %= 7;
                p2.setScore(tempInp + p2.getScore());
                p2.setRounds(p2.getRounds() + 1);
                System.out.print("Point : " + tempInp + "      ");
                System.out.print("Score " + p2.getScore() + "      ");
                System.out.println("Rounds Left : " + roundsLeft);
                if (p2.getScore() >= p1.getScore()) {
                    // surely p2 wins
                    if (roundsLeft != 0) {
                        System.out.println(p2.getName() + " Win Match !! ");
                    }
                    break;
                }
                if (roundsLeft == 0 || tempInp == 0) {
                    System.out.println(p1.getName() + " Win Match !! ");
                }
            }
        } while (roundsLeft > 0);
        line();
        createGame();

    }

    public static void main(String[] args) {
        BookCricketgame game = new BookCricketgame();
        game.welcome();
        game.rules();
        game.createGame();
    }
}
