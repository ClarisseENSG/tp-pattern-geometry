package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(0.0, c.getX(), EPSILON);
		Assert.assertEquals(0.0, c.getY(), EPSILON);
	}
	
	@Test
	public void testConstructorWithParam() {
		final double x = 1.0;
		final double y = 2.0;
		Coordinate c = new Coordinate(x, y);
		Assert.assertEquals(x, c.getX(), EPSILON);
		Assert.assertEquals(y, c.getY(), EPSILON);
	}

}
