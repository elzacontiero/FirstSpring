package com.sparta.firstspring.model;

import jakarta.persistence.*;  // the people that are doing the persistence

import java.time.Instant; // more precision than the Date class.

// jpa annotation that tells spring this class Actor is representing an entity in a table.
@Entity
// this annotation @Table tells which table this class is associated with.
@Table(name = "actor")
public class Actor { // Class Actor models table Actor in the Database. So, the Repository takes
                    // this model and exchange data with the Database.

    // this annotation @Id tells spring this is the primary key of the table.
    @Id
    // @GeneratedValue tells the Spring who is generating the Id is IDENTITY, meaning the database.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id; // this is the property id that maps to the actor_id column in the database.

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