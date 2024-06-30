package pl.edu.wszib.jwd.jwd_colors.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="SelectedColors", schema = "colors")
public class SelectedColor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String color;
    private Date ctime;

    public SelectedColor() {

    }

    public SelectedColor(String color, Date time) {
        this.color = color;
        this.ctime = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date time) {
        this.ctime = time;
    }
}
