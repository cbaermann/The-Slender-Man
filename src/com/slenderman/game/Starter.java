package com.slenderman.game;

import com.slenderman.actors.SlenderMan;
import com.slenderman.musicplayer.SimplePlayer;
import java.util.Scanner;






/**
 * Starter instantiates the Game class and begins the game. Nothing but code needed to start the
 * game should be in this class. It should be very small.
 */
public class Starter {

  public static void main(String[] args) throws InterruptedException {

    Game game = new Game();
    new Console(game);
    Scanner scanme = new Scanner(System.in);
    game.gameOptions(scanme);

//    Thread thread1 = new Thread(){
//      public void run(){
//        Game game = new Game();
//        new Console(game);
//        Scanner scanMe = new Scanner(System.in);
//        try {
////          game.start(scanMe);
//          game.gameOptions(scanMe);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//      }
//    };
//

//    Thread thread2 = new Thread(() -> {
//      try {
//        Thread.sleep(1500);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      while(!SlenderMan.isGameDone) {
//        SimplePlayer player = new SimplePlayer("Paranormal_Lullaby.mp3");
//      }
//    });
//
//    Thread thread3 = new Thread(() -> {
//      try {
//        Thread.sleep(1500);
//        while (!SlenderMan.isGameDone) {
//          Thread.sleep(60000);
//          SimplePlayer player = new SimplePlayer("Scream.mp3");
//        }
//        } catch(InterruptedException e){
//          e.printStackTrace();
//        }
//    });

//    thread1.start();
//    thread2.start();
//    thread3.start();
  }

}




