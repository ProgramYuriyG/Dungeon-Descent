public class BeginJourney {

    public void Journey(){
        Person player = new Person();
        player.getInfo();
        Journey(player);
    }
    public void Journey(Person player){
        Sleep.Sleep(2000);
        System.out.println("\nWelcome");
        Sleep.Sleep(750);
        System.out.println("You have entered the dungeon.");
        //wait 2 seconds
        Sleep.Sleep(1000);
        System.out.println("If your health bar goes down to zero you cease to exist.");
        Sleep.Sleep(1500);
        System.out.println("Prepare yourself\n");

        //attack sequence
        Sleep.Sleep(2000);
        System.out.println("A mystical being shrouded in darkness appears before you.");
        Sleep.Sleep(1000);
        System.out.println("This dungeon does not take kindly to your people " + player.getRace().toLowerCase() + "!");
        Sleep.Sleep(2500);
        player.setHealth( 1 );
        player.getGameInfo(player);
    }
}
