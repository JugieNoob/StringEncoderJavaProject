import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class main {
    
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
    static JComboBox<String> dropdownmenu;
    static String[] choices = {"Base64",  "Decimal ASCII", "Binary"};

    static void makeWindow()
    {
        JPanel window = new JPanel();
        window.setPreferredSize(new Dimension(640, 480));
        //window.setBackground(Color.CYAN); Changes the color of the background
        window.setLayout(null);

        frame = new JFrame("Simple Java Encoder");
        frame.setResizable(false);
       
        dropdownmenu = new JComboBox<String>(choices);
        dropdownmenu.setBounds(50, 65,200, 25);
        
        title = new JLabel("Simple Java Encoder");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 40));
        title.setBounds(125, 10, 1000, 50);

    //    JOptionPane option = new JOptionPane();

    
        inputfield = new JTextField();
        inputfield.setBounds(50, 100, 200, 200);        

    
        openfile = new JButton("Get Text From File");
        openfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });
        openfile.setPreferredSize(new Dimension(100, 100));
        openfile.setBounds(145 - 70, 325, 140, 35);
        


        convertbtn = new JButton("Convert");
        convertbtn.setPreferredSize(new Dimension(100, 100));
        convertbtn.setBounds(290, 175, 75, 50);
        convertbtn.setFont(new Font(convertbtn.getFont().getName(), Font.BOLD, 10));
    

        outputfield = new JTextField();

        outputfield.setBounds(400, 100, 200, 200);
        outputfield.setEditable(false);
        
        copybtn = new JButton("Copy To Clipboard");
        copybtn.setPreferredSize(new Dimension(100, 100));
        copybtn.setBounds(500 - 70, 325, 140, 35);



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
        outputfield.setText("");
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
                String base64 = Base64.getEncoder().encodeToString(text.getBytes());
                System.out.println("String: " + text +  "\n" + "Output: " + base64 + "\n" + "Encoder: " + selectedchoice);
                outputfield.setText(base64);
                break;
            case "Decimal ASCII":
            int[] asciiarray = new int[text.length()];
            for (int i = 0; i < text.length(); i++) {
                var getChar = (text.charAt(i));
                var asciioutput = (int) getChar;
                asciiarray[i] = asciioutput;
                outputfield.setText(outputfield.getText() + " " + asciiarray[i]);
            }               
            /*
              int[] ascii = new int[text.length()];
                for (byte textbyte : text.getBytes()) {
                    int value = textbyte;
                    System.out.println(text.length());
                    for (int i = 0; i < text.length(); i++) 
                    {
                        ascii[i] = value;
                        break;
                    }
                }
                System.out.println(ascii);
                break;
       */
        }

           
        
    }

    static void copytoclipboard(String text)
    {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
