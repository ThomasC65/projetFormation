package poidao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Formation;
import entities.User;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportXlsDao {

	public static void readEntierFile() throws IOException {
		// TODO Auto-generated method stub
		File excel = new File("C:/code/workspace/formation/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {
			XSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.toString();
				data[i][j] = value;
				// System.out.println("the value is " + value);
			}
		}
	}

	public static List<User> users() throws IOException {

		File excel = new File("C:/code/workspace/formation/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];

		User user = new User();
		List<User> datausers = new ArrayList<User>();

		for (Row r : ws) {

			try {
				Cell cName = r.getCell(7);
				user.setName(cName.toString());

				Cell cLastname = r.getCell(8);
				user.setLastname(cLastname.toString());

				Cell cAgence = r.getCell(1);
				user.setAgence(cAgence.toString());

				datausers.add(user);

				// user.setAgence(cLastname.toString());

			} catch (Exception ex) {
				// ex.printStackTrace();
			}

			System.out.println(user);
		}

		// System.out.println(datausers);
		return datausers;

	}

	public static List<Formation> formation() throws IOException {

		File excel = new File("C:/code/workspace/formation/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];

		Formation formation = new Formation();
		List<Formation> dataformation = new ArrayList<Formation>();
		
		for (Row r : ws) {

			try {


				Cell cNbjours = r.getCell(2);
				formation.setNbjours(BigDecimal.valueOf(cNbjours.toString()));

				Cell cFormation = r.getCell(5);
				formation.setFormation(cFormation.toString());

				Cell cLieuFormation = r.getCell(6);
				formation.setLieuFormation(cLieuFormation.toString());

				Cell cOrganisme = r.getCell(9);
				formation.setOrganisme(cOrganisme.toString());

				dataformation.add(formation);

				// user.setAgence(cLastname.toString());

			} catch (Exception ex) {
				// ex.printStackTrace();
			}

			System.out.println(formation);
		}

		// System.out.println(datausers);
		return dataformation;

		
		
	}
		
}
