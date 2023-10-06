$source = 'I:\metlifews\autoitwsbackup\backup'
$dest = 'I:\metlifews\autoitwsbackup\backup12'


FileMove($source & "\*.*", $dest, 1) ;Move all source files first
$hSearch = FileFindFirstFile($Source & "\*.*") ;Now find any remaining (in this case: folders)
if $hSearch = -1 then exit ;No folders
While 1
    $hFilename = FileFindNextFile($hSearch)
    if @ERROR then exitloop ;No more files
    DirMove($source & "\" & $hFilename, $Dest,1);move subdir and all contents to new location
WEnd