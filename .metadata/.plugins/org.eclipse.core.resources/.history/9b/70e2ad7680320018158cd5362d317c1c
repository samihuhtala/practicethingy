package hh.palvelinohjelmointi.todolist.domain;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Object {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private String status;
@ManyToOne
@JsonIgnore
@JoinColumn(name="categoryid")
private Category category;


public Object(){}
public Object(String name, String status, Category category){
	super();
	this.name=name;
	this.status=status;
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


public void setId(Long id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}



public void setStatus(String status) {
	this.status = status;
}
public String getStatus() {
	return status;
}
@Override
public String toString() {
	if (this.category != null)
	return "Product [id=" + id + ", name=" + name + ", status=" + status + ", category=" + this.getCategory() + "]";
	else
		return "Product [id=" + id + ", name=" + name + ", status" + status +", category=" + category +"]";
}


}
