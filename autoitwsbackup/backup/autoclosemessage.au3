#include <MsgBoxConstants.au3>
#include <Timers.au3>

Local $iDuration = 10

Local $iTimerProgress = _Timer_SetTimer(0, 1000, "_CountDown") ; create timer
Local $sMsgboxTitle = "My MsgBox"
Local $sMsgboxText = "The text of the MsgBox"

MsgBox($MB_YESNO, $sMsgboxTitle, $sMsgboxText)

Func _CountDown($hWnd, $iMsg, $iIDTimer, $iTime)
    Local Static $iCountDown = 10
    Local Static $hMsgBox = WinGetHandle($sMsgboxTitle, $sMsgboxText)
    $iCountDown -= 1
    ControlSetText($hMsgBox, "", "[CLASS:Button; INSTANCE:2]", "Close in " & $iCountDown & " s")
    If $iCountDown = 0 Then ControlClick($hMsgBox, "", "[CLASS:Button; INSTANCE:1]")
EndFunc