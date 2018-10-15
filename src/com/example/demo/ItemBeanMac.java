package com.example.demo;

public class ItemBeanMac
{
    private String addressMac;
    private String bindStatus;
    
    public ItemBeanMac() {
    }
    
    public ItemBeanMac(String addressMac, String bindStatus) {
        this.addressMac = addressMac;
        this.bindStatus = bindStatus;
    }

    public String getAddressMac() {
        return addressMac;
    }

    public String getBindStatus() {
        return bindStatus;
    }

    public void setAddressMac(String addressMac) {
        this.addressMac = addressMac;
    }

    public void setBindStatus(String bindStatus) {
        this.bindStatus = bindStatus;
    }
    
}

