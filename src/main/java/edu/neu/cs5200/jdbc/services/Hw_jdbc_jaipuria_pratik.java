package edu.neu.cs5200.jdbc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import edu.neu.cs5200.jdbc.dao.DeveloperDao;
import edu.neu.cs5200.jdbc.dao.PageDao;
import edu.neu.cs5200.jdbc.dao.RoleDao;
import edu.neu.cs5200.jdbc.dao.WebsiteDao;
import edu.neu.cs5200.jdbc.dao.WidgetDao;
import edu.neu.cs5200.jdbc.models.Address;
import edu.neu.cs5200.jdbc.models.Developer;
import edu.neu.cs5200.jdbc.models.HeadingWidget;
import edu.neu.cs5200.jdbc.models.HtmlWidget;
import edu.neu.cs5200.jdbc.models.ImageWidget;
import edu.neu.cs5200.jdbc.models.Page;
import edu.neu.cs5200.jdbc.models.Phone;
import edu.neu.cs5200.jdbc.models.Role;
import edu.neu.cs5200.jdbc.models.User;
import edu.neu.cs5200.jdbc.models.Website;
import edu.neu.cs5200.jdbc.models.Widget;
import edu.neu.cs5200.jdbc.models.YouTubeWidget;

public class Hw_jdbc_jaipuria_pratik {

//	INSERT Developers and Users
	public void insertDevelopers() {
				
		DeveloperDao devDao = DeveloperDao.getInstance();
		
		Developer dev = new Developer("Alice","Wonder", "alice", "alice", "alice@wonder.com",
				LocalDate.of(1985, 05, 25),"4321rewq");
		devDao.createDeveloper(dev);
		dev = new Developer("Bob","Marley", "bob", "bob", "bob@marley.com",
				LocalDate.of(1987, 07, 15),"5432trew");
		devDao.createDeveloper(dev);
		dev = new Developer("Charles","Garcia", "charlie", "charlie", "chuch@garcia.com",
				LocalDate.of(1987, 07, 15),"6543ytre");
		devDao.createDeveloper(dev);
		dev = new Developer("Dan","Martin", "dan", "dan", "dan@martin.com",
				LocalDate.of(1990, 06, 05),"7654fda");
		devDao.createDeveloper(dev);
		dev = new Developer("Ed","Karaz", "ed", "ed", "ed@kar.com",
				LocalDate.of(1991, 07, 21),"5678dfgh");
		devDao.createDeveloper(dev);

	}
	
	public void insertWebsites() {
		
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		DeveloperDao devDao = DeveloperDao.getInstance();
		RoleDao roleDao = RoleDao.getInstance();
		
		Website website = new Website("Facebook", "an online social media and social networking service", LocalDate.now(),LocalDate.now(),1234234);
		Developer developer = devDao.findDeveloperByUsername("alice");
		websiteDao.createWebsiteForDeveloper(developer.getDeveloperId(), website);
		
		Collection<Website> websites = websiteDao.findWebsitesForDeveloper(developer.getDeveloperId());
		Integer websiteId = null;
		for(Website web : websites) {
			if(website.getName().equals(web.getName())) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.editor);
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.admin);
		
		
//		Twitter
		website = new Website("Twitter", "an online news and social networking service", LocalDate.now(),LocalDate.now(),4321543);
		developer = devDao.findDeveloperByUsername("bob");
		websiteDao.createWebsiteForDeveloper(developer.getDeveloperId(), website);
		
		websites = websiteDao.findWebsitesForDeveloper(developer.getDeveloperId());
		websiteId = null;
		for(Website web : websites) {
			if(website.getName().equals(web.getName())) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.editor);
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.admin);
		
		
//		Wikipedia
		website = new Website("Wikipedia", "a free online encyclopedia", LocalDate.now(),LocalDate.now(),3456654);
		developer = devDao.findDeveloperByUsername("charlie");
		websiteDao.createWebsiteForDeveloper(developer.getDeveloperId(), website);
		
		websites = websiteDao.findWebsitesForDeveloper(developer.getDeveloperId());
		websiteId = null;
		for(Website web : websites) {
			if(website.getName().equals(web.getName())) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.editor);
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.admin);
		
//		CNN
		website = new Website("CNN", "an American basic cable and satellite television news channel", LocalDate.now(),LocalDate.now(),6543345);
		developer = devDao.findDeveloperByUsername("alice");
		websiteDao.createWebsiteForDeveloper(developer.getDeveloperId(), website);
		
		websites = websiteDao.findWebsitesForDeveloper(developer.getDeveloperId());
		websiteId = null;
		for(Website web : websites) {
			if(website.getName().equals(web.getName())) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.editor);
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.admin);
		
