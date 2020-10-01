import javax.swing.*;
import java.awt.*;

public class HorseRace extends JFrame {
    public static void main(String[] args) throws InterruptedException {
        new HorseRace().GUI();
    }

    public void GUI() throws InterruptedException {
        Paard[] paarden = new Paard[]{
                new Paard("Hennie"),
                new Paard("Harry"),
                new Paard("Hork"),
                new Paard("Arnold"),
                new Paard("Hinny"),
                new Paard("Henk"),
                new Paard("Doughnut"),
                new Paard("Langhorst")
        };
        new HorseRace();
        setTitle("Horse Race 2020");
        setSize(1500, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JPanel horses = new JPanel();
        horses.setPreferredSize(new Dimension(1500, 600));

        c.add(horses);

        JButton start = new JButton("Start");
        c.add(start);

        setVisible(true);

        Thread.sleep(100);

        start.addActionListener(e -> {
            boolean won = false;
            while (!won) {
                for (Paard paard : paarden) {
                    paard.addAfstand();
                    drawLine(horses.getGraphics(), paard.getKleur(), paard.getAfstand(), paard.getPaardNummer() * 70);
                    if (paard.getAfstand() >= 1500){
                        won = true;
                        JOptionPane.showMessageDialog(c, paard.getNaam() + " heeft gewonnen");
                    }
                }
                try {
                    Thread.sleep(15);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            for (Paard paard : paarden) {
                paard.clearAfstand();
            }
            Graphics g = horses.getGraphics();
            g.clearRect(0, 0, 1500, 600);
        });

    }

    public static void drawLine(Graphics g, Color color, int x, int position){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(20F));
        g2d.drawLine(0, position, x, position);
    }

}
