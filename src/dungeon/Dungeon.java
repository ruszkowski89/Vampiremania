package dungeon;

public class Dungeon {
  private int length;
  private int height;
  private int vampires;
  private int moves;
  private boolean vampiresMove;
  private Map map;
  private Player player;
  private Reader reader;

  public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
    this.length = length;
    this.height = height;
    this.vampires = vampires;
    this.moves = moves;
    this.vampiresMove = vampiresMove;
    this.player = new Player(moves);
    this.map = new Map(this, player, vampires);
    this.reader = new Reader();
  }

  public void run(){
    while (player.alive()) {
      System.out.println(player.getBattery());
      System.out.println();
      map.printPositions();
      System.out.println();
      map.printMap();
      System.out.println();
      String input = reader.input();
      map.movePlayer(input);
    }
  }

  public int getLength(){
    return length;
  }

  public int getHeight(){
    return height;
  }

  public boolean isVampiresMove() {
    return vampiresMove;
  }
}
