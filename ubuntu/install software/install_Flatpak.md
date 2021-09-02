# Install Flatpak

https://flatpak.org/setup/Ubuntu/

## 1.Install Flatpak

```she
 sudo apt install flatpak
```

## 2.Install the Software Flatpak plugin

The Flatpak plugin for the Software app makes it possible to install apps without needing the command line. To install, run:


```shell
sudo apt install gnome-software-plugin-flatpak
```

> Note: the Software app is distributed as a Snap since Ubuntu 20.04 and does not support graphical installation of Flatpak apps. Installing the Flatpak plugin will also install a deb version of Software and result in two Software apps being installed at the same time.

## 3.Add the Flathub repository

Flathub is the best place to get Flatpak apps. To enable it, run:

```shell
flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo
```

## 4.Restart

To complete setup, restart your system. Now all you have to do is [install some apps](https://flathub.org/)!
