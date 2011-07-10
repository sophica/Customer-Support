package controllers;

import models.Company;
import play.db.jpa.Blob;
import play.mvc.Controller;

public class Logo extends Controller{

  public static void uploadPicture(long companyId, Blob image) {
    System.out.println("uploading " +companyId);
    Company company = Company.findById(companyId);
    company.image = image;
    company.hasImage = true;
    company.save();
    renderTemplate("Application/index.html");
  }

  public static void getPicture(long companyId) {
    Company company = Company.findById(companyId);
    renderBinary(company.image.get());
  }
}
