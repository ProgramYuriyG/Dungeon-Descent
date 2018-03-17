import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import java.util.Scanner;

import static GUI.Visuals.*;

public class StartFile {

    public static boolean beginJourney = false;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[]args) {

        BeginSession();
        Texture no = QuickLoad("No");
        Texture yes = QuickLoad("Yes");
        while(!Display.isCloseRequested()){

            DrawQuadTex(no, 200, 700, 400, 180);
            DrawQuadTex(yes, 700, 700, 400, 180);

            Display.update();
            Display.sync(60);
        }

        //destroy the window once the window is prompted to close
        Display.destroy();

        //if its their first time continue with the story, if not then initiate the dungeon.
        System.out.println("Is this your first time playing?");
        String firstTime = input.next();
        firstTime = firstTime.toLowerCase();
        if (firstTime.equals("no")) {
            BeginJourney journey = new BeginJourney();
            journey.Journey();
        }else{
            FirstTime();
        }
    }

    public static void FirstTime(){
        //have all of the text be centered going down the screen as if it was being typed out
        System.out.println();
        Sleep.Sleep(500);
        System.out.println("What do we have here?");
        //wait 2 seconds
        Sleep.Sleep(1000);
        System.out.print("An adventurer");
        //wait "..."
        for(int x=0;x<3;x++) {
            Sleep.Sleep(500);
            System.out.print(".");
        }
        Sleep.Sleep(1000);
        System.out.println("\nLooking to prove their worth?");
        //wait
        Sleep.Sleep(1500);
        System.out.println("Then enter the dungeon.");
        //wait
        Sleep.Sleep(1500);
        //have these show up as shivering italics like hes provoking and have a sense of malice
        System.out.print("\nI");
        //wait a half second before the next text
        Sleep.Sleep(1500);
        System.out.print(" DARE");
        //wait a half second before the next text
        Sleep.Sleep(1500);
        System.out.print(" YOU");
        Sleep.Sleep(2500);
        System.out.println();

        //Starts the title screen

        //adds a new player
        Person player = new Person();
        player.getInfo();

        Sleep.Sleep(2000);
        System.out.println("\nDo you wish to begin your journey?");
        //yes or no
        System.out.println("yes or no");
        String vote = input.next();
        vote = vote.toLowerCase();
        System.out.println();

        beginJourney = (vote.equals("yes"))?true:false;
        BeginJourney journey = new BeginJourney();
        if(beginJourney == true){
            //starts the dungeon if they say yes
            journey.Journey(player);
        }else{
            //make dialogue to banter with the player until they say yes, keep blocking the button if they say no
            BanterDialogue banter = new BanterDialogue();
            banter.Banter(player.getRace());
            //gives the user the weapon if they opted for it first
            journey.Journey(player);
        }
    }
}
