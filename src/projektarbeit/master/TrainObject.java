package projektarbeit.master;



    public class TrainObject 
    {
        private String departureTime;
        private String date;        
        private int totalCapacity;
        private int seatCapacity;
        private int totalArrivingPersons;
        private int totalDepartingPersons;
        private int totalUtilization;
        private int seatUtilization;        
        private double relativeTotalUtilization;
        private double relativeSeatUtilization;        
        private int leavingPersons;
        private int enteringPersons;
        
        
        //---------- GET-Methods ----------
     

    
    public String getDepartureTime()
    {
        return departureTime;
    }
    
    public String getDate() 
    {
        return date;
    }

    public int getTotalCapacity() 
    {
        return totalCapacity;
    }
    
    public int getSeatCapacity()
    {
        return seatCapacity;
    }

    public int getTotalUtilization() 
    {
        return totalUtilization;
    }
    
    public int getSeatUtilization() 
    {
        return seatUtilization;
    }

    public double getRelativeTotalUtilization() 
    {
        return relativeTotalUtilization;
    }
    
    public double getRelativeSeatUtilization() 
    {
        return relativeSeatUtilization;
    }

    
    

    //---------- Set-Methods ----------
    
    
    public void setDepartureTime(String departureTime) 
    {
        this.departureTime = departureTime;
    }
    
    public void setDate(String date) 
    {            
        this.date = date;
    }

    public void setTotalCapacity(int totalCapacity) 
    {
        this.totalCapacity = totalCapacity;
    }
    
    public void setSeatCapacity(int seatCapacity) 
    {
        this.seatCapacity = seatCapacity;
    }
    
    public void setTotalArrivingPersons(int totalArrivingPersons)
    {
        this.totalArrivingPersons = totalArrivingPersons;
    }
    
    public void setTotalDepartingPersons(int totalDepartingPersons)
    {
        this.totalDepartingPersons = totalDepartingPersons;
    }
    
    public void setLeavingPersons(int leavingPersons)
    {
        this.leavingPersons = leavingPersons;
    }
    
    public void setEnteringPersons(int enteringPersons)
    {
        this.enteringPersons = enteringPersons;
    }
    
    
    public void calculateRelativeTotalUtilization()
    {
        this.relativeTotalUtilization = ((totalArrivingPersons/totalCapacity*100)+(totalDepartingPersons/totalCapacity*100)/2);
    }
    
    public void calculateRelativeSeatUtilization()
    {
        this.relativeSeatUtilization = ((totalArrivingPersons/seatCapacity*100)+(totalDepartingPersons/seatCapacity*100)/2);
    }
        
}

    
    
   
