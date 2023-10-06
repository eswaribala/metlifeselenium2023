#include <GuiConstants.au3>
#include <GuiConstantsEx.au3>
#include <FileConstants.au3>
#include <EditConstants.au3>

GuiCreate('Test App', 700, 600, @DesktopWidth / 2 - 192, _
            @DesktopHeight / 2 - 235, -1, $WS_EX_ACCEPTFILES)

GUICtrlCreateGroup("Dict Files", 5, 5, 570, 90)
GUICtrlCreateLabel('Select file:', 20, 30)
$dropmpfile = GUICtrlCreateInput ("", 120, 30, 200, 20, -1, $WS_EX_STATICEDGE)
GUICtrlSetState (-1, $GUI_DROPACCEPTED)
GUICtrlSetTip (-1, 'You can drag & drop files here...')


GUICtrlCreateLabel('Select file:', 20, 60)
$droporgfile = GUICtrlCreateInput ("", 120, 60, 200, 20, -1, $WS_EX_STATICEDGE)
GUICtrlSetState (-1, $GUI_DROPACCEPTED)
GUICtrlSetTip (-1, 'You can drag & drop files here...')

;GUI MESSAGE LOOP

GuiSetState()
While 1
  $msg = GuiGetMsg()
    Select
    Case $msg = $GUI_EVENT_CLOSE
        Exit
  EndSelect
WEnd