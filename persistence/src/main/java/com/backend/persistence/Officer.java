package com.backend.persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "officers")
public class Officer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rank rank;

    @Column(name = "first_name")
    private String first;

    @Column(name = "last_name")
    private String last;

    public Officer(Integer id, Rank rank, String first, String last) {
        this.id = id;
        this.rank = rank;
        this.first = first;
        this.last = last;
    }

    public Officer(Rank rank, String first, String last) {
        this.rank = rank;
        this.first = first;
        this.last = last;
    }

    public Officer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String toString(){
        return String.format("Officer{id=%d, rank=%s, first='%s', last='%s'}", id, rank, first, last);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Officer officer = (Officer) o;
        return Objects.equals(id, officer.id) &&
                rank == officer.rank &&
                Objects.equals(first, officer.first) &&
                Objects.equals(last, officer.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rank, first, last);
    }
}
