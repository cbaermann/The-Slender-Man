package com.slenderman.game;

import com.slenderman.scenes.*;
import com.slenderman.actors.Player;
import com.slenderman.tools.LoseGameTimer;
import java.util.Scanner;



/**
 * Game is the class where we will build out the logic for the actual game.
 * Essentially, this is the place where everything comes together to create
 * the game.
 *
 * This class will be instantiated in the Starter class' Main method to
 * actually start the game
 *
 */
public final class Game {


  private Scene currentScene;
  private Scene aAbandonedCar;
  private Scene aHouse;
  private Scene aOutHouse;
  private Scene aForest;
  private Shed aShed;
  private Scene aTree;
  private Scene aPond;
  private Scene aCave;
  private Scene aField;


  private Player Player;


  public Game() {
    Player = new Player();

    aForest = new Forest();
    aShed = new Shed();
    aAbandonedCar = new AbandonedCar();
    aField = new Field();
    aTree = new Tree();
    aPond = new Pond();
    aCave = new Cave();
    aOutHouse = new OutHouse();
    aHouse = new House();

    aForest.connectSouth(aShed);
    aForest.connectEast(aHouse);

    aAbandonedCar.connectEast(aOutHouse);
    aOutHouse.connectSouth(aPond);
    aHouse.connectEast(aAbandonedCar);
    aHouse.connectSouth(aCave);

    aShed.connectEast(aCave);
    aCave.connectEast(aPond);
    aPond.connectEast(aField);
    aField.connectEast(aTree);
  }



  public void start(Scanner in) throws InterruptedException {
    String userText = "";

    new LoseGameTimer(1);
    Introduction.playIntro();

    currentScene = aForest;
    currentScene.enter(in, Player);

    while (!userText.equals("quit")) {
      userText = in.nextLine().toLowerCase().trim();

      if (userText.equals("quit")) {
        System.out.println("Goodbye!");
        break;
      }

      else if (userText.startsWith("go ")) {
        currentScene = currentScene.changeScene(userText.substring(3));
        currentScene.enter(in, Player);
      }

      else {
        System.out.println("Unknown command '" + userText + "'.  Try go/take/quit.\n");
      }

      if (currentScene == aTree) {
        Thread.sleep(2000);
        System.out.println("You have killed SlenderMan\n");
        Thread.sleep(5000);
        System.out.println("You Win!");
        System.out.println("Thanks for playing!");
        Thread.sleep(5000);
        System.exit(0);
      }
    }
  }
  // Unit testing purpose
  public Scene getCurrentScene() {
    return currentScene;
  }
}
