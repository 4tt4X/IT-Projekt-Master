package projektarbeit.master;

import java.util.ArrayList;


public class SubwayStation 
{
    
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
