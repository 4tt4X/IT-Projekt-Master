package projektarbeit.master;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;



    public class TrainObject 
    {
        private String station;
        private Timestamp departureDateTime;
        private String date;
        private String time;
        private int totalCapacity;
        private int seatCapacity;
        private int totalArrivingPersons;
        private int totalDepartingPersons;
        private int totalUtilization;
        private int seatUtilization;        
        private double relativeTotalUtilization = ((totalArrivingPersons/totalCapacity*100)+(totalDepartingPersons/totalCapacity*100)/2);
        private double relativeSeatUtilization = ((totalArrivingPersons/seatCapacity*100)+(totalDepartingPersons/seatCapacity*100)/2);       
        private int leavingPersons;
        private int enteringPersons;
        
        
        //---------- GET-Methods ----------
     

    public String getStation()
    {
        return station;
    }
    
    public Timestamp getDepartureDateTime()
    {
        departureDateTime = Timestamp.valueOf(date+" "+time);
        return departureDateTime;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public int getTotalCapacity() // Zur Anzeige auslesen
    {
        return totalCapacity;
    }
    
    public int getSeatCapacity() // Zur Anzeige auslesen
    {
        return seatCapacity;
    }

    public int getTotalUtilization() // Zur Anzeige auslesen
    {
        return totalUtilization;
    }
    
    public int getSeatUtilization() // Zur Anzeige auslesen
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
    

    public void setStation(String station)
    {
        this.station = station;
    }
    
    public void setTime(String time) 
    {
        this.time = time;
    }
    
    public void setDate(String date)
    {            
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(date);
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
    
}

    
    
   
