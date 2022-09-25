import static java.lang.System.in;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChooseYourOwnAdventure {
    private static Scanner console = new Scanner(in); // gets user input
    private static final String DELIMITER = "\n\n"; // in the adventure.txt file, I have all of them spaced by one line
    private static String[] adventureStr = new String[20]; // 22 total strings, including ones that aren't scenarios
    private static int[] roomScores = { 1, 1, 1, 3, 1, 2, 1, 1, 5, 1, 0, 1, 5, 4, 1, 1, 2 };// represents the point
    // value of each room
    // higher the value, the
    // better choice made
    private static String invalidChoice = "You didn't choose a valid choice, and the whole classroom corrupts. You glitch into the backrooms. "
            +
            "Good luck and Game Over";
    private static int currentScenario = 1;
    private static int score = 1;
    private static char ans;

    public static void main(String[] args) {
        boolean foundFile = false;
        while (!foundFile) {
            try (Scanner fileScanner = new Scanner(new File("adventures.txt"), "UTF-8")) {// reader to grab strings from
                                                                                          // the
                                                                                          // adventures.txt doc
                String fileString = "";// used to temporarily store the string aquired to check if it's at the end of
                                       // the file
                int i = 0;// iterates thru for the String array
                fileString = fileScanner.useDelimiter(DELIMITER).next();// inital read, acts as a safeguard against
                                                                        // empty
                // files
                while (fileString != null) {// checks if at eof
                    adventureStr[i] = fileString;
                    i++;
                    if (i == 20)
                        break;
                    fileString = fileScanner.useDelimiter(DELIMITER).next();// uses the 2 newlines found at the end of
                                                                            // each
                    // room/string to isolate each part
                }
                foundFile = true;
            } catch (FileNotFoundException f) {// safeguard in case file wasn't placed in right dir
                out.println(
                        "Oops! Looks like our story file wasn't found, make sure it exists in the same dir as this class!");
                out.println("More detailed output:\n" + f);
                // implement go to start call
            }
        }
        // Indx 0-3 are "wrapper" style strings that facilitate user input and other
        // aspects, scenarios are 4-20
        clear();
        out.print(adventureStr[0] + DELIMITER + adventureStr[1]);
        console.nextLine();
        clear();
        out.println(adventureStr[currentScenario + 2]);// scenario 1
        out.print(adventureStr[2]);
        ans = console.nextLine().toUpperCase().charAt(0);
        if (ans == 'T') {// scenario 2
            displayScenario(2, false);
            if (ans == 'S') {// scenario 4
                displayScenario(4, false);
                if (ans == 'T') {// scenario 8
                    displayScenario(8, true);
                } else if (ans == 'D') {// scenario 9
                    displayScenario(9, true);
                } else {
                    out.println(invalidChoice);
                }
            } else if (ans == 'K') {// scenario 5
                displayScenario(5, false);
                if (ans == 'G') {// scenario 10
                    displayScenario(10, true);
                } else if (ans == 'S') {// scenario 11
                    displayScenario(11, true);
                } else {
                    out.println(invalidChoice);
                }
            } else {
                out.println(invalidChoice);
            }
        } else if (ans == 'D') {// scenario 3
            displayScenario(3, false);
            if (ans == 'I') {// scenario 7
                displayScenario(7, false);

                if (ans == 'S') {// scenario 14
                    displayScenario(14, true);
                } else if (ans == 'L') {// scenario 15
                    displayScenario(15, false);
                    if (ans == 'W') {// scenario 17
                        displayScenario(17, true);
                    } else if (ans == 'T') {// scenario 16
                        displayScenario(16, true);
                    } else {
                        out.println(invalidChoice);
                    }
                } else {
                    out.println(invalidChoice);
                }
            } else if (ans == 'T') {// scenario 6
                displayScenario(6, false);

                if (ans == 'T') {// scenario 12
                    displayScenario(12, true);
                } else if (ans == 'S') {// scenario 13
                    displayScenario(13, true);
                } else {
                    out.println(invalidChoice);
                }
            } else {
                out.println(invalidChoice);
            }
        } else {
            out.println(invalidChoice);
        }
    }

    private static void clear() {
        out.print("\033[H\033[2J");
    }

    private static void displayScenario(int scenario, boolean end) {
        currentScenario = scenario;
        score += roomScores[currentScenario - 1];
        out.println(adventureStr[currentScenario + 2] + '\n');
        if (!end) {
            out.print(adventureStr[2]);
            ans = console.nextLine().toUpperCase().charAt(0);
        } else if (score < 10)
            out.println("In that scenario you won a total of " + score + " points. The most you can get is 10 points");
        else
            out.println("Nice job getting the highest score of " + score + '!');
    }
}
