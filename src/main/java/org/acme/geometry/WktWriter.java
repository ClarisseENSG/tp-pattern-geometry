package org.acme.geometry;

public class WktWriter {
	
	public String write(Geometry geometry) {
		if (geometry instanceof Point){
		    Point point = (Point)geometry;
		    StringBuilder wkt = new StringBuilder();
		    wkt.append("POINT");
		    if(point.isEmpty()) {
		    	wkt.append(" EMPTY");
		    	return wkt.toString();
		    }
		    wkt.append("(");
		    wkt.append(point.getCoordinate().getX());
		    wkt.append(" ");
		    wkt.append(point.getCoordinate().getY());
		    wkt.append(")");
			return wkt.toString();
		}
		else if (geometry instanceof LineString){
		    LineString lineString = (LineString)geometry;
		    StringBuilder wkt = new StringBuilder();
		    wkt.append("LINESTRING");
		    if(lineString.isEmpty()) {
		    	wkt.append(" EMPTY");
		    	return wkt.toString();
		    }
		    wkt.append("(");
		    for(int i = 0; i < lineString.getNumPoints(); i++) {
		    	wkt.append(lineString.getPointN(i).getCoordinate().getX());
		    	wkt.append(" ");
		    	wkt.append(lineString.getPointN(i).getCoordinate().getY());
		    	if(i<lineString.getNumPoints()-1) {
			    	wkt.append(",");
		    	}
		    }
		    wkt.append(")");
		    return wkt.toString();		    
		}
		else{
		    throw new RuntimeException("geometry type not supported");
		}
	}

}
