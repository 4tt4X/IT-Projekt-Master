package projektarbeit.master;

import java.sql.Timestamp;
import java.util.ArrayList;


public class TrainDataNode 
{

    ArrayList<TrainObject> trainObjects;
    private double averageUtilization = 0.0;
    private Timestamp startNode;
    private Timestamp endNode;
    private String stationName;
    

    
    public void addTrainObjects(TrainObject actualTrain)
    {
        this.trainObjects.add(actualTrain);
    }
    
    
    
    public void calculateAverageUtilization()
    {
        int counter = 1;
        double utilizationPercent = 0.0;
        
        for(TrainObject a: trainObjects)
        {
            utilizationPercent+=a.getRelativeTotalUtilization();
            counter +=1;
        }
        
        this.averageUtilization = utilizationPercent/counter;
    }
    
    public void setTimeFrame(Timestamp startNode, Timestamp endNode)
    {
        this.startNode=startNode;
        this.endNode=endNode;
    }
    
    public void setStationName(String stationName)
    {
        this.stationName=stationName;
    }
    
    //------------GETTER-Methoden-------------
    
    public double getAverageUtilization() 
    {
        return averageUtilization;
    }

    public Timestamp getStartNode() 
    {
        return startNode;
    }

    public Timestamp getEndNode() 
    {
        return endNode;
    }
    
    
    

    
    
}
