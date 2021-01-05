package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class LogGeometryVisitorTest {
	
	@Test
	public void testVisitPoint() throws UnsupportedEncodingException {
		Point point = SampleFactory.createPointPx2y3();
		ByteArrayOutputStream outStr = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outStr);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		point.accept(visitor);
		assertEquals("Je suis un point avec x=2.0 et y=3.0", outStr.toString());
	}
	
	@Test
	public void testVisitLineString() throws UnsupportedEncodingException {
		LineString lineString = SampleFactory.createLineStringThreePoints();
		ByteArrayOutputStream outStr = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outStr);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		lineString.accept(visitor);
		assertEquals("Je suis une polyligne définie par 3 point(s)", outStr.toString());
	}

}
