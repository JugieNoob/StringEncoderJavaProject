import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.attribute.FileAttribute;
import javax.swing.JFileChooser;

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
       // filechooser.cancelSelection();

        if (choice == JFileChooser.SAVE_DIALOG)
        {
            
            System.out.println("Saving File...");
            
         
           try
           {
            File file = new File("C:/");    //filechooser.getCurrentDirectory().toString()     // // Files.createFile(filechooser.getCurrentDirectory(), new FileAttribute<T>() {
            file.createNewFile();
           }
           catch (IOException e)
           {}
        }
           }
    }

