@echo off

set DOCDIR=..\docs
set HTMLDIR=_build\html

rem delete doc directory
rem /s: recurfsive
rem /q: no confirmation
rmdir /s/q  %DOCDIR%

rem copy html to doc directory
rem /e: recursive
rem /y: no confirmation
xcopy /e/y %HTMLDIR%\* %DOCDIR%\