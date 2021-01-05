package org.acme.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

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
	
	@Test
	public void testAccept() {
		GeometryVisitor builder = new EnvelopeBuilder();
		Geometry geometry = new Point(new Coordinate(3.0,3.0));
		geometry = new GeometryWithCachedEnvelope(geometry);
		geometry.accept(builder);
		assertEquals(3.0, geometry.getEnvelope().getXmin(), EPSILON);
	}
	
	@Test
	public void testUseCase() {
		Geometry original = Mockito.mock(Geometry.class);
		Envelope envelope = new Envelope();
		Mockito.when(original.getEnvelope()).thenReturn(envelope);
		
		GeometryWithCachedEnvelope cached = new GeometryWithCachedEnvelope(original);
		assertSame(envelope, cached.getEnvelope());
		assertSame(envelope, cached.getEnvelope());
		
		Mockito.verify(original, Mockito.times(1)).getEnvelope();
	}
	
	@Test 
	public void testTranslate() {
		Geometry original = SampleFactory.createLineString();
		GeometryWithCachedEnvelope geometry = new GeometryWithCachedEnvelope(original);
		Envelope envelopeA = geometry.getEnvelope();
		geometry.translate(1.0, 1.0);
		assertNotSame(envelopeA, geometry.getEnvelope());
	}

	@Test
	public void testAsText() {
		Geometry original = new Point(new Coordinate(3.0, 4.0));
		GeometryWithCachedEnvelope geometry = new GeometryWithCachedEnvelope(original);
		assertEquals("POINT(3.0 4.0)", geometry.asText());
	}
	
	@Test
	public void testClone() {
		Geometry original = new Point(new Coordinate(3.0, 4.0));
		GeometryWithCachedEnvelope geometry = new GeometryWithCachedEnvelope(original);
		Geometry cloneGeom = geometry.clone();
		assertEquals(original, cloneGeom);
	}
	
	@Test
	public void testAddListener() {
		AbstractGeometry original = new Point(new Coordinate(3.0, 4.0));
		GeometryWithCachedEnvelope geometry = new GeometryWithCachedEnvelope(original);
		geometry.addListener(geometry);
		Geometry cloneGeom = geometry.clone();
		assertEquals(original, cloneGeom);
	}

}
