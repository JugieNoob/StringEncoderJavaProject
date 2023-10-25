import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Info {
    static JFrame window;
    static JPanel panel;
    static JLabel title;
    static JLabel label;
    public static void infoMenu()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(330, 240));
        panel.setLayout(null);

        window = new JFrame("Information");
        window.setResizable(false);

        title = new JLabel("Information");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setBounds(320 / 2 - 50, 10, 200, 50);

        label = new JLabel("<html>Project made for the 2022-2024 Computing<br/>Course. Enter an input in the left field, press the<br/>ENCODE button to encode your input or press<br/>DECODE to decode your input.<html>");
        label.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        label.setBounds(10, 0, 1000, 200);

        

        window.add(panel);
        panel.add(title);
        panel.add(label);
        window.setVisible(true); window.add(panel);
        window.pack();
        window.setVisible(true);
    }
}
