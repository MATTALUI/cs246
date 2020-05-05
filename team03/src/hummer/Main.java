package hummer;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
	    Player hero = new Player();
      hero.name = "Team 07";
      hero.mana = 7;
      hero.health = 8;
      hero.gold = 9;
      hero.equipment.put("sword", 400);

      Game game = new Game(hero);
      game.saveGame();


      Player emptyHero = new Player();
      Game game2 = new Game(emptyHero);
      game2.loadGame();
      game2._player.display();
    }
}
