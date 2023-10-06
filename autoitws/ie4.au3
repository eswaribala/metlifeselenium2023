#include <IE.au3>

;open survey ie link
Local $oIE = _IECreate("https://beta.bls.gov/dataViewer/view/timeseries/CES8000000001") ;change url to your specific url
$oAccess = _IEGetObjById($oIE, "excelclickCE")
_IEAction($oAccess, "click")
sleep(1000)

;focus download dialog - dont need to change any of this
$hIE = WinGetHandle("[Class:IEFrame]")
$hCtrl = ControlGetHandle($hIE,"","[Class:DirectUIHWND]")
$aPos = ControlGetPos($hIE,"",$hCtrl)
$x = $aPos[2]-160
$y = $aPos[3]-30

;Use - dont need to change any of this
WinActivate($hIE) ;doesn't work in the background
ControlClick($hIE,"",$hCtrl,"primary",1,$x,$y) ;this only gives focus to the save button
ControlSend($hIE,"",$hCtrl,"{down}") ;this does work once the save button is focussed
ControlSend($hie, "", "[Class:DirectUIHWND]","a")

;save as - Dont need to change any of this except for filepath.
WinActivate("Save As", "Save");
WinWaitActive("Save As", "Save", 10);
ControlSetText("Save As", "", "Edit1", "test34324.xlsx");
ControlClick("Save As", "", "&Save", "left", 1, 5, 5);
sleep(500)
ControlClick("Confirm Save As","","Button1", "left", 1, 0, 0);

;quit ie
_IEQuit($oIE)