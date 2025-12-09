package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "StatusOrder")
public class StatusOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId")
    private Integer statusId;

    @NotNull
    @Size(max = 50)
    @Column(name = "statusName", length = 50, nullable = false, unique = true)
    private String statusName;

    @OneToMany(mappedBy = "statusOrder", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<ChitietDonhang> chitietDonhangs;

    public StatusOrder() {
    }

    public StatusOrder(Integer statusId, String statusName, Set<ChitietDonhang> chitietDonhangs) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.chitietDonhangs = chitietDonhangs;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Set<ChitietDonhang> getChitietDonhangs() {
        return chitietDonhangs;
    }

    public void setChitietDonhangs(Set<ChitietDonhang> chitietDonhangs) {
        this.chitietDonhangs = chitietDonhangs;
    }
}
