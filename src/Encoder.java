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
                asciiarray[i] = getChar;
                main.setOutput(main.outputfield.getText() + " " + asciiarray[i]);
            }  
         outputInfo(text, main.outputfield.getText(), "Decimal ASCII");
        }

    public static void Binary(String text)
    {
        //Converting variable text to Decimal ASCII
        int[] asciiarray = new int[text.length()];
            for (int i = 0; i < text.length(); i++) {
                var getChar = (text.charAt(i));
                asciiarray[i] = getChar;  
            }  
        
        for (int i = 0; i < text.length(); i++)
        {
            
            for (int j = 0; j < 8; j++)
            {
                System.out.println(text.charAt(j) % 8);
            }
        }
   }
   public static void CaesarCipher(String text)
   {
        //Converting variable text to a Caesar Cipher Version
        String output = "";
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
     public static void Reverse(String text)
    {
        var output = "";
        for (int i = 0; i < text.length(); i++)
        {
            char getChar = text.charAt(i);
            output = getChar + output;
        }
        main.setOutput(main.outputfield.getText() + "" + output);

        outputInfo(text, main.outputfield.getText(), "Reverse");

    }
    
}