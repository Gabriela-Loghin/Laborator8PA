package compulsory;

import java.util.Date;

public class Movie {
    private int id;
    private String titlu;
    private Date premiera;
    private int durata;
    private int top;

    public Movie(int id , String titlu , Date premiera , int durata , int top) {
        this.id = id;
        this.titlu = titlu;
        this.premiera = premiera;
        this.durata = durata;
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Date getPremiera() {
        return premiera;
    }

    public void setPremiera(Date premiera) {
        this.premiera = premiera;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
