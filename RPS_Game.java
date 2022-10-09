import java.util.Random;
import java.util.Scanner;

public class RPS_Game {
    private static final String ROCK="Rock";
    private static final String PAPER="Paper";
    private static final String SCISSORS="Scissors";
    private static String playerMove="";
    private static boolean validInput=true;

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        startMenu();
        String input=scanner.nextLine();
        int winCounter=0;
        int loseCounter=0;
        int drawCounter=0;
        while (!input.equalsIgnoreCase("q")){
            inputCheck(input);
            if(validInput) {
                String computerMove = generateMove();
                System.out.printf("The computer chose %s.%n", computerMove);
                String result=resultCheck(playerMove,computerMove);
                System.out.println(result);
                if(result.equals("You win.")){
                    winCounter++;
                } else if(result.equals("You lose.")){
                    loseCounter++;
                } else{
                    drawCounter++;
                }
            }
            startMenu();
            input=scanner.nextLine();
        }
        System.out.printf("You have won %d games, lost %d games, and finished %d times without a winner.",winCounter,loseCounter,drawCounter);
    }
    public static void startMenu(){
        System.out.print("Choose [r]ock, [p]aper, [s]cissors ([q]uit): ");
    }
    public static void inputCheck(String inputChoice){
        if(inputChoice.equalsIgnoreCase("r") || inputChoice.equalsIgnoreCase("rock")){
            playerMove=ROCK;
            validInput=true;
        } else if(inputChoice.equalsIgnoreCase("p") || inputChoice.equalsIgnoreCase("paper")){
            playerMove= PAPER;
            validInput=true;
        } else if(inputChoice.equalsIgnoreCase("s") || inputChoice.equalsIgnoreCase("scissors")){
            playerMove=SCISSORS;
            validInput=true;
        } else {
            System.out.println("Invalid Input. Try Again...");
            validInput=false;
        }
    }
    public static String generateMove(){
        Random random=new Random();
        String move="";
        int index=random.nextInt(3);
        if(index==0){
            move=ROCK;
        } else if(index==1){
            move=PAPER;
        } else if(index==2){
            move=SCISSORS;
        }
        return move;
    }
    public static String resultCheck(String choseMove, String generatedMove){
        String result="";
        if(choseMove.equals(generatedMove)){
            result="This game was a draw.";
        } else if(choseMove.equals("Rock") && generatedMove.equals("Scissors") ||
                (choseMove.equals("Scissors") && generatedMove.equals("Paper")) ||
                (choseMove.equals("Paper") && generatedMove.equals("Rock"))){
            result="You win.";
        } else {
            result="You lose.";
        }
        return result;
    }
}
