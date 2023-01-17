package assignments.PlayPig.PlayPigMultiplayer;

import java.util.Scanner;

public class PlayPigMultiplayer {
    public int rollDice() {
        int die = 1 + (int) (Math.random() * 5);
        System.out.println("Die: " + die);
        return die;
    }

    private void line() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
    }

    private void welcome() {
        System.out.print(
                "Let's Play PIG!\n* See how many turns it takes you to get to 20.\n* Turn ends when you hold or roll a 1.\n* If you roll a 1, you lose all points for the turn.\n* If you hold, you save all points for the turn.\n\n");
    }

    public void showResult(Pig[] players, int n) {
        line();
        System.out.println("~~~~~~~~~~~~~~~~~~~~Now See the Results~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (players[i].getTurns() > players[j].getTurns()) {
                    Pig temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                } else if (players[i].getTurns() == players[j].getTurns()) {
                    if (players[i].getTotalScore() < players[j].getTotalScore()) {
                        Pig temp = players[i];
                        players[i] = players[j];
                        players[j] = temp;
                    }
                }
            }
        }
        System.out.println("Our Winner is ***" + players[0].getName() + "***");
        for (int i = 0; i < n; i++) {
            System.out.print("Rank : " + (i + 1) + " " + players[i].getName() + " ");
            if (i < 3) {
                for (int j = 0; j < (3 - i); j++) {
                    System.out.print("*");
                }
            }
            System.out.print("   turns : " + players[i].getTurns() + "  score : " + players[i].getTotalScore() + "\n");
        }
    }

    public void PlayPig(Pig pig) {
        line();
        System.out.println("welcome " + pig.getName() + "!!!");
        Scanner sc = new Scanner(System.in);
        int turn = 0;
        do {
            int tempScore = 0;
            turn++;
            System.out.println("TURN " + turn);
            do {
                System.out.println("Roll or hold? (r/h): ");
                char c = sc.next().charAt(0);
                if (c == 'r') {
                    int tempRoll = rollDice();
                    if (tempRoll == 1) {
                        System.out.println("Turn Over. No Score");
                        break;
                    }
                    tempScore += tempRoll;
                } else if (c == 'h') {
                    System.out.println("Score for turn: " + tempScore);
                    pig.setTotalScore(pig.getTotalScore() + tempScore);
                    pig.setTurns(turn);
                    System.out.println("total score: " + pig.getTotalScore());
                    break;
                } else {
                    System.out.println("Wrong input!(enter r/h)");
                }
            } while (true);

        } while (pig.getTotalScore() < 20);
        if (pig.getTotalScore() >= 20) {
            System.out.println(pig.getName() + " finished in " + pig.getTurns() + " turns!\n");
        }
        line();
    }

    public void setName(Pig pig, int pos) {
        System.out.println("Enter name of Player " + pos + " : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        pig.setName(name);
    }

    public void start() {
        line();
        line();
        welcome();
        System.out.println("Enter No of Players(it should be >=2)");
        Scanner sc = new Scanner(System.in);
        int pCounts = sc.nextInt();
        // creating users
        Pig[] players = new Pig[pCounts];
        // initialize players
        for (int i = 0; i < pCounts; i++) {
            players[i] = new Pig();
        }
        // set the names of the players
        for (int i = 0; i < pCounts; i++) {
            setName(players[i], i + 1);
        }
        line();
        // play one by one
        for (int i = 0; i < pCounts; i++) {
            PlayPig(players[i]);
        }
        showResult(players, pCounts);
        line();
        line();
    }

    public static void main(String[] args) {
        //you can add multiple players (2 or more)
        PlayPigMultiplayer game = new PlayPigMultiplayer();
        game.start();
    }
}
