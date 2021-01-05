package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnvelopeBuilderTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		assertEquals(0, envelopeBuilder.getListCoordinate().size());
	}
	
	@Test
	public void testInsert() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		envelopeBuilder.insert(new Coordinate());
		assertEquals(1, envelopeBuilder.getListCoordinate().size());
	}
	
	@Test
	public void getXMin() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		envelopeBuilder.insert(new Coordinate(0.0, 0.0));
		envelopeBuilder.insert(new Coordinate(1.0, 1.0));
		assertEquals(0.0, envelopeBuilder.build().getXmin(),EPSILON);
	}
	
	@Test
	public void getYMin() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		envelopeBuilder.insert(new Coordinate(0.0, 0.0));
		envelopeBuilder.insert(new Coordinate(1.0, 1.0));
		assertEquals(0.0, envelopeBuilder.build().getYmin(),EPSILON);
	}

	@Test
	public void getXMax() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		envelopeBuilder.insert(new Coordinate(0.0, 0.0));
		envelopeBuilder.insert(new Coordinate(1.0, 1.0));
		assertEquals(1.0, envelopeBuilder.build().getXmax(),EPSILON);
	}
	
	@Test
	public void getYMax() {
		EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
		envelopeBuilder.insert(new Coordinate(0.0, 0.0));
		envelopeBuilder.insert(new Coordinate(1.0, 1.0));
		assertEquals(1.0, envelopeBuilder.build().getYmax(),EPSILON);
	}
}
