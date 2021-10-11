https://blog.csdn.net/huiruwei1020/article/details/107551106

https://docs.microsoft.com/zh-cn/windows/wsl/

```
Start-Process powershell -Verb runAs # 提升自己的权限
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart # 第一次装只是 wsl1
重启
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart # 第二次升级
重启
wsl --set-default-version 2 # 设置为 wsl2
重启
```

## 问题 

0x800701bc WSL2

内核没有升级到 wsl2 

下载 

https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi

## 子系统的目录

C:\Users\yangh\AppData\Local\Packages\CanonicalGroupLimited.Ubuntu20.04onWindows_79rhkp1fndgsc\LocalState

LocalState 目录下有一个磁盘