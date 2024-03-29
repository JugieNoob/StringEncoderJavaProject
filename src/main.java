
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class main {

    static JFrame window;
    static JPanel panel;
    static JLabel title;
    static JButton openfile;
    static JButton savefile;
    static JButton encodebtn;
    static JButton decodebtn;
    static JButton copybtn;
    static JTextField inputfield;
    static JTextField outputfield;
    static JComboBox<String> encoderdropdown;
    static String[] choices = {"Base64",  "Decimal ASCII", "Binary", "Caesar Cipher", "Reverse"};
    static JButton infobutton;

    public static void main(String[] args) throws Exception {

        // Creates a window.

        window = new JFrame("Simple Java Encoder");
        window.setResizable(false);

        // Creates the UI panel so that the interface can be added to the window.
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(640, 480));
        panel.setLayout(null);

        drawUI();

        window.add(panel);
        window.pack();
        window.setVisible(true);
    }

  
    // A function that draws the UI to the screen.
    static void drawUI()
    {
        title = new JLabel("Simple Java Encoder");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 40));
        title.setBounds(125, 10, 1000, 50);


        // A dropdown element that allows the user to select an encoder.

        encoderdropdown = new JComboBox<String>(choices);
        encoderdropdown.setBounds(50, 65,200, 25);
        
        // The input field that allows the user to input a string.

        inputfield = new JTextField();
        inputfield.setBounds(50, 100, 200, 200);

        // The output field that shows the user the converted input.

        outputfield = new JTextField();
        outputfield.setBounds(400, 100, 200, 200);
        outputfield.setEditable(false);

        // The encode button, when pressed it will encode the string in the input field and output it in the output field.

        encodebtn = new JButton("Encode");
        encodebtn.setPreferredSize(new Dimension(100, 100));
        encodebtn.setBounds(290, 225, 75, 50);
        encodebtn.setFont(new Font(encodebtn.getFont().getName(), Font.BOLD, 10));
        encodebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encodeText(inputfield.getText().trim());
            }
        });
    
        // The decode button, when pressed it will decode the string in the input field and output it in the output field.

        decodebtn = new JButton("Decode");
        decodebtn.setPreferredSize(new Dimension(100, 100));
        decodebtn.setBounds(290, 125, 75, 50);
        decodebtn.setFont(new Font(decodebtn.getFont().getName(), Font.BOLD, 10));
        decodebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decodeText(inputfield.getText());
            }
        });

        
        // The Copy to Clipboard button, when pressed it will copy the string in the output field to the clipboard.

        copybtn = new JButton("Copy To Clipboard");
        copybtn.setPreferredSize(new Dimension(100, 100));
        copybtn.setBounds(500 - 70, 325, 140, 35);
        copybtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copytoclipboard(outputfield.getText());
            }
        });

        // The Info button, when pressed it will display a new window showing information about the project.        

        infobutton = new JButton("?");
        infobutton.setBounds(640 - 45, 480 - 45, 45, 45);
        infobutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info.infoMenu();
            }
        });

        // The Get Text From File button, when pressed it will open a file chooser window that allows the user to choose a file to open into the input field.   

        openfile = new JButton("Get Text From File");
        openfile.setPreferredSize(new Dimension(100, 100));
        openfile.setBounds(145 - 70, 325, 140, 35);
        openfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileChooser.openFileChooser();
            }
        });

        // The Save Text To File button, when pressed it will open a file chooser window that allows the user to save the contents of the output folder to a file.

        savefile = new JButton("Save Text To File");
        savefile.setPreferredSize(new Dimension(100, 100));
        savefile.setBounds(500 - 70, 375, 140, 35);
        savefile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileChooser.saveFileChooser();
            }
        });

        // Adding UI elements to the window.
        
        panel.add(title);
        panel.add(openfile);
        panel.add(savefile);
        panel.add(inputfield);
        panel.add(outputfield);
        panel.add(encodebtn);
        panel.add(decodebtn);
        panel.add(copybtn);
        panel.add(encoderdropdown);
        panel.add(infobutton);
    } 

    // A function that loads the text and the encoder that was selected by the user.

    static void encodeText(String text)
    {
        outputfield.setText("");
        String selectedchoice = String.valueOf(encoderdropdown.getSelectedItem());

        switch (selectedchoice) 
        {
            case "Base64":
                Encoder.Base64(text);
                break;
            case "Decimal ASCII":
                Encoder.DAscii(text);
                break;
            case "Binary":
                Encoder.Binary(text);
                break;
            case "Caesar Cipher":
                Encoder.CaesarCipher(text);
                break;
            case "Reverse":
                Encoder.Reverse(text);
                break;
        }
    }

    // A function that loads the text and the decoder that was selected by the user.

    static void decodeText(String text)
    {
        outputfield.setText("");
        String selectedchoice = String.valueOf(encoderdropdown.getSelectedItem());

        switch (selectedchoice) 
        {
            case "Base64":
                Decoder.Base64(text);
                break;
            case "Decimal ASCII":
                Decoder.DAscii(text);
                break;
            case "Binary":
                Decoder.Binary(text);
                break;
            case "Caesar Cipher":
                Decoder.CaesarCipher(text);
                break;
            case "Reverse":
                Decoder.Reverse(text);
                break;
        }
    }

    // A function that copies a string to the user's clipboard.

    static void copytoclipboard(String text)
    {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    // A function that sets the output of the output field to the inputted string. This is mainly used in other classes to easily change the output field.

    public static void setOutput(String output)
    {
        outputfield.setText(output);
    }


}

