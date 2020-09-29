package net.guides.springboot2.springboot2jpacrudexample.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import net.guides.springboot2.springboot2jpacrudexample.model.Mahasiswa;

public class UploadHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "id", "idmahasiswa", "nama", "alamat" };
	  static String SHEET = "ExcelTes";
	  
	  public static boolean hasExcelFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  
	  public static List<Mahasiswa> excelToTutorials(InputStream is) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);

		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();

		      List<Mahasiswa> tutorials = new ArrayList<Mahasiswa>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }

		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        Mahasiswa mahasiswa = new Mahasiswa();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();

		          switch (cellIdx) {
		          case 0:
		            mahasiswa.setId((long) currentCell.getNumericCellValue());
		            break;

		          case 1:
		        	  mahasiswa.setIdmahasiswa((long) currentCell.getNumericCellValue());
		            break;

		          case 2:
		        	  mahasiswa.setNama(currentCell.getStringCellValue());
		            break;

		          case 3:
		        	  mahasiswa.setAlamat(currentCell.getStringCellValue());
		            break;

		          default:
		            break;
		          }

		          cellIdx++;
		        }

		        tutorials.add(mahasiswa);
		      }

		      workbook.close();

		      return tutorials;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }

}
