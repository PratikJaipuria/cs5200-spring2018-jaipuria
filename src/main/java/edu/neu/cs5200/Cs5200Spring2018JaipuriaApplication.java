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
		
//		jdbc.insertDevelopers();
//		
//		jdbc.insertWebsites();
//		
//		jdbc.insertPages();
//		
//		jdbc.insertWidgets();
		
		
//		=======================================================
//		DELETES
		
//		Delete developer - Delete Alice's primary address
//		jdbc.deleteFirstQ();
		
//		Delete widget - Remove the last widget in the Contact page. The last widget is the one with the highest value in the order field
//		jdbc.deleteSecondQ();
		
//		Delete page - Remove the last updated page in Wikipedia
//		jdbc.deleteThirdQ();
		
//		Delete website - Remove the CNET web site, as well as all related roles and privileges relating developers to the Website and Pages
//		jdbc.deleteFourthQ();
		
		
//	   ==========================================
		
//		===================================
//		Implement Updates
		
//		1
		
//		DeveloperDao devDao = DeveloperDao.getInstance();
//		Developer developer = devDao.findDeveloperByUsername("charlie");
//		Phone phone = new Phone("123-456-789",true,developer.getPersonId());
//		devDao.updatePhonebyUsername("charlie", phone);
		
		
		
		
//		2
		jdbc.updateSecondQ();
		
//		3 Update page - Append 'CNET - ' to the beginning of all CNET's page titles
		
		
//		WebsiteDao websiteDao = WebsiteDao.getInstance();
//		Integer websiteId = null;
//		for(Website website: websiteDao.findAllWebsites()) {
//			if(website.getName().contains("CNET")) {
//				websiteId = website.getWebsiteId();
//				break;
//			}
//		}
//		
//		PageDao pageDao = PageDao.getInstance();
//		
//		if(websiteId != null) {
//			Collection<Page> pages = pageDao.findPagesForWebsite(websiteId);
//			
//			for(Page page : pages) {
//				page.setTitle("CNET - "+ page.getTitle());
//				pageDao.updatePage(page.getPageId(), page);
//			}
//			
//		}

		
		
//		4
		
//		jdbc.updateFourthQ();
		
//		===================================
//		RoleDao dao = RoleDao.getInstance();
		
//		dao.deletePageRole(37, 345, Role.owner);
//		dao.deleteWebsiteRole(23, 678, Role.admin);
//		Role role;
//		for (Role r : Role.values()) {
//	         System.out.println(r);
//	      }
		
//		ImageWidget image = new ImageWidget("UpdateImage",50,100,null,null,"Image",5,234,"https://Updatedimage");
//		WidgetDao dao = WidgetDao.getInstance();
//		dao.deleteWidget(791);
////		Widget w = dao.findWidgetsForPage(567);
//		for(Widget w : dao.findWidgetsForPage(234)) {
//			System.out.println(w.getName() + " " + w.getPageId() + " " + w.getText());
//		}
//		DeveloperDao dao = DeveloperDao.getInstance();
//		dao.delete(36);
//		PageDao dao = PageDao.getInstance();
		
//		Page page = dao.findPageById(456);
//		System.out.println(page.getTitle() + " " + page.getViews() + " " + page.getWebsiteId());
//		Website website1 = new Website("testUpdated123","sdcsdcsd",LocalDate.now(),LocalDate.now(),12345);
//		Page page1 = new Page(457,"testUpdated123", "text for test", LocalDate.now(),LocalDate.now(),123,345);
//		dao.deletePage(457);
//		for(Page page : dao.findPagesForWebsite(345)) {
//			System.out.println(page.getTitle() + " " + page.getViews() + " " + page.getWebsiteId());
//		}
//		dao.createPageForWebsite(678, page);
//		Website website = dao.findWebsiteById(68);
//		System.out.println(website.getName() + " " + website.getVisits() + " " + website.getCreated());
//		Website website = new Website("test123","sdcsdcsd",LocalDate.now(),LocalDate.now(),123);
//		dao.createWebsiteForDeveloper(37, website);
//		for(Website website : dao.findAllWebsites()) {
//			System.out.println(website.getName() + " " + website.getVisits() + " " + website.getCreated());
//		}
		
//		dao.updateDeveloper(9879, new Developer("Pratik", "Jaipuria", "jaipuria.p", "abc123",
//				"jaipuriapratik@gmail.com", LocalDate.of(1995, 11, 20), "haha123"));
//		ArrayList<Developer> devList = new ArrayList<>(dao.findAllDevelopers());
//		
//		for(Developer dev : devList) {
//			System.out.println(dev.getDeveloperId()+" " + dev.getPersonId() + " " + dev.getUsername()+
//					dev.getFirstName() + " " + dev.getLastName() + " " + dev.getEmail() + " " + 
//					dev.getDeveloperKey() + " " + dev.getPassword() + " " + dev.getDob());
//		}
//		Developer dev = dao.findDeveloperByCredentials("alice", "alice");
//		System.out.println(dev.getDeveloperId()+" " + dev.getPersonId() + " " + dev.getUsername()+
//				dev.getFirstName() + " " + dev.getLastName() + " " + dev.getEmail() + " " + 
//				dev.getDeveloperKey() + " " + dev.getPassword() );

//		Developer sampledev = new Developer("Jose", "Annanziato", "jannunzi", 
//											"abc123", "xyz.p@husky.neu.edu",
//											LocalDate.of(1991, 11, 20), "9877abc");
//		dao.createDeveloper(sampledev);
		
	}
}
