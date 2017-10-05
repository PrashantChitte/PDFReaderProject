package com.rest.PDFtoExcel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfReadExample {

	public static void main(String[] args) throws IOException {
		Individual ind;

		/*
		 * 
		 * Document reader1=null; PdfReader reader; FileReader er=null;
		 * BufferedReader bw=null;
		 * 
		 * Document document = new Document();
		 * 
		 * try {
		 * 
		 * reader = new PdfReader("G:/download");
		 * PdfWriter.getInstance(document, new FileOutputStream(new
		 * File("G:/temp")));
		 * 
		 * // pageNumber = 1 String textFromPage =
		 * PdfTextExtractor.getTextFromPage(reader, 1);
		 * 
		 * System.out.println(textFromPage);
		 * 
		 * reader.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } catch
		 * (DocumentException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		int count = 0;
		PdfReader reader = null;
		try {
			reader = new PdfReader("F:/yogeshSir/PDF/download.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter("Demo.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			count = reader.getNumberOfPages();
			for (int i = 1; i <= count; i++) {
				String page = PdfTextExtractor.getTextFromPage(reader, i);
				bw.write(page);
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* Create Workbook and Worksheet */
		/*
		 * XSSFWorkbook workbook = new XSSFWorkbook(); XSSFSheet sheet =
		 * workbook.createSheet("Java Books");
		 * 
		 * 
		 * 
		 * int rowCount = 0;
		 * 
		 * for (Object[] aBook : bookData) { Row row =
		 * sheet.createRow(++rowCount);
		 * 
		 * int columnCount = 0;
		 * 
		 * for (Object field : aBook) { Cell cell =
		 * row.createCell(++columnCount); if (field instanceof String) {
		 * cell.setCellValue((String) field); } else if (field instanceof
		 * Integer) { cell.setCellValue((Integer) field); } }
		 * 
		 * }
		 * 
		 * 
		 * /* try (FileOutputStream outputStream = new
		 * FileOutputStream("G:/JavaBooks.xlsx")) {
		 * workbook.write(outputStream); }
		 */

		FileReader fileread = new FileReader("Demo.txt");
		BufferedReader br = new BufferedReader(fileread);
		String line = br.readLine();
		ind = new Individual();
		while (line != null) {
			Individual indObject=createIndividualObject(line,br,ind);
			
						line = br.readLine();
		}
	}
	
	public static Individual createIndividualObject(String line,BufferedReader br,Individual ind) throws IOException
	{
		String cons = "Individual";
		boolean flag = false;
		while (line.equalsIgnoreCase(cons) || flag == true) {
			flag = true;
			if (flag == true) {
				line = br.readLine();
			}
			else
			{
				break;
			}
			if (line.contains("First Name")) {
				int nextIndex = line.lastIndexOf("Middle Name");
				ind.setFirstName(line.substring("First Name".length() + 1, nextIndex));
				System.out.println("first name:" + ind.getFirstName());
			}
			if (line.contains("Middle Name")) {
				int startIndex = line.lastIndexOf("Middle Name") + "Middle Name".length();
				ind.setMiddleName(line.substring(startIndex));
				System.out.println("Middle Name:" + ind.getMiddleName());
			}
			if (line.contains("Last Name")) {
				int startIndex = line.lastIndexOf("Last Name") + "Last Name".length();
				ind.setLastName(line.substring(startIndex));
				System.out.println("Last name:" + ind.getLastName());
			}
			if (line.contains("Father Full Name")) {
				int startIndex = "Father Full Name".length();
				ind.setFaterName(line.substring(startIndex));
				System.out.println("father :" + ind.getFaterName());
			}
			if (line.contains("Do you have any Past")) {
				int startIndex = "Do you have any Past".length();
				ind.setAnyExperience(line.substring(startIndex));
				System.out.println("Experince :" + ind.getAnyExperience());
				System.out.println("Here is Individual Object:\n" + ind);
				flag=false;
			}
		}

		return ind;
		
	}
}
