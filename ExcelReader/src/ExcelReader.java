import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static void main(String[] args) {
		// create file path.
		String wd = System.getProperty("user.dir");

		// get name list.
		List<String> nameList = retrieveNameList(wd+"/src/meibo.xls");
		if(nameList == null){
			System.out.println("cannot retrieve name list.");
			return;
		}

		// create folders
		createFolders(wd + "/output/", nameList);
	}

	static List<String> retrieveNameList(String excelFile){
		List<String>nameList = new ArrayList<String>();
		Exception exception = null;

		try {
			FileInputStream in = new FileInputStream(excelFile);
			Workbook wb = WorkbookFactory.create(in);
			Sheet sheet1 = wb.getSheet("Sheet1");
			for(int i=0;i<100;i++){
				Row row = sheet1.getRow(i);
				Cell cell = row.getCell(0);
				nameList.add( cell.getStringCellValue() );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			exception = e;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			exception = e;
		} catch (IOException e) {
			e.printStackTrace();
			exception = e;
		}

		if(exception != null){
			return null;
		}

		return nameList;
	}

	static void createFolders(String path, List<String>nameList){
		for(String name: nameList){
			File f = new File(path + name);
			if(!f.exists()){
				f.mkdirs();
			}
		}
	}
}
