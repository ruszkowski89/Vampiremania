package dungeon;

import java.util.Scanner;

public class Reader {
  private Scanner reader;

  public Reader() {
    this.reader = new Scanner(System.in);
  }

  public String input(){
    return reader.nextLine();
  }

}
