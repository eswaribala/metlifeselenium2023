Local $sTitle = "Password Safe"
Local $sClass = "[CLASS:ToolbarWindow32; INSTANCE:2]"
WinWaitActive($sTitle)

Local $hWnd = WinGetHandle($sTitle, "")
Local $hToolBar = ControlGetHandle($hWnd, "", $sClass)
ConsoleWrite($hWnd & @TAB & $hToolBar & @LF)
ControlCommand($hWnd, "", $hToolBar, "SendCommandID", 32003)
; "SendCommandID", Command ID
; Simulates the WM_COMMAND message. Usually used for ToolbarWindow32 controls - use the ToolBar tab of Au3Info to get the Command ID.