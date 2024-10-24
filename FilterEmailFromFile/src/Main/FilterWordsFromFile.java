package Main;

/*
 * Author: Tamnhhe
 * Version: 1.1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Set<String> uniqueEmails = new HashSet<>();
            List<String> filteredEmails = new ArrayList<>();

            // Define a regex pattern for matching email addresses
            Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

            while ((line = reader.readLine()) != null) {
                // Find all email addresses in the current line
                Matcher matcher = emailPattern.matcher(line);
                while (matcher.find()) {
                    String email = matcher.group().toLowerCase();
                    // Remove any unwanted characters from the email
                    email = email.replaceAll("[<>;/ª,]", "");
                    // Add to the list if it's unique
                    if (uniqueEmails.add(email)) {
                        filteredEmails.add(email);
                    }
                }
            }

            // Sort and write the filtered email addresses to the output file
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
