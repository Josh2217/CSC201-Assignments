::these bat files aren't necessary if you know how to use the command line
@echo off

cd ..
mkdir .\out\A04
set STDOUT=.\out\A04\stdout.md
set GOLFOUT=.\out\A04\golfout.md
set SRC=.\src\assignment04

echo standard solution > %STDOUT%
echo: >> %STDOUT%
echo ``` >> %STDOUT%
echo: >> %STDOUT%
echo you'll need to input an integer here
java %SRC%\Assignment4.java >> %STDOUT%
echo: >> %STDOUT%
echo ``` >> %STDOUT%