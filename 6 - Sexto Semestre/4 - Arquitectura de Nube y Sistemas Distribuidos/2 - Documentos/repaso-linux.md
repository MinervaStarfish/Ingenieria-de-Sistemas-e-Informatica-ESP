# REPASO LINUX

1. **Conceptos Básicos de Linux**
2. **Sistema de Archivos en Linux**
3. **Permisos y Gestión de Usuarios**
4. **Comandos Esenciales**
5. **Gestión de Paquetes**
6. **Redes en Linux**
7. **Servicios y Daemons**
8. **Scripting en Bash**
9. **Virtualización y Contenedores**
10. **Herramientas y Configuraciones para Sistemas Distribuidos**

### 1. Conceptos Básicos de Linux

#### Kernel
El kernel es el núcleo de Linux, que maneja las interacciones entre el hardware y el software del sistema. Es responsable de la gestión de recursos, como CPU, memoria, y dispositivos de entrada/salida.

#### Distribuciones
Linux viene en muchas distribuciones (distros), como Ubuntu, CentOS, Fedora, y Debian. Cada distro tiene su propio conjunto de herramientas y configuraciones, pero todas se basan en el mismo núcleo Linux.

#### Shell
El shell es la interfaz de línea de comandos de Linux, donde los usuarios pueden ejecutar comandos y scripts. Bash (Bourne Again SHell) es el shell más común.

### 2. Sistema de Archivos en Linux

#### Jerarquía de Directorios
Linux sigue una jerarquía de directorios estandarizada conocida como Filesystem Hierarchy Standard (FHS):

- `/`: Root, el directorio raíz.
- `/bin`: Comandos esenciales del sistema.
- `/etc`: Archivos de configuración.
- `/home`: Directorios de usuarios.
- `/var`: Archivos de variables, logs, etc.
- `/tmp`: Archivos temporales.
- `/dev`: Dispositivos del sistema.
- `/proc` y `/sys`: Información del sistema y configuraciones del kernel.

#### Tipos de Archivos
- **Archivos regulares** (`-`): Texto, binarios, etc.
- **Directorios** (`d`): Contienen otros archivos.
- **Enlaces simbólicos** (`l`): Punteros a otros archivos.
- **Dispositivos de bloque** (`b`) y **carácter** (`c`): Representan dispositivos como discos duros o puertos serie.

### 3. Permisos y Gestión de Usuarios

#### Permisos de Archivos
Linux tiene un sistema de permisos basado en tres categorías:

- **Usuario (u)**
- **Grupo (g)**
- **Otros (o)**

Y tres tipos de permisos:

- **Lectura (r)**: `4`
- **Escritura (w)**: `2`
- **Ejecución (x)**: `1`

Los permisos se configuran con el comando `chmod` y se pueden visualizar con `ls -l`.

#### Gestión de Usuarios y Grupos
- **`adduser`**: Añadir un nuevo usuario.
- **`usermod`**: Modificar un usuario.
- **`passwd`**: Cambiar la contraseña de un usuario.
- **`groupadd`**: Crear un nuevo grupo.
- **`usermod -aG [grupo] [usuario]`**: Añadir un usuario a un grupo.

### 4. Comandos Esenciales

- **`ls`**: Listar archivos y directorios.
- **`cd`**: Cambiar de directorio.
- **`cp`**: Copiar archivos.
- **`mv`**: Mover o renombrar archivos.
- **`rm`**: Eliminar archivos o directorios.
- **`touch`**: Crear un archivo vacío.
- **`cat`**, **`more`**, **`less`**: Mostrar contenido de archivos.
- **`grep`**: Buscar texto dentro de archivos.
- **`find`**: Buscar archivos y directorios.
- **`df`**: Mostrar espacio en disco.
- **`du`**: Mostrar uso de espacio por archivos/directorios.
- **`ps`**: Ver procesos en ejecución.
- **`top`**: Monitorizar procesos en tiempo real.
- **`kill`**: Terminar procesos.
- **`tar`**, **`gzip`**: Comprimir y descomprimir archivos.

