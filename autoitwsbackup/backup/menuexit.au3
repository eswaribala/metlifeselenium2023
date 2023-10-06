#include <GUIConstantsEx.au3>

Opt("GUIOnEventMode", 1)

GUICreate("Test", 300, 200)
GUISetOnEvent($GUI_EVENT_CLOSE, "MenuExit")
GUISetState(@SW_SHOW)

While 1
  Sleep(10)
WEnd

Exit

Func MenuExit()

  GUIDelete()
  Exit

EndFunc