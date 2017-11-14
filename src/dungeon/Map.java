package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map{
  private List<Vampire> vampireList;
  private Dungeon dungeon;
  private Player player;
  private Random random = new Random();

  public Map(Dungeon dungeon, Player player, int vampiresNumber) {
    this.vampireList = new ArrayList<Vampire>();
    for(int i=0; i<vampiresNumber; i++) {
      Vampire vampire = new Vampire(0, 0);
      do {
        vampire.setRandomVampirePosition(dungeon.getLength(), dungeon.getHeight());
      } while (checkIfVampireIsHere(vampire.getPositionX(), vampire.getPositionY()));

      this.vampireList.add(vampire);
    }
    this.dungeon = dungeon;
    this.player = player;
  }

  public void printPositions(){
    System.out.println("@ " + player.getPositionX() + " " + player.getPositionY());

    for (Vampire vampire : vampireList)
      System.out.println("v " + vampire.getPositionX() + " " + vampire.getPositionY());
  }

  public void printMap(){
    for (int j=0; j<dungeon.getHeight(); j++) {
      for (int i = 0; i <dungeon.getLength(); i++) {
        if (j == player.positionY && i == player.positionX)
          System.out.print("@");
        else if (checkIfVampireIsHere(i,j))
          System.out.print("v");
        else
          System.out.print(".");
      }
      System.out.println();
    }
  }

  public boolean checkIfVampireIsHere(int positionX, int positionY) {
    for (Vampire vampire : vampireList){
      if (vampire.getPositionX() == positionX && vampire.getPositionY() == positionY)
        return true;
    }
    return false;
  }

  public void moveVampires(){
      String directions = "wasd";

      for (Vampire vampire : vampireList){
        char move = directions.charAt(random.nextInt(3));
        move(move, vampire);
      }
  }

  public void movePlayer(String input){
    player.reduceBattery();

      for (int i=0; i<input.length(); i++) {
        move(input.charAt(i), player);
        if (dungeon.isVampiresMove())
          moveVampires();

        if (allVampiresAllDead()) {
          System.out.println("YOU WIN");
          return;
        }
        if (!player.alive())
          System.out.println("YOU LOSE");
      }
  }

  public boolean allVampiresAllDead(){
    if (this.vampireList.isEmpty())
      return true;

    return false;
  }

  public void move(char input, Character character) {
    Character testMove = null;

    if (character instanceof Player) {
      testMove = new Player(((Player) character).getBattery());
      testMove.setPositions(character.getPositionX(), character.getPositionY());
    } else if (character instanceof Vampire){
      testMove = new Vampire(character.getPositionX(), character.getPositionY());
    }

      if (input == 'w' && character.getPositionY() > 0)
        testMove.moveUp();
      else if (input == 'a' && character.getPositionX() > 0)
        testMove.moveLeft();
      else if (input == 's' && character.getPositionY() < dungeon.getHeight()-1)
        testMove.moveDown();
      else if (input == 'd' && character.getPositionX() < dungeon.getLength()-1) {
        testMove.moveRight();
      }

    if (!checkIfVampireIsHere(testMove.positionX, testMove.positionY)) {
        character.setPositions(testMove.getPositionX(), testMove.getPositionY()) ; //apply move to vampire if there is no other vamp
    } else if(checkIfVampireIsHere(testMove.getPositionX(), testMove.getPositionY())) {
        if (character instanceof Vampire) {
          return;
        } else if (character instanceof Player){
          character.setPositions(testMove.getPositionX(), testMove.getPositionY());
          removeVampire(testMove);
        }
      }
  }

  public void removeVampire(Character position){
    ArrayList<Vampire> toBeRemoved = new ArrayList<Vampire>();

    for (Vampire vampire : vampireList){
      if (vampire.getPositionX() == position.getPositionX() && vampire.getPositionY() == position.getPositionY()) {
        toBeRemoved.add(vampire);
      }
    }

    vampireList.removeAll(toBeRemoved);
  }
}
