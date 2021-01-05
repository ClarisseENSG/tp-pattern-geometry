package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbstractGeometryTest {
	
	@Test
	public void testAsText() {
		AbstractGeometry geometry = new Point(new Coordinate(3.0, 4.0));
		assertEquals("POINT(3.0 4.0)", geometry.asText());
	}
	

}
