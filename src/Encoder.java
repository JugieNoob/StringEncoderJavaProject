import java.util.Base64;

public class Encoder {

    static void outputInfo(String input, String output, String encoder){
        System.out.println("String: " + input +  "\n" + "Output: " + output + "\n" + "Encoder: " + encoder);
    }

    public static void Base64(String text){
        String output = Base64.getEncoder().encodeToString(text.getBytes());
        main.setOutput(output);
        outputInfo(text, output, "Base64");

    }

    public static void DAscii(String text){ 
        int[] asciiarray = new int[text.length()];
            for (int i = 0; i < text.length(); i++) {
                var getChar = (text.charAt(i));
                var output = (int) getChar;
                asciiarray[i] = output;
                main.setOutput(main.outputfield.getText() + " " + asciiarray[i]);
                
               // outputfield.setText(outputfield.getText() + " " + asciiarray[i]);
            }  
         outputInfo(text, main.outputfield.getText(), "Decimal ASCII");
        }
}