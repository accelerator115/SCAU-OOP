@echo off
REM 压缩 src 文件夹为 src.zip
tar -a -c -f src.zip src
REM 删除 src 文件夹下的所有子文件夹及其内容
for /d %%d in (src\*) do rmdir /s /q "%%d"