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
    static JButton convertbtn;
    static JButton decodebtn;
    static JButton copybtn;
    static JTextField inputfield;
    static JTextField outputfield;
    static JComboBox<String> dropdownmenu;
    static String[] choices = {"Base64",  "Decimal ASCII", "Binary", "Caesar Cipher", "Reverse"};
    static JButton infobutton;

    public static void main(String[] args) throws Exception {
       makeWindow();
    }

  
    static void makeWindow()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(640, 480));
        panel.setLayout(null);

        window = new JFrame("Simple Java Encoder");
        window.setResizable(false);
        
        dropdownmenu = new JComboBox<String>(choices);
        dropdownmenu.setBounds(50, 65,200, 25);
        
        title = new JLabel("Simple Java Encoder");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 40));
        title.setBounds(125, 10, 1000, 50);
    
        inputfield = new JTextField();
        inputfield.setBounds(50, 100, 200, 200);

        openfile = new JButton("Get Text From File");
        openfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileChooser.openFileChooser();
            }
        });
        openfile.setPreferredSize(new Dimension(100, 100));
        openfile.setBounds(145 - 70, 325, 140, 35);

        savefile = new JButton("Save Text To File");
        savefile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileChooser.saveFileChooser();
            }
        });
        savefile.setPreferredSize(new Dimension(100, 100));
        savefile.setBounds(500 - 70, 375, 140, 35);

        convertbtn = new JButton("Encode");
        convertbtn.setPreferredSize(new Dimension(100, 100));
        convertbtn.setBounds(290, 225, 75, 50);
        convertbtn.setFont(new Font(convertbtn.getFont().getName(), Font.BOLD, 10));
    

        decodebtn = new JButton("Decode");
        decodebtn.setPreferredSize(new Dimension(100, 100));
        decodebtn.setBounds(290, 125, 75, 50);
        decodebtn.setFont(new Font(decodebtn.getFont().getName(), Font.BOLD, 10));

        outputfield = new JTextField();

        outputfield.setBounds(400, 100, 200, 200);
        outputfield.setEditable(false);
        
        copybtn = new JButton("Copy To Clipboard");
        copybtn.setPreferredSize(new Dimension(100, 100));
        copybtn.setBounds(500 - 70, 325, 140, 35);

        infobutton = new JButton("?");
        infobutton.setBounds(640 - 45, 480 - 45, 45, 45);
        infobutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info.infoMenu();
            }
        });
        
        
  
        convertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encodeText(inputfield.getText().trim());
            }
        });

        decodebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decodeText(inputfield.getText());
            }
        });

       
        copybtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copytoclipboard(outputfield.getText());
            }
        });


        //Adding Window Features
        window.add(panel);
        panel.add(title);
        panel.add(openfile);
        panel.add(savefile);
        panel.add(inputfield);
        panel.add(outputfield);
        panel.add(convertbtn);
        panel.add(decodebtn);
        panel.add(copybtn);
        panel.add(dropdownmenu);
        panel.add(infobutton);

        window.pack();
        window.setVisible(true);
    } 

    static void encodeText(String text)
    {
        outputfield.setText("");
        String selectedchoice = String.valueOf(dropdownmenu.getSelectedItem());

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

    static void decodeText(String text)
    {
        outputfield.setText("");
        String selectedchoice = String.valueOf(dropdownmenu.getSelectedItem());

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

    static void copytoclipboard(String text)
    {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static void setOutput(String output)
    {
        outputfield.setText(output);
    }


}

