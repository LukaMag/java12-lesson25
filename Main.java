package CLASSWORK25;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        Scanner sc = new Scanner(System.in);
        int scoreWins = 0;
        int scoreLoses = 0;
        int times = 0;
        int[] scores = {scoreWins,scoreLoses,times};
        int[] raspings = chooseRasping();
        for(int i = 0; i < 5; i++) {
            raspings = chooseRasping();
            scores = action(raspings[0], raspings[1], scores);
        }
        while(true){
            System.out.print("Do you want to replay again? 1 - YES, any other number - NO");
            int answer = sc.nextInt();
            if(answer == 1){
                raspings = chooseRasping();
                scores = action(raspings[0], raspings[1], scores);
                continue;
            }else{
                double percentage = percentageCount(scores);
                statistics(scores,percentage);
                break;
            }
        }

    }

    static int isCapableRasping(int raspingNum) throws InputMismatchException {
        if (raspingNum > 0 && raspingNum < 4) {
            return raspingNum;
        } else {
            throw new InputMismatchException("Choose correct number of rasping!!!");
        }
    }
    static double percentageCount(int[] scores){
        double percentage = (scores[0]*100)/scores[2];
        return percentage;
    }

    static void statistics(int[] scores,double percentage){
        int ties = scores[2] - scores[0] -scores[1];
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| Wins | Loses | Ties | Total games | Wins percentage |");
        System.out.println(String.format("|\t %d |\t  %d |\t %d |\t\t %d | \t %f",scores[0],scores[1],ties,scores[2],percentage));
        System.out.println("+-----------------------------------------------------+");
    }
    static int[] action(int userNum, int compNum,int[] scores) {
        Game userRasping = null;
        Game compRasping = null;
        int generalScore = 0;
        Game[] rasping = {Game.ROCK, Game.PAPER, Game.SCISSORS};
        for (int i = 0; i < rasping.length; i++) {
            if (rasping[i].getId() == userNum) {
                userRasping = rasping[i];
            }
        }for (int j = 0; j < rasping.length; j++) {
            if (rasping[j].getId() == compNum) {
                compRasping = rasping[j];
            }
        }
        generalScore = userRasping.winnerIs(compRasping);
        if(generalScore == 1){
            scores[0]+=1;
        }if(generalScore == -1){
            scores[1] +=1;
        }
        scores[2]+=1;
        return scores;
    }

    static int[] chooseRasping() {
        int[] raspings = new int[2];
        int raspingNum = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1 - To choose Rock");
                System.out.println("2 - To choose Paper");
                System.out.println("3 - To choose Scissors");
                System.out.print("Choose a rasping:");
                raspingNum = sc.nextInt();
                isCapableRasping(raspingNum);
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        int rndRasping = r.nextInt(3) + 1;
        raspings[0] = raspingNum;
        raspings[1] = rndRasping;
        return raspings;
    }


}
