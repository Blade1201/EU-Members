package book;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private String id;
    private String szerző;
    private String cim;
    private int kiadásÉv;

    public Book(String id, String szerző, String cim, int kiadásÉv) {
        this.id = id;
        this.szerző = szerző;
        this.cim = cim;
        this.kiadásÉv = kiadásÉv;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", szerz\u0151=" + szerző + ", cim=" + cim + ", kiad\u00e1s\u00c9v=" + kiadásÉv + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSzerző() {
        return szerző;
    }

    public void setSzerző(String szerző) {
        this.szerző = szerző;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getKiadásÉv() {
        return kiadásÉv;
    }

    public void setKiadásÉv(int kiadásÉv) {
        this.kiadásÉv = kiadásÉv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.szerző);
        hash = 61 * hash + Objects.hashCode(this.cim);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.szerző, other.szerző)) {
            return false;
        }
        if (!Objects.equals(this.cim, other.cim)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Book obj) {
        int result = this.szerző.compareTo(obj.szerző);
        if (result == 0) {
            result = this.cim.compareTo(obj.szerző);

        }
        return result;
    }

}
