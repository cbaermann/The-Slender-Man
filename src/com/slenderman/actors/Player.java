package com.slenderman.actors;

import java.util.*;

public class Player {
  private String state = "alive";
  private String currentSceneName = "forest";

  private List<Item> inventory = new ArrayList<>();


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Player() {
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addItemToInventory(Item... items) {
    inventory.addAll(Arrays.asList(items));
    for (Item item : items) {
      item.setCurrentScene(this.currentSceneName);
      inventory.add(item);

      System.out.printf("What a prize! You have added %s to your inventory.\n",
        item.getItemName());
    }
  }

  public void dropItemFromInventory(Item item) {
    Item returnableItem;
    if (inventory.contains(item)) {
      item.setCurrentScene(this.currentSceneName);

      int indexOfItem = inventory.indexOf(item);
      returnableItem = inventory.get(indexOfItem);

      inventory.remove(indexOfItem);

      System.out.printf("You dropped %s from your inventory.\n", returnableItem.getItemName());
    } else {
      System.out.println("It doesn't look like you have that item in your " +
                         "inventory.\n");
    }
  }

  /**
   * Changes the currentScene field for all items in inventory to Player's
   * current scene location
   */
  public void changeInvItemsLocation() {
    inventory.forEach(item -> item.setCurrentScene(this.currentSceneName));
  }

  /**
   * Changes the currentScene field for all items in inventory to sceneName
   * @param sceneName
   */
  public void changeInvItemsLocation(String sceneName) {
    inventory.forEach(item -> item.setCurrentScene(sceneName));
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS
  public void setState(String state) {
    this.state = state;
  }

  public void setInventory(List<Item> inventory) {
    this.inventory = inventory;
  }

  public void setCurrentSceneName(String currentSceneName) {
    this.currentSceneName = currentSceneName;
  }

  // GET METHODS
  public String getState() {
    return state;
  }

  public Collection<Item> getInventory() {
    return Collections.unmodifiableCollection(inventory);
  }

  public String getCurrentSceneName() {
    return currentSceneName;
  }

}
