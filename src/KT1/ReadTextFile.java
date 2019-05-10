package KT1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.io.*;


public class ReadTextFile {

	public static void main(String[] args) throws IOException {
		ReadTextFile tr = new ReadTextFile();
		int[] numbers = Arrays.stream(tr.readFile("numbers.txt").split("\\s+|,\\s*|\\.\\s*")).mapToInt(Integer::parseInt).toArray();
		String[] words = tr.readFile("words.txt").split(" ");
		tr.printMinAvgMaxValues(numbers);
		System.out.println("Ilma etteantud täheta leidub nii palju teisi tähti: " + tr.LetterCount(words, 'l'));
		System.out.println(tr.WordCount(words));
	}

	public String readFile (String name) throws IOException {
		return new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);
	}
	
	public void printMinAvgMaxValues (int[] numbers) {
		int max = numbers[0];
		int min = numbers[0];
		double sum = 0;
		double avg;
		
		for (int number : numbers) {
			if (number < min) {
				min = number;
			} else if (number > max) {
				max = number;
			}
			sum += number;
		}
		avg = sum / numbers.length;
		System.out.println("Max: " + max + ", Min: " + min + ", Avg: " + avg);
	}
	
	public String WordCount (String[] words) {
		String result = "";
		HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (String word : words) {
			Integer value = wordsMap.get(word);
			if (value != null) {				
				wordsMap.put(word, wordsMap.get(word) + 1);
			} else {
				wordsMap.put(word, 1);
			}
		}
		
		for(Entry<String, Integer> m : wordsMap.entrySet()) {
			result += m.getKey() + ": " + m.getValue() + "; ";
		}
		
		return result;
	}
	
	public int LetterCount (String[] words, char c) {
		int count = 0;
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) != c) {
					count ++;
				}
			}
		}
		return count;
	}
	
}