//		CNET
		website = new Website("CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", LocalDate.now(),LocalDate.now(),6543345);
		developer = devDao.findDeveloperByUsername("bob");
		websiteDao.createWebsiteForDeveloper(developer.getDeveloperId(), website);
		
		websites = websiteDao.findWebsitesForDeveloper(developer.getDeveloperId());
		websiteId = null;
		for(Website web : websites) {
			if(website.getName().equals(web.getName())) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.editor);
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.admin);
		
//		Gizmodo
		website = new Website("Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", LocalDate.now(),LocalDate.now(),4322345);
		developer = devDao.findDeveloperByUsername("charlie");
		websiteDao.createWebsiteForDeveloper(developer.getDeveloperId(), website);
		
		websites = websiteDao.findWebsitesForDeveloper(developer.getDeveloperId());
		websiteId = null;
		for(Website web : websites) {
			if(website.getName().equals(web.getName())) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.editor);
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignWebsiteRole(developer.getDeveloperId(), websiteId, Role.admin);
		
	}
	
	public void insertPages() {
		
		PageDao pageDao = PageDao.getInstance();
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		RoleDao roleDao = RoleDao.getInstance();
		DeveloperDao devDao = DeveloperDao.getInstance(); 
		
		//Home
		Page page = new Page("Home", "Landing Page", LocalDate.now(),LocalDate.now(),123434);
		Collection<Website> websites = websiteDao.findAllWebsites();
		
		Integer websiteId = null;
		for(Website web : websites) {
			if(web.getName().equals("CNET")) {
				websiteId = web.getWebsiteId();
				break;
			}
		}
		
		
		pageDao.createPageForWebsite(websiteId, page);
		
		Integer pageId = null;
		Collection<Page> pages = pageDao.findPagesForWebsite(websiteId);
		for(Page p : pages) {
			if(p.getTitle().equals("Home") && p.getWebsiteId()==websiteId) {
				pageId = p.getPageId();
				break;
			}
		}
		
		
		Developer developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.editor);
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.reviewer);
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.writer);
		
		
	
		//About
		page = new Page("About", "Website description", LocalDate.now(),LocalDate.now(),234545);
		
		
		websiteId = null;
		for(Website web : websites) {
			if(web.getName().equals("Gizmodo") ) {
				websiteId = web.getWebsiteId();
				break;
			}
		}		
		pageDao.createPageForWebsite(websiteId, page);
		
		pageId = null;
		pages = pageDao.findPagesForWebsite(websiteId);
		for(Page p : pages) {
			if(p.getTitle().equals("About") && p.getWebsiteId()==websiteId) {
				pageId = p.getPageId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.editor);
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.reviewer);
		
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.writer);
		
		
		//Contact
		page = new Page("Contact", "Addresses, phones, and contact info", LocalDate.now(),LocalDate.now(),345656);
		
		websiteId = null;
		for(Website web : websites) {
			if(web.getName().equals("Wikipedia")) {
				websiteId = web.getWebsiteId();
				break;
			}
		}		
		pageDao.createPageForWebsite(websiteId, page);
		
		pageId = null;
		pages = pageDao.findPagesForWebsite(websiteId);
		for(Page p : pages) {
			if(p.getTitle().equals("Contact") && p.getWebsiteId()==websiteId) {
				pageId = p.getPageId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.editor);
		
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.reviewer);
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.writer);
		
		
		//Preferences
		page = new Page("Preferences", "Where users can configure their preferences", LocalDate.now(),LocalDate.now(),456776);
	
		websiteId = null;
		for(Website web : websites) {
			if(web.getName().equals("CNN")) {
				websiteId = web.getWebsiteId();
				break;
			}
		}		
		pageDao.createPageForWebsite(websiteId, page);
		
		pageId = null;
		pages = pageDao.findPagesForWebsite(websiteId);
		for(Page p : pages) {
			if(p.getTitle().equals("Preferences") && p.getWebsiteId()==websiteId) {
				pageId = p.getPageId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.editor);
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.reviewer);
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.writer);

		//Profile
		page = new Page("Profile", "Users can configure their personal information", LocalDate.now(),LocalDate.now(),567878);
	
		websiteId = null;
		for(Website web : websites) {
			if(web.getName().equals("CNET")) {
				websiteId = web.getWebsiteId();
				break;
			}
		}		
		pageDao.createPageForWebsite(websiteId, page);
		
		pageId = null;
		pages = pageDao.findPagesForWebsite(websiteId);
		for(Page p : pages) {
			if(p.getTitle().equals("Profile") && p.getWebsiteId()==websiteId) {
				pageId = p.getPageId();
				break;
			}
		}
		
		developer = devDao.findDeveloperByUsername("bob");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.editor);
		
		developer = devDao.findDeveloperByUsername("charlie");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.reviewer);
		
		developer = devDao.findDeveloperByUsername("alice");
		roleDao.assignPageRole(developer.getDeveloperId(), pageId, Role.writer);

	}
	
	public void insertWidgets() {
		
		WidgetDao widgetDao = WidgetDao.getInstance();
		PageDao pageDao = PageDao.getInstance();
		
		
		Collection<Page> pages = pageDao.findAllPages();
		Integer pageId = null;
		
		
//		Heading
		for(Page page : pages) {
			if(page.getTitle().equals("Home")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		HeadingWidget headingWidget = new HeadingWidget("head123", null,null,null,null,"Welcome",0,pageId,null);
		widgetDao.createWidgetForPage(pageId, headingWidget);
		

//		HTML
		pageId = null;
		for(Page page : pages) {
			if(page.getTitle().equals("About")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		HtmlWidget htmlWidget = new HtmlWidget("post234", null,null,null,null,"<p>Lorem</p>",0,pageId,"<p>Lorem</p>");
		widgetDao.createWidgetForPage(pageId, htmlWidget);

//		Heading
		pageId = null;
		for(Page page : pages) {
			if(page.getTitle().equals("Contact")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		headingWidget = new HeadingWidget("head345", null,null,null,null,"Hi",1,pageId,null);
		widgetDao.createWidgetForPage(pageId, headingWidget);
		
		
		//HTML
		pageId = null;
		for(Page page : pages) {
			if(page.getTitle().equals("Contact")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		htmlWidget = new HtmlWidget("intro456", null,null,null,null,"<h1>Hi</h1>",2,pageId,"<h1>Hi</h1>");
		widgetDao.createWidgetForPage(pageId, htmlWidget);

		//Image
		pageId = null;
		for(Page page : pages) {
			if(page.getTitle().equals("Contact")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		ImageWidget imageWidget = new ImageWidget("image345", 50,100,null,null,null,3,pageId,"/img/567.png");
		widgetDao.createWidgetForPage(pageId, imageWidget);

		
		//Youtube
		pageId = null;
		for(Page page : pages) {
			if(page.getTitle().equals("Preferences")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		YouTubeWidget youtubeWidget = new YouTubeWidget("video456", 400,300,null,null,null,0,pageId,"https://youtu.be/h67VX51QXiQ", true, true);
		widgetDao.createWidgetForPage(pageId, youtubeWidget);

		return ;
	}
	
	public void updateFirstQ() {
		DeveloperDao devDao = DeveloperDao.getInstance();
		Developer developer = devDao.findDeveloperByUsername("charlie");
		Phone phone = new Phone("333-444-555",true,developer.getPersonId());
		devDao.updatePhonebyUsername("charlie", phone);
		return;
		
	}
	
//	Update widget - Update the relative order of widget head345 on the page so that it's new order is 3. Note that the other widget's order needs to update as well
	public void updateSecondQ() {
		
		WidgetDao widgetDao = WidgetDao.getInstance();
		
		Widget widget = null;
		for(Widget w : widgetDao.findAllWidgets()) {
			if(w.getName().equals("head345")) {
				widget = w;
				break;
			}
		}
		
		int currentOrder = widget.getOrder();
		int newOrder = 3;
		
		if(newOrder > currentOrder) {
			for(Widget w : widgetDao.findWidgetsForPage(widget.getPageId())) {
				if(w.getOrder() > currentOrder && w.getOrder() <= newOrder) {
					w.setOrder(w.getOrder()-1);
					widgetDao.updateWidget(w.getWidgetId(), w);
				}else if(w.getOrder() == currentOrder) {
					w.setOrder(newOrder);
					widgetDao.updateWidget(w.getWidgetId(), w);
				}
				
			}			
		}else{
			for(Widget w : widgetDao.findWidgetsForPage(widget.getPageId())) {
				if(w.getOrder() >= newOrder && w.getOrder() < currentOrder) {
					w.setOrder(w.getOrder()+1);
					widgetDao.updateWidget(w.getWidgetId(), w);
				}else if(w.getOrder() == currentOrder) {
					w.setOrder(newOrder);
					widgetDao.updateWidget(w.getWidgetId(), w);
				}			
			}		
		}
		
		return;
	}
	
	
	public void updateThirdQ() {
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		Integer websiteId = null;
		for(Website website: websiteDao.findAllWebsites()) {
			if(website.getName().contains("CNET")) {
				websiteId = website.getWebsiteId();
				break;
			}
		}
		
		PageDao pageDao = PageDao.getInstance();
		
		if(websiteId != null) {
			Collection<Page> pages = pageDao.findPagesForWebsite(websiteId);
			
			for(Page page : pages) {
				page.setTitle("CNET - "+ page.getTitle());
				pageDao.updatePage(page.getPageId(), page);
			}
			
		}
	}
	
	
//	Update roles - Swap Charlie's and Bob's role in CNET's Home page
	public void updateFourthQ() {
		DeveloperDao devDao = DeveloperDao.getInstance();
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		PageDao pageDao = PageDao.getInstance();
		RoleDao roleDao = RoleDao.getInstance();
		
		
		Developer charlie = devDao.findDeveloperByUsername("charlie");
		Developer bob = devDao.findDeveloperByUsername("bob");
		Integer websiteId = null;
		for( Website website : websiteDao.findAllWebsites()) {
			if(website.getName().equals("CNET")) {
				websiteId = website.getWebsiteId();
			}
		}
		
		Integer pageId = null;
		for( Page page : pageDao.findPagesForWebsite(websiteId)) {
			if(page.getTitle().equals("Home")) {
				pageId = page.getPageId();
			}
		}
		
		Role charliesRole = roleDao.findPageRole(charlie.getDeveloperId(),pageId);
		Role bobsRole = roleDao.findPageRole(bob.getDeveloperId(),pageId);
	
		roleDao.deletePageRole(charlie.getDeveloperId(), pageId, charliesRole);
		roleDao.deletePageRole(bob.getDeveloperId(), pageId, bobsRole);
		roleDao.assignPageRole(charlie.getDeveloperId(), pageId, bobsRole);
		roleDao.assignPageRole(bob.getDeveloperId(), pageId, charliesRole);

	}
	
	
	public void deleteFirstQ() {
		DeveloperDao devDao = DeveloperDao.getInstance();
		
		Developer dev = devDao.findDeveloperByUsername("alice");
		Integer personId = dev.getPersonId();
		
		Collection<Address> addresses = devDao.findAllAddressByPersonId(personId);
		Address address = null; 
		for(Address a : addresses) {
			if(a.isPrimary()) {
				address = a;
			}
		}
		
		
		devDao.deleteAddress(address);		
	}
	
	public void deleteSecondQ() {
		PageDao pageDao = PageDao.getInstance();
		WidgetDao widgetDao = WidgetDao.getInstance();
		
		Collection<Page> pages = pageDao.findAllPages();
		Integer pageId = null;
		for(Page page : pages) {
			if(page.getTitle().equals("Contact")) {
				pageId = page.getPageId();
				break;
			}
		}
		
		Collection<Widget> widgets = widgetDao.findWidgetsForPage(pageId);
		Integer widgetId = null;
		int maxSofar = Integer.MIN_VALUE;
		
		for(Widget widget : widgets) {
			if(widget.getOrder() > maxSofar) {
				widgetId = widget.getWidgetId();
				maxSofar = widget.getOrder();
			}
		}
		
		widgetDao.deleteWidget(widgetId);
		
	}
	
	public void deleteThirdQ() {
		
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		PageDao pageDao = PageDao.getInstance();
		
		Collection<Website> websites = websiteDao.findAllWebsites();
		Integer websiteId = null;
		
		for(Website website : websites) {
			if(website.getName().equals("Wikipedia")) {
				websiteId = website.getWebsiteId();
				break;
			}
		}
		
		Collection<Page> pages = pageDao.findPagesForWebsite(websiteId);
		LocalDate maxdate = LocalDate.of(1900, 01, 01);
		Integer pageId = null;
		for(Page page : pages) {
			if(page.getUpdated().isAfter(maxdate)) {
				maxdate = page.getUpdated();
				pageId = page.getPageId();
			}
		}
		
		pageDao.deletePage(pageId);
	}
	
	public void deleteFourthQ() {
		
		WebsiteDao websiteDao = WebsiteDao.getInstance();
		
		Collection<Website> websites = websiteDao.findAllWebsites();
		Integer websiteId = null;
		for(Website website : websites) {
			if(website.getName().equals("CNET")) {
				websiteId = website.getWebsiteId();
				break;
			}
		}
		
		websiteDao.deleteWebsite(websiteId);
	}
}
