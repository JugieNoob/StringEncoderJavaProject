import java.util.Base64;

public class Encoder {

    static String output = "";
    static void outputInfo(String input, String output, String encoder){
        System.out.println("String: " + input +  "\n" + "Output: " + output + "\n" + "Encoder: " + encoder);
    }

    // Conveting a string to Base64

    public static void Base64(String text){
        output = Base64.getEncoder().encodeToString(text.getBytes());
        main.setOutput(output);
        outputInfo(text, output, "Base64");

    }

    // Converting a string to Decimal ASCII

    public static void DAscii(String text){ 
        int[] asciiarray = new int[text.length()];
            for (int i = 0; i < text.length(); i++) {
                var getChar = (text.charAt(i));
                asciiarray[i] = getChar;
                output = (main.outputfield.getText() + " " + asciiarray[i]).trim();
                main.setOutput(output);
            }  
         outputInfo(text, main.outputfield.getText(), "Decimal ASCII");
        }

    // Converting a string to Binary ASCII

    public static void Binary(String text)
    {
        
        int[] asciiarray = new int[text.length()];
            for (int i = 0; i < text.length(); i++) {
                var getChar = (text.charAt(i));
                asciiarray[i] = getChar;  

                output = (main.outputfield.getText() + Integer.toBinaryString(text.charAt(i)) + " ");
                main.setOutput(output);

            } 
            outputInfo(text, main.outputfield.getText(), "Binary");
   }

   // Encodes a string using the Caesar Cipher

   public static void CaesarCipher(String text)
   {
        output = "";
            for (int i = 0; i < text.length(); i++) {
                char getChar = (text.charAt(i));  
                getChar += 1; 

                if (getChar != 33)
                {
                    output = String.valueOf(getChar);
                }
                else
                {
                    output = " ";
                }
                
                main.setOutput(main.outputfield.getText() + "" + output);

            }  
            outputInfo(text, main.outputfield.getText(), "Caesar Chipher");
        }

    // Reverses the string and outputs the value.

    public static void Reverse(String text)
    {
        output = "";
        for (int i = 0; i < text.length(); i++)
        {
            char getChar = text.charAt(i);
            output = getChar + output;
        }
        main.setOutput(main.outputfield.getText() + "" + output);

        outputInfo(text, main.outputfield.getText(), "Reverse");
    }
    
}