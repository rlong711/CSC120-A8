import java.util.*; 
/**
 * This class implements the Contract class as its interface. It does a variety of things regarding when someone is hosting a game night. 
 */
public class Boardgame implements Contract{ 
    
    private ArrayList<String> players;  
    private ArrayList<String> games; 
    String guest; 
    String game; 
    Boolean forward; 
    Boolean backwards; 
    Number nGames; 
    Double time; 

    /**
     * Constructor for the Boardgame class. 
     * @param players A list of the players during game night. 
     * @param games A list of the current boardgames inventory. 
     * @param guest A guest at the boardgame night. 
     * @param game The current game being played. 
     * @param forward If the direction of the game is going forward or not.
     * @param backwards if the direction of the game is going backwards.
     * @param nGames The number of games in the host's inventory of games. 
     * @param time The current time during game night. 
     */
    public Boardgame(ArrayList<String> players, ArrayList<String> games, String game, Boolean forward,
    Boolean backwards, Number nGames, Double time, String guest){
        this.players = new ArrayList<String>();  
        this.games = new ArrayList<String>(); 
        this.game = game; 
        this.forward = forward; 
        this.backwards = backwards; 
        this.nGames = nGames; 
        this.time = time; 
        this.guest = guest; 
    }

    
    /**
     * Method that stores item (boardgame in this case) that was already grabbed to play.
     * @param item The item in this case the boardgame that is being grabbed/updated in the inventory. 
     */
    public void grab(String item){
        if (this.games.contains(item)) {
            throw new RuntimeException("This boardgame is already apart of your game night!!"); 
        }
        if (!this.games.contains(item)){
            this.games.add(item); 
        }
        
    }

    /**
     * Drops a game from someone's collection if they dno longer want to play this and returns the string version of the current inventory of boardgames list.
     * @param item The boardgame that is being dropped from the inventory. 
     * @return The String version of the array list of the current inventory of boardgames.  
     */
    public String drop(String item){
        if (!this.games.contains(item)){
            throw new RuntimeException("This board game is not a part of your collection!"); 
        }
        if (this.games.contains(item)){
           this.games.remove(item); 
           System.out.println("I am so sorry you don't want this game anymore and want to drop it! Give it to me, I love Board Games.");  
        }
       String gamesString = String.join(", ", this.games);  
       return gamesString; 
    }

    /** 
     * Assigns that the current game being played/examined is the item. 
     * @param item The boardgame being used/played at boardgame night. 
     */
    public void examine(String item){
        this.game = item; 
    }

    /**
     * Removes a game from the current inventory of games when one is currently being used. 
     * @param item The boardgame being played right now
     */
    public void use(String item){
        this.games.remove(item); 
    }

    /**
     * If the 'walking' is forward in the game then this method returns true but if the boardgame 'walking' is going backwards then returns false (in the boardgame). 
     * @param direction The direction of the boardgame. 
     */
    public boolean walk(String direction){
        if (this.forward) {
            return true; 
        }

        return false; 
    }

    /**
     * This is for a boardgame where you fly a little plane/figurine. If it goes less than one feet in the air and or less than one feet across then it did not fly successfully. 
     */
    public boolean fly(int x, int y){
        if (y >= 1){
            return true; 
        }
        if (x >= 1){
            return true; 
        } 
        return false; 
    }

    /**
     * Returns the number of games after you shrink the collection of your boardgames to 0. 
     */
    public Number shrink(){
        this.nGames = 0; 
        this.games.clear(); 
        return this.nGames; 
    }

    /**
     * Grows the board collection by the item being added and then returns the new number of the board collection after the growth. 
     */
    public Number grow(){
        this.games.add(this.game); 
        return this.games.size(); 
    }

    /**
     * Depending on the time, it will tell us if it is time to go rest or to keep playing!
     */
    public void rest(){
        if(this.time > 24) {
            throw new RuntimeException("You picked a military time that doesn't exist!! Please use a valid time!");
        }
        if(this.time >= 23){
            System.out.println("It is time to go home and rest! Game night is unfortunately over :()");
        }
        if(this.time <= 23){
            System.out.println("Looks like the party can still keep going!!"); 
        }
    }

    /**
     * Will change the list of players depending on if a new guest has arrived. Will undo the mistake made of not adding them to the list of players. 
     */
    public void undo(){
        if (this.players.contains(this.guest)){
            System.out.println("Yay! This person is playing games and is an invited guest here at this party."); 
        }
        if (!this.players.contains(this.guest)){
            this.players.add(guest); 
            System.out.println("Oh no! It looks like a guest was not recording any games. Do not worry! We have added them to the list of players.");
        }
    }

    public static void main(String [] args){
    }



}