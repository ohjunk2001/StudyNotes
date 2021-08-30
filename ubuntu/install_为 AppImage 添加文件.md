# 为 Appimage 添加启动图标

启动文件一般都在 `/usr/share/applications` 中

打开文件夹 `/usr/share/applications`

```shell
cd /usr/share/applications
```

创建 `xxx.desktop` 文件，这个文件会添加启动图标

```shell
sudo vim xxx.desktop
```
加上 `sudo` 获得 root 权限

```shell
[Desktop Entry]
Name=SoftwareName
Exec=Appimage 文件的绝对路径
Icon=相对应的图标文件的绝对路径
Type=Application
StartupNotify=true
```

