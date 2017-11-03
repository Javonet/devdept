import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.JavonetFramework;
import com.javonet.api.INEventListener;
import com.javonet.api.NControlContainer;
import com.javonet.api.NEnum;
import com.javonet.api.NNull;
import com.javonet.api.NObject;
import com.javonet.api.NType;
import com.javonet.api.keywords.NOut;

public class EyeshotProfessionalJavaDemoMain {
	private Frame frame;
	private Frame frameLoading;
	private NObject viewportLayout1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new EyeshotProfessionalJavaDemoMain();
		} catch (JavonetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EyeshotProfessionalJavaDemoMain() throws JavonetException, IOException{
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				frameLoading=new Frame();
				Label lblLoading = new Label();
				lblLoading.setText("Loading...");
				frameLoading.add(lblLoading);
				frameLoading.setSize(300, 150);
				frameLoading.setVisible(true);
			}
			
		});
		//Todo: Before running this sample signup and download free trial of Eyeshot Professional
		//http://devdept.com/Products/Eyeshot/Download
		
		//Todo: Go to https://www.javonet.com/pricing/ and signup for free trial license key
		//Todo: Put your license key below
		Javonet.activate("your@mail.com", "your-license-key", JavonetFramework.v45);
		Javonet.addReference("System.Windows.Forms");
		Javonet.addReference("System.Drawing");
		AddEmbeddedDllReference("devDept.DataSet.dll");
		AddEmbeddedDllReference("devDept.Eyeshot.Control.v10.dll");
		AddEmbeddedDllReference("devDept.Geometry.v10.dll");
		AddEmbeddedDllReference("devDept.Graphics.Shaders.v10.dll");
		AddEmbeddedDllReference("devDept.Graphics.v10.dll");
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					gui();
				} catch (JavonetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private static void AddEmbeddedDllReference(String fileName) throws IOException, JavonetException{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(fileName);
		byte[] dllBytes = IOUtils.toByteArray(input);
		
		Javonet.addReference(fileName,dllBytes);
	}
	
	private void gui() throws JavonetException, IOException{
		
		this.viewportLayout1 = Javonet.New("devDept.Eyeshot.ViewportLayout");
		
		NObject camera1 = Javonet.New("devDept.Eyeshot.Camera",
				Javonet.New("devDept.Geometry.Point3D",0D,0D,0D),
				617.101007166283D, 
				Javonet.New("devDept.Geometry.Quaternion",0.12940952255126D, 0.224143868042013D, 0.482962913144534D, 0.836516303737808D), 
				new NEnum("devDept.Graphics.projectionType","Perspective"), 
				50D, 4D, false, 0.001D);
		NObject backgroundSettings1 = Javonet.New("devDept.Graphics.BackgroundSettings",
				new NEnum("devDept.Graphics.backgroundStyleType","Solid"), 
				Javonet.getType("System.Drawing.Color").get("DeepSkyBlue"),
				Javonet.getType("System.Drawing.Color").get("DodgerBlue"),
				Javonet.getType("System.Drawing.Color").get("Snow"),
				0.75D, null, 
				new NEnum("devDept.Graphics.colorThemeType","Auto"), 0.3D);
        NObject grid1 = Javonet.New("devDept.Eyeshot.Grid",
        		Javonet.New("devDept.Geometry.Point3D",-50D, -50D, 0D), 
        		Javonet.New("devDept.Geometry.Point3D",100D, 100D, 0D), 
        		10D, 
        		Javonet.New("devDept.Geometry.Plane",
        				Javonet.New("devDept.Geometry.Point3D",0D, 0D, 0D),
        				Javonet.New("devDept.Geometry.Vector3D",0D, 0D, 1D)),
        				
        				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(127)) & 0xFF)), ((int)(((byte)(128)) & 0xFF)), ((int)(((byte)(128)) & 0xFF)), ((int)(((byte)(128)) & 0xFF))), 
        				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(127)) & 0xFF)), ((int)(((byte)(32)) & 0xFF)), ((int)(((byte)(32)) & 0xFF)), ((int)(((byte)(32)) & 0xFF))), 
        				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(127)) & 0xFF)), ((int)(((byte)(32)) & 0xFF)), ((int)(((byte)(32)) & 0xFF)), ((int)(((byte)(32)) & 0xFF))), 
        				false, true, false, false, 10, 100, 10, 
        				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(127)) & 0xFF)), ((int)(((byte)(90)) & 0xFF)), ((int)(((byte)(90)) & 0xFF)), ((int)(((byte)(90)) & 0xFF))), 
        				Javonet.getType("System.Drawing.Color").get("Empty")
        				, false);
        
        NObject rotateSettings1 = Javonet.New("devDept.Eyeshot.RotateSettings",
        		Javonet.New("devDept.Eyeshot.MouseButton",
        				new NEnum("devDept.Eyeshot.mouseButtonsZPR","Middle"),
        				new NEnum("devDept.Eyeshot.modifierKeys","None")), 
        		10D, true, 1D, 
        		new NEnum("devDept.Eyeshot.rotationType","Trackball"), 
        		new NEnum("devDept.Eyeshot.rotationCenterType","CursorLocation"), 
        		Javonet.New("devDept.Geometry.Point3D",0D, 0D, 0D), false);
        
        NObject zoomSettings1 = Javonet.New("devDept.Eyeshot.ZoomSettings",
        		Javonet.New("devDept.Eyeshot.MouseButton",
        				new NEnum("devDept.Eyeshot.mouseButtonsZPR","Middle"),
        				new NEnum("devDept.Eyeshot.modifierKeys","Shift")),
        		25, true, 
        		new NEnum("devDept.Eyeshot.zoomStyleType","AtCursorLocation"),
        		false, 1D, 
        		Javonet.getType("System.Drawing.Color").get("DeepSkyBlue"),
        		new NEnum("devDept.Eyeshot.Camera+perspectiveFitType","Accurate"),
        		false, 10, true);
        
        NObject panSettings1 =Javonet.New("devDept.Eyeshot.PanSettings",
        		Javonet.New("devDept.Eyeshot.MouseButton",
        				new NEnum("devDept.Eyeshot.mouseButtonsZPR","Middle"),
        				new NEnum("devDept.Eyeshot.modifierKeys","Ctrl")),
        		25, true);
        NObject navigationSettings1 = Javonet.New("devDept.Eyeshot.NavigationSettings",
        		new NEnum("devDept.Eyeshot.Camera+navigationType","Examine"),
        		Javonet.New("devDept.Eyeshot.MouseButton",
        				new NEnum("devDept.Eyeshot.mouseButtonsZPR","Left"),
        				new NEnum("devDept.Eyeshot.modifierKeys","None")),
				Javonet.New("devDept.Geometry.Point3D",-1000D, -1000D, -1000D), 
				Javonet.New("devDept.Geometry.Point3D",1000D, 1000D, 1000D), 8D, 50D, 50D);
        
        NObject savedViewsManager1 = Javonet.New("devDept.Eyeshot.Viewport+SavedViewsManager",8);
        
        NObject homeToolBarButton1 = Javonet.New("devDept.Eyeshot.HomeToolBarButton",
        		"Home",
        		new NEnum("devDept.Eyeshot.ToolBarButton+styleType","PushButton"),
        		 true, true);
        
        NObject rotateToolBarButton1 = Javonet.New("devDept.Eyeshot.RotateToolBarButton","Rotate", 
        		new NEnum("devDept.Eyeshot.ToolBarButton+styleType","ToggleButton"), true, true);
   
        
        
        NObject toolBar1 = Javonet.New("devDept.Eyeshot.ToolBar",
        		new NEnum("devDept.Eyeshot.ToolBar+positionType","HorizontalTopCenter"),
        		true, new NObject[] {
        				rotateToolBarButton1 
        				      				
        		});
                
		
		NObject viewport1 = Javonet.New("devDept.Eyeshot.Viewport",
				Javonet.New("System.Drawing.Point",0,0), 
				Javonet.New("System.Drawing.Size",862,810), 
				backgroundSettings1, camera1,new NObject[] {toolBar1}, 
				new NEnum("devDept.Eyeshot.displayType","Rendered")
				, true, false, false, false, new NObject[] {
	            grid1}, false, rotateSettings1, 
				zoomSettings1, panSettings1, navigationSettings1, 
				savedViewsManager1, new NEnum("devDept.Eyeshot.viewType","Trimetric"));
		
		this.viewportLayout1.getRef("Viewports").invoke("Add",viewport1);

		NObject viewCubeIcon1 = Javonet.New("devDept.Eyeshot.ViewCubeIcon",new NEnum("devDept.Eyeshot.coordinateSystemPositionType","TopRight"), true, Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(255))) & 0xFF), ((int)(((byte)(20))) & 0xFF), ((int)(((byte)(147)))) & 0xFF), true, "FRONT", "BACK", "LEFT", "RIGHT", "TOP", "BOTTOM", 
				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(240))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77)))) & 0xFF), 
				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(240))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77)))) & 0xFF),  
				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(240))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77)))) & 0xFF),  
				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(240))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77)))) & 0xFF), 
				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(240))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77)))) & 0xFF), 
				Javonet.getType("System.Drawing.Color").invoke("FromArgb",((int)(((byte)(240))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77))) & 0xFF), ((int)(((byte)(77)))) & 0xFF), 
				'S', 'N', 'W', 'E', true, Javonet.getType("System.Drawing.Color").get("White"), Javonet.getType("System.Drawing.Color").get("Black"), 120, true, true, null, null, null, null, null, null, false);
        
		viewCubeIcon1.set("InitialRotation", Javonet.New("devDept.Geometry.Quaternion",0D, 0D, 0D, 1D));
		viewport1.set("ViewCubeIcon", viewCubeIcon1);
		
		this.viewportLayout1.set("WriteDepthForTransparents",false);
		
        viewportLayout1.set("ActionMode",new NEnum("devDept.Eyeshot.actionType","None")); // reset all actions
        viewportLayout1.invoke("Focus");
        
        viewportLayout1.invoke("Clear");             
        viewportLayout1.getRef("Grid").set("Visible",true);
        viewportLayout1.getRef("Grid").set("Step",10);
        
        this.viewportLayout1.addEventListener("WorkCompleted", new INEventListener() {

			@Override
			public void eventOccurred(Object[] arg0) {
				// TODO Auto-generated method stub
				NObject e = (NObject) arg0[1];
				try {
					System.out.println((String)e.getRef("WorkUnit").invoke("ToString"));
					 NObject rfa = e.getRef("WorkUnit");

		             rfa.invoke("AddToScene",viewportLayout1,true,new NNull("String"));
		                viewportLayout1.invoke("ZoomFit");
				} catch (JavonetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
        	
        });


        viewportLayout1.getRef("HiddenLines").set("Lighting", false);
        viewportLayout1.getRef("HiddenLines").set("ColorMethod",new NEnum("hiddenLinesColorMethodType","SingleColor"));
        viewportLayout1.getRef("HiddenLines").set("DashedHiddenLines", false);

        viewportLayout1.set("AutoHideLabels",true);
        viewportLayout1.set("DisplayMode",new NEnum("displayType","Rendered"));
        
		NControlContainer ncc = new NControlContainer(this.viewportLayout1);
		
		frame = new Frame();
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				frame.dispose();
			}
		});
		
		frame.add(ncc, BorderLayout.CENTER);
		
		frame.setSize(new Dimension(700,700));
		frame.setTitle("Eyeshot Professional Demo");
		
		frameLoading.setVisible(false);
		frame.setVisible(true);
		
		MotherBoard(viewportLayout1);
		
	}
	
    private void MotherBoard(NObject viewportLayout) throws JavonetException
    {
    	NObject objStream=null, mtlStream=null;
    	NOut objStreamOut=new NOut(objStream,"Stream"), mtlStreamOut=new NOut(mtlStream,"Stream");
        NType stringType = Javonet.getType("String");
        NType streamType = Javonet.getType("Stream");
        NObject texStreams = Javonet.getType("Dictionary`2",stringType,streamType).create();

        Javonet.getType("DataSet").invoke("GetMotherBoardStream",
        		objStreamOut, 
        		mtlStreamOut, 
        				new NOut(texStreams));

       NEnum enu= new NEnum("devDept.Eyeshot.Entities.Mesh+edgeStyleType","None");
        NObject ro = Javonet.New("ReadOBJ",objStreamOut.getArgument(), mtlStreamOut.getArgument(), texStreams, 
        		enu);

        viewportLayout.invoke("StartWork",ro);

    }
}
