import java.util.Scanner;

//The banter dialogue for if the user says no
public class BanterDialogue{
    //their journey does not begin until beginJourney is true
    public static boolean beginJourney = false;
    private Scanner input = new Scanner(System.in);

    //gives the user a weapon if they make it to the end but takes it away near the beginning of the journey
    public void Banter(String race){
        Sleep.Sleep(1000);
        System.out.println("Welcome to...");
        StartBanter(race);
    }

    //continues the banter until the user finally says yes
    private void StartBanter(String race){
        //wait a second
        Sleep.Sleep(1000);
        System.out.print("wait");
        for(int x=0;x<3;x++) {
            Sleep.Sleep(400);
            System.out.print(".");
        }
        Sleep.Sleep(1000);
        System.out.print("no? ");
        Sleep.Sleep(1000);
        System.out.print("You just said no?\n");
        //wait a second
        Sleep.Sleep(1500);
        System.out.println("Who do you think you're saying no to?");
        //wait a second
        Sleep.Sleep(2000);
        System.out.println("You will say yes this instant and enter that dungeon!");
        //checks to see if the user said yes
        checkVote();
        if(beginJourney){
            return;
        }

        Sleep.Sleep(1000);
        System.out.println("Insolent " + race.toLowerCase() + " brat, how dare you defy me.");
        //wait
        Sleep.Sleep(1500);
        System.out.println("You shall know my wrath!");
        Sleep.Sleep(2000);
        System.out.println("I will give you a weapon to begin your journey if you say yes.");
        Sleep.Sleep(1500);
        System.out.println("How does that sound puny "+ race.toLowerCase() +"?");
        //checks to see if the user said yes
        checkVote();
        if(beginJourney){
            System.out.println("Wonderful, I hope you have fun in the dungeon.");
            //sound effects of laughing
            return;
        }
        Sleep.Sleep(1000);
        System.out.println("Well then, I guess you'll have to enter the dungeon without anything, now have fun down there pathetic " + race.toLowerCase() + ".");
        Sleep.Sleep(500);
    }

    //method to check if the user has said yes
    private void checkVote(){
        String vote = input.next();
        System.out.println();
        beginJourney = (vote.equals("yes"))?true:false;

    }
}
