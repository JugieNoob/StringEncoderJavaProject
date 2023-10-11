import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.nio.file.Files;
import java.io.*;




public class main {
    
    public static void main(String[] args) throws Exception {
       makeWindow();
    }

    static JFrame frame;
    static JLabel title;
    static JButton openfile;
    static JButton convertbtn;
    static JButton decodebtn;
    static JButton copybtn;
    static JTextField inputfield;
    static JTextField outputfield;
    static JComboBox<String> dropdownmenu;
    static String[] choices = {"Base64",  "Decimal ASCII", "Binary", "Caesar Cipher", "Reverse"};

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



        convertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encodeText(inputfield.getText());
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
        frame.add(window);
        window.add(title);
        window.add(openfile);
        window.add(inputfield);
        window.add(outputfield);
        window.add(convertbtn);
        window.add(decodebtn);
        window.add(copybtn);
        window.add(dropdownmenu);

        frame.pack();
        frame.setVisible(true);

        System.out.println("Added Window");
    } 

    static void openFileChooser()
    {
        JFileChooser filechooser = new JFileChooser();
        int choice = filechooser.showOpenDialog(filechooser);

       
        filechooser.cancelSelection();
    

        //JFrame filewindow = new JFrame();
//
       //
    //
        //filewindow.add(filechooser); 
        //filewindow.pack();
        //filewindow.setVisible(true);
        System.out.println("File Chooser Opened");

        if (choice == filechooser.OPEN_DIALOG)
        {
            System.out.println("Opening File...");
            System.out.println(filechooser.getSelectedFile());
            try
            {
                inputfield.setText(Files.readString(filechooser.getSelectedFile().toPath()));
            }
            catch (IOException e)
            {

            }
          
     
           
         //   filewindow.dispose();
        }
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
            case "Binary":
                Encoder.Binary(text);
            case "Caesar Cipher":
                Encoder.CaesarCipher(text);
            case "Reverse":
                Encoder.Reverse(text);
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
                //Decoder.DAscii(text);
            case "Binary":
                //Decoder.Binary(text);
            case "Caesar Cipher":
               // Decoder.CaesarCipher(text);
            case "Reverse":
                Decoder.Reverse(text);
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

