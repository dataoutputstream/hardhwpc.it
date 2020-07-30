package com.hardhwpc.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="\"users\"", schema = "stock")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", nullable = false)
    private BigInteger id;
    @Basic
    @Column(name = "code", nullable = true, length = 70)
    private String piva_cf;
    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    private String lastName;
    @Basic
    @Column(name = "telephone_number", nullable = true, length = 20)
    private String telephoneNumber;
    @Basic
    @Column(name = "email", nullable = true, length = 90)
    private String email;
    @Basic
    @Column(name = "address", nullable = true, length = 150)
    private String address;
    @Basic
    @Column(name="password", nullable = true)
    private String password;
    @Transient
    private String passwordConfirm;
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Order> orders;
    @OneToOne(mappedBy = "user",cascade=CascadeType.ALL)
    private BillingData fiscaladdress;




    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCode() {
        return piva_cf;
    }

    public void setCode(String piva_cf) {
        this.piva_cf = piva_cf;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BillingData getFiscaladdress(){
        return fiscaladdress;
    }

    public void setFiscaladdress(BillingData fiscaladdress){
        this.fiscaladdress=fiscaladdress;
    }

    public String getPasswod(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Order> getOrders() {
      return orders;
     }

    public void setPurchases(List<Order> orders) {
    this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(piva_cf, that.piva_cf) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(telephoneNumber, that.telephoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, piva_cf, firstName, lastName, telephoneNumber, email, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", code='" + piva_cf + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    /**
    @ManyToOne(optional = false)
    private Operator users;

    public Operator getUsers() {
        return users;
    }

    public void setUsers(Operator users) {
        this.users = users;
    }
    **/
}
