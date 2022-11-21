import java.awt.Color;

public class Entity {
	protected GamePanel gp;
	protected KeyHandler kh;
	int x;
	int y;
	int health;
	Color color;
	int size;
	int speed;
	boolean deleted = false;
	int xVelocity;
	int yVelocity;
	boolean collision = false;

	public boolean getDeleted() {
		return deleted;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHealth() {
		return health;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setDeleted(boolean isDeleted) {
		isDeleted = deleted;
	}

	public boolean checkCollision(Entity e) {

		if (x < e.x + e.size && x + size > e.x && y < e.y + e.size && y + size > e.y) {
			collision = true;
		} else {
			collision = false;
		}
		return collision;
	}

}