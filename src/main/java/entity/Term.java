package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// fields
public class Term {
    private int id;
    private String term;
    private String duration;

// вставили переменную дисциплины, тк семестр является перекрестной
    private List<Discipline> disciplines = new ArrayList<>();

    //constr

    public Term() {
    }

    public Term(int id, String term, String duration, List<Discipline> disciplines) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term1 = (Term) o;
        return id == term1.id && Objects.equals(term, term1.term) && Objects.equals(duration, term1.duration) && Objects.equals(disciplines, term1.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, duration, disciplines);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}
