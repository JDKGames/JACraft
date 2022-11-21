import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setTitle("JaCraft");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();

        frame.add(gp);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
