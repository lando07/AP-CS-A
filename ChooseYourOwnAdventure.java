import java.util.Scanner;
import static java.lang.System.*;

import java.io.File;
import java.io.FileNotFoundException;

public class ChooseYourOwnAdventure {
    private static Scanner console = new Scanner(in);
    private static final String DELIMITER = "\n\n";
    private static final String NAME_DELIMITER = "[name]";
    public static void main(String[] args) {
        try(Scanner fileScanner = new Scanner(new File("adventures.txt"), "UTF-8")){

        }
        catch (FileNotFoundException f){
            out.println("Oops! Looks like our story file wasn't found, make sure it exists in the same dir as this class!");
            out.println("More detailed output:\n"+f);
        }
        
    }
}
