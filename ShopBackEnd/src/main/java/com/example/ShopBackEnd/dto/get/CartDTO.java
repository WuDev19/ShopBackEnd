package com.example.ShopBackEnd.dto.get;

public class CartDTO {
    private Integer cartId;
    private String maND;
    private String tenND;
    private Integer maNB;
    private String tenShop;
    private Long updateTime;

    public CartDTO() {
    }

    public CartDTO(Integer cartId, String maND, String tenND, Integer maNB, String tenShop, Long updateTime) {
        this.cartId = cartId;
        this.maND = maND;
        this.tenND = tenND;
        this.maNB = maNB;
        this.tenShop = tenShop;
        this.updateTime = updateTime;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getMaNB() {
        return maNB;
    }

    public void setMaNB(Integer maNB) {
        this.maNB = maNB;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
