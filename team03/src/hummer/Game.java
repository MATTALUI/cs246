package hummer;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
  public Player _player;

  public Game(Player player){
    _player = player;
  }

  public void saveGame() {
    Gson gson = new Gson();

    String data = gson.toJson(_player);
    System.out.println(data);
    try {
      FileWriter writer = new FileWriter("savedata.json");
      writer.write(data);
      writer.close();
      System.out.println("Successfully saved data.");
    } catch (IOException e) {
      System.out.println("there was errro.");
    }

  }

  public void loadGame() {
    try {
      File dataFile = new File("savedata.json");
      Scanner dataReader = new Scanner(dataFile);
      String data = "";
      while(dataReader.hasNextLine()){
        data = dataReader.nextLine();
      }
      System.out.println(data);


      Gson gson = new Gson();
      _player = gson.fromJson(data, Player.class);

      dataReader.close();
    } catch(FileNotFoundException e) {}
  }
}
