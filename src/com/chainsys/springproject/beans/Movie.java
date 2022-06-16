package com.chainsys.springproject.beans;

public class Movie {
  public String filmtitle;
  public String filmdirector;
  public Movie(String title, String director) {
	 // this.title = title;  // this .title is global variable and title is local variabe
	 filmtitle  = title;  // this is similar to this.title = filmtitle , but using this. prefix is not compulsory
	  filmdirector = director;
	  System.out.println(title);
	  System.out.println(director);}
}
