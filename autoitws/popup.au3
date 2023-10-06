While 1
If WinExists("") Then
;If ProcessExists("") Then <- Better Solution
   WinClose("") ; Closes the Window based solely on the Window Title
   ;ProcessClose("") ; Closes the Window based on the Windows Process.exe name
   WinWaitClose("") ; Wait until the window is closed
   ;ProcessWaitClose("") ; Wait until the window is closed via Process Close
   MsgBox(0, "", "Window X has been closed", 10)
ElseIf WinExists("") = "0" Then
;ElseIf ProcessExists("") = "0" Then
   MsgBox(0, "", "Hey Jack, That window doesn't exist!", 10)
EndIf
WEnd