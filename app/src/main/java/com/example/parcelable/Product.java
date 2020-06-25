package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String name;
    private String company;
    private int price;

    public static final Creator<Product> CREATOR=new Creator<Product>() {
        //метод создания обьекта классса из parcel
        @Override
        public Product createFromParcel(Parcel source) {
            String name=source.readString();
            String company=source.readString();
            int price=source.readInt();
            return new Product(name, company,price);
        }
        //массив обьектов Product
        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    // конструктор
    public Product(String name, String company, int price){
        this.name=name;
        this.company=company;
        this.price=price;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    //описывает контент и возращает некоторое число
    @Override
    public int describeContents(){
        return 0;
    }
    //метод записи в parcel
    @Override
    public void writeToParcel(Parcel parcel, int flags){
        parcel.writeString(name);
        parcel.writeString(company);
        parcel.writeInt(price);
    }
}
