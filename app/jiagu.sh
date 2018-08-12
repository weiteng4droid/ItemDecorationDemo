#!/usr/bin/env bash

# 加固工具包的核心目录
jiagu_dir="/Users/weiTeng/javaEE/jiagubao/jiagu"

a=0
files=()

# 遍历文件夹查找apk文件
function read_dir() {
	for file in `ls $1`
	do
		if [ -d $1"/"${file}  ]
		then
			read_dir $1"/"${file}
		else
			if [ ${file: -4} == ".apk" ]
			then
				files["$a"]=$1"/"${file}
				a=`expr ${a} + 1`
			fi
		fi
	done
}

read_dir $1

# 遍历apk文件并进行加固
for apk in "${files[@]}"
do
	echo "apk file = ${apk}"
	cd ${jiagu_dir}
	java -jar jiagu.jar -login $3 $4
	java -jar jiagu.jar -importsign $5 $6 $7 $8
	java -jar jiagu.jar -config -crashlog -x86
	java -jar jiagu.jar -jiagu ${apk} $2 -autosign -automulpkg
done