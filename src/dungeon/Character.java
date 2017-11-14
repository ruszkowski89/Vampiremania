package dungeon;

public abstract class Character {
  String name;
  Dungeon dungeon;
  int positionX;
  int positionY;
  boolean alive;

  public Character(boolean alive) {
    this.alive = true;
  }

  public boolean alive(){
    return alive;
  }

  public int getPositionX(){
    return positionX;
  }

  public int getPositionY(){
    return positionY;
  }

  public void moveUp(){
    this.positionY--;
  }

  public void moveDown(){
    this.positionY++;
  }

  public void moveLeft(){
    this.positionX--;
  }

  public void moveRight(){
    this.positionX++;
  }

  public void setPositions(int positionX, int positionY){
    this.positionX = positionX;
    this.positionY = positionY;
  }
}