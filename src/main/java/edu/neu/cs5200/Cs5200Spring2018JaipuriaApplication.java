package edu.neu.cs5200;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import edu.neu.cs5200.jdbc.dao.*;
import edu.neu.cs5200.jdbc.models.*;
import edu.neu.cs5200.jdbc.services.Hw_jdbc_jaipuria_pratik;

@SpringBootApplication
public class Cs5200Spring2018JaipuriaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder
	 configure(SpringApplicationBuilder application) {
	  return application.sources(Cs5200Spring2018JaipuriaApplication.class);
	 }


	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring2018JaipuriaApplication.class, args);
		
		
		Hw_jdbc_jaipuria_pratik jdbc = new Hw_jdbc_jaipuria_pratik();
		
//		=======================================================
//		INSERTS
		
		jdbc.insertDevelopers();
		
		jdbc.insertWebsites();
		
		jdbc.insertPages();
		
		jdbc.insertWidgets();
				
//		=======================================================
		
//		UPDATES
		
//		Update widget - Update the relative order of widget head345 on the page so that it's new order is 3. Note that the other widget's order needs to update as well
		jdbc.updateFirstQ();
		
//		Update page - Append 'CNET - ' to the beginning of all CNET's page titles
		jdbc.updateSecondQ();
			
//		Update roles - Swap Charlie's and Bob's role in CNET's Home page
		jdbc.updateThirdQ();
			
//		========================================================

//		DELETES

//		Delete widget - Remove the last widget in the Contact page. The last widget is the one with the highest value in the order field
		jdbc.deleteFirstQ();
		
//		Delete page - Remove the last updated page in Wikipedia
		jdbc.deleteSecondQ();
		
//		Delete website - Remove the CNET web site, as well as all related roles and privileges relating developers to the Website and Pages
		jdbc.deleteThirdQ();
		
		
//	   =========================================================
	}
}
