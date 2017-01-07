
package projektarbeit.master;

import java.sql.Timestamp;


public class BikeObject 
{
    
    private Timestamp startRentalTimeStamp;
    private String endRentalTime;
    private String startRentalZone;
    private String endRentalZone;
    
     //---------- GET-Methods ----------
     
    public Timestamp getStartRentalTimeStamp() 
    {
        return startRentalTimeStamp;
    }

    public String getEndRentalTime() 
    {
        return endRentalTime;
    }

    public String getStartRentalZome() 
    {
        return startRentalZone;
    }

    public String getEndRentalZone() 
    {
        return endRentalZone;
    }
    
    //---------- Set-Methods ----------
    
    
    public void setStartRentalTime(String startRentalTime) 
    {
        this.startRentalTimeStamp = Timestamp.valueOf(startRentalTime);
    }
        
    public void setEndRentalTime(String endRentalTime) 
    {
        this.endRentalTime = endRentalTime;
    }
    
    public void setStartRentalZone(String startRentalZone) 
    {
        this.startRentalZone = startRentalZone;
    }

    public void setEndRentalZone(String endRentalZone) 
    {
        this.endRentalZone = endRentalZone;
    }
    
    
    
    
    
}
