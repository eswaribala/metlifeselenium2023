#include <IE.au3>
While ProcessExists("iexplore.exe")
    ProcessClose("iexplore.exe")
WEnd
Global $sFileSavePath = "C:\Download"  ;~ Folder Path to Save Excel Documents
Global $oIE = _IECreate("https://jsonplaceholder.typicode.com/users")
Sleep(10000)     ;~ Wait while page loads
$oDivs = $oIE.Document.getElementByID('financials')
For $oDiv In $oDivs
    If $oDiv.className = "large_button" Then
        _IEAction($oDiv, "click")
        ExitLoop
    EndIf
Next