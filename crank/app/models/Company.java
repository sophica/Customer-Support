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
	public String  name;
	public Blob    image;
  public boolean hasImage;
	
	public double  rating;
	public int     numRatings;  
	public Date    lastUpdated;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags;

	public Company(String n) {
		name = n;
		hasImage = false;
		numRatings = 0;
		lastUpdated = new Date();
	}

	public void addRating(int r) {
	  rating = ((rating*numRatings)+r)/++numRatings;
	  lastUpdated = new Date();
	}
}
