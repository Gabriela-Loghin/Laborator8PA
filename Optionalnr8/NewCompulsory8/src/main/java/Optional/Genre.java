package Optional;

import java.util.concurrent.atomic.AtomicInteger;

public class Genre {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String nume;

    public Genre(String nume) {
        this.id = count.incrementAndGet();
        this.nume = nume;
    }
    public Genre(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}
