package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		LineString lineString = new LineString();
		assertEquals(0, lineString.getNumPoints());
	}
	
	@Test
	public void testGetNumPoint() {		
		LineString lineString = SampleFactory.createLineString();
		assertEquals(2, lineString.getNumPoints());
	}
	
	@Test
	public void testGetNumPointNull() {
		LineString lineStringNull = SampleFactory.createLineStringNull();
		assertEquals(0, lineStringNull.getNumPoints());
	}
	
	@Test
	public void testGetPointNNotNull() {		
		LineString lineString = SampleFactory.createLineString();
		Point point = SampleFactory.createPointPx1yMinus2();
		assertEquals(point, lineString.getPointN(0));
	}
	
	@Test
	public void testGetPointNEmpty() {		
		LineString lineString = SampleFactory.createLineString();
		assertTrue(lineString.getPointN(1).isEmpty());
	}
	
	@Test
	public void testGetPointNNull() {
		LineString lineStringNull = SampleFactory.createLineStringNull();
		assertNull(lineStringNull.getPointN(0));
	}
	
	@Test
	public void testGetPointNNullOversize() {
		LineString lineStringNull = SampleFactory.createLineStringNull();
		assertNull(lineStringNull.getPointN(10));
	}
	
	@Test
	public void testGetType() {
		LineString lineString = new LineString();
		assertEquals(LineString.TYPE, lineString.getType());
	}
	
	@Test
	public void testTranslateGetX() {
		LineString lineString = SampleFactory.createLineString();
		
		lineString.translate(2.0, -2.0);
		assertEquals(3.0, lineString.getPointN(0).getCoordinate().getX(), EPSILON);
	}
	
	@Test
	public void testTranslateGetY() {
		LineString lineString = SampleFactory.createLineString();
		
		lineString.translate(2.0, -2.0);
		assertEquals(-4.0, lineString.getPointN(0).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testIsEmptyNull() {
		LineString lineStringNull = SampleFactory.createLineStringNull();
		assertTrue(lineStringNull.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty() {
		LineString lineString = SampleFactory.createLineString();
		assertFalse(lineString.isEmpty());
	}
	
	@Test
	public void testIsEmpty() {
		LineString lineString = new LineString();
		assertTrue(lineString.isEmpty());
	}
	
	@Test
	public void testClone() {
		LineString lineString = SampleFactory.createLineString();
		Geometry lineStringClone = lineString.clone();
		assertEquals(lineString, lineStringClone);
	}
	
	@Test
	public void testGetEnvelopeXMin() {
		LineString lineString = SampleFactory.createLineStringThreePoints();
		Envelope envelope = lineString.getEnvelope();
		assertEquals(1.0, envelope.getXmin(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeYMin() {
		LineString lineString = SampleFactory.createLineStringThreePoints();
		Envelope envelope = lineString.getEnvelope();
		assertEquals(-2.0, envelope.getYmin(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeXMax() {
		LineString lineString = SampleFactory.createLineStringThreePoints();
		Envelope envelope = lineString.getEnvelope();
		assertEquals(4.0, envelope.getXmax(), EPSILON);
	}
	
	@Test
	public void testGetEnvelopeYMax() {
		LineString lineString = SampleFactory.createLineStringThreePoints();
		Envelope envelope = lineString.getEnvelope();
		assertEquals(5.0, envelope.getYmax(), EPSILON);
	}

}
