package projektarbeit.master;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BikeImport 
{

    public ArrayList<BikeObject> generateBikeList() throws IOException
    {        
        String excelFilePath = "C:\\Users\\Martin\\Desktop\\IT projekt\\Bike_bereinigt.xlsx";

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);

        ArrayList<BikeObject> bikeObjectList = new ArrayList<>();

        Sheet workSheet = workbook.getSheetAt(0);

        Map<String, Integer> indices = new HashMap<>();
        //Durchlaufen der 0.Zeile  um max. Spalten zu bestimmen
        Row one= workSheet.getRow(0);
        int rowcounter = 0;
        
        for(int z=0;z<one.getLastCellNum();z++){
            Cell actualCell = one.getCell(z);
            actualCell.setCellType(Cell.CELL_TYPE_STRING);
            indices.put(actualCell.getStringCellValue(), z);
                    try 
                    {
                         int c =actualCell.getCellType();
                    } 
                    catch (NullPointerException e) 
                    {
                        rowcounter=z;
                        break;
                    }
            rowcounter=z;
        }
        //Durchlaufen der einzelnen Zeilen eines Worksheets
        for(int zeile=1; zeile<=workSheet.getLastRowNum();zeile++)
           {
               Row actualRow= workSheet.getRow(zeile);
               BikeObject bike = new BikeObject();

               //Durchlaufen der einzelnen Zellen
                for(int zelle=0; zelle<=rowcounter;zelle++)
                {
                    Cell actualCell = actualRow.getCell(zelle);

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
                bikeObjectList.add(bike);
           }
        
        return bikeObjectList;
    }
}
                           

