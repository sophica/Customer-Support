package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Company> companies = Company.find("order by lastUpdated desc").fetch(2);
    	
    	renderArgs.put("companies", companies);
        render();
    }
    
    public static void populateDatabase() {
    	Company.deleteAll();
    	
    	Company company1 = new Company("HP");
    	company1.satisfaction = 50;
    	company1.lastUpdated = new Date(10000000);
    	company1.save();
    	
    	Company company2 = new Company("Dell");
    	company2.satisfaction = 75;
    	company2.lastUpdated = new Date(11000001);
    	company2.save();
    	
    	Company company3 = new Company("Apple");
    	company3.satisfaction = 60;
    	company3.lastUpdated = new Date(12000002);
    	company3.save();
    }

}