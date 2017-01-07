package projektarbeit.master;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Station
{
    ArrayList<DataNode> dataNodes = new ArrayList<>();
    
    ArrayList<TrainObject> trainObjectList = new TrainImport().generateTrainList();
    
    ArrayList<BikeObject> bikeObjectList = new BikeImport().generateBikeList();
    
    Map<String, String> stationMatchList = new HashMap<>();
    
    
    
    
    public void createTrainDataNodes()
    {
        DataNode actualDataNode = new DataNode();
        int timeFactor = 900000;
        int i = 1;
        String multipliedTimeFactor = Integer.toString(timeFactor*i);
        Timestamp startNode;
        Timestamp endNode;

                        
        for(TrainObject nextActual:trainObjectList)
        {            
            Timestamp departureTime = nextActual.getDepartureDateTime();
            startNode = Timestamp.valueOf(nextActual.getDate());
            endNode = Timestamp.valueOf(nextActual.getDate() + multipliedTimeFactor);

            
            if((departureTime.after(startNode) || departureTime.equals(startNode)) && departureTime.before(endNode))
            {
                actualDataNode
                                
                actualDataNode.setTotalUtilization(nextActual.getRelativeTotalUtilization());
                actualDataNode.setSeatUtilization(nextActual.getRelativeSeatUtilization());
            }
            
            else
            {
                dataNodes.add(actualDataNode);
                actualDataNode = new DataNode();
                
            }
                
        }
    }
    // Kriegs heute nicht mehr gebacken
    
    
    public void createBikeDataNodes()
    {
        for(BikeObject nextActual:bikeObjectList)
        {
            Timestamp startRentalTime = nextActual.getStartRentalTimeStamp();
            String actualTimeFrame = "0:00";
            Timestamp timeFrame = Timestamp.valueOf(actualTimeFrame);
            
            if(startRentalTime.)
        }
    }
    
    
    
    
    
    
    private String stationName;
    
    
    
    private ArrayList<Object> dataNode;
 
    
            //---------- GET-Methods ----------
    
    public String getStationName() 
    {
        return stationName;
    }
    
    public ArrayList<Object> getDataNode() 
    {
        return dataNode;
    }
    
        //---------- Set-Methods ----------

    public void setStationName(String stationName) 
    {
        this.stationName = stationName;
    }

    public void setDataNode(ArrayList<Object> dataNode) 
    {
        this.dataNode = dataNode;
    }
    

    
    //dataNode=statisch aufaddierte Uhrzeiten im x-Abstand
    
    
}
