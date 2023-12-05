import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) throws FileNotFoundException {

        // 17 words
        String filePath = "sample.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder fileContent = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(" ");
            }

            reader.close();

            // Convert the fileContent to String and split by whitespace("\\s+")
            String[] words = fileContent.toString().split("\\s+");

            int wordCount = words.length;

            System.out.println("Total number of words in file '" + filePath + "' is: " + wordCount);

            // TODO: 1.Frequency of each word, 2. Average word length

        } catch (IOException e) {
            System.out.println("File Error");
        }

    }
}
