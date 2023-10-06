#include <IE.au3>
$window = _IECreate("www.google.com", 0, 1, 1, 0)
WinWaitActive("Google")
Send("{F11}")