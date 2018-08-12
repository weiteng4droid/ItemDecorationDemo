### 扩展属性说明

1. `apkDir`: 编译后生成apk的目录
2. `username`: 加固宝的用户名
3. `password`: 加固宝密码
4. `signPath`: 签名文件的路径
5. `storePassword`：秘钥密码
6. `keyAlias`: 别名
7. `keyPassword`： 别名密码
8. `outApkPath`：加固后文件的路径，配置绝对路径，不然命令行加固失败。

### 加固脚本中相关配置

1. `jiagu.sh` 用于linux/unix系统脚本

    - 变量`jiagu_dir`：表示360加固宝的位置，需要替换成自己的

2. `jiagu.bat` 用于windows系统批处理文件

    如果是windows系统，16、17行中的位置表示360加固宝的路径。16号表示盘符，17表示具体的磁盘下的路径

### 打包加固命令

    在项目根目录下，打开终端输入（linux/unix）：

    ./gradlew clean aR

    aR 表示 assembleRelease 打包命令的简写，gradle task 支持这种驼峰的简写，将会打所有的变体包。

    windows系统则运行：

    gradle clean aR

    # 单独渠道包的构建
    # 例如构建xiaomi的渠道包
    ./gradlew assembleXiaomiRelease