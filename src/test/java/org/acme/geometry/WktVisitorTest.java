package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WktVisitorTest {
	
	@Test
	public void testVisitPointNull() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate());
		geometry.accept(visitor);
		assertEquals("POINT EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0, 4.0));
		geometry.accept(visitor);
		assertEquals("POINT(3.0 4.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitLineStringNull() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString(null);
		geometry.accept(visitor);
		assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitLineString() {
		WktVisitor visitor = new WktVisitor();
		List<Point> points = new ArrayList<>();
		points.add(SampleFactory.createPointPx1yMinus2());
		points.add(SampleFactory.createPointPx2y3());
		points.add(SampleFactory.createPointPx4y5());
		Geometry geometry = new LineString(points);
		geometry.accept(visitor);
		assertEquals("LINESTRING(1.0 -2.0,2.0 3.0,4.0 5.0)", visitor.getResult());
	}

}
