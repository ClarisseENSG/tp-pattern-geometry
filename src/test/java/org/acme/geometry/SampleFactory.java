package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class SampleFactory {
	
	public static Point createPointO() {
		return new Point();
	}
	
	public static Point createPointPx1yMinus2() {
		return new Point(new Coordinate(1.0, -2.0));
	}
	
	public static Point createPointPx2y3() {
		return new Point(new Coordinate(2.0, 3.0));
	}
	
	public static Point createPointPx4y5() {
		return new Point(new Coordinate(4.0, 5.0));
	}
	
	public static LineString createLineString() {
		List<Point> points = new ArrayList<>();
		points.add(createPointPx1yMinus2());
		points.add(createPointO());
		return new LineString(points);
	}
	
	public static LineString createLineStringThreePoints() {
		List<Point> points = new ArrayList<>();
		points.add(createPointPx1yMinus2());
		points.add(createPointPx2y3());
		points.add(createPointPx4y5());
		return new LineString(points);
	}
	
	public static LineString createLineStringNull() {
		return new LineString(null);
	}

}
