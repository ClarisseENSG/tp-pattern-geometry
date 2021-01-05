package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		Envelope envelope = new Envelope();
		assertTrue(envelope.isEmpty());
	}
	
	@Test
	public void testConstructorWithParamBottomLeft() {
		final Coordinate bottomLeft = new Coordinate(1.0, 2.0);
		final Coordinate topRight = new Coordinate(3.0, 4.0);
		Envelope envelope = new Envelope(bottomLeft, topRight);
		Coordinate coordinate = new Coordinate(envelope.getXmin(), envelope.getYmin());
		assertEquals(bottomLeft, coordinate);
	}
	
	@Test
	public void testConstructorWithParamTopRight() {
		final Coordinate bottomLeft = new Coordinate(1.0, 2.0);
		final Coordinate topRight = new Coordinate(3.0, 4.0);
		Envelope envelope = new Envelope(bottomLeft, topRight);
		Coordinate coordinate = new Coordinate(envelope.getXmax(), envelope.getYmax());
		assertEquals(topRight, coordinate);
	}

	@Test
	public void testIsEmpty() {
		Envelope envelope = new Envelope();
		assertTrue(envelope.isEmpty());
	}
	
	@Test
	public void testIsEmptyNull() {
		Envelope envelope = new Envelope(null, null);
		assertTrue(envelope.isEmpty());
	}
	
	@Test
	public void testGetXminEnvelopeEmpty() {
		Envelope envelope = new Envelope(null, null);
		assertEquals(Double.NaN, envelope.getXmin(), EPSILON);
	}
	
	@Test
	public void testGetYminEnvelopeEmpty() {
		Envelope envelope = new Envelope(null, null);
		assertEquals(Double.NaN, envelope.getYmin(), EPSILON);
	}
	
	@Test
	public void testGetXmaxEnvelopeEmpty() {
		Envelope envelope = new Envelope(null, null);
		assertEquals(Double.NaN, envelope.getXmax(), EPSILON);
	}
	
	@Test
	public void testGetYmaxEnvelopeEmpty() {
		Envelope envelope = new Envelope(null, null);
		assertEquals(Double.NaN, envelope.getYmax(), EPSILON);
	}

}
