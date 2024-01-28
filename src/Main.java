import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Spiel game = new Spiel();
            game.start();
        });
    }
}
