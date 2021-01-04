package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Point point = new Point();
		assertTrue(point.isEmpty());
	}
	
	@Test 
	public void testIsEmptyNull() {
		Point point = new Point(null);
		assertTrue(point.isEmpty());
	}
	
	@Test 
	public void testIsNotEmpty() {
		Point point = SampleFactory.createPointPx1yMinus2();
		assertFalse(point.isEmpty());
	}
	
	@Test
	public void testConstructorWithParamGetX() {
		Point point = SampleFactory.createPointPx1yMinus2();
		assertEquals(1.0, point.getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testConstructorWithParamGetY() {
		Point point = SampleFactory.createPointPx1yMinus2();
		assertEquals(-2.0, point.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testGetType() {
		Point point = new Point();
		assertEquals(Point.TYPE, point.getType());
	}
	
	@Test
	public void testTranslateGetX() {
		Point point = SampleFactory.createPointPx1yMinus2();
		
		point.translate(2.0, -2.0);
		assertEquals(3.0, point.getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testTranslateGetY() {
		Point point = SampleFactory.createPointPx1yMinus2();
		
		point.translate(2.0, -2.0);
		assertEquals(-4.0, point.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testClone() {
		Point point = SampleFactory.createPointO();
		Geometry pointClone = point.clone();
		assertEquals(point, pointClone);
	}
}
