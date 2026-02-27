import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class World{
    
    /**
     * A Map is a fancy form of ArrayList where the indexes are not integers, but rather any datatype you choose
     * 
     * In this case, rooms is a mapping from a String to a Room object
     * 
     * This will store all of the rooms in your world.
     */
    public Map<String,Room> rooms = new HashMap<String,Room>();
    
    /**
     * The room that the player will start in.
     */
    public Room start;
    
    /**
     * Upon initialization of the class, all the Rooms are created.
     */
    public World() {
        initializeRooms();
    }

    /**
     * The whole world is created here.
     * 
     * If the world is complicated enough, it might be reasonable to have different methods for different levels
     */
    public void initializeRooms() {
        /**
         * An arraylist of items that will be added to each room, needs to be reset for each room.
         */
        ArrayList<Item> stuff = new ArrayList<Item>();
        
        /**
         * Room 1 - This is a basic starter room
         * 
         * Contains two items, THING1 & THING2
         */
         
        // Creating a room requires first creating all items in that room and adding them to stuff.
        stuff.add(new Item("THING1","Red with a 1 in a white circle."));
        stuff.add(new Item("THING2","Red with a 2 in a white circle."));
        
        // Now we create the room.
        rooms.put("ROOM1",new Room("ROOM1","This is where it starts.",new Inventory(stuff)));

        /**
         * ROOM2
         * 
         * Contains THING3
         */
        stuff.clear();  // This is important to reset the items for each room.
        stuff.add(new Item("THING3","Red with a 3 in a white circle."));
        
        rooms.put("ROOM2",new Room("ROOM2","This is the next room.",new Inventory(stuff)));
        
        
        /**
         * ROOM3
         * 
         * Contains nothing.
         */
        stuff.clear();
        rooms.put("ROOM3",new Room("ROOM3","This room has no items.",new Inventory(stuff)));

        /**
         * ROOM4
         * 
         * Contains a ROCK.
         */
        stuff.clear();
        stuff.add(new Item("ROCK", "A small, ordinary-looking rock."));
        rooms.put("ROOM4", new Room("ROOM4", "This is room 4. There is a rock here.", new Inventory(stuff)));
        
        /**
         * Once all the rooms are created, we need to also add connections between all rooms
         */
        addConnections("ROOM1","ROOM2", 'N');        // by default this will add a connection both ways
        addConnections("ROOM2","ROOM3", 'N', false); // now the player will be stuck in room 3

        // ROOM4 is to the EAST of ROOM1 (and back WEST from ROOM4 to ROOM1)
        addConnections("ROOM1", "ROOM4", 'E');
        
        // Be sure to set the start room!  Replace ROOM1 with your room names.
        start = rooms.get("ROOM1");
    }
    
    /**
     * Adds a connection between two rooms.
     * 
     * @param from  the name of the first room
     * @param to    the name of the second room
     * @param dir   the direction traveled to get from the first room to the second room
     * @param both  should the connection also be created in the other direction?
     */
    public void addConnections(String from, String to, char dir, boolean both) {
        Room From = rooms.get(from);
        Room To = rooms.get(to);
        
        From.addConnection(dir,To);
        
        /**
         * A map to find the opposite direction for a given direction
         * 
         * Needs to be COMPLETED with the other directions
         */
        Map<Character,Character> opposite = new HashMap<Character,Character>();
        
        opposite.put('N', 'S');
        opposite.put('S', 'N');
        opposite.put('E', 'W');
        opposite.put('W', 'E');
        
        if(both) {
            To.addConnection(opposite.get(dir),From);
        }
        
    }
    
    /**
     * If the boolean is not given, the connection will be made in both directions.
     */
    public void addConnections(String from, String to, char dir) {
        // Allows a default of true for both directions connection
        
        addConnections(from, to, dir, true);
    }
}