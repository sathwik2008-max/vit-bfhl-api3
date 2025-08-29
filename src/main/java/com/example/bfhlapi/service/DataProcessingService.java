package com.example.bfhlapi.service;

import com.example.bfhlapi.dto.DataResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    
    // Default user information (fallback)
    private static final String DEFAULT_FULL_NAME = "john_doe";
    private static final String DEFAULT_EMAIL = "john@xyz.com";
    private static final String DEFAULT_ROLL_NUMBER = "ABCD123";
    
    public DataResponse processData(List<String> data, String fullName, String email, String rollNumber) {
        try {
            // Use provided user details or fallback to defaults
            String userFullName = (fullName != null && !fullName.trim().isEmpty()) ? fullName : DEFAULT_FULL_NAME;
            String userEmail = (email != null && !email.trim().isEmpty()) ? email : DEFAULT_EMAIL;
            String userRollNumber = (rollNumber != null && !rollNumber.trim().isEmpty()) ? rollNumber : DEFAULT_ROLL_NUMBER;
            
            // Generate user_id with current date
            String user_id = generateUserId(userFullName);
            
            // Separate data into different categories
            List<String> oddNumbers = new ArrayList<>();
            List<String> evenNumbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> specialCharacters = new ArrayList<>();
            List<String> allAlphabets = new ArrayList<>();
            int sum = 0;
            
            for (String item : data) {
                if (isNumeric(item)) {
                    int num = Integer.parseInt(item);
                    sum += num;
                    if (num % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (isAlphabet(item)) {
                    alphabets.add(item.toUpperCase());
                    allAlphabets.add(item);
                } else {
                    specialCharacters.add(item);
                }
            }
            
            // Generate concatenated string with alternating caps in reverse order
            String concatString = generateConcatString(allAlphabets);
            
            return new DataResponse(
                true,
                user_id,
                userEmail,
                userRollNumber,
                oddNumbers,
                evenNumbers,
                alphabets,
                specialCharacters,
                String.valueOf(sum),
                concatString
            );
            
        } catch (Exception e) {
            // Return error response
            return new DataResponse(
                false,
                generateUserId(DEFAULT_FULL_NAME),
                DEFAULT_EMAIL,
                DEFAULT_ROLL_NUMBER,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                "0",
                ""
            );
        }
    }
    
    private String generateUserId(String fullName) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String dateString = currentDate.format(formatter);
        // Convert full name to lowercase and replace spaces with underscores
        String formattedName = fullName.toLowerCase().replaceAll("\\s+", "_");
        return formattedName + "_" + dateString;
    }
    
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isAlphabet(String str) {
        return str.matches("^[a-zA-Z]+$");
    }
    
    private String generateConcatString(List<String> alphabets) {
        if (alphabets.isEmpty()) {
            return "";
        }
        
        // Concatenate all alphabets
        String concatenated = String.join("", alphabets);
        
        // Reverse the string
        String reversed = new StringBuilder(concatenated).reverse().toString();
        
        // Apply alternating caps
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        
        return result.toString();
    }
}
