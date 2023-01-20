import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.*;


public class App {
    
    public static void main(String[] args) throws Exception {
       makeWindow();
    }

    static JFrame frame;
    static JLabel title;
    static JButton openfile;
    static JButton convertbtn;
    static JButton copybtn;
    static JTextField inputfield;
    static JTextField outputfield;
    static void makeWindow()
    {
        JPanel window = new JPanel();
        window.setPreferredSize(new Dimension(640, 480));
        window.setLayout(null);

        frame = new JFrame("Test window");

        
        title = new JLabel("Title");
        title.setBounds(100, 10, 1000, 15);
        title.setText("Simple Java Encoder");
        title.setSize(1000, 100);
    //    JOptionPane option = new JOptionPane();

    
        openfile = new JButton("Get Text From File");
        openfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });
        openfile.setPreferredSize(new Dimension(100, 100));
        openfile.setBounds(300, 100, 50, 50);


        convertbtn = new JButton("Convert");
        convertbtn.setPreferredSize(new Dimension(100, 100));
        convertbtn.setBounds(300, 175, 50, 50);

        copybtn = new JButton("Copy To Clipboard");
        copybtn.setPreferredSize(new Dimension(100, 100));
        copybtn.setBounds(300, 250, 50, 50);

        inputfield = new JTextField();
        inputfield.setBounds(50, 100, 200, 200);
        

        outputfield = new JTextField();

        outputfield.setBounds(400, 100, 200, 200);
        outputfield.setEditable(false);


        convertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertText(inputfield.getText());
            }
        });

        copybtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copytoclipboard(outputfield.getText());
            }
        });
        //Adding Window Features
        frame.add(window);
        window.add(title);
        window.add(openfile);
        window.add(inputfield);
        window.add(outputfield);
        window.add(convertbtn);
        window.add(copybtn);

       
    //    frame.add(option);




        
        frame.pack();
        frame.setVisible(true);

        System.out.println("Added Window");
    } 

    static void openFileChooser()
    {
        JFileChooser filechooser = new JFileChooser();

        JFrame filewindow = new JFrame();
        
       // filewindow.setPreferredSize(new Dimension(640, 480));
       // filewindow.setLayout(null);

        filewindow.add(filechooser); 
        filewindow.pack();
        filewindow.setVisible(true);
        System.out.println("File Chooser Opened");
    }

    static void convertText(String text)
    {
        System.out.println("String: " + text +  "\n" + "Output: " + Base64.getEncoder().encodeToString(text.getBytes()) + "\n" + "Encoder: " + "Base64");
        outputfield.setText(Base64.getEncoder().encodeToString(text.getBytes()));
    }

    static void copytoclipboard(String text)
    {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
