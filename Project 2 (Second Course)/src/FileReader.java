
//Imported file reading
import java.util.Scanner;
import java.io.File;
//File reader class
public class FileReader {

    //Number of skaters defined as a static number
    static final int NUMBER_OF_SKATERS = 21;

    //All columns are defined as such, they are also static and final
    static final String[] SKATER_NAMES = new String[NUMBER_OF_SKATERS];
    static final String[] SKATER_CLUBS = new String[NUMBER_OF_SKATERS];
    static final double[] SHORT_PROGRAM_POINTS = new double[NUMBER_OF_SKATERS];
    static final double[] LONG_PROGRAM_POINTS = new double[NUMBER_OF_SKATERS];
    static final double[] PROGRAM_COMPONENTS = new double[NUMBER_OF_SKATERS]; //Artistic points
    static final double[] EXECUTED_ELEMENTS = new double[NUMBER_OF_SKATERS];//Athletic points
    static final double[] TOTAL_POINTS = new double[NUMBER_OF_SKATERS];
    static final String[] HIGHEST_SCORE_SKATER= new String[1];

    //Using file not found exception instead of a try catch block
    public static void main(String[] args) {

        //Creating a simple path in case I decide to change it back to text
        String path = ("fsdata (3).csv");
        File file = new File(path);
        Scanner scanner;

        //Try catch block for reading the file
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }

        scanner.nextLine();

        for (int i = 0; i < NUMBER_OF_SKATERS; i++) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");

            String skaterName = columns[0];
            String skaterClub = columns[1];

            //Parsing Doubles
            double shortProgram = Double.parseDouble(columns[2]);
            double longProgram = Double.parseDouble(columns[3]);
            double programComponent = Double.parseDouble(columns[4]);
            double executedElement = Double.parseDouble(columns[5]);

            SKATER_NAMES[i] = skaterName;
            SKATER_CLUBS[i] = skaterClub;
            SHORT_PROGRAM_POINTS[i] = shortProgram;
            LONG_PROGRAM_POINTS[i] = longProgram;
            PROGRAM_COMPONENTS[i] = programComponent;
            EXECUTED_ELEMENTS[i] = executedElement;

        }
        scanner.close();

        double highestScore = 0;

        //Calculating the highest scores
        for (int i = 0; i < NUMBER_OF_SKATERS; i++) {
            String skaterName = SKATER_NAMES[i];
            String skaterClub = SKATER_CLUBS[i];
            double shortProgram = SHORT_PROGRAM_POINTS[i];
            double longProgram = LONG_PROGRAM_POINTS[i];
            double programComponent = PROGRAM_COMPONENTS[i];
            double executedElement = EXECUTED_ELEMENTS[i];
            double totalPoints = longProgram + shortProgram;
            TOTAL_POINTS[i] = totalPoints;

            for (int a = 0; a < NUMBER_OF_SKATERS; a++) {
                if (highestScore < TOTAL_POINTS[a]) {
                    highestScore = TOTAL_POINTS[a];

                }


            }
            System.out.printf("%d\t%s (%s)  %f [%f] %f %f %f %n", i + 1, skaterName, skaterClub, shortProgram, longProgram, programComponent, executedElement, totalPoints);

            if (i == NUMBER_OF_SKATERS - 1) {
                System.out.printf("Highest Score:%f", highestScore);
            }
            //Reading the int on the next line to allocate all the arrays


        }

    }
}
