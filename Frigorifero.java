import java.time.LocalDate;

public class Frigorifero {
    private int id;
    private String des;
    private int cal;
    private LocalDate expiryDate;

    public Frigorifero(int id, String des, int cal, LocalDate expiryDate) {
        this.id = id;
        this.des = des;
        this.cal = cal;
        this.expiryDate = expiryDate;
    }

    public int getId(){
        return id;
    }

    public String getDes(){
        return des;
    }

    public int getCal(){
        return cal;
    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", des=" + des + ", cal=" + cal + ", expiryDate=" + expiryDate + "]";
    }

    
}
