
//Made By BioShot\\
import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler kh;
    long shootingDelay = 500;
    long shootingTimer = System.nanoTime();

    public Player(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;
        sdv();
    };

    public void sdv() {
        x = (gp.screenWidth / 2);
        y = (gp.screenHeight / 2);
        speed = 4;
        color = Color.WHITE;
        size = gp.tileSize;
        health = 100;

    }

    public void update() {
        if (health > 0) {

            if (kh.shooting == true) {

                long currentTime = System.nanoTime();
                long differenceTime = currentTime - shootingTimer;
                differenceTime /= 1000000;
                if (differenceTime >= shootingDelay) {
                    GamePanel.bullets.add(new Bullet(gp));
                    shootingTimer = System.nanoTime();
                }
            }
            if (kh.up == true) {
                if (y != 0) {
                    y -= speed;
                }
            }
            if (kh.down == true) {
                if (y != gp.screenHeight - gp.tileSize) {
                    y += speed;
                }
            }
            if (kh.left == true) {
                if (x != 0) {
                    x -= speed;
                }
            }
            if (kh.right == true) {
                if (x != gp.screenWidth - gp.tileSize) {
                    x += speed;
                }
            }
        } else {
            x = 999;
            y = 999;
        }
    }

    public void draw(Graphics2D g1) {
        g1.setColor(color);
        g1.fillRect(x, y, size, size);
    }

    public void fireBullet() {
        long shootingTimer = System.nanoTime();
        long currentTime = System.nanoTime();
        long differenceTime = currentTime - shootingTimer;
        differenceTime /= 1000000;
        if (differenceTime >= shootingDelay) {
            GamePanel.bullets.add(new Bullet(gp));
            shootingTimer = System.nanoTime();
        }

    }
}
