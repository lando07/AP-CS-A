import static java.lang.System.in;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChooseYourOwnAdventure {
    private static Scanner console = new Scanner(in); //gets user input
    private static final String DELIMITER = "\n\n"; //in the adventure.txt file, I have all of them spaced by one line
    private static String[] adventureStr = new String[22]; //22 total strings, including ones that aren't scenarios
    private static int[] roomScores = {1,1,1,3,1,2,1,1,5,1,0,1,5,4,1,1,2};//represents the point value of each room; higher the value, the better choice made
    public static void main(String[] args) {
        int currentScenario = 1;
        try(Scanner fileScanner = new Scanner(new File("adventures.txt"), "UTF-8")){//reader to grab strings from the adventures.txt doc
            String fileString = "";//used to temporarily store the string aquired to check if it's at the end of the file
            int i = 0;//iterates thru for the String array
            fileString = fileScanner.useDelimiter(DELIMITER).next();//inital read, acts as a safeguard against empty files
            while(fileString != null){//checks if at eof
                adventureStr[i] = fileString;
                i++;
                if(i == 22) break;
                fileString = fileScanner.useDelimiter(DELIMITER).next();//uses the 2 newlines found at the end of each room/string to isolate each part
            }
        }
        catch (FileNotFoundException f){//safeguard in case file wasn't placed in right dir
            out.println("Oops! Looks like our story file wasn't found, make sure it exists in the same dir as this class!");
            out.println("More detailed output:\n"+f);
        }
        //Indx 0-4 are "wrapper" style strings that facilitate user input and other aspects, scenarios are 5-21
        out.println(adventureStr[0]+DELIMITER+adventureStr[1]);
        console.nextLine();
        clear();
         

    }
    private static void clear(){
        out.print("\033[H\033[2J");
    }
}
