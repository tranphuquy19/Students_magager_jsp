package models.Bean;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */
public class SinhVien {
    private int id;
    private String name;
    private Boolean male;
    private String faculty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
