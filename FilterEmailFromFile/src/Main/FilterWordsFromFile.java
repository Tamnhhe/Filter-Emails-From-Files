package Main;

/*
 * Author: Tamnhhe
 * Version: 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A Java program to filter and extract email addresses from a text file.
 */
public class FilterWordsFromFile {

    /**
     * The main method that reads an input file, filters email addresses,
     * and writes the results to an output file.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        String inputFile = "src/Source/input.txt";  // Input file name
        String outputFile = "src/Source/output.txt";  // Output file name

        try {
            // Open the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            // Open the output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            Map<String, Integer> wordCount = new HashMap<>();
            Set<String> uniqueWords = new HashSet<>();
            List<String> filteredEmails = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                // Use regular expression to split words
                String[] words = line.split("\\s");
                for (String word : words) {
                    // Check if the word contains "@" and is not already in wordCount
                    if (word.contains("@") && uniqueWords.add(word)) {
                        // Remove unwanted characters from the email
                        word = word.replaceAll("[<>;/ª,]", "");
                        // Convert the email to lowercase
                        word = word.toLowerCase();
                        filteredEmails.add(word);
                        wordCount.put(word, 1);
                    }
                }
            }
            Collections.sort(filteredEmails);
            for (String email : filteredEmails) {
                writer.write(email);
                writer.newLine();
            }
            // Close the files after processing
            reader.close();
            writer.close();

            System.out.println("Email filtering successful.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred.");
        }
    }
}
