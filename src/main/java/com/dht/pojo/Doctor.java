package com.dht.pojo;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer ccid;
    private Date dateOfBirth;
    private String gender;
    private String image;
    @Transient
    private MultipartFile img;

    @ManyToOne
    @JoinColumn(name = "departmentid")
    private Department departmentid;

    private String email;
    private String phone;
    private String address;

//    @OneToMany(mappedBy = "doctorid", fetch = FetchType.LAZY)
//    private List<Appointment> appointment;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Account account;

    @OneToMany(mappedBy = "doctor")
    private List<ShiftDetail> shiftDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Department getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCcid() {
        return ccid;
    }

    public void setCcid(Integer ccid) {
        this.ccid = ccid;
    }

//    public List<Appointment> getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(List<Appointment> appointment) {
//        this.appointment = appointment;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<ShiftDetail> getShiftDetails() {
        return shiftDetails;
    }

    public void setShiftDetails(List<ShiftDetail> shiftDetails) {
        this.shiftDetails = shiftDetails;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
