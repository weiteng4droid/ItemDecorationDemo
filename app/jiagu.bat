::功能：使用批处理文件加固apk
if "%JAVA_HOME%" == "" (
	echo "The system not have java environment!"
	exit
)

echo %1
echo %2

c:
cd %1

for /R %1 %%b in (*.apk) do (
	echo "The apk file name is %%b"

	:: 我本地的加固工具包的路径 F:\360jiagubao\jiagu
	F:
	cd 360jiagubao\jiagu

	java -jar jiagu.jar -login %3 %4
	java -jar jiagu.jar -importsign %5 %6 %7 %8
	java -jar jiagu.jar -config -crashlog -x86
	java -jar jiagu.jar -jiagu %%b %2 -autosign -automulpkg