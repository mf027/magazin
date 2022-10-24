package com.mircea.magazinmobila.entity;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;



@Entity
@Table(name = "marfa_magazin")
@Getter
@Setter
public class Item {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @NonNull
    @Column(name = "category", nullable = false)
    @NotBlank(message = "Va rugam sa alegeti o categorie")
    private String category;

    @NonNull
    @Column(name = "name", nullable = false)
    @NotBlank(message = "Va rugam sa introduceti numele produsului")
    private String name;

    @Column(name = "price", nullable = false)
    @Min(value = 1, message = "Pretul trebuie sa fie mai mare ca si 0")
    private double price;

    @Column(name = "discount", nullable = false)
    @Min(value = 0, message = "Discount-ul nu poate fi negativ")
    private double discount;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "", nullable = false)
    @Past(message = "Data trebuie sa fie in trecut")
    private Date date;

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    // public String getFormatDate() {
    //     SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    //     return formatter.format(date);   
    // }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(category, item.category) && Objects.equals(name, item.name) && price == item.price && discount == item.discount && Objects.equals(date, item.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, price, discount, date);
    }

    
}
