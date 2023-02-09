package com.monocept.test;

import java.util.Scanner;

public class PlayPig {
	int turn = 0;
    Pig pig = new Pig();
    
    public int rollDice() {
        int die = 1 + (int) (Math.random() * 5);
        System.out.println("Die: " + die);
        return die;
    }

    private void welcome() {
        System.out.print(
                "Let's Play PIG!\n* See how many turns it takes you to get to 20.\n* Turn ends when you hold or roll a 1.\n* If you roll a 1, you lose all points for the turn.\n* If you hold, you save all points for the turn.\n\n");
    }
    private int dessionOnRollHold() {
    	int tempScore=0;
    	System.out.println("Roll or hold? (r/h): ");
        Scanner sc = new Scanner(System.in);
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
    	return tempScore;
    }
    private void rollHold() {
    	int tempScore = 0;
    	do {
            tempScore=dessionOnRollHold();
            
        } while (true);
    }
    public void start() {
    	turn=0;
        welcome();
        do {
            turn++;
            System.out.println("TURN " + turn);
            rollHold();

        } while (pig.getTotalScore() < 20);
        if (pig.getTotalScore() >= 20) {
            System.out.print("You finished in " + pig.getTurns() + " turns!\nGame over!");
        }
    }

    public static void main(String[] args) {
        PlayPig game = new PlayPig();
        game.start();
    }
}
