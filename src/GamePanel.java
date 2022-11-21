import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    Thread gameThread;
    public int FPS = 60;
    public KeyHandler kh = new KeyHandler();
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    public GamePanel self = this;
    public Player player = new Player(this, kh);
    public Bullet bullet = new Bullet(this);

    public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(kh);

        startGame();
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
        enemies.add(new Enemy(this));
    }

    @Override
    public void run() {
        while (gameThread != null) {
            repaint();
            update();

            try {
                Thread.sleep(1000 / FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Bullet b : bullets) {
            b.draw(g2);
        }
        player.draw(g2);
        for (Enemy e : enemies) {
            e.draw(g2);
        }

        g2.dispose();
    }

    public void update() {

        for (Bullet b : bullets) {
            b.update();
        }
        player.update();

        for (Enemy e : enemies) {
            e.update();
            System.out.println("x: " + e.getX() + "y: " + e.getY());
            System.out.println("speed: " + e.speed);
            System.out.println("Enemy hp: " + e.getHealth() + "Player hp: " + player.getHealth());
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            if (e.getDeleted() == true) {
                enemies.remove(i);
                i--;
            }
        }
        bullets.removeIf(b -> b.getDeleted());

    }
}