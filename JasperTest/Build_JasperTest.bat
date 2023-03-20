@echo off
set PATH = "C:\MSYS2\mingw64\bin"
set MSYS2_INCLUDE = "C:\MSYS2\mingw64\include"
set MSYS2_LIB = "C:\MSYS2\mingw64\lib"
gjasper JasperTest.j -I%MSYS2_INCLUDE% -L%MSYS2_LIB% -O1 -o JasperTest.jpp
jasper JasperTest --Debug:11592