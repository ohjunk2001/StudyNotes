## Docker makes development efficient and predictable

### Docker takes away repetitive, mundane configuration tasks and is used throughout the development lifecycle for fast, easy and portable application development - desktop and cloud. Docker’s comprehensive end to end platform includes UIs, CLIs, APIs and security that are engineered to work together across the entire application delivery lifecycle.





Today I would like to introduce docker to you

Docker is an open source application container engine that allows developers to package their applications and dependencies into a portable image that can then be distributed to any popular Linux or Windows machine, as well as virtualization. Containers are completely sandboxed and have no interface with each other.

Docker is a container engine that encapsulates and abstracts Linux cgroup, Namespace and other underlying container technologies, providing users with a convenient interface (command line and API) for creating and managing containers.

A build that can run anywhere; Good cross platform and consistency

Containers provide isolated running Spaces for applications: each container contains a single, complete user environment space, and changes in one container do not affect the running environments of the other containers. Container technology uses Namespaces for space isolation, file system mount points to determine which files containers can access, and cgroups to determine how many resources each container can utilize. In addition, containers share the same system kernel, which increases memory efficiency when the same library is used by multiple containers.

For system virtualization technology, the virtual layer provides users with a complete virtual machine: a complete system image including the kernel. The CPU virtualization technology provides each user with an independent system environment isolated from other users. The virtual layer allocates virtualized CPU, memory, and I/O device resources to each user

今天我给大家介绍的是 docker 

Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的镜像中，然后发布到任何流行的 Linux或Windows操作系统的机器上，也可以实现虚拟化。容器是完全使用沙箱机制，相互之间不会有任何接口。

Docker是容器引擎，把linux的cgroup、namespace等容器底层技术进行封装抽象，为用户提供了创建和管理容器的便捷界面（命令行和API）

一次构建，可以运行在任何地方；很好的释全了跨平台和强一致性

　容器为应用程序提供了隔离的运行空间：每个容器内都包含一个独享的完整用户环境空间，并且一个容器内的变动不会影响其他容器的运行环境。容器技术使用了namespaces来进行空间隔离，通过文件系统的挂载点来决定容器可以访问哪些文件，通过cgroups来确定每个容器可以利用多少资源。此外容器之间共享同一个系统内核，这样当同一个库被多个容器使用时，内存的使用效率会得到提升。

　　对于系统虚拟化技术来说，虚拟层为用户提供了一个完整的虚拟机：包括内核在内的一个完整的系统镜像。CPU虚拟化技术可以为每个用户提供一个独享且和其他用户隔离的系统环境，虚拟层可以为每个用户分配虚拟化后的CPU、内存和IO设备资源