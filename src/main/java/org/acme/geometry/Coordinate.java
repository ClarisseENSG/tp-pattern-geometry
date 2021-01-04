package org.acme.geometry;

public class Coordinate {
	
	private double x;
	private double y;
	
	public Coordinate() {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public boolean isEmpty() {
		return Double.isNaN(this.x) && Double.isNaN(this.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		Coordinate coordinate = (Coordinate) obj;
		return ((Double.isNaN(coordinate.getX()) && Double.isNaN(this.getX())) || coordinate.getX() == this.getX()) 
			&& ((Double.isNaN(coordinate.getY()) && Double.isNaN(this.getY())) || coordinate.getY() == this.getY());
	}
}
