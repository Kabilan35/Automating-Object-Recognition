package com.example.demo;
import org.openqa.selenium.By;
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
            System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe" ); 
            WebDriver driver=new ChromeDriver();  
            driver.get(url.getUrl());
            List<WebElement> s1= new ArrayList<WebElement>();
            s1.addAll(driver.findElements(By.cssSelector("a")));
            s1.addAll(driver.findElements(By.cssSelector("button")));
            s1.addAll(driver.findElements(By.cssSelector("input")));
            List<String> test = new ArrayList<String>();
            xpath xp = new xpath();
            Map<String,String> map1 = new HashMap<String,String>();
            Map<String,String> map2 = new HashMap<String,String>();
            ResponseEntity<model> response;
            String current = "";
            for(WebElement elm :s1 ) {
                                                                                //test.add(xp.generateXpath(driver,elm));
                 test.add(xp.generateXpath(elm,current));
                 map2.put(elm.getText(),xp.generateXpath(elm,current));
                 map1.put(elm.getText(),elm.getTagName());
                                                                                
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
			            driver.close();
			            url.setElement(map1);
			            url.setXpath(test);
			            url.setElement1(map2);
			            response = new ResponseEntity<model>(url,HttpStatus.OK);
			            return response;                                             
                }

}

