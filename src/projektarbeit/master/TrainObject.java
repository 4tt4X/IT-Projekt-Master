package projektarbeit.master;


    import java.util.Date;

    public class TrainObject 
    {
        private String trainID;
        
        private String line;
        private String direction;
        private String departureTime;
        private String dateString;
        private Date date;
        
        private int totalCapacity;
        private int totalArrivingPersons;
        private int totalDepartingPersons;
        
        private int utilization;
        private int utilizationPercent;
        
        
        //---------- GET-Methods ----------
     
    public String getTrainID()
    {
        return trainID;
    }
    
    public String getDepartureTime()
    {
        return departureTime;
    }

    public int getTotalCapacity() 
    {
        return totalCapacity;
    }

    public int getUtilization() 
    {
        return utilization;
    }

    public int getUtilizationPercent() 
    {
        return utilizationPercent;
    }
    
    public Date getDate() 
    {
        return date;
    }
    
    

    //---------- Set-Methods ----------
    
    
    public void setLine(String line) 
    {
        this.line = line;
    }
    
    public void setDateString(String dateString) 
    {            
        this.dateString = dateString;
    }

    public void setDirection(String direction) 
    {
        this.direction = direction;
    }

    public void setDepartureTime(String departureTime) 
    {
        this.departureTime = departureTime;
    }
    

    public void setTotalCapacity(int totalCapacity) 
    {
        this.totalCapacity = totalCapacity;
    }

    public void setTotalArrivingPersons(int totalArrivingPersons)
    {
        this.totalArrivingPersons = totalArrivingPersons;
    }
    
    public void setTotalDepartingPersons(int totalDepartingPersons)
    {
        this.totalDepartingPersons = totalDepartingPersons;
    }
    
    
    
    //Auslastung an berechnen
    //Auslastung ab berechnen
        
        
}

    
    
   
