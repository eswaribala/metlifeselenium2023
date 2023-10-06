#include <IE.au3>
$oIE = _IECreate ("www.autoitscript.com")
_IENavigate($oIE, 'http://www.htmlite.com/JS002.php',0)
                While 1
                If WinExists("Message from webpage") Then
                    WinClose("Message from webpage", "")
                    ExitLoop
                EndIf
                WEnd