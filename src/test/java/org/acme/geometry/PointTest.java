package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class PointTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Point point = new Point();
		assertTrue(point.isEmpty());
	}
	

	@Test 
	public void testIsEmpty() {
		Coordinate coordinate = Mockito.mock(Coordinate.class);
		Mockito.when(coordinate.isEmpty()).thenReturn(true);
		Point point = new Point(coordinate);
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
	
	@Test
	public void testGetEnvelopeXMin() {
		Point point = SampleFactory.createPointPx1yMinus2();
		Envelope envelope = point.getEnvelope();
		assertEquals(1.0, envelope.getXmin(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeYMin() {
		Point point = SampleFactory.createPointPx1yMinus2();
		Envelope envelope = point.getEnvelope();
		assertEquals(-2.0, envelope.getYmin(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeXMax() {
		Point point = SampleFactory.createPointPx1yMinus2();
		Envelope envelope = point.getEnvelope();
		assertEquals(1.0, envelope.getXmax(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeYMax() {
		Point point = SampleFactory.createPointPx1yMinus2();
		Envelope envelope = point.getEnvelope();
		assertEquals(-2.0, envelope.getYmax(), EPSILON);
	}
}
