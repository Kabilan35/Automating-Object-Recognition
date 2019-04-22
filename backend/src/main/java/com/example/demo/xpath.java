package com.example.demo;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpath{
                public String generateXpath(WebElement childElement, String current){

    String childTag = childElement.getTagName();
    if(childTag.equals("html")) {
        return "/html[1]"+current;
    }
    WebElement parentElement = childElement.findElement(By.xpath("..")); 
    List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
    int count = 0;
    for(int i=0;i<childrenElements.size(); i++) {
        WebElement childrenElement = childrenElements.get(i);
        String childrenElementTag = childrenElement.getTagName();
        if(childTag.equals(childrenElementTag)) {
            count++;
        }
        if(childElement.equals(childrenElement)) {
            return generateXpath(parentElement, "/" + childTag + "[" + count + "]"+current);
        }
   
    }
    return null;
}
                public String generateXpath(WebDriver driver, WebElement ele){
                    JavascriptExecutor js=(JavascriptExecutor) driver;
                    return (String)js.executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", ele);
        }
}
