package hummer;

import java.awt.Color;
import java.util.Random;

public class Granny extends Creature implements Movable, Spawner, Aware {

  Random _rand;
  int _health;
  Direction _nextStep;

  public Granny() {
    _rand = new Random();
    _health = 1;
    _nextStep = Direction.RIGHT;
  }

  public Boolean isAlive() {
		return _health > 0;
	}

	public Shape getShape() {
		return Shape.Circle;
	}

	public Color getColor() {
		return new Color(112, 10, 10);
	}

  // Movable Implementation
  public void move() {
    // Move according to next step
    switch(_nextStep){
      case UP:
        _location.y++;
        break;
      case DOWN:
        _location.y--;
        break;
      case LEFT:
        _location.x++;
        break;
      case RIGHT:
        _location.x++;
    }

    // Choose next step
    switch(_rand.nextInt(4)) {
			case 0:
				_nextStep = Direction.UP;
				break;
			case 1:
				_nextStep = Direction.DOWN;
				break;
			case 2:
				_nextStep = Direction.LEFT;
				break;
			case 3:
				_nextStep = Direction.RIGHT;
				break;
		}
  }

  // Aware Implementation
  public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
    // Granny knows to move perpindicular to wolves since they chase
    if (left instanceof Wolf || right instanceof Wolf){
      _nextStep = Direction.UP;
    } else if (left instanceof Wolf || right instanceof Wolf) {
      _nextStep = Direction.RIGHT;
    }
  }

  // Spawner Implementation
  public Creature spawnNewCreature() {
    // Grannies plant flowers wherever they go
    return new Flower();
  }
}
