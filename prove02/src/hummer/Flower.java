package hummer;

import java.awt.Color;
import java.util.Random;

public class Flower extends Plant {

  Color color;

  public Flower() {
    // Generate random color; 150-200 so bright colors only
    Random rand = new Random();
    int minimumValue = 150;
    int r = minimumValue + rand.nextInt(51);
    int g = minimumValue + rand.nextInt(51);
    int b = minimumValue + rand.nextInt(51);

    color = new Color(r, g, b);
  }

  @Override
  public Color getColor() {
    return color;
	}

}
