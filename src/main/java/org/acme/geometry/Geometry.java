package org.acme.geometry;

public interface Geometry {
	
	public String getType();
	
	public boolean isEmpty();
	
	public void translate(Double dx, Double dy);
	
	public Geometry clone();
	
	public Envelope getEnvelope();

}
