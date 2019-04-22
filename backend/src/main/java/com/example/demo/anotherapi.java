package com.example.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value="tagsapi")
public class anotherapi {

      @RequestMapping(method = RequestMethod.POST, value="tags1")
      public ResponseEntity<?> getTags(@RequestBody model url){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Kabilan\\Documents\\chromedriver.exe" ); 
        WebDriver driver=new ChromeDriver();  
        driver.get("https://www.google.com/");
        List<WebElement> list1= new ArrayList<WebElement>();	//for inputs, buttons and links
        List<String> list2= new ArrayList<String>();    //for all links only
        List<WebElement> list3= new ArrayList<WebElement>();	//for links from new pages
        List<String> list4= new ArrayList<String>();
        list1.addAll(driver.findElements(By.cssSelector("a")));
        list1.addAll(driver.findElements(By.cssSelector("button")));
        list1.addAll(driver.findElements(By.cssSelector("input")));
        List<String> test = new ArrayList<String>();
        xpath xp = new xpath();
        Map<String,String> map1 = new HashMap<String,String>();
        Map<String,String> map2 = new HashMap<String,String>();
        String current = "";

        for(WebElement elm :list1 ) {
             //test.add(xp.generateXpath(driver,elm));
             test.add(xp.generateXpath(elm,current));
             list2.add(elm.getAttribute("href"));
             
             //looping through all pages
             for(int i =0; i< list2.size(); ++i)
             {
            	 System.out.println("DONE");
             	if(!list2.get(i).equals("javascript:void(0)") && !list2.get(i).equals(""))
             	{	System.out.println(list2.get(i));
             		driver.get(list2.get(i));}
             	list4.add(list2.get(i));   //adding visited links to list
             	list3.addAll(driver.findElements(By.cssSelector("a")));
             	
             	for(WebElement elm1 :list3)	
             		{
             		try{
             			if(!list2.contains(elm1.getAttribute("href")));
             			{list2.add(elm1.getAttribute("href"));}
             			 map1.put(elm1.getText(),elm1.getTagName());
             			 map2.put(elm1.getText(),xp.generateXpath(elm1,current));
             			}
             		catch(StaleElementReferenceException e) {}
             			}
             }
             
             
             if(elm.getTagName()!="input")
             {                                                           
              map1.put(elm.getText(),elm.getTagName());
             }                                                            
             if(elm.getAttribute("type")=="")
             {
                             map1.put(elm.getAttribute("name"),elm.getTagName());
             }
             else
             {
                             map1.put(elm.getAttribute("type"),elm.getTagName());
             }
             if(map1.containsKey(""))
             {
                             map1.remove("");
             }
    }

    System.out.println(map1);
    System.out.println(map2);
    driver.close();
			            url.setElement(map1);
			            url.setXpath(test);
			            url.setElement1(map2);
			            response = new ResponseEntity<model>(url,HttpStatus.OK);
			            return response;                                             
                }

}

