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

    @Override
    public String toString() {
        return "Frigorifero [id=" + id + ", des=" + des + ", cal=" + cal + ", expiryDate=" + expiryDate + "]";
    }

    
}
