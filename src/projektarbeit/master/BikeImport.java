package projektarbeit.master;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BikeImport 
{

    public static void main(String[] args) throws IOException 
    {
        String excelFilePath = "C:\\Users\\Julian\\Google Drive\\IT-Projekt\\finale Daten\\Verwendete Datensätze\\Bike_bereinigt.xlsx";

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);

        ArrayList<BikeObject> bikeObjectList = new ArrayList<>();

        Sheet workSheet = workbook.getSheet("Blatt1");

        Map<String, Integer> indices = new HashMap<>();

        //Durchlaufen der einzelnen Zeilen eines Worksheets
        for(int zeile=0; zeile<=workSheet.getLastRowNum();zeile++)
           {
               Row actualRow= workSheet.getRow(zeile);
               BikeObject bike = new BikeObject();

               //Durchlaufen der einzelnen Zellen
                for(int zelle=0; zelle<=actualRow.getLastCellNum();zelle++)
                {
                    Cell actualCell = actualRow.getCell(zelle);

                    try 
                    {
                         int c =actualCell.getCellType();
                    } 
                    catch (NullPointerException e) 
                    {
                          break;
                    }

                    if(zeile==0)
                    {
                        actualCell.setCellType(Cell.CELL_TYPE_STRING);
                        indices.put(actualCell.getStringCellValue(), zelle);
                    }

                    else
                    {
                        actualCell.setCellType(Cell.CELL_TYPE_STRING);
                        
                        if(zelle==indices.get("DATE_FROM"))//StartRentalTime
                            bike.setStartRentalTime(actualCell.getStringCellValue());
                        
                        if(zelle==indices.get("DATE_UNTIL"))//EndRentalTime
                            bike.setEndRentalTime(actualCell.getStringCellValue());
                        
                        if(zelle==indices.get("START_RENTAL_ZONE"))//StartRentalZone
                            bike.setStartRentalZone(actualCell.getStringCellValue());
                        
                        if(zelle==indices.get("END_RENTAL_ZONE"))//EndRentalZone
                            bike.setEndRentalZone(actualCell.getStringCellValue());
                        
                    }
                }
                bikeObjectList.add(bike);
           }
    }
}
                           

