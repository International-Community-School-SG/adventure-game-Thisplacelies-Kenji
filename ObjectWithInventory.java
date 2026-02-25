public class ObjectWithInventory{
	//Parent class for anything that needs to be able to have an inventory of items
	
	/**
	 * The inventory of items
	 */
	public Inventory inventory = new Inventory();

	/**
	 * Adds an item to the inventory
	 * 
	 * @param item - the item to be added
	 */
	public void addItem(Item item) {
		inventory.addItem(item);
	}
	
	/**
	 * Looks through the words to see if any of them match any of the items in the inventory
	 * 
	 * @param words - a list of all the words entered by the player
	 * 
	 * @return - the item if it exists in the inventory, otherwise null
	 */
	public Item getItem(String[] words){
		// words is a list of all the words the user entered
        // getItem goes through the words and checks if one of the words is an item in the inventory
        // If so, it returns the item
        // Otherwise it returns null
		
		for(String w : words) {
			if (hasItem(w)) {
				return inventory.getItem(w);
			}
		}
		return null;
	}
	
	/**
	 * Check if the given item name is in the inventory
	 * 
	 * @param name - the name of the item you are looking for
	 * 
	 * @return whether you have the item.
	 */
	public boolean hasItem(String name) {
		return inventory.hasItem(name);
	}
	
	/**
	 * Removes the item from the inventory
	 * 
	 * @param name - the name of the item
	 * 
	 * @return the item
	 */
	public Item removeItem(String name) {
		return inventory.removeItem(name);
	}
	
	/**
	 * Removes the item from the inventory
	 * 
	 * @param item - the name of the item
	 * 
	 * @return the item
	 */
	public Item removeItem(Item item) {
		return inventory.removeItem(item);
	}
	
	/**
	 * Overrides the current inventory with a new one
	 * 
	 * @param inv - a new Inventory object
	 */
	public void setInventory(Inventory inv) {
		inventory = inv;
	}
}