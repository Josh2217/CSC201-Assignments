@echo off

cd ..
mkdir .\out\A05
set STDOUT=.\out\A05\stdout.md
set SRC=.\src\assignment05

echo # Standard Solution # > %STDOUT%
echo: >> %STDOUT%
echo ```>> %STDOUT%
cd %SRC%
javac *.java
java Test >> temp.md
cd ..\..
type %SRC%\temp.md >> %STDOUT%
echo: >> %STDOUT%
echo ```>> %STDOUT%
cd %SRC%
del temp.md
del *.class