package org.acme.geometry;

public class Point extends AbstractGeometry implements Geometry{
	
	public static final String TYPE = "Point";
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isEmpty() {
		return this.coordinate == null || this.coordinate.isEmpty();
	}

	@Override
	public void translate(Double dx, Double dy) {
		this.coordinate = new Coordinate(
			this.coordinate.getX() + dx, 
			this.coordinate.getY() + dy);
	}
	
	@Override
	public Point clone() {
		return new Point(this.coordinate);
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		Point point = (Point) obj;
		return point.getCoordinate().equals(this.getCoordinate());
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
