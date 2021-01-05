package org.acme.geometry;

public interface Geometry {
	
	public String getType();
	
	public boolean isEmpty();
	
	public void translate(Double dx, Double dy);
	
	public Geometry clone();
	
	public Envelope getEnvelope();
	
	public String asText();
	
	public void accept(GeometryVisitor visitor);
	
	public void addListener(GeometryListener listener);

}
