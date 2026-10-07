import aes.AES;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.HexFormat;

/**
 * @author uninhm
 */
public class FileEncryptionGUI extends JFrame {
    private String DEFAULT_MODE = "ENCRYPT";

    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JPanel centerPanel;
    private JPanel selectedModePanel;
    private JButton changeModeButton;
    private JTextArea filePreview, resultPreview;
    private JScrollPane filePreviewScrollPane;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;

    private String selectedMode;

    public FileEncryptionGUI() {
        super("File encryption and decryption GUI");

        contentPane = new JPanel();

        contentPane.setLayout(new BorderLayout());

        // Set up menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        fileMenu.add("Import file");
        menuBar.add(new JMenu("File"));
        contentPane.add(menuBar, BorderLayout.NORTH);

        // Set up the center panel
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the selected mode row to the center panel
        selectedModePanel = new JPanel();
        selectedModePanel.setLayout(new BoxLayout(selectedModePanel, BoxLayout.X_AXIS));
        JLabel l = new JLabel("Selected mode:");
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectedModePanel.add(l);
        selectedMode = DEFAULT_MODE;
        changeModeButton = new JButton(selectedMode);
        changeModeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (selectedMode.equals("ENCRYPT"))
                    selectedMode = "DECRYPT";
                else
                    selectedMode = "ENCRYPT";
                changeModeButton.setText(selectedMode);
            }
        });
        selectedModePanel.add(changeModeButton);

        centerPanel.add(selectedModePanel);

        // Add the file preview to the center panel
        l = new JLabel("File preview:");
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerPanel.add(l);
        filePreview = new JTextArea();
        filePreviewScrollPane = new JScrollPane(filePreview);
        filePreviewScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerPanel.add(filePreviewScrollPane);

        // Add the center panel to the content pane
        contentPane.add(centerPanel, BorderLayout.CENTER);

        this.setContentPane(contentPane);
    }

    public static void main(String[] args) {
        AES aes = new AES("000102030405060708090a0b0c0d0e0f");
        System.out.println(HexFormat.of().formatHex(aes.encrypt("Hola")));

        FileEncryptionGUI frame = new FileEncryptionGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}
