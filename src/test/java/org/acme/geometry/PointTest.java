package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Point point = new Point();
		Assert.assertTrue(point.isEmpty());
	}
	
	@Test
	public void testConstructorWithParam() {
		Point point = SampleFactory.createPointP();
		Assert.assertEquals(1.0, point.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-2.0, point.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testGetType() {
		Point point = new Point();
		Assert.assertEquals("Point", point.getType());
	}
	
	@Test
	public void testTranslate() {
		Point point = SampleFactory.createPointP();
		
		point.translate(2.0, -2.0);
		Assert.assertEquals(3.0, point.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-4.0, point.getCoordinate().getY(), EPSILON);
	}
}
