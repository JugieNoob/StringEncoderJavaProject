import java.util.Base64;

public class Decoder {

    static String output = "";

    static void outputInfo(String input, String output, String encoder){
        System.out.println("String: " + input +  "\n" + "Output: " + output + "\n" + "Encoder: " + encoder);
    }

    public static void Base64(String text)
    {
        String output = new String(Base64.getDecoder().decode(text));
        main.setOutput(output);
        outputInfo(text, output, "Base64");
    }

    public static void DAscii(String text)
    {
    }

    public static void Binary(String text)
    {
    //  TODO
       //int bintodec = Integer.parseInt(text, 2);
       //char dectostring = (char)bintodec;
       //main.setOutput("" + dectostring);
      //  outputInfo(text, dectostr, "Binary");
    }

    public static void CaesarCipher(String text)
    {
        output = "";
            for (int i = 0; i < text.length(); i++) {
                char getChar = (text.charAt(i));  
                getChar -= 1; 

                if (getChar != 31)
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
            output =  getChar + output;
        }
        main.setOutput(main.outputfield.getText() + "" + output);

        outputInfo(text, main.outputfield.getText(), "Reverse");
    }

}