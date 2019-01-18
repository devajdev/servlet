package com.nt.service;
import java.util.Random;

public class RotatorService {
	private String images[]={"digjam.jpg","siyarams.jpg","ramraj.jpg","vimal.jpg","raymond.jpg"};
	private String links[]={"http://www.digjam.co.in/","http://www.siyaram.com/","https://www.ramrajcotton.in/","http://onlyvimal.co.in/","http://www.raymond.in/"};
	int counter;
	
	public void nextAdd(){
		counter=new Random().nextInt(5);
	}
	
	public  String getImage(){
		  return images[counter];
	}
	
	public String getLink(){
		return links[counter];
	}
	

}
