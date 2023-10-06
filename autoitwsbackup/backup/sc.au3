#include <ScreenCapture.au3>
#include <GUIConstants.au3>
#include <WindowsConstants.au3>
#include <SendMessage.au3>

If ProcessExists ("communicator.exe") Then Call ("LyncPop01")

Global $Title01, $RTitle01, $RTitle02, $size, $JpegFileName01

Func LyncPop01()

If ProcessExists ("communicator.exe") Then
WinWait ("Instant Message from")
$Title01 = WinGetTitle ("[CLASS:MsCommunicatorToastPopup]", "")
$size = WinGetPos("[CLASS:MsCommunicatorToastPopup]")
WinSetTrans("[CLASS:MsCommunicatorToastPopup]", "", 255)

#comments-start
 $size[0] = X position
 $size[1] = Y position
 $size[2] = Width
 $size[3] = Height
#comments-end

$JpegFileName01 = @YEAR & @MON & @MDAY & @HOUR & @MIN & @SEC & @MSEC

Sleep (1000)

_ScreenCapture_Capture(@MyDocumentsDir & "\" & $JpegFileName01 & ".jpg", $size[0], $size[1], $size[0]+$size[2], $size[1]+$size[3])

    Local $n, $msg

    GUICreate("My GUI picture", $size[2], $size[3], $size[0], $size[1], $WS_SIZEBOX + $WS_SYSMENU)

    GUISetBkColor(0xE0FFFF)
    $n = GUICtrlCreatePic(@MyDocumentsDir & "\" & $JpegFileName01 & ".jpg", $size[0], $size[1], $size[2],$size[3])

    GUISetState()

    ; Run the GUI until the dialog is closed
    While 1
        $msg = GUIGetMsg()

        If $msg = $GUI_EVENT_CLOSE Then ExitLoop
    WEnd

WinWaitClose ("Instant Message from")
$RTitle01 = StringReplace($Title01, "Instant Message from ", "")
$RTitle02 = StringReplace($RTitle01, ".  Press Windows key plus A to accept.", "")
MsgBox(0, "IM From: ", $RTitle02)
Call ("LyncPop01")
EndIf
EndFunc


MsgBox(0, "Lync Is Not Running - Exiting", "Lync Is Not Running - Exiting")

Exit