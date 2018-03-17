import java.util.Scanner;

//The player class
public class Person {
    /*
    date created
    class
    race
    health
    mana
    name
     */

    //private variables
    private Scanner input = new Scanner(System.in);
    //gets the date
    private java.util.Date dateSet = new java.util.Date();
    //list of races
    private String[] race = {"Human", "Elf", "Dwarf"};
    //health and mana corresponding to the race
    private int [] raceHealth = {10, 8, 12};
    private int [] raceMana = {10, 12, 8};
    //the variables that will be used and defined by the setters.
    private int health;
    private int mana;
    private String dateCreated;
    private String name;
    private String raceChosen;
    private String gender;


    //creates a new person and sets the date, name, gender, race, health, and mana.
    public Person() {
        setDate();
        setName();
        setGender();
        setRace();
        setHealthAndMana(raceChosen);

    }

    //sets the date the player was created
    private void setDate(){
        //date created
        dateCreated = dateSet.toString().substring(0, 10);
    }

    //gets the date the player was created
    private String getDate() {
        return dateCreated;
    }

    //sets the name of the player by asking them for their name
    private void setName() {
        //name
        System.out.println("\nWhat is your name?");
        String newName = input.nextLine();

        name = newName;
    }

    //gets the name of the player
    public String getName() {
    return name;
    }

    //sets the gender of the player (can be anything but the defaults are male or female)
    private void setGender(){
    System.out.println("Are you a male or female?");
    String newGender;
    //checks to see if the input is male or female
    int y = 0;
    do{
        if(y>0){
            System.out.println("That gender is not recognized in the dungeon.");
            System.out.println("Male or Female?");
        }
        newGender = input.next();
        newGender = newGender.toLowerCase();
        String empty = input.nextLine();
        y++;
    }while(!(newGender.equals("male"))&&!(newGender.equals("female")));

    newGender = (newGender.substring(0,1)).toUpperCase() + newGender.substring(1);

    gender = newGender;
    }

    //gets the gender of the player
    public String getGender(){
    return gender;
    }

    //sets the race of the player
    private void setRace() {
        //race chosen
        System.out.println("Choose your race.");
        String newRaceChosen = "";

        //if the race does not align with one of the givens then keep asking
        int y = 0;
        while (y == 0) {

            System.out.println("Human, Elf, or Dwarf");
            newRaceChosen = input.nextLine();
            newRaceChosen = newRaceChosen.toLowerCase();
            newRaceChosen = (newRaceChosen.substring(0,1)).toUpperCase() + newRaceChosen.substring(1);

            for (int x = 0; x < race.length; x++) {
                if (newRaceChosen.equals(race[x])) {
                    y = 1;
                    break;
                }
            }

            if (y == 0) {
                System.out.println("That race is not recognized in the dungeon. Please choose one of the races.");
            }

        }
    raceChosen = newRaceChosen;
    }

    //gets the race of the player
    public String getRace() {

    return raceChosen;
    }

    //sets the health and mana of the player according to race
    private void setHealthAndMana(String raceChosen){

        for(int x = 0; x< race.length;x++){
            if(raceChosen.equals(race[x])){
                health = raceHealth[x];
                mana = raceMana[x];
                break;
            }
        }
    }

    //sets the player's new health
    public void setHealth(int newHealth){
        health = newHealth;
    }

    //sets the player's new mana
    public void setMana(int newMana){
        mana = newMana;
    }

    //gets the player's health
    public int getHealth(){
    return health;
    }

    //gets the player's mana
    public int getMana(){
    return mana;
    }

    //gets all of the info on the player
    public void getInfo() {
        //Info
        System.out.println("\nCreated on " + getDate() + "\nName: " + getName() + "\nGender: " + getGender() + "\nRace: " + getRace()
                + "\nHealth: " + getHealth() + "\nMana: " + getMana() );
    }

    public void getInfo(Person player) {
        //Info
        System.out.println("\nCreated on " + player.getDate() + "\nName: " + player.getName() + "\nGender: " + player.getGender() + "\nRace: " + player.getRace()
                + "\nHealth: " + player.getHealth() + "\nMana: " + player.getMana() );
    }

    public void getGameInfo(Person player) {
        System.out.println("\n" + player.getName() + "\nHealth: " + player.getHealth() + "\nMana: " + player.getMana() );
    }
}

