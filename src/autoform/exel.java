package autoform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class exel {

	public exel() {

	}
	
	FileInputStream in = null;
	Workbook wb = null;
	private int startgyo=2;//最初のデータが入っている行番号
	private int startRetsu=2;//最初のデータが入っている列番号
	private int retsuSize=24;
	public void setRetsuSize(int x,int y){
		retsuSize=this.getSE(x, y);
	}
	public void setStartgyo(int a){
		startgyo=a;
	}
	public String getSEString(int x,int y){
		String nun;
		try {
			in = new FileInputStream("testExample.xls");
			wb = WorkbookFactory.create(in);
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (InvalidFormatException e) {
			System.out.println(e.toString());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(y);
		Cell cell1 = row.getCell(x);
		int celltype=cell1.getCellType();
		if(celltype==Cell.CELL_TYPE_STRING) {

				nun= cell1.getStringCellValue();
		}else{
			return "";
		}
		return nun;
	}
	public int getSE(int x,int y){//エクセルの任意のセルのintを返すメソッド
		int nun=0;
		try {
			in = new FileInputStream("testExample.xls");
			wb = WorkbookFactory.create(in);
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (InvalidFormatException e) {
			System.out.println(e.toString());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(y);
		Cell cell1 = row.getCell(x);
		int celltype=cell1.getCellType();
		System.out.println(Cell.CELL_TYPE_NUMERIC);
		if(celltype==Cell.CELL_TYPE_NUMERIC) {

			if (DateUtil.isCellDateFormatted(cell1)) {
				// System.out.println("Date:" +
				// cell1.getDateCellValue());
			} else {
				// System.out.println("Numeric:" +
				// Math.round(cell1.getNumericCellValue()));
				nun= (int) Math.round(cell1.getNumericCellValue());
			}
		}else{
			return -1;
		}
		return nun;
	}

	public String[][] get(int gyo, int gyoend) {
		gyoend++;
		int gyoSize = gyoend - gyo;
		String exdata[][] = new String[gyoSize][retsuSize];
		try {
			in = new FileInputStream("testExample.xls");
			wb = WorkbookFactory.create(in);
		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (InvalidFormatException e) {
			System.out.println(e.toString());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		Sheet sheet = wb.getSheetAt(0);//0番目のシート
		for (int i = 0; i < gyoSize; i++) {
			ArrayList<String> list = new ArrayList<String>();
			System.out.println(gyo-1+i);
			Row row = sheet.getRow(gyo-1+i);// i行を取得
			if (row == null) {
				return null;
				// row = sheet.createRow(retu);
			}
			for (int i2 = startRetsu-1; i2 < retsuSize+startRetsu-1; i2++) {
				Cell cell1 = row.getCell(i2);// 引数は列番号
				if (cell1 == null) {
					cell1 = row.createCell(i2);
					cell1.setCellValue(0);
					FileOutputStream out = null;
				    try{
				      out = new FileOutputStream("testExample.xls");
				      wb.write(out);
				    }catch(IOException e){
				      System.out.println(e.toString());
				    }finally{
				      try {
				        out.close();
				      }catch(IOException e){
				        System.out.println(e.toString());
				      }
				    }
				}

				switch (cell1.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					// System.out.println("String:" +
					// cell1.getStringCellValue());
					list.add(cell1.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell1)) {
						// System.out.println("Date:" +
						// cell1.getDateCellValue());
					} else {
						// System.out.println("Numeric:" +
						// Math.round(cell1.getNumericCellValue()));
						list.add(String.valueOf(Math.round(cell1.getNumericCellValue())));
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.println("Boolean:" + cell1.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					System.out.println("Formula:" + cell1.getCellFormula());
					break;
				case Cell.CELL_TYPE_ERROR:
					System.out.println("Error:" + cell1.getErrorCellValue());
					break;
				case Cell.CELL_TYPE_BLANK:
					System.out.println("Blank:");
					break;
				}
				
			}

			//System.out.println(retsuSize);
			for(int i3=0;i3<retsuSize;i3++){
				exdata[i][i3] = list.get(i3);
			}
		}
		return exdata;
	}
}
