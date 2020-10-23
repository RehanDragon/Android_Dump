Type=Activity
Version=4
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
     	Dim pdfv As PDFViewer
Dim i,pc As Int=0
Dim iv
	Private Panel1 As Panel
	Private btnZoomIn As Button
	Private btnZoomOut As Button
	Dim zoom = 1.0 As Double
	Private Label1 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	
	
	    Else If BJavaBooks.pdfnum = 2 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/C++ Without Fear.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	
		'ComFund
	   Else If BJavaBooks.pdfnum = 3 Then
    	If File.Exists(File.DirRootExternal,"ComputerOrg and Design.pdf")=False Then
    		File.Copy(File.DirAssets,"ComputerOrg and Design.pdf",File.DirRootExternal,"ComputerOrg and Design.pdf")
		End If
	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/ComputerOrg and Design.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	  Else If BJavaBooks.pdfnum = 4 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Structured Computer Organization.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
		  Else If BJavaBooks.pdfnum = 5 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Computer Organization.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	
	
	
	
			  Else If BJavaBooks.pdfnum = 6 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Intro to database.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	
	
			  Else If BJavaBooks.pdfnum = 7 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Oracle Database for Microsoft.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	
				  Else If BJavaBooks.pdfnum = 8 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Computer Fundamentals.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
					  Else If BJavaBooks.pdfnum = 9 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/LearningManagementSystem.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	
					  Else If BJavaBooks.pdfnum = 10 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/UnderstandingComputer.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
		
					  Else If BJavaBooks.pdfnum = 11 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/BIG JAVA.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
		
					  Else If BJavaBooks.pdfnum = 12 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/JAVA How to Program.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
			  Else If BJavaBooks.pdfnum = 13 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Movie Making,Animation and Multimedia.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
				  Else If BJavaBooks.pdfnum = 14 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Networking Security Essentials.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
				  Else If BJavaBooks.pdfnum = 15 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Upgrading and Troubleshooting Networks.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
				  Else If BJavaBooks.pdfnum = 16 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Operating System Concept.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
			  Else If BJavaBooks.pdfnum = 17 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/OperatingSystem.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
			  Else If BJavaBooks.pdfnum = 18 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Introduction of Software Engineering.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
			  Else If BJavaBooks.pdfnum = 19 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Software Engineering.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
				  Else If BJavaBooks.pdfnum = 20 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Principles of Web Design.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
				  Else If BJavaBooks.pdfnum = 21 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Software Engineering - Web.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
				  Else If BJavaBooks.pdfnum = 22 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/Web 2.0 Fundamentals with Ajax.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
				  Else If BJavaBooks.pdfnum = 23 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/System and Design.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
				  Else If BJavaBooks.pdfnum =24 Then

	pdfv.init
	Panel1.AddView(pdfv,0,0,-1,-1)
	pdfv.getpdf(File.DirRootExternal&"/System Analysis and Design.pdf")
	
	If pdfv.isValid Then
		Log("pagecount:" & pdfv.GetPageCount)
		Label1.Text = pdfv.GetPageCount & " Pages"
		pdfv.scrollToPage(0)
		pc=pdfv.GetPageCount
		Log("pc:"&pc)
		pdfv.zoom(zoom)
	Else
		Msgbox("Error pdf file!","Error")
		'Activity.Finish
		Return
	End If
	
	
	
	End If
   
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub



Sub btnZoomIn_Click
	zoom=zoom + 0.5
	pdfv.zoom(zoom)
End Sub
Sub btnZoomOut_Click
	zoom=zoom - 0.5
	pdfv.zoom(zoom)
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
  If KeyCode = KeyCodes.KEYCODE_BACK Then 
  Activity.finish
  StartActivity("Category")
  End If
  End Sub