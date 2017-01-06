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


public class DataImport 
{
        public static void main(String[] args) throws IOException 
        {
            String excelFilePath = "C:\\Users\\Julian\\Google Drive\\IT-Projekt\\finale Daten\\Frankfurt\\U-Bahn-Daten-bereinigt.xlsx";
            
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        
            Workbook workbook = new XSSFWorkbook(inputStream);
          
            ArrayList<TrainObject> trainObjectList = new ArrayList<>();
            
            ArrayList<SubwayStation> subwayStationList = new ArrayList<>();
            
                     
            //Durchlaufen der einzelnen Worksheets eines Excel-Files
            Iterator<Sheet> sheetIterator = workbook.iterator();
            
            while(sheetIterator.hasNext())
            {
               Sheet workSheet = sheetIterator.next();
                                  
               SubwayStation station = new SubwayStation();
               Map<String, Integer> indices = new HashMap<>();
               station.setStationName(workSheet.getSheetName());
               
               Iterator<Row> rowIterator = workSheet.rowIterator();
               
               //Durchlaufen der einzelnen Zeilen eines Worksheets
               while(rowIterator.hasNext())
               {
                   Row actualRow = rowIterator.next();
                   TrainObject train = new TrainObject();
                   boolean firstRow = true;
                   
                    //Durchlaufen der einzelnen Zellen einer Zeile
                    for(int zelle=0; zelle<=actualRow.getPhysicalNumberOfCells();zelle++)
                    {
                        Cell actualCell = actualRow.getCell(zelle);
                        
                        if(firstRow==true)
                        {
                            indices.put(actualCell.getStringCellValue(), zelle);
                        }
                        
                        else
                        {
                            if(actualRow.getCell(indices.get("Erf")).getNumericCellValue()!=1)
                            {
                                break;
                            }

                            else
                            {

                                if(zelle==indices.get("Zeit Fpl"))//DepartureTime
                                    train.setDepartureTime(actualCell.getStringCellValue());

                                if(zelle==indices.get("Datum")) //Date
                                    train.setDate(actualCell.getStringCellValue());

                                if(zelle==indices.get("Plätze")) //totalCapacity
                                    train.setTotalCapacity(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Sitz")) //seatCapacity
                                    train.setSeatCapacity(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Last An")) //totalArrivingPersons
                                    train.setTotalArrivingPersons(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Last Ab")) //totalDepartingPersons
                                    train.setTotalDepartingPersons(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Aus")) //leavingPersons
                                    train.setLeavingPersons(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Ein")) //enteringPersons
                                    train.setEnteringPersons(Integer.parseInt(actualCell.getStringCellValue()));
                            }
                        }
                           
                    }
                    trainObjectList.add(train);
                    firstRow=false;
               }
                    
                subwayStationList.add(station);
            }
                        
                   
    }
}


