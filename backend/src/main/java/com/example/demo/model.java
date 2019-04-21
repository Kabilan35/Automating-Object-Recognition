package com.example.demo;

import java.util.List;
import java.util.Map;

public class model {
       
       String url;
       List<String> xpath;
       Map<String,String> element;
       Map<String,String> element1;
       
       public Map<String, String> getElement1() {
              return element1;
       }

       public void setElement1(Map<String, String> element1) {
              this.element1 = element1;
       }

       public Map<String, String> getElement() {
              return element;
       }

       public void setElement(Map<String, String> element) {
              this.element = element;
       }

       public void setXpath(List<String> xpath) {
              this.xpath = xpath;
       }
       
       public List<String> getXpath() {
              return xpath;
       }

       public String getUrl() {
              return url;
       }

       public void setUrl(String url) {
              this.url = url;     
       }
       
}

