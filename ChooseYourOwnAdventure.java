import static java.lang.System.in;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChooseYourOwnAdventure {
    private static Scanner console = new Scanner(in); // gets user input
    private static final String DELIMITER = "\n\n"; // in the adventure.txt file, I have all of them spaced by one line
    private static String[] adventureStr = new String[21]; // 22 total strings, including ones that aren't scenarios
    private static int[] roomScores = { 1, 1, 1, 3, 1, 2, 1, 1, 5, 1, 0, 1, 5, 4, 1, 1, 2 };// represents the point
                                                                                            // value of each room;
                                                                                            // higher the value, the
                                                                                            // better choice made
    private static String invalidChoice = "You didn't choose a valid choice, and the whole classroom corrupts. You glitch into the backrooms. "
            +
            "Good luck and Game Over";

    public static void main(String[] args) {
        int currentScenario = 1;
        char ans;
        try (Scanner fileScanner = new Scanner(new File("adventures.txt"), "UTF-8")) {// reader to grab strings from the
                                                                                      // adventures.txt doc
            String fileString = "";// used to temporarily store the string aquired to check if it's at the end of
                                   // the file
            int i = 0;// iterates thru for the String array
            fileString = fileScanner.useDelimiter(DELIMITER).next();// inital read, acts as a safeguard against empty
            // files
            while (fileString != null) {// checks if at eof
                adventureStr[i] = fileString;
                i++;
                if (i == 21)
                break;
                fileString = fileScanner.useDelimiter(DELIMITER).next();// uses the 2 newlines found at the end of each
                // room/string to isolate each part
            }
        } catch (FileNotFoundException f) {// safeguard in case file wasn't placed in right dir
        out.println(
            "Oops! Looks like our story file wasn't found, make sure it exists in the same dir as this class!");
            out.println("More detailed output:\n" + f);
            // implement go to start call
        }
        // Indx 0-3 are "wrapper" style strings that facilitate user input and other
        // aspects, scenarios are 4-20
        int score = 1;
        out.println(adventureStr[0] + DELIMITER + adventureStr[1]);
        console.nextLine();
        clear();
        out.println(adventureStr[currentScenario + 4]);// scenario 1
        out.println(adventureStr[3]);
        ans = console.nextLine().toUpperCase().charAt(0);
        if (ans == 'T') {// scenario 2
            currentScenario = 2;
            score += roomScores[currentScenario - 1];
            out.println(adventureStr[currentScenario + 4]);
            out.println(adventureStr[3]);
            ans = console.nextLine().toUpperCase().charAt(0);
            if (ans == 'S') {// scenario 4
                currentScenario = 4;
                score += roomScores[currentScenario - 1];
                out.println(adventureStr[currentScenario + 4]);
                out.println(adventureStr[3]);
                ans = console.nextLine().toUpperCase().charAt(0);
                if (ans == 'T') {// scenario 8
                    currentScenario = 8;
                    score = roomScores[currentScenario - 1];
                    out.println(adventureStr[currentScenario + 4]);
                    out.println(adventureStr[4]);
                    // implement go back to beginning or stop
                } else if (ans == 'D') {// scenario 9
                    currentScenario = 9;
                    score = roomScores[currentScenario - 1];
                    out.println(adventureStr[currentScenario + 4]);
                    out.println(adventureStr[4]);
                    // implement go back to beginning or stop
                } else {
                    out.println(invalidChoice);
                    // implement go back to beginning or stop
                }
            } else if (ans == 'K') {// scenario 5
                currentScenario = 5;
                score = roomScores[currentScenario - 1];
                out.println(adventureStr[currentScenario + 4]);
                out.println(adventureStr[3]);
                ans = console.nextLine().toUpperCase().charAt(0);
                if (ans == 'G') {// scenario 10
                    currentScenario = 10;
                    score = roomScores[currentScenario - 1];
                    out.println(adventureStr[currentScenario + 4]);
                    out.println(adventureStr[4]);
                    // implement go back to beginning or stop
                } else if (ans == 'S') {// scenario 11
                    currentScenario = 11;
                    score = roomScores[currentScenario - 1];
                    out.println(adventureStr[currentScenario + 4]);
                    out.println(adventureStr[4]);
                    // implement go back to beginning or stop
                } else {
                    out.println(invalidChoice);
                    // implement go back to beginning or stop
                }
            } else {
                out.println(invalidChoice);
            }
        } else if (ans == 'D') {// scenario 3
            currentScenario = 3;
            score += roomScores[currentScenario - 1];
            out.println(adventureStr[currentScenario + 4]);
            out.println(adventureStr[3]);
            ans = console.nextLine().toUpperCase().charAt(0);
            if (ans == 'I') {// scenario 7
                currentScenario = 7;
                score = roomScores[currentScenario - 1];
                out.println(adventureStr[currentScenario + 4]);
                out.println(adventureStr[3]);
                ans = console.nextLine().toUpperCase().charAt(0);
                if (ans == 'S') {// scenario 14
                    currentScenario = 14;
                    score = roomScores[currentScenario - 1];
                    out.println(adventureStr[currentScenario + 4]);
                    out.println(adventureStr[4]);
                    // implement go back to beginning or stop
                } else if (ans == 'L') {// scenario 15
                    currentScenario = 15;
                    score = roomScores[currentScenario - 1];
                    out.println(adventureStr[currentScenario + 4]);
                    out.println(adventureStr[3]);
                    ans = console.nextLine().toUpperCase().charAt(0);
                    if(ans == 'W'){//scenario 17
                        currentScenario = 17;
                        score = roomScores[currentScenario - 1];
                        out.println(adventureStr[currentScenario +4]);
                        out.println(adventureStr[4]);
                        //implement go back to beginning or stop
                    }
                    else if(ans == 'T'){//scenario 16
                        currentScenario = 16;
                        score = roomScores[currentScenario - 1];
                        out.println(adventureStr[currentScenario+4]);
                        out.println(adventureStr[4]);
                        //implement go back to beginning or stop
                    }
                    else{
                        out.println(invalidChoice);
                        //implement go back to beginning or stop
                    }
                } else {
                    out.println(invalidChoice);
                    // implement go back to beginning or stop
                }
            } else if (ans == 'T') {// scenario 6

            } else {
                out.println(invalidChoice);
                // implement go back to beginning or stop
            }
        } else {
            out.println(invalidChoice);
        }
    }

    private static void clear() {
        out.print("\033[H\033[2J");
    }
}
