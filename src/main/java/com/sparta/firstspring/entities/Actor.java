package com.sparta.firstspring.entities;
import jakarta.persistence.*;
import java.time.Instant;

@Entity // Tells JPA that the class that follows is an Entity (a class that map to a table)
@Table(name = "actor") // Instruct which table this class is mapping.
public class Actor {
    @Id // Tells JPA that this property should be treated as the primary key for the object-table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity is to say this id is generated in the database.
    // Instruct which column in the database  this id is mapping:
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /* Overrides the Object.toString() method */
    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

}

