package domain;

import java.util.ArrayList;

//=== chris
public class Order {

    private int ono;
    private int cno; // A FK that should be mapped to a reference
    private int eno; // A FK that should be mapped to a reference
    private String received;
    private String startDato;
    private String slutDato;
    private String projectLocation;
    private ArrayList<Pakke> orderDetails;

    public Order(int c, int e, String r, String startDate, String endDate, String oLocation) {

        cno = c;
        eno = e;
        received = r;
        startDato = startDate;
        slutDato = endDate;
        projectLocation = oLocation;
    }

    // overloaded for existing orders
    public Order(int order, int cust, int empl, String recieved, String startDate, String endDate, String oLocation) {
        ono = order;
        cno = cust;
        eno = empl;
        received = recieved;
        startDato = startDate;
        slutDato = endDate;
        projectLocation = oLocation;

    }

    //== accessors
    public int getOno() {
        return ono;
    }

    public void setOno(int ono) {
        this.ono = ono;
    }

    public void setCustomer(int c) {
        this.cno = c;
    }

    public int getCustomerNo() {
        return cno;
    }

    public void setEmployee(int e) {
        this.eno = e;
    }

    public int getEmployeeNo() {
        return eno;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getReceived() {
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

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public void addDetail(ArrayList<Pakke> p) {
        orderDetails = p;
    }

    @Override
    public String toString() {
        return ono + " " + cno + " " + eno + " " + received + " " + startDato + " " + slutDato
                + " " + projectLocation;
    }

    String detailsToString() {
        String res = "";
        for (int i = 0; i < orderDetails.size(); i++) {
            res += orderDetails.get(i).toString() + "\n";
        }
        return res;
    }
}
