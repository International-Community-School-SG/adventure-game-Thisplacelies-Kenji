import java.util.ArrayList;

public class Inventory{
  
    /**
     * The list of items in the Inventory
     */
    ArrayList<Item> items = new ArrayList<Item>();
  
    /**
     * Creates an Inventory given an ArrayList of items
     */
    public Inventory(ArrayList<Item> myItems){
    
        for(Item thing : myItems) {
        	items.add(thing);
        }
    
    }
    
    /**
     * Creates an Inventory given an item
     */
    public Inventory(Item thing){
    
        items.add(thing);
    
    }
    
    /**
     * Creates an empty Inventory
     */
    
    public Inventory(){
    // Leave inventory empty
    
    }
    
    
    /**
     * Creates an Inventory given a List of items
     */
    public Inventory(Item[] things){
        for(Item thing : things) {
          items.add(thing);
        }
    }
    
    /**
     * String is the string of all items in the inventory
     */
    public String toString(){
        String res = "";
        for(Item i : items){
            res += i.toString() + "\n";
        }
        
        return res;
    }
    
    /**
     * Adds the item to the inventory
     *
     * @param item - the item to add
     */
    public void addItem(Item item){
        items.add(item);
    }
    
    /**
     * Looks for the item in the inventory
     * 
     * @param name - the name of the item you are looking for
     * 
     * @return the item if it exists, otherwise null
     */
    public Item getItem(String name){
    
        for(Item i: items){
            if (name.equals(i.getName())){
                return i;
            }
        }
        return null;
    }
    
    /**
     * Checks if the item exists in the inventory
     *
     * @param name - the name of the item you are looking for
     * 
     * @return true if it exists, otherwise null
     */
    public boolean hasItem(String name){
    
        for(Item i: items){
            if(name.equals(i.getName())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the item exists in the inventory
     * 
     * looks based off of the name of the item and not the other attributes
     *
     * @param item - the item you are looking for
     * 
     * @return true if it exists, otherwise null
     */
    public boolean hasItem(Item item){
        return hasItem(item.getName());
    }
    
    /**
     * Removes the item from the inventory
     *
     * @param item - the item you are removing 
     * 
     * @return the item if it exists, otherwise null
     */
    public Item removeItem(Item item){
        return removeItem(item.getName());
    
    }
    
    /**
     * Removes the item from the inventory
     *
     * @param name - the name of the item you are removing 
     * 
     * @return the item if it exists, otherwise null
     */
    public Item removeItem(String name){
        for(Item i: items){
            if(name.equals(i.getName())){
                items.remove(i);
                return i;
            }
        }
        return null;
    }
}