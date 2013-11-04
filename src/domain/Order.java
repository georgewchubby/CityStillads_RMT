package domain;

import java.util.ArrayList;
//=== hau
public class Order
{

	  private int ono; 
	  private int cno; // A FK that should be mapped to a reference
	  private int eno; // A FK that should be mapped to a reference
	  private String received;
	  private String startDato;
	  private String slutDato;
	  private String projectLocation;
	  private ArrayList<PakkeListe> orderDetails;
         	
	  public Order(int o, int c, int e, String r, String startDate, String endDate)
	  {
	    ono = o;
	    cno = c;
	    eno = e;
	    received = r;
	    startDate = startDate;
            slutDato = endDate;
	    orderDetails = new ArrayList<PakkeListe>();
	  }
	  
	  //== accessors
	  public int getOno()
	  {
	    return ono;
	  }
	  public void setOno(int ono)
	  {
	    this.ono = ono;
	  }
	
	  public void setCustomer(int c)
	  {
	    this.cno = c;
	  }
	
	  public int getCustomerNo()
	  {
	    return cno;
	  }
	
	  public void setEmployee(int e)
	  {
	    this.eno = e;
	  }
	
	  public int getEmployeeNo()
	  {
	    return eno;
	  }
	
	  public void setReceived(String received)
	  {
	    this.received = received;
	  }
	
	  public String getReceived()
	  {
	    return received;
	  }

    public String getStartDato() {
        return startDato;
    }

    public void setStartDato(String startDato) {
        this.startDato = startDato;
    }

    public String getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(String slutDato) {
        this.slutDato = slutDato;
    }
	
	  
	  public void addDetail(PakkeListe od)
	  {
	    orderDetails.add(od);
	  }
          
    @Override
	  public String toString()
	  {
	    return ono + " " + cno + " " + eno + " " + received + " " + startDato + " " + slutDato +
                    " " + projectLocation;
	  }
	
          
	  String detailsToString()
	  {
	    String res = "";
	    for (int i = 0; i < orderDetails.size(); i++) 
	    {
	      res += orderDetails.get(i).toString() + "\n";
	    }
	    return res;
	  }
}
