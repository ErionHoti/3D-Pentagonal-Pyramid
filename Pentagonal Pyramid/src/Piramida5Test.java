
import javax.vecmath.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.media.j3d.*;
   import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
   import java.applet.*;
   import com.sun.j3d.utils.applet.MainFrame;
    public class Piramida5Test extends Applet { 
       public static void main(String[] args) 
      { 
         new MainFrame(new Piramida5Test(), 800, 500); 
      } 
       public void init() 
      { 
         GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
         Canvas3D cv = new Canvas3D(gc);
         setLayout(new BorderLayout());
         add(cv, BorderLayout.CENTER);
         BranchGroup bg = createSceneGraph();
         bg.compile(); 
         SimpleUniverse su = new SimpleUniverse(cv);
         su.getViewingPlatform().setNominalViewingTransform();
         su.addBranchGraph(bg);
      } 
       private BranchGroup createSceneGraph() 
      {  BranchGroup root = new BranchGroup();
         TransformGroup spin = new TransformGroup(); 
         spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); 
         root.addChild(spin);  // object
         Appearance ap = new Appearance();
         ap.setMaterial(new Material());
         Shape3D shape = new Piramida5();
         shape.setAppearance(ap); 
         Transform3D tr = new Transform3D();
         tr.setTranslation(new Vector3f(0.35f, -0.2f, 0.1f));//rrotullimi 
         tr.setScale(0.25);
         TransformGroup tg = new TransformGroup(tr);
         spin.addChild(tg);
  		 tg.addChild(shape);
         Alpha alpha = new Alpha(-1, 8000);//shpejtesia e rrotullimit
         {
		 RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
         BoundingSphere bounds = new BoundingSphere();
         rotator.setSchedulingBounds(bounds);
         spin.addChild(rotator);  // background dhe light
         Background background = new Background(1,0,0);
         background.setApplicationBounds(bounds);
         root.addChild(background); 
         PointLight light = new PointLight(new Color3f(Color.CYAN),new Point3f(3f,3f,3f), new Point3f(0f,0f,0f));
         light.setInfluencingBounds(bounds);
         root.addChild(light);
         light.setInfluencingBounds(bounds);
         return root;
      }
   } 
    }