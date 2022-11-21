import java.awt.Color;
import java.awt.Graphics2D;

public class Bullet extends Entity {
    public Bullet(GamePanel gp) {
        this.gp = gp;
        setDefaultValues();
    }

    public void setDefaultValues() {
        color = Color.ORANGE;
        size = 10;
        x = (gp.player.x + (gp.player.size / 2) - (size / 2));
        y = gp.player.y;
        speed = 5;
        collision = false;
        deleted = false;
    }

    public void update() {
        for (int i = 0; i < GamePanel.enemies.size(); i++) {
            Enemy e = GamePanel.enemies.get(i);

            if (checkCollision(e)) {
                e.getHit(10);
                setDeleted(true);
            }
        }

        if (y < 0) {
            setDeleted(true);
        }

        y -= speed;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, size, size);
    }
}