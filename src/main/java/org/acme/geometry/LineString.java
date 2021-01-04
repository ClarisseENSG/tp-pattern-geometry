package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> points;
	
	public LineString() {
		this.points = new ArrayList<Point>();
	}
	
	public LineString(List<Point> points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public boolean isEmpty() {
		return this.points == null;
	}

	@Override
	public void translate(Double dx, Double dy) {
		for (int i = 0; i < this.points.size(); i++) {
			this.points.get(i).translate(dx, dy);
		}
	}

}
