package projektarbeit.master;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Station
{
    ArrayList<TrainDataNode> trainDataNodes = new ArrayList<>();
    
    ArrayList<BikeDataNode> bikeDataNodes = new ArrayList<>();
    
    ArrayList<TrainObject> trainObjectList = new TrainImport().generateTrainList();
    
    ArrayList<BikeObject> bikeObjectList = new BikeImport().generateBikeList();
    
    Map<String, String> stationMatchList = new HashMap<>();
    
    
    
    
    public void createTrainDataNodes()
    {
        TrainDataNode actualDataNode = new TrainDataNode();
        int timeSpan = 900000;
        int timeFactor = 1;
        String multipliedStartTimeFactor = Integer.toString(timeSpan*(timeFactor-1));
        String multipliedEndTimeFactor = Integer.toString(timeSpan*timeFactor);
        Timestamp startNode;
        Timestamp endNode;
// 
                        
        for(TrainObject nextActual:trainObjectList)
        {            
            Timestamp departureTime = nextActual.getDepartureDateTime();
            startNode = Timestamp.valueOf(nextActual.getDate() + multipliedStartTimeFactor);
            endNode = Timestamp.valueOf(nextActual.getDate() + multipliedEndTimeFactor);

            
            if((departureTime.after(startNode) || departureTime.equals(startNode)) && departureTime.before(endNode))
            {
                actualDataNode.addTrainObjects(nextActual);
            }
            
            else
            {
                actualDataNode.calculateAverageUtilization();
                actualDataNode.setTimeFrame(startNode, endNode);//endnode evtl Überschneidung mit nächstem Node?
                //Data Node muss Station-Name noch mitgegeben werden
                //actualDataNode.setStationName(stationName);
                trainDataNodes.add(actualDataNode);
                actualDataNode = new TrainDataNode();
                timeFactor+=1;
                
            }
                
        }
    }

    
    public void createBikeDataNodes()
    {
        BikeDataNode actualDataNode = new BikeDataNode();
        int timeSpan = 900000;
        int timeFactor = 1;
        String multipliedStartTimeFactor = Integer.toString(timeSpan*(timeFactor-1));
        String multipliedEndTimeFactor = Integer.toString(timeSpan*timeFactor);
        Timestamp startNode;
        Timestamp endNode;
        
        
        
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
