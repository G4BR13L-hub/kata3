package software.ulpgc.kata3.control;

import software.ulpgc.kata3.view.BarchartDisplay;
import software.ulpgc.kata3.view.JFreeBarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private BarchartDisplay barchartDisplay;

    public MainFrame() throws HeadlessException {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setTitle("Statistics");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(getJFreeBarchartDisplay());
        add(menu(), BorderLayout.NORTH);
        this.commands = new HashMap<>();
        setVisible(true);
    }

    public BarchartDisplay getBarchartDisplay() {
        return barchartDisplay;
    }

    public void put(String commandLine, Command command){
        commands.put(commandLine, command);
    }

    private JPanel menu() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(showChart());
        return panel;
    }

    private JButton showChart() {
        JButton button = new JButton("Chart");
        button.addActionListener(e -> commands.get("chart").execute());
        return button;
    }

    private JPanel getJFreeBarchartDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }
}
