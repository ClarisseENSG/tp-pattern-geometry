package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor{
	
	private List<Coordinate> listCoordinate;
	
	public EnvelopeBuilder() {
		this.listCoordinate = new ArrayList<>();
	}
	
	public List<Coordinate> getListCoordinate() {
		return this.listCoordinate;
	}

	public void insert(Coordinate coordinate) {
		this.listCoordinate.add(coordinate);
	}
	
	public Envelope build() {
		return new Envelope(this.getBottomLeft(), this.getTopRight());
	}

	/**
	 * Méthode permettant de retourner la coordonnée en bas à gauche
	 * @return Coordinate bottomLeft
	 */
	private Coordinate getBottomLeft() {
		return new Coordinate(this.getXMin(), this.getYMin());
	}
	
	/**
	 * Méthode permettant de retourner la coordonnée en haut à gauche
	 * @return Coordinate topRight
	 */
	private Coordinate getTopRight() {
		return new Coordinate(this.getXMax(), this.getYMax());
	}
	
	private double getXMin() {
		double xMin = Double.NaN;
		if(this.listCoordinate != null) {
			for(Coordinate coordinate : this.listCoordinate) {
				if(!Double.isNaN(coordinate.getX()) && (Double.isNaN(xMin) || coordinate.getX() < xMin)) {
					xMin = coordinate.getX();
				}
			}
		}
		return xMin;
	}
	
	private double getYMin() {
		double yMin = Double.NaN;
		if(this.listCoordinate != null) {
			for(Coordinate coordinate : this.listCoordinate) {
				if(!Double.isNaN(coordinate.getY()) && (Double.isNaN(yMin) || coordinate.getY() < yMin)) {
					yMin = coordinate.getY();
				}
			}
		}
		return yMin;
	}
	
	private double getXMax() {
		double xMax = Double.NaN;
		if(this.listCoordinate != null) {
			for(Coordinate coordinate : this.listCoordinate) {
				if(!Double.isNaN(coordinate.getX()) && (Double.isNaN(xMax) || coordinate.getX() > xMax)) {
					xMax = coordinate.getX();
				}
			}
		}
		return xMax;
	}
	
	private double getYMax() {
		double yMax = Double.NaN;
		if(this.listCoordinate != null) {
			for(Coordinate coordinate : this.listCoordinate) {
				if(!Double.isNaN(coordinate.getY()) && (Double.isNaN(yMax) || coordinate.getY() > yMax)) {
					yMax = coordinate.getY();
				}
			}
		}
		return yMax;
	}

	@Override
	public void visit(Point point) {
		this.insert(point.getCoordinate());
	}

	@Override
	public void visit(LineString lineString) {
		for(int i = 0; i < lineString.getNumPoints(); i++) {
			this.insert(lineString.getPointN(i).getCoordinate());
		}
	}

}
