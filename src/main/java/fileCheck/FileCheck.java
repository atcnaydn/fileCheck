package fileCheck;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileCheck {

	public static void main(String args[]) {

		fileCheck();

	}

	public static void fileCheck() {

		Boolean bool = null;
		Scanner scanner = new Scanner(System.in);
		String word;

		do {
			System.out.println("What word, apple, table, orange?");
			word = scanner.next();
			if (word.equalsIgnoreCase("apple") || word.equalsIgnoreCase("table") || word.equalsIgnoreCase("orange")) {
				bool = true;
			} else {
				bool = false;
			}
		} while (bool == false);

		ExcelReader excelRead = null;

		try {
			excelRead = new ExcelReader("./src/main/java/data/dictionary.xlsx");
			System.out.println("File Found.");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		}

		String appleWord = excelRead.getCellData("Sheet1", "word", 2);
		String appleMeaning1 = excelRead.getCellData("Sheet1", "meaning", 2);
		String appleMeaning2 = excelRead.getCellData("Sheet1", "meaning2", 2);

		String tableWord = excelRead.getCellData("Sheet1", "word", 3);
		String tableMeaning1 = excelRead.getCellData("Sheet1", "meaning", 3);
		String tableMeaning2 = excelRead.getCellData("Sheet1", "meaning2", 3);

		String orangeWord = excelRead.getCellData("Sheet1", "word", 4);
		String orangeMeaning1 = excelRead.getCellData("Sheet1", "meaning", 4);

		if (word.equalsIgnoreCase("apple")) {
			System.out.println("Word: " + appleWord);
			System.out.println("Meaning1: " + appleMeaning1);
			System.out.println(appleMeaning2);
		}
		if (word.equalsIgnoreCase("table")) {
			System.out.println("Word: " + tableWord);
			System.out.println("Meaning1: " + tableMeaning1);
			System.out.println("Meaning2: " + tableMeaning2);
		}
		if (word.equalsIgnoreCase("orange")) {
			System.out.println("Word: " + orangeWord);
			System.out.println("Meaning1: " + orangeMeaning1);
		}

	}

}
