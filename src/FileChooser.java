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
            Path path = filechooser.getSelectedFile().toPath();
            File file = new File(path.toString() + ".txt");//filechooser.getCurrentDirectory().toString() + "/" + file.getName() + ".txt");    //
            file.createNewFile();
            System.out.println("MADE NEW FILE: " + file.getName());
            System.out.println(filechooser.getCurrentDirectory().toString());
            
          //  Path path = Paths.get(filePath);
           BufferedWriter writer = null;
            writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND); //else appends to already existing file
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

