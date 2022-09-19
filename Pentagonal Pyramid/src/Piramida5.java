
import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;

public class Piramida5 extends Shape3D{
   public Piramida5() {
    GeometryInfo gi = new GeometryInfo(GeometryInfo.TRIANGLE_STRIP_ARRAY);
    
    Point3d[] vertices = {
               new Point3d(2*Math.sin(0*72*Math.PI/180),0,2*Math.cos(0*72*Math.PI/180)),//pika 0
               new Point3d(2*Math.sin(1*72*Math.PI/180),0,2*Math.cos(1*72*Math.PI/180)),//pika 1
               new Point3d(2*Math.sin(2*72*Math.PI/180),0,2*Math.cos(2*72*Math.PI/180)),//pika 2
               new Point3d(2*Math.sin(3*72*Math.PI/180),0,2*Math.cos(3*72*Math.PI/180)),//pika 3
               new Point3d(2*Math.sin(4*72*Math.PI/180),0,2*Math.cos(4*72*Math.PI/180)),//pika 4
               new Point3d(0,2.5, 0)};//pika 5
       	int[] indices = {0,1,5,1,2,5,2,3,5,3,4,5,4,0,5,0,1,2,3,4};
    gi.setCoordinates(vertices);
    gi.setCoordinateIndices(indices);
    	int[] stripCounts = {3,3,3,3,3,5};
    gi.setStripCounts(stripCounts);
    NormalGenerator ng = new NormalGenerator();
    ng.generateNormals(gi);
    this.setGeometry(gi.getGeometryArray());
  }
}
