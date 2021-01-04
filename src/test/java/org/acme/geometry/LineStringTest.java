package org.acme.geometry;

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
		LineString lineString = SampleFactory.createLineString();
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
	
	@Test
	public void testTranslate() {
		LineString lineString = SampleFactory.createLineString();
		
		lineString.translate(2.0, -2.0);
		Assert.assertEquals(3.0, lineString.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(-4.0, lineString.getPointN(0).getCoordinate().getY(), EPSILON);
		
	}
	

}
