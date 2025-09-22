package com.kh.example.inherit;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString() + " / " +Math.PI * c.getRadius() * c.getRadius();
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString() + " / "+ Math.PI * c.getRadius() * 2;
	}
}
