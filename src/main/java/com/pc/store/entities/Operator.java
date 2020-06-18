package com.pc.store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

    @Entity
    @Table(name = "operators", schema = "stock")
    public class Operator {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private int id;
        @Basic
        @Column(name = "code", nullable = true, length = 70)
        private String code;
        @Basic
        @Column(name = "first_name", nullable = true, length = 50)
        private String firstName;
        @Basic
        @Column(name = "last_name", nullable = true, length = 50)
        private String lastName;

        @OneToMany(mappedBy = "operators", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Order> order;

        @OneToMany(mappedBy= "users", cascade = CascadeType.ALL)
        private List<User> users;

        public Operator() {
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

    }
