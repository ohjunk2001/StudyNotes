# 6.828 lab tools guide

Familiarity with your environment is crucial for productive development and debugging. This page gives a brief overview of the JOS environment and useful GDB and QEMU commands. Don't take our word for it, though. Read the GDB and QEMU manuals. These are powerful tools that are worth knowing how to use. 

## Debugging Tips

GDB is your friend. Use the `qemu-gdb` target (or its qemu-gdb-nox variant) to make QEMU wait for GDB to attach. See the GDB reference below for some commands that are useful when debugging kernels.

If you're getting unexpected interrupts, exceptions, or triple faults, you can ask QEMU to generate a detailed log of interrupts using the -d argument.

To debug virtual memory issues, try the QEMU monitor commands `info mem` (for a high-level overview) or `info pg` (for lots of detail). Note that these commands only display the current page table.

(Lab 4+) To debug multiple CPUs, use GDB's thread-related commands like `thread` and `info threads`.

