import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.attribute.FileAttribute;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

    public static void openFileChooser()
    {
        JFileChooser filechooser = new JFileChooser();
        int choice = filechooser.showOpenDialog(filechooser);
        filechooser.cancelSelection();
    
        System.out.println("File Chooser Opened");

        if (choice == JFileChooser.OPEN_DIALOG)
        {
            System.out.println("Opening File...");
            System.out.println(filechooser.getSelectedFile());
            try
            {
                main.inputfield.setText(Files.readString(filechooser.getSelectedFile().toPath()));
            }
            catch (IOException e)
            {}
        }
    }

    public static void saveFileChooser()
    {
        JFileChooser filechooser = new JFileChooser();
        int choice = filechooser.showSaveDialog(filechooser);
         FileNameExtensionFilter filechooserfilter = new FileNameExtensionFilter(
        "Text File", "txt");
        //filechooser.setFileFilter(filechooserfilter);
       // filechooser.cancelSelection();

        if (choice == JFileChooser.APPROVE_OPTION)
        {
            
            System.out.println("Saving File...");
            
         
           try
           {
            //Makes a file or overrides a file with the given name in the filechooser
            Path path = filechooser.getSelectedFile().toPath();
            File file = new File(path.toString() + ".txt");
            file.createNewFile();
            System.out.println("MADE NEW FILE: " + file.getName());
            System.out.println(filechooser.getCurrentDirectory().toString());
            
            //Writes to the file
            
            BufferedWriter writer = null;
            writer = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND);
            writer.write(main.outputfield.getText());
            writer.newLine();
             
            writer.close();
           }
           catch (IOException e)
           {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        }
           }
        
        }

    

