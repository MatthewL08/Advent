import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Advent01 {


    public static int partOneAnswer = 0;
    public static int partTwoAnswer = 0;
    public static int position = 50;


    public static void main(String[] args) {




        // get a list of Strings from the data file we created
        ArrayList<String> fileData = getFileData("src/data");


        // go through the list line by line
        for (String current : fileData) {
            String direction = current.substring(0, 1);
            int turn = Integer.parseInt(current.substring(1));
            position = turn(direction, turn);
            if (position == 0) {
                partOneAnswer++;
            }
        }
        System.out.println(partOneAnswer);
        System.out.println(partTwoAnswer);
    }
    public static int turn (String direction, int turn) {
        if (direction.equals("L")) {
            position = position - turn;
            for (int i = 0; position < 0; i++){
                position = position + 100;
                partTwoAnswer = partTwoAnswer + 1;
            }
        }
        if (direction.equals("R")) {
            position = position + turn;
            for (int i = 0; position > 99; i++){
                position = position - 100;
                partTwoAnswer = partTwoAnswer + 1;
            }
        }

        return position;
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


