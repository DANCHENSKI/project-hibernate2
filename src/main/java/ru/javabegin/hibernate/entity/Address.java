package ru.javabegin.hibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(schema = "movie",name = "address")
public class Address {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="address_id",nullable = false)
     private Short addressId;
    @Column(nullable = false, name="address",length = 50)
     private String address;

    @Column(name="address2",length = 50)
    private String address2;

    @Column(nullable = false, length = 20)
    private String district;

    @Column(name="postal_code",length = 10)
    private String postalCode;

    @Column(nullable = false, name="phone",length = 20)
    private String phone;

    @Column(nullable = false, name="last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
