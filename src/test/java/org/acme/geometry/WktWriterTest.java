package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WktWriterTest {
	
	@Test
	public void testWritePointNull() {
		Geometry geometry = new Point(new Coordinate());
		WktWriter writer = new WktWriter();
		assertEquals("POINT EMPTY", writer.write(geometry));
	}
	
	@Test
	public void testWritePoint() {
		Geometry geometry = new Point(new Coordinate(3.0, 4.0));
		WktWriter writer = new WktWriter();
		assertEquals("POINT(3.0 4.0)", writer.write(geometry));
	}
	
	@Test
	public void testWriteLineStringNull() {
		Geometry geometry = new LineString(null);
		WktWriter writer = new WktWriter();
		assertEquals("LINESTRING EMPTY", writer.write(geometry));
	}
	
	@Test
	public void testWriteLineString() {
		List<Point> points = new ArrayList<>();
		points.add(SampleFactory.createPointPx1yMinus2());
		points.add(SampleFactory.createPointPx2y3());
		points.add(SampleFactory.createPointPx4y5());
		Geometry geometry = new LineString(points);
		WktWriter writer = new WktWriter();
		assertEquals("LINESTRING(1.0 -2.0,2.0 3.0,4.0 5.0)", writer.write(geometry));
	}
	
	@Test(expected = RuntimeException.class)
	public void testRuntimeException() {
		WrongGeometry wrongGeometry = new WrongGeometry();
		WktWriter writer = new WktWriter();
		writer.write(wrongGeometry);
	}
	
	private class WrongGeometry extends AbstractGeometry {

		@Override
		public String getType() {
			return null;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public void translate(Double dx, Double dy) {
		}

		@Override
		public void accept(GeometryVisitor visitor) {
		}

		@Override
		public Geometry clone() {
			return null;
		}
		
	}
	
}
