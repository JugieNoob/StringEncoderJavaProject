import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



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
    static JComboBox dropdownmenu;
    static String[] choices = {"Base64",  "Decimal ASCII", "Binary"};
    static void makeWindow()
    {
        JPanel window = new JPanel();
        window.setPreferredSize(new Dimension(640, 480));
        window.setLayout(null);

        frame = new JFrame("Simple Java Encoder");
        frame.setResizable(false);
       
        dropdownmenu = new JComboBox<String>(choices);
        dropdownmenu.setBounds(50, 65,200, 25);
        
        title = new JLabel("Simple Java Encoder");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 40));
        title.setBounds(125, 10, 1000, 50);

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
        convertbtn.setBounds(290, 175, 75, 50);
        convertbtn.setFont(new Font(convertbtn.getFont().getName(), Font.BOLD, 10));
    

        copybtn = new JButton("Copy To Clipboard");
        copybtn.setPreferredSize(new Dimension(100, 100));
        copybtn.setBounds(300, 250, 50, 50);
        copybtn.setFont(new Font(copybtn.getFont().getName(), Font.BOLD, 10));

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
        window.add(dropdownmenu);

       
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
        String selectedchoice = String.valueOf(dropdownmenu.getSelectedItem());
/*
    
            if (selectedchoice == "Base64")
            {
            System.out.println("String: " + text +  "\n" + "Output: " + Base64.getEncoder().encodeToString(text.getBytes()) + "\n" + "Encoder: " + selectedchoice);
            outputfield.setText(Base64.getEncoder().encodeToString(text.getBytes()));
               }
            else if (selectedchoice == "Decimal ASCII")
            {
            System.out.println("String: " + text +  "\n" + "Output: " + text.chars().boxed().collect(Collectors.toList()) + "\n" + "Encoder: " + selectedchoice);
            outputfield.setText("" + text.chars().boxed().collect(Collectors.toList()));
        }
        */
        switch (selectedchoice) 
        {
            case "Base64":
                System.out.println("String: " + text +  "\n" + "Output: " + Base64.getEncoder().encodeToString(text.getBytes()) + "\n" + "Encoder: " + selectedchoice);
                outputfield.setText(Base64.getEncoder().encodeToString(text.getBytes()));
                break;
            case "Decimal ASCII":
                System.out.println("String: " + text +  "\n" + "Output: " + text.chars().boxed().collect(Collectors.toList()) + "\n" + "Encoder: " + selectedchoice);
                outputfield.setText("" + text.chars().boxed().collect(Collectors.toList()));
                break;
            case "Binary":
                byte[] stringbytes = text.getBytes();
                StringBuilder convertedbinary = new StringBuilder();

                for (byte b : stringbytes) {
                    int value = b;
                    for (int i = 0; i < 8; i++)
                    {
                        convertedbinary.append((value & 128) == 0 ? 0 : 1);
                        value <<= 1;
                    }
                    convertedbinary.append(' ');
                }
                
               outputfield.setText("" + convertedbinary);

                break;
        }

           
        
    }

    static void copytoclipboard(String text)
    {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
