package projektarbeit.master;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TrainImport 
{
        public static void main(String[] args) throws IOException 
        {
            String excelFilePath = "C:\\Users\\Julian\\Google Drive\\IT-Projekt\\finale Daten\\Verwendete Datensätze\\U-Bahn-Daten-bereinigt.xlsx";

            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        
            Workbook workbook = new XSSFWorkbook(inputStream);
          
            ArrayList<TrainObject> trainObjectList = new ArrayList<>();
            
            //ArrayList<SubwayStation> subwayStationList = new ArrayList<>();
                     
            //Durchlaufen der einzelnen Worksheets eines Excel-Files
            Iterator<Sheet> sheetIterator = workbook.iterator();
            
            while(sheetIterator.hasNext())
            {
               Sheet workSheet = sheetIterator.next();                                
               //SubwayStation station = new SubwayStation();
               Map<String, Integer> indices = new HashMap<>();
               //station.setStationName(workSheet.getSheetName());  
               
               //Durchlaufen der einzelnen Zeilen eines Worksheets
               for(int zeile=0; zeile<=workSheet.getLastRowNum();zeile++)
               {
                   Row actualRow= workSheet.getRow(zeile);
                   TrainObject train = new TrainObject();
                    //Durchlaufen der einzelnen Zellen einer Zeile
                    for(int zelle=0; zelle<=actualRow.getLastCellNum();zelle++)
                    {
                        Cell actualCell = actualRow.getCell(zelle);
                        try {
                             int c =actualCell.getCellType();
                            } catch (NullPointerException e) {
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
                      trainObjectList.add(train);
                    }
                //subwayStationList.add(station);                                                
               }                
            }                                   
    }

