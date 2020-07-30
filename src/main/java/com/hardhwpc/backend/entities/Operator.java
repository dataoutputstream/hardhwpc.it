package com.hardhwpc.backend.entities;


import javax.persistence.*;
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

    @Basic
    @Column(name="username", nullable=true, length = 40)
    private String username;
    @Basic
    @Column(name="password", nullable=true,length=40)
    private String password;

    //@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    //  @JsonIgnore
   // private List<Order> order;

    //@OneToMany(mappedBy= "users", cascade = CascadeType.ALL)
    //private List<User> users;

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

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


}
