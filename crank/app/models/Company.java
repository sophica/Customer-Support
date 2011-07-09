package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Company extends Model{
	public String 	name;
	public int 		satisfaction;
}