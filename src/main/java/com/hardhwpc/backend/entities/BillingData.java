package com.hardhwpc.backend.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;


@Entity
    @Table(name="\"billing_data\"", schema = "stock")
    public class BillingData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private BigInteger id;
        @Basic
        @Column(name = "fcode", nullable = true, length = 70)
        private String cf;
        @Basic
        @Column(name = "piva", nullable = true, length = 70)
        private String piva;
        @Basic
        @Column(name = "billing_name", nullable = true, length = 50)
        private String billingName;
        @Basic
        @Column(name = "u_code", nullable = true, length = 20)
        private String uCode;
        @Basic
        @Column(name = "pec", nullable = true, length = 90)
        private String emailpec;
        @OneToOne()
        @JoinColumn(name = "user_bd")
        private User user;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getuCode() {
        return uCode;
    }

    public void setuCode(String uCode) {
        this.uCode = uCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public String getEmailpec() {
        return emailpec;
    }

    public void setEmailpec(String emailpec) {
        this.emailpec = emailpec;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillingData)) return false;
        BillingData that = (BillingData) o;
        return id.equals(that.id) &&
                Objects.equals(getCf(), that.getCf()) &&
                Objects.equals(getPiva(), that.getPiva()) &&
                Objects.equals(getBillingName(), that.getBillingName()) &&
                Objects.equals(getuCode(), that.getuCode()) &&
                Objects.equals(getEmailpec(), that.getEmailpec());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCf(), getPiva(), getBillingName(), getuCode(), getEmailpec());
    }
}
