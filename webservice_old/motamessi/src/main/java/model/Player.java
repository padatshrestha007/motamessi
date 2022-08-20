package model;

import java.util.Objects;


import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Player {
    public Player() {}

    public Player(String first, String last, String gender, int age, String cell, String email) {
        this.first = first;
        this.last = last;
        this.gender = gender;
        this.age = age;
        this.cell = cell;
        this.email = email;
    }
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + gender  +
                ", cell='" + cell + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    private @Id @GeneratedValue int id;
    @Column(name = "first_name")
    private String first;

    @Column(name = "last_name")
    private String last;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "cell")
    private String cell;
    @Column(name = "email")
    private String email;
    public int getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCell() {
        return cell;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
