package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {
    private String name;
    private String descr;
    private float price;
    private int id;

    public Item() {

    }

    static public Collection searchItems(String group){
        return ItemDB.searchItems(group);
    }

    protected Item(int id,float price, String name, String descr){
        this.id = id;
        this.price = price;
        this.name = name;
        this.descr = descr;
    }

    public float getPrice() {
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
