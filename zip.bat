@echo off
REM 压缩 src 文件夹为 src.zip
tar -a -c -f src.zip src
REM 删除 src 文件夹下所有文件
del /q src\*