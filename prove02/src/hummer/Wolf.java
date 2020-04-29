package hummer;

import java.awt.Color;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner {

  Random _rand;
  int _health;
  Direction _preferredDirection;
  Boolean _pregnant;

  public Wolf() {
    _rand = new Random();
    _health = 1;
    _pregnant = false;

    switch(_rand.nextInt(4)) {
			case 0:
				_preferredDirection = Direction.RIGHT;
				break;
			case 1:
				_preferredDirection = Direction.LEFT;
				break;
			case 2:
				_preferredDirection = Direction.UP;
				break;
			case 3:
				_preferredDirection = Direction.DOWN;
				break;
			default:
				break;
		}
  }

  public Boolean isAlive() {
		return _health > 0;
	}

	public Shape getShape() {
		return Shape.Square;
	}

	public Color getColor() {
		return new Color(112, 112, 112);
	}

  // Moveable Implementation
  public void move() {
    switch(_preferredDirection) {
			case RIGHT:
				_location.x++;
				break;
			case LEFT:
				_location.x--;
				break;
			case UP:
				_location.y++;
				break;
			case DOWN:
				_location.y--;
				break;
			default:
				break;
		}
  }

  // Aggressor Implementation
  public void attack(Creature victim) {
    if(victim instanceof Animal) {
      victim.takeDamage(5);
      _pregnant = true;
    }
  }

  // Aware Implementation
  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
    // Keep going if Wolf is already heading in "preyable" direction
    switch(_preferredDirection) {
			case RIGHT:
				if(right instanceof Animal) { return; }
        break;
			case LEFT:
				if(left instanceof Animal) { return; }
        break;
			case UP:
				if(above instanceof Animal) { return; }
        break;
			case DOWN:
				if(below instanceof Animal) { return; }
		}

    // Otherwise, search in clockwise pattern starting from the top
    if(above instanceof Animal) {
      _preferredDirection = Direction.UP;
    }else if(right instanceof Animal) {
      _preferredDirection = Direction.RIGHT;
    }else if (below instanceof Animal) {
      _preferredDirection = Direction.DOWN;
    }else if (left instanceof Animal) {
      _preferredDirection = Direction.LEFT;
    }
  }

  // Spawner Implementation
  public Creature spawnNewCreature() {
    if(_pregnant){
      _pregnant = false;

      return new Wolf();
    } else {
      return null;
    }
  }
}
