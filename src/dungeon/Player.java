package dungeon;

public class Player extends Character{
  private int battery;

  public Player(int battery) {
    super(true);
    this.name = "Player";
    this.battery = battery;
    this.positionX = 0;
    this.positionY = 0;
  }

  public int getBattery(){
    return battery;
  }

  public void reduceBattery(){
    this.battery--;

    if (battery == 0)
      this.alive = false;
  }
}
