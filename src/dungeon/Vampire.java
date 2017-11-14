package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vampire extends Character{
  private Random random = new Random();

  public Vampire(int positionX, int positionY) {
    super(true);
    this.name = "Vampire";
    this.positionX = positionX;
    this.positionY = positionY;
  }

  public void setRandomVampirePosition(int length, int heigth){
    this.positionX = 1+ random.nextInt(length-1);
    this.positionY = 1+ random.nextInt(heigth-1);
  }

}
