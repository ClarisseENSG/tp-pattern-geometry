package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		LineString lineString = new LineString();
		Assert.assertEquals(0, lineString.getNumPoints());
	}
	
	@Test
	public void testConstructorWithParam() {
		Coordinate coord = new Coordinate(1.0, -2.0);
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(coord));
		points.add(new Point());
		
		LineString lineString = new LineString(points);
		Assert.assertEquals(2, lineString.getNumPoints());
		
		Assert.assertEquals(1.0, lineString.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.0, lineString.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertTrue(lineString.getPointN(1).isEmpty());
	}
	
	@Test
	public void testGetType() {
		LineString lineString = new LineString();
		Assert.assertEquals("LineString", lineString.getType());
	}

}
