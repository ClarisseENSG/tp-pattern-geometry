package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testGeometryWithCachedEnvelope() {
		Geometry geometry = new Point(new Coordinate(3.0,3.0));
		geometry = new GeometryWithCachedEnvelope(geometry);
		Envelope envelopeA = geometry.getEnvelope();
		Envelope envelopeB = geometry.getEnvelope();
		assertSame(envelopeA, envelopeB);
	}
	
	@Test
	public void testGetType() {
		Geometry geometry = new Point(new Coordinate(3.0,3.0));
		geometry = new GeometryWithCachedEnvelope(geometry);
		assertEquals("Point", geometry.getType());
	}
	
	@Test
	public void testIsEmpty() {
		Geometry geometry = new Point(null);
		geometry = new GeometryWithCachedEnvelope(geometry);
		assertTrue(geometry.isEmpty());
	}


}
