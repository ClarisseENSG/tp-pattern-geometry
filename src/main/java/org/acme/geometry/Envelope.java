package org.acme.geometry;

public class Envelope {
	
	private Coordinate bottomLeft;
	private Coordinate topRight;
	
	public Envelope() {
		this.bottomLeft = new Coordinate();
		this.topRight = new Coordinate();
	}
	
	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	public boolean isEmpty() {
		return this.bottomLeft == null || this.topRight == null || this.bottomLeft.isEmpty() || this.topRight.isEmpty();
	}
	
	public double getXmin() {
		if(!this.isEmpty()) {
			return this.bottomLeft.getX();
		}
		else {
			return Double.NaN;
		}
	}
	
	public double getYmin() {
		if(!this.isEmpty()) {
			return this.bottomLeft.getY();
		}
		else {
			return Double.NaN;
		}
	}
	
	public double getXmax() {
		if(!this.isEmpty()) {
			return this.topRight.getX();
		}
		else {
			return Double.NaN;
		}
	}
	
	public double getYmax() {
		if(!this.isEmpty()) {
			return this.topRight.getY();
		}
		else {
			return Double.NaN;
		}
	}	

}
