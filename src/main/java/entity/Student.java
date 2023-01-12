package entity;

import java.sql.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String group;
    private Date date;

    public Student() {
    }

    public Student(int id, String surname, String name, String group, Date date) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate(Date date) {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(surname, student.surname) && Objects.equals(name, student.name) && Objects.equals(group, student.group) && Objects.equals(date, student.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, group, date);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                '}';
    }
}