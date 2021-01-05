package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{
	
	private PrintStream out;

	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public void visit(Point point) {
		StringBuilder info = new StringBuilder();
		info.append("Je suis un point avec x=");
		info.append(point.getCoordinate().getX());
		info.append(" et y=");
		info.append(point.getCoordinate().getY());
		this.out.print(info);
	}

	@Override
	public void visit(LineString lineString) {
		StringBuilder info = new StringBuilder();
		info.append("Je suis une polyligne définie par ");
		info.append(lineString.getNumPoints());
		info.append(" point(s)");
		this.out.print(info);		
	}
	
	

}
