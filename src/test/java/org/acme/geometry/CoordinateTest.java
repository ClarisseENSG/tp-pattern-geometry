package org.acme.geometry;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		assertTrue(c.isEmpty());
	}
	
	@Test
	public void testDefaultConstructorDoubleNaNX(){
		Coordinate c = new Coordinate();
		assertTrue(Double.isNaN(c.getX()));
	}
	
	@Test
	public void testDefaultConstructorDoubleNaNY(){
		Coordinate c = new Coordinate();
		assertTrue(Double.isNaN(c.getY()));
	}
	
	@Test
	public void testConstructorWithParamIsNotEmpty() {
		Coordinate c = new Coordinate(1.0, 1.0);
		assertFalse(c.isEmpty());
	}
	
	@Test
	public void testConstructorWithParamGetX() {
		final double x = 1.0;
		final double y = 2.0;
		Coordinate c = new Coordinate(x, y);
		assertEquals(x, c.getX(), EPSILON);
	}
	
	@Test
	public void testConstructorWithParamGetY() {
		final double x = 1.0;
		final double y = 2.0;
		Coordinate c = new Coordinate(x, y);
		assertEquals(y, c.getY(), EPSILON);
	}
	
	@Test
	public void testEqualsNull() {
		Object obj = null;
		Coordinate c = new Coordinate(1.0, 1.0);
		assertNotEquals(c, obj);
	}
	
	@Test
	public void testEqualsDifferentClass() {
		Object obj = new Object();
		Coordinate c = new Coordinate(1.0, 1.0);
		assertNotEquals(c, obj);
	}
	
	@Test
	public void testEqualsNaN() {
		Coordinate c1 = new Coordinate();
		Coordinate c2 = new Coordinate();
		assertEquals(c1, c2);
	}
	
	@Test
	public void testEquals() {
		Coordinate c1 = new Coordinate(1.0, 1.0);
		Coordinate c2 = new Coordinate(1.0, 1.0);
		assertEquals(c1, c2);
	}
	
	@Test
	public void testNotEquals() {
		Coordinate c1 = new Coordinate(1.0, 2.0);
		Coordinate c2 = new Coordinate(1.0, 1.0);
		assertNotEquals(c1, c2);
	}
	
}
