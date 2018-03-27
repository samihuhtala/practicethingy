package hh.palvelinohjelmointi.marketplace.domain;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private double price;
@ManyToOne
@JsonIgnore
@JoinColumn(name="categoryid")
private Category category;


public Product(){}
public Product(String name, double price, Category category){
	super();
	this.name=name;
	this.price=price;
	this.category = category;
}

public void setCategory(Category category) {
	this.category = category;
}
public Category getCategory() {
	return category;
}
public Long getId() {
	return id;
}
public String getName() {
	return name;
}
public double getPrice() {
	return price;
}

public void setId(Long id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setPrice(double price) {
	this.price = price;
}


@Override
public String toString() {
	if (this.category != null)
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + this.getCategory() + "]";
	else
		return "Product [id=" + id + ", name=" + name + ", price" + price +", category=" + category +"]";
}

}
