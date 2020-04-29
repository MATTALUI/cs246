package hummer;

import java.awt.Color;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {

  Random _rand;
  int _health;

  public Zombie() {
    _rand = new Random();
    _health = 1;
  }

  public Boolean isAlive() {
		return _health > 0;
	}

	public Shape getShape() {
		return Shape.Square;
	}

	public Color getColor() {
		return new Color(0, 0, 135);
	}

  // Moveable Implementation
  public void move() {
    if(_rand.nextInt(2) == 1) {
      _location.x++;
    } else {
      _location.x--;
    }
  }

  // Aggressor Implementation
  public void attack(Creature victim) {
    if(!(victim instanceof Plant)) {
      victim.takeDamage(10);

    }
  }
}
