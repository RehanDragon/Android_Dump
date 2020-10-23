package b4a.example;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public ice.pdfviewer.pdfviewerwrapper _pdfv = null;
public static int _i = 0;
public static int _pc = 0;
public static String _iv = "";
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnzoomin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnzoomout = null;
public static double _zoom = 0;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",mostCurrent._activity,"btnZoomIn",mostCurrent._btnzoomin,"btnZoomOut",mostCurrent._btnzoomout,"i",_i,"iv",mostCurrent._iv,"Label1",mostCurrent._label1,"Panel1",mostCurrent._panel1,"pc",_pc,"pdfv",mostCurrent._pdfv,"zoom",_zoom};
}

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = main.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public static String  _activity_create(boolean _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,mostCurrent.activityBA,mostCurrent,31);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"viewPDF\")";
Debug.ShouldStop(-2147483648);
mostCurrent._activity.LoadLayout("viewPDF",mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="Activity.Title = \"View PDF - Lyndon Bermoy\"";
Debug.ShouldStop(1);
mostCurrent._activity.setTitle((Object)("View PDF - Lyndon Bermoy"));
 BA.debugLineNum = 34;BA.debugLine="Panel1.Left = 0%x";
Debug.ShouldStop(2);
mostCurrent._panel1.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 BA.debugLineNum = 35;BA.debugLine="Panel1.Top = 10%y";
Debug.ShouldStop(4);
mostCurrent._panel1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 BA.debugLineNum = 36;BA.debugLine="Panel1.Width= 100%x";
Debug.ShouldStop(8);
mostCurrent._panel1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 37;BA.debugLine="Panel1.Height = 100%y";
Debug.ShouldStop(16);
mostCurrent._panel1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 39;BA.debugLine="pdfv.init";
Debug.ShouldStop(64);
mostCurrent._pdfv.init(mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="Panel1.AddView(pdfv,0,0,-1,-1)";
Debug.ShouldStop(128);
mostCurrent._panel1.AddView((android.view.View)(mostCurrent._pdfv.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
 BA.debugLineNum = 41;BA.debugLine="File.Copy(File.DirAssets,\"Sample pdf.pdf\",File.DirRootExternal,\"Sample pdf.pdf\")";
Debug.ShouldStop(256);
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Sample pdf.pdf",anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"Sample pdf.pdf");
 BA.debugLineNum = 42;BA.debugLine="pdfv.getpdf(File.DirRootExternal&\"/Sample pdf.pdf\")";
Debug.ShouldStop(512);
mostCurrent._pdfv.getpdf(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Sample pdf.pdf");
 BA.debugLineNum = 44;BA.debugLine="If pdfv.isValid Then";
Debug.ShouldStop(2048);
if (mostCurrent._pdfv.isValid()) { 
 BA.debugLineNum = 45;BA.debugLine="Log(\"pagecount:\" & pdfv.GetPageCount)";
Debug.ShouldStop(4096);
anywheresoftware.b4a.keywords.Common.Log("pagecount:"+BA.NumberToString(mostCurrent._pdfv.GetPageCount()));
 BA.debugLineNum = 46;BA.debugLine="Label1.Text =  \"Page: \" & pdfv.GetPageCount";
Debug.ShouldStop(8192);
mostCurrent._label1.setText((Object)("Page: "+BA.NumberToString(mostCurrent._pdfv.GetPageCount())));
 BA.debugLineNum = 47;BA.debugLine="pdfv.scrollToPage(0)";
Debug.ShouldStop(16384);
mostCurrent._pdfv.scrollToPage((int) (0));
 BA.debugLineNum = 48;BA.debugLine="pc=pdfv.GetPageCount";
Debug.ShouldStop(32768);
_pc = mostCurrent._pdfv.GetPageCount();
 BA.debugLineNum = 49;BA.debugLine="Log(\"pc:\"&pc)";
Debug.ShouldStop(65536);
anywheresoftware.b4a.keywords.Common.Log("pc:"+BA.NumberToString(_pc));
 BA.debugLineNum = 50;BA.debugLine="pdfv.zoom(zoom)";
Debug.ShouldStop(131072);
mostCurrent._pdfv.zoom((float) (_zoom));
 }else {
 BA.debugLineNum = 52;BA.debugLine="Msgbox(\"Error pdf file!\",\"Error\")";
Debug.ShouldStop(524288);
anywheresoftware.b4a.keywords.Common.Msgbox("Error pdf file!","Error",mostCurrent.activityBA);
 BA.debugLineNum = 53;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
mostCurrent._activity.Finish();
 BA.debugLineNum = 54;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return "";
 };
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _btnzoomin_click() throws Exception{
try {
		Debug.PushSubsStack("btnZoomIn_Click (main) ","main",0,mostCurrent.activityBA,mostCurrent,58);
 BA.debugLineNum = 58;BA.debugLine="Sub btnZoomIn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="zoom=zoom + 0.5";
Debug.ShouldStop(67108864);
_zoom = _zoom+0.5;
 BA.debugLineNum = 60;BA.debugLine="pdfv.zoom(zoom)";
Debug.ShouldStop(134217728);
mostCurrent._pdfv.zoom((float) (_zoom));
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _btnzoomout_click() throws Exception{
try {
		Debug.PushSubsStack("btnZoomOut_Click (main) ","main",0,mostCurrent.activityBA,mostCurrent,62);
 BA.debugLineNum = 62;BA.debugLine="Sub btnZoomOut_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="zoom=zoom - 0.5";
Debug.ShouldStop(1073741824);
_zoom = _zoom-0.5;
 BA.debugLineNum = 64;BA.debugLine="pdfv.zoom(zoom)";
Debug.ShouldStop(-2147483648);
mostCurrent._pdfv.zoom((float) (_zoom));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    if (mostCurrent != null && mostCurrent.activityBA != null) {
Debug.StartDebugging(mostCurrent.activityBA, 22523, new int[] {3}, "0ebc4e5b-278e-4d27-8561-c85ed2b6f970");}

    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Dim pdfv As PDFViewer";
mostCurrent._pdfv = new ice.pdfviewer.pdfviewerwrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim i,pc As Int=0";
_i = 0;
_pc = (int) (0);
 //BA.debugLineNum = 23;BA.debugLine="Dim iv";
mostCurrent._iv = "";
 //BA.debugLineNum = 24;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private btnZoomIn As Button";
mostCurrent._btnzoomin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private btnZoomOut As Button";
mostCurrent._btnzoomout = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Dim zoom = 1.0 As Double";
_zoom = 1.0;
 //BA.debugLineNum = 28;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
}
