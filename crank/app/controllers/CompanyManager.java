package controllers;

import java.util.Date;

import models.Company;
import play.mvc.Controller;

public class CompanyManager extends Controller{

    public static void addCompany(String companyName) {
      Company company = new Company(companyName);
      company.rating = 0;
      company.lastUpdated = new Date();
      company.save();
    }
}
