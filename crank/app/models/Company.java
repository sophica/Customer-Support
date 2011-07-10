package models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Company extends Model{
	public String 	name;
	public Blob   image;
	public int 		satisfaction;
	public Date		lastUpdated;
	public boolean    hasImage;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags;
	
	public Company(String n) {
		name = n;
		hasImage = false;
	}
}
