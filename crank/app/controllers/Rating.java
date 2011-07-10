package controllers;

import models.Company;
import play.mvc.Controller;

public class Rating extends Controller {
  
  public static void saveRating(long cId, int rating) {
    Company company = Company.findById(cId);
    company.addRating(rating);
    company.save();
    renderTemplate("Application/index.html");
  }
}
