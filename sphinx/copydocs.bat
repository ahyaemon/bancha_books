@echo off

set DOCDIR=..\docs
set HTMLDIR=_build\html

rem delete doc directory
rem /s: recurfsive
rem /q: no confirmation
rmdir /s/q  %DOCDIR%

rem copy html to doc directory without unnesessary files
rem /e: recursive
rem /y: no confirmation
xcopy /e/y/exclude:exclude.list %HTMLDIR%\* %DOCDIR%\

rem create .nojekyll to ignore github jekyll encoding
type nul > %DOCDIR%\.nojekyll