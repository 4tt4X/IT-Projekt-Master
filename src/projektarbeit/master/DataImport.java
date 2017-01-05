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
               
               
               //Durchlaufen der einzelnen Zeilen eines Worksheets
               for(int zeile=0; zeile<=workSheet.getLastRowNum();zeile++)
               {
                   Row actualRow= workSheet.getRow(zeile);
                   TrainObject train = new TrainObject();
                          
                    //Durchlaufen der einzelnen Zellen einer Zeile
                    for(int zelle=0; zelle<=actualRow.getLastCellNum();zelle++)
                    {
                        Cell actualCell = actualRow.getCell(zelle);
                        actualCell.setCellType(Cell.CELL_TYPE_STRING);
                        actualCell.setCellType(CellType.STRING);

                            
                        if(zeile==0)
                        {
                            indices.put(actualCell.getStringCellValue(), zelle);
                        }
                        
                                              
                        else
                        {
                            if(actualRow.getCell(indices.get("Erf")).getNumericCellValue()!=1)
                            {
                                zeile+=1;
                            }
                                
                            else
                            {
                            
                                if(zelle==indices.get("Linie")) //Line
                                    train.setLine(actualCell.getStringCellValue());

                                if(zelle==indices.get("Datum")) //Date
                                    train.setDateString(actualCell.getStringCellValue());

                                if(zelle==indices.get("Ri"))//Richtung
                                    train.setDirection(actualCell.getStringCellValue());

                                if(zelle==indices.get("Zeit Fpl"))//Abfahrtszeit
                                    train.setDepartureTime(actualCell.getStringCellValue());


                                if(zelle==indices.get("Plätze")) //totalCapacity
                                    train.setTotalCapacity(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Last An")) //totalArrivingPersons
                                    train.setTotalArrivingPersons(Integer.parseInt(actualCell.getStringCellValue()));

                                if(zelle==indices.get("Last Ab")) //totalDepartingPersons
                                    train.setTotalDepartingPersons(Integer.parseInt(actualCell.getStringCellValue()));

                            }
                            
                        }
                      
                        
                    }       
                    
                        trainObjectList.add(train);                                                
               }
                    
                subwayStationList.add(station);
            }
                        
                   
    }
}
