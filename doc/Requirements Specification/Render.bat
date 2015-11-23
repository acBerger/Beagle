:: LyX executable. Add some logic here to search differen paths if your installation is elsewhere. 
set LYX="C:\Program Files (x86)\LyX 2.1\bin\lyx.exe"
if not exist %LYX% set LYX="G:\Programme\LyX 2.1\bin\lyx.exe"
set UMLET="C:\Program Files (x86)\Umlet\Umlet.exe"
if not exist %UMLET% set UMLET="C:\Program Files\Umlet\Umlet.exe"
if not exist %UMLET% set UMLET="C:\weitere Programme\Umlet\Umlet.exe"
set FILENAME="Requirements Specification"

:: Get a temporary folder name that we can savely delete later
call :GETTEMPNAME
:: Create the folder and copy all contents in it
mkdir %TMPDIR%
xcopy . %TMPDIR% /e /i

set drive=%cd:~0,2%
set OLDPWD=%cd%
C:
cd %TMPDIR%

::generate .pdf from .uxf
For /R %f in (*.uxf) do %UMLET% -action=convert -format=pdf -filename="%f"

:: generate .tex
%LYX% --export pdflatex %FILENAME%.lyx


:: generate all the other stuff
pdflatex %FILENAME%.tex
:: make the glossary
makeglossaries %FILENAME%
bibtex %FILENAME%
:: render the pdf (we need at least two times. And you know… just to be sure ;))
pdflatex %FILENAME%.tex
pdflatex %FILENAME%.tex
pdflatex %FILENAME%.tex
pdflatex %FILENAME%.tex

:: Go back
%drive%
cd %OLDPWD%


:: Save the PDF
copy %TMPDIR%\%FILENAME%.pdf . /y


:: Delete the temporary folder, as we don't need the tons of files in it
rmdir %TMPDIR% /s /q
goto :EOF

:GETTEMPNAME
set TMPDIR=%TMP%\%RANDOM%
if exist "%TMPDIR%" GOTO :GETTEMPNAME 

:EOF