### 5. Gestión de Paquetes

#### Distribuciones Basadas en Debian/Ubuntu:
- **`apt-get`**: Para instalar, actualizar y eliminar paquetes.
  - `sudo apt-get update`: Actualizar la lista de paquetes.
  - `sudo apt-get upgrade`: Actualizar todos los paquetes instalados.
  - `sudo apt-get install [paquete]`: Instalar un paquete.
  - `sudo apt-get remove [paquete]`: Eliminar un paquete.

#### Distribuciones Basadas en Red Hat (RHEL, CentOS, Fedora):
- **`yum`** o **`dnf`**: Para la gestión de paquetes.
  - `sudo yum update`: Actualizar la lista de paquetes.
  - `sudo yum install [paquete]`: Instalar un paquete.
  - `sudo yum remove [paquete]`: Eliminar un paquete.

### 6. Redes en Linux

#### Configuración de Redes
- **`ifconfig`**: Configuración de interfaces de red (se está reemplazando por `ip`).
- **`ip`**: Herramienta más nueva para gestionar interfaces de red.
  - `ip addr`: Mostrar direcciones IP asignadas.
  - `ip link set [interface] up/down`: Habilitar o deshabilitar interfaces.

#### Diagnóstico de Redes
- **`ping`**: Comprobar la conectividad de red.
- **`traceroute`**: Rastrear la ruta hacia un destino.
- **`netstat`** o **`ss`**: Mostrar conexiones de red y puertos abiertos.
- **`iptables`** o **`firewalld`**: Configurar reglas de firewall.

#### SSH (Secure Shell)
- **`ssh`**: Conectarse a sistemas remotos de forma segura.
- **`scp`**: Copiar archivos de manera segura entre sistemas.
- **`sftp`**: Transferir archivos de manera segura.

### 7. Servicios y Daemons

- **`systemd`**: Sistema de gestión de servicios en muchas distribuciones modernas.
  - `systemctl start [servicio]`: Iniciar un servicio.
  - `systemctl stop [servicio]`: Detener un servicio.
  - `systemctl status [servicio]`: Verificar el estado de un servicio.
  - `systemctl enable/disable [servicio]`: Habilitar o deshabilitar un servicio en el arranque.

### 8. Scripting en Bash

#### Variables y Control de Flujo
- **Variables**: Se declaran sin tipo (`variable="valor"`).
- **Condicionales**: `if [ condición ]; then ... fi`
- **Bucles**: `for`, `while`, `until`.

#### Ejemplo Básico
```bash
#!/bin/bash
echo "Introduce un número:"
read num

if [ $num -gt 10 ]; then
    echo "El número es mayor que 10"
else
    echo "El número es 10 o menor"
fi
```

#### Ejecución de Scripts
- Crear un archivo `.sh`.
- Dar permisos de ejecución: `chmod +x script.sh`.
- Ejecutar: `./script.sh`.

### 9. Virtualización y Contenedores

#### Virtualización con KVM/QEMU
- **KVM**: Kernel-based Virtual Machine, para virtualización a nivel de hardware.
- **QEMU**: Emulador y virtualizador, se usa junto con KVM.

#### Contenedores con Docker
- **Docker**: Herramienta para crear, desplegar y gestionar contenedores.
  - `docker run`: Correr un contenedor.
  - `docker ps`: Listar contenedores en ejecución.
  - `docker images`: Listar imágenes disponibles.

### 10. Herramientas y Configuraciones para Sistemas Distribuidos

#### Herramientas de Orquestación
- **Kubernetes**: Plataforma de orquestación de contenedores.
- **Ansible**: Herramienta para automatización de configuración y gestión de sistemas.

#### Sistemas de Archivos Distribuidos
- **NFS**: Network File System, para compartir archivos entre sistemas a través de la red.
- **GlusterFS**: Sistema de archivos distribuido escalable.

#### Configuración de Alta Disponibilidad
- **HAProxy**: Balanceador de carga y proxy.
- **Keepalived**: Proporciona alta disponibilidad y balanceo de carga.

---
