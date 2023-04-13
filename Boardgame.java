import java.util.*; 
public class Boardgame implements Contract{ 
    
    private ArrayList<String> players;  
    private ArrayList<String> games; 
    String guest; 
    String game; 
    Boolean forward; 
    Boolean backwards; 
    Number nGames; 
    Double time; 

    public Boardgame(ArrayList players, ArrayList games, String game, Boolean forward,
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
     * stores item (boardgame in this case) that is being grabbed to play
     */
    public void grab(String item){
        if (this.games.contains(item)) {
            throw new RuntimeException("This boardgame is already apart of your game night!!")
        }
        if (!this.games.contains(item)){
            this.games.add(item); 
        }
        
    }

    /**
     * Drops a game from someone's collection if they dno longer want to play this and returns the string version of that list. 
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
     * assigns that the current game being played/examine is the item 
     */
    public void examine(String item){
        this.game = item; 
    }

    /**
     * removes a game from the current inventory of games when one is currently being used. 
     */
    public void use(String item){
        this.games.remove(item); 
    }

    /**
     * if walking is forward thaen returns true but if going backwards then returns false (in the boardgame)
     */
    public boolean walk(String direction){
        if (this.forward) {
            return true; 
        }

        return false; 
    }

    /**
     * if this a boardgame where you fly a little plan, if it goes less than one feet in the air and or less than one feet across then it did not fly successfully. 
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
     * returns the number of games after you shrink the collection of your boardgames to 0. 
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
            throw new RuntimeException("You picked a military time that doesn't exist!! Please use a valid time!")
        }
        if(this.time >= 23){
            System.out.println("It is time to go home and rest! Game night is unfortunately over :()")
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
            System.out.println("Oh no! It looks like a guest was not recording any games. Do not worry! We have added them to the list of players.")
        }
    }



}