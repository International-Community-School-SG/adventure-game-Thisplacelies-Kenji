public class Item{
    
    /**
     * The name of the Item (should be in all CAPS to match rest of code)
     */
    private String name;  
    /**
     * The description of the item
     */
    private String description;  
    /**
     * The weight of the item (this is optional if you want it)
     */
    private int weight;   
    
    /**
     * You may want to add more attributes for your items based on the functionality needed
     */
    
    
    /**
     * Creates an item with the given information
     * 
     * @param myName - the name
     * @param myDescription - the description
     * @param myWeight - the weight
     */
    public Item(String myName, String myDescription, int myWeight){
        
        name = myName;
        description = myDescription;
        setWeight(myWeight);
    }
    
    /**
     * Creates an item with the given information
     * 
     * @param myName - the name
     * @param myDescription - the description
     * 
     */
    public Item(String myName, String myDescription){
        name = myName;
        description = myDescription;
        setWeight(0);
    }
    
    /**
     * The string is the name and description.
     */
    public String toString(){
        return name + "\n" + description;
    }
    
    public int getWeight() {
    	return weight;
    }
    
    public void setWeight(int weight) {
    	this.weight = weight;
    }
    
    public String getName() {
    	return name;
    }
    
}