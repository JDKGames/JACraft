
//Made By BioShot\\
import java.awt.*;

public class Enemy extends Entity {
    long collisionTimer = System.nanoTime();
    long collisionDelay = 2000;
    long movementTimer = System.nanoTime();
    long movementDelay = 50;

    public Enemy(GamePanel gp) {
        this.gp = gp;

        sdv();

    }

    public void sdv() {
        x = (gp.screenWidth / 2);
        y = (gp.screenHeight / 2);
        speed = 4;
        color = Color.RED;
        health = 100;

    }

    public void update() {

        if (checkCollision(gp.player)) {
            gp.player.color = Color.RED;
            long currentTime = System.nanoTime();
            long differenceTime = currentTime - collisionTimer;
            differenceTime /= 1000000;
            if (differenceTime >= collisionDelay) {

                gp.player.health -= 5;
                collisionTimer = System.nanoTime();

            }

        } else {
            if (!checkCollision(gp.player)) {

                long currentTime = System.nanoTime();
                long differenceTime = currentTime - movementTimer;
                differenceTime /= 1000000;
                if (differenceTime >= movementDelay) {

                    if (gp.player.x < x) {
                        x -= speed;
                    } else if (gp.player.x > x) {
                        x += speed;
                    }
                    if (gp.player.y < y) {
                        y -= speed;
                    } else if (gp.player.y > y) {
                        y += speed;
                    }
                    movementTimer = System.nanoTime();

                }

                gp.player.color = Color.WHITE;

            } else {
                // gp.player.health = gp.player.health - 10;
            }
        }

        if (health <= 0) {
            this.deleted = true;
        }
    }

    public void getHit(int damage) {
        health -= damage;
    }

    public void shoot(GamePanel gp) {
        GamePanel.bullets.add(new Bullet(gp));
    }

    public void draw(Graphics2D g1) {
        g1.setColor(color);
        g1.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
