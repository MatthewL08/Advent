import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03Template {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        int largestCombination = Integer.parseInt(batteries.substring(0, 1))*10;
        int indexOfHighest = 0;
        for (int i = 0; i < batteries.length() - 1; i++) {
            int a = Integer.parseInt(batteries.substring(i, i+1));
            int b = Integer.parseInt(batteries.substring(i+1, i+2));
            if (b > a){
                largestCombination = b *10;
                indexOfHighest = i;
            }
        }

        return largestCombination;
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}