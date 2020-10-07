import java.io.*;
import java.util.*;
import java.lang.Object;

public class nato {
    static final int NUMBER_OF_WORDS = 26;

    public static void main(String[] args) {
        String path = "nato.csv";
        File file = new File(path);
        Scanner scanner;
        //Try catch block for reading the files
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {

            System.out.println("File not found");
            return;
        }
        //Parallel arrays for storage
        String[] phoneticLetters = new String[NUMBER_OF_WORDS];
        String[] phoneticWords = new String[NUMBER_OF_WORDS];

        //Reading the nato files
        scanner.nextLine();
        //For loop for reading each of em

        for (int i = 0; i < NUMBER_OF_WORDS; i++) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            //Different from their counterparts
            //Those are used as an array vs these
            //These store their individual values
            String phoneticLetter;
            phoneticLetter = columns[0];
            String phoneticWord = columns[1];
            //Placing the data
            phoneticLetters[i] = phoneticLetter;
            phoneticWords[i] = phoneticWord;

        }
        //Turning phoneticLetters into phoneticLettersChar array
        String s = "";
        for (String n : phoneticLetters)
            s += n;
            char[] phoneticLettersChar = s.toCharArray();


        //Creating the scanner
        Scanner in = new Scanner(System.in);

        //Create a randomly generated letter from a-z
        Random rnd = new Random();

        //Creating a counter for the questions asked
        int countedCorrect = 0;
        //Asking for 10 questions
        for (int i = 0; i < 10; i++) {

            //c for character set equal to the next int plus a, char so it isn't a string
            char c = (char) (rnd.nextInt(26) + 'a');
            char cUpper= Character.toUpperCase(c);
            //Print the value of the char
           // int value = Character.getNumericValue(c);

            //Goes through the array to find the character equal to the randomized one
            for(int a =0; a<NUMBER_OF_WORDS; a++) {
                if (cUpper == phoneticLettersChar[a]) {
                    //Answer is set to what ever the phonetic word is in the array
                    String ans = phoneticWords[a];
                    System.out.println("Please input the correct phonetic word for the letter below:");
                    System.out.println(c);
                    String wordInput = in.nextLine();

                    if (wordInput.equalsIgnoreCase(ans)) {
                        System.out.println("Correct");
                        countedCorrect++;

                    } else {
                        System.out.println("Incorrect, the correct answer was " + ans);


                    }
                }


            }
            //Creating the output for the end of the file
            if(i==10)
            {
                System.out.printf("You got %d/10 correct homie",countedCorrect);
                if(countedCorrect==10){
                    System.out.println("Well done!");


                }

            }








        }


    }
}


