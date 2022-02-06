@echo off
cd ..
mkdir .\out\A02
set STDOUT=.\out\A02\stdout.txt
set GOLFOUT=.\out\A02\golfout.txt
set SRC=.\src\assignment02

echo standard > %STDOUT%
echo: >> %STDOUT%
echo you're going to have to input 3 integers here
java %SRC%\Assignment2.java >> %STDOUT%
echo golf > %GOLFOUT%
echo: >> %GOLFOUT%
echo and you'll have to do it again here
java %SRC%\A.java >> %GOLFOUT%
