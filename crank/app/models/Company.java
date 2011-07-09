package models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Company extends Model{
	public String 	name;
	public int 		satisfaction;
	public Date		lastUpdated;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags;
}
