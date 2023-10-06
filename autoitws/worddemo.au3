#include <MsgBoxConstants.au3>
#include <Word.au3>

; Create application object
Local $oWord = _Word_Create()
If @error Then Exit MsgBox($MB_SYSTEMMODAL, "Word UDF: _Word_DocOpen Example", _
                "Error creating a new Word application object." & @CRLF & "@error = " & @error & ", @extended = " & @extended)

; Open a document read-only
Local $sDocument = @ScriptDir & ".\Akka.docx"
_Word_DocOpen($oWord, $sDocument, Default, Default, True)
If @error Then Exit MsgBox($MB_SYSTEMMODAL, "Word UDF: _Word_DocOpen Example 1", "Error opening 'Akka.docx'." & _
                @CRLF & "@error = " & @error & ", @extended = " & @extended)
MsgBox($MB_SYSTEMMODAL, "Word UDF: _Word_DocOpen Example 1", "Document '" & $sDocument & "' has been opened successfully.")