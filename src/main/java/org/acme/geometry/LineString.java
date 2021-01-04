package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	public static final String TYPE = "LineString";
	private List<Point> points;
	
	public LineString() {
		this.points = new ArrayList<>();
	}
	
	public LineString(List<Point> points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points != null ? this.points.size() : 0;
	}
	
	public Point getPointN(int n) {
		return this.points != null 
			&& this.points.size() > n 
			&& n >= 0
			? this.points.get(n) : null;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isEmpty() {
		return this.points == null || this.points.isEmpty();
	}

	@Override
	public void translate(Double dx, Double dy) {
		if(this.points != null) {
			for(Point point : this.points) {
				point.translate(dx, dy);
			}
		}
	}
	
	@Override
	public Geometry clone() {
		return new LineString(this.points);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		LineString lineString = (LineString) obj;
		return this.points.equals(lineString.points);
	}
	
}
