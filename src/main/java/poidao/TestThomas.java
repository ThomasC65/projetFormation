package poidao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import entities.DemandeFormation;
import entities.Formation;
import entities.User;
import jpa.EmFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestThomas {

	public void readEntierFile() throws IOException {

		File excel = new File("C:/code/workspace/formation/sopra-modified.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Suivi");

		UserDao ud = new UserDao();
		FormationDao fd = new FormationDao();
		DemandeFormationDao dfd = new DemandeFormationDao();

		boolean first = true;
		for (Row r : ws) {
			if (first) {
				first = false;
				continue;
			}
			try {

				User user = new User();

				Cell cName = r.getCell(7);
				user.setName(cName.toString());

				Cell cLastname = r.getCell(8);
				user.setLastname(cLastname.toString());

				Cell cAgence = r.getCell(1);
				user.setAgence(cAgence.toString());

				user = ud.getOrInsertUserInDb(user);

				Formation formation = new Formation();

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

				Cell cDateAttendue = r.getCell(4);
				formation.setDateAttendue(cDateAttendue.getDateCellValue());

				formation = fd.getOrInsertFormationInDb(formation);

				DemandeFormation demandeFormation = new DemandeFormation();
				demandeFormation.setUser(user);
				demandeFormation.setFormation(formation);

				demandeFormation = dfd.getOrInsertDemandeFormationInDb(demandeFormation, user, formation);

			} catch (Exception ex) {
				ex.printStackTrace();
				//break;
			}

		}

		EmFactory.close();
	}
}
