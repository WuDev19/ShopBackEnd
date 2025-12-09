package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GioHang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maGioHang")
    private Integer maGioHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNguoiBan", referencedColumnName = "maNguoiBan")
    @JsonBackReference
    private Nguoiban nb_gh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maND", referencedColumnName = "maND")
    @JsonBackReference
    private Nguoidung nd_gh;

    @Column(name = "updateTime", insertable = false)
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "ci_gh", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private Set<CartItem> cartItems = new HashSet<>();

    public GioHang() {
    }

    public GioHang(Integer maGioHang, Nguoiban nb_gh, Nguoidung nd_gh, LocalDateTime updateTime, Set<CartItem> cartItems) {
        this.maGioHang = maGioHang;
        this.nb_gh = nb_gh;
        this.nd_gh = nd_gh;
        this.updateTime = updateTime;
        this.cartItems = cartItems;
    }

    public Integer getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(Integer maGioHang) {
        this.maGioHang = maGioHang;
    }

    public Nguoiban getNb_gh() {
        return nb_gh;
    }

    public void setNb_gh(Nguoiban nb_gh) {
        this.nb_gh = nb_gh;
    }

    public Nguoidung getNd_gh() {
        return nd_gh;
    }

    public void setNd_gh(Nguoidung nd_gh) {
        this.nd_gh = nd_gh;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem cartItem){
        cartItem.setCi_gh(this);
        cartItems.add(cartItem);
    }

}
