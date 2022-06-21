package CLASSWORK25;

import java.sql.SQLOutput;
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
        int[] raspings = new int[2];
        int modeNum =0;
        while(true){
            try{
                System.out.println("1 - Hard mode");
                System.out.println("2 - Easy mode");
                System.out.print("Which mode do you want to play?");
                int mode = sc.nextInt();
                modeNum = isCapableMode(mode);
                break;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        if(modeNum == 2){
        int replaysNum = replaysTimes();
        for(int i = 0; i < replaysNum; i++) {
            raspings = chooseRasping();
            scores = EasyMode(raspings[0], raspings[1], scores);
        }
        while(true){
            System.out.print("Do you want to replay again? 1 - YES, any other number - NO");
            int answer = sc.nextInt();
            if(answer == 1){
                raspings = chooseRasping();
                scores = EasyMode(raspings[0], raspings[1], scores);
                continue;
            }else{
                double percentage = percentageCount(scores);
                statistics(scores,percentage);
                break;
            }
        }

    }if(modeNum == 1){
            int replaysNum = replaysTimes();
            for(int i = 0; i < replaysNum; i++) {
                raspings = chooseRasping("Hard");
                scores = HardMode(raspings[0], raspings[1], scores);
            }
            while(true){
                System.out.print("Do you want to replay again? 1 - YES, any other number - NO");
                int answer = sc.nextInt();
                if(answer == 1){
                    raspings = chooseRasping("Hard");
                    scores = HardMode(raspings[0], raspings[1], scores);
                    continue;
                }else{
                    double percentage = percentageCount(scores);
                    statistics(scores,percentage);
                    break;
                }
            }
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
    static int[] EasyMode(int userNum, int compNum, int[] scores) {
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
        while(true){
        try {
            generalScore = userRasping.winnerIs(compRasping);
            break;
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            continue;
        }
        }
        if(generalScore == 1){
            scores[0]+=1;
            System.out.println(String.format("User wins: total points %d and total games %d",scores[0],scores[2] + 1));
        }if(generalScore == -1){
            scores[1] +=1;
            System.out.println(String.format("Computer wins: total points %d and total games %d",scores[1],scores[2]+1));
        }if(generalScore == 0){
            System.out.println(String.format("Round ties : total games %d",scores[2]+1));
        }
        scores[2]+=1;
        return scores;
    }

    static int[] HardMode(int userNum, int compNum, int[] scores){
        Game userRasping = null;
        Game compRasping = null;
        int generalScore = 0;
        Game[] rasping = {Game.ROCK, Game.PAPER, Game.SCISSORS,Game.LIZARD,Game.SPOCK};
        for (int i = 0; i < rasping.length; i++) {
            if (rasping[i].getId() == userNum) {
                userRasping = rasping[i];
            }
        }for (int j = 0; j < rasping.length; j++) {
            if (rasping[j].getId() == compNum) {
                compRasping = rasping[j];
            }
        }
        while(true){
            try {
                generalScore = userRasping.winnerIs(compRasping);
                break;
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
                continue;
            }
        }

        if(generalScore == 1){

            scores[0]+=1;
            System.out.println(String.format("User wins: total points %d and total games %d",scores[0],scores[2] + 1));
        }if(generalScore == -1){
            scores[1] +=1;
            System.out.println(String.format("Computer wins: total points %d and total games %d",scores[1],scores[2]+1));
        }if(generalScore == 0){
            System.out.println(String.format("Round ties : total games %d",scores[2]+1));
        }
        scores[2]+=1;
        return scores;
    }


    static int[] chooseRasping() {
        int[] raspings = new int[2];
//        int raspingNum = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1 - To choose Rock");
                System.out.println("2 - To choose Paper");
                System.out.println("3 - To choose Scissors");
                System.out.print("Choose a rasping:");
                int raspingNum = sc.nextInt();
                isCapableRasping(raspingNum);
                raspings[0] = raspingNum;
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        int rndRasping = r.nextInt(3) + 1;
        raspings[1] = rndRasping;
        return raspings;
    }
    static int[] chooseRasping(String mode) {
        int[] raspings = new int[2];
//        int raspingNum = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1 - To choose Rock");
                System.out.println("2 - To choose Paper");
                System.out.println("3 - To choose Scissors");
                System.out.println("4 - To choose Lizard");
                System.out.println("5 - To choose Spock");
                System.out.print("Choose a rasping:");
                int raspingNum = sc.nextInt();
                isCapableRasping(raspingNum,"Hard");
                raspings[0] = raspingNum;
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        int rndRasping = r.nextInt(5) + 1;
        raspings[1] = rndRasping;
        return raspings;
    }


    static int isCapableRasping(int raspingNum) throws InputMismatchException {
        if (raspingNum > 0 && raspingNum < 4) {
            return raspingNum;
        } else {
            throw new InputMismatchException("Choose correct number of rasping!!!");
        }
    }
    static int isCapableRasping(int raspingNum,String mode) throws InputMismatchException {
        if (raspingNum > 0 && raspingNum < 6) {
            return raspingNum;
        } else {
            throw new InputMismatchException("Choose correct number of rasping!!!");
        }
    }
    static int isCapableReplays(int replays) throws InputMismatchException {
        if (replays > 0) {
            return replays;
        } else {
            throw new InputMismatchException("Choose correct number of replays!!!");
        }
    }
    static int isCapableMode(int mode){
        if(mode > 0 && mode < 3){
            return mode;
        }else{
            throw new InputMismatchException("Choose correct mode!!!");
        }
    }
    static int replaysTimes(){
        Scanner sc = new Scanner(System.in);
        int replaysNum = 0;
        while(true) {
            try {
                System.out.print("How many times do you to play:");
                int replays = sc.nextInt();
                replaysNum = isCapableReplays(replays);
                return replaysNum;
            }catch (InputMismatchException | NumberFormatException e ){
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
}
