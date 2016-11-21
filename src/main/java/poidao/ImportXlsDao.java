package poidao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Formation;
import entities.User;
import jpa.EmFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportXlsDao {

	
	@PersistenceContext
	EntityManager em;
	
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
		
		EntityManager em = EmFactory.createEntityManager();

		File excel = new File("C:/code/workspace/formation/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];


		List<User> datausers = new ArrayList<User>();

		for (Row r : ws) {
			User user = new User();
			try {
				Cell cName = r.getCell(7);
				user.setName(cName.toString());

				Cell cLastname = r.getCell(8);
				user.setLastname(cLastname.toString());

				Cell cAgence = r.getCell(1);
				user.setAgence(cAgence.toString());



				// user.setAgence(cLastname.toString());

			} catch (Exception ex) {
				// ex.printStackTrace();
			}

			datausers.add(user);
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

			
			//System.out.println(user);

		}
		//System.out.println(datausers.size());
		// System.out.println(datausers);
		
		
		em.close();



		
		return datausers;

	}

	public static List<Formation> formation() throws IOException {
		EntityManager em2 = EmFactory.createEntityManager();

		File excel = new File("C:/code/workspace/formation/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];


		List<Formation> dataformation = new ArrayList<Formation>();
		
		for (Row r : ws) {
			Formation formation = new Formation();
			try {

				Cell cDateReel = r.getCell(3);
				formation.setDateReel(cDateReel.getDateCellValue());
				
				Cell cNbjours = r.getCell(2);
				BigDecimal bdNbjours = new BigDecimal(cNbjours.toString());
				formation.setNbjours(bdNbjours);

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
			em2.getTransaction().begin();
			em2.persist(formation);
			em2.getTransaction().commit();


			//System.out.println(formation);
		}
		//System.out.println(dataformation.size());
		// System.out.println(datausers);


		em2.close();


		EmFactory.getInstance().close();
		return dataformation;
	}
		
}
