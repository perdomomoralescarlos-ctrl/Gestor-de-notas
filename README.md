# Gestor de Notas – Java Swing

## Descripción

Este proyecto es una aplicación de escritorio desarrollada en **Java utilizando Swing**.
Permite gestionar notas personales mediante una interfaz gráfica y soporta **registro e inicio de sesión de usuarios**.

Cada usuario puede crear, editar y eliminar sus propias notas, las cuales se guardan en archivos para mantener la información incluso después de cerrar el programa (Como el anterior Ejercicio pero en **interfaz grafica**).


---

# Funcionalidades

## Gestión de notas

La aplicación permite:

* Crear una nueva nota.
* Visualizar una nota seleccionada.
* Editar una nota existente.
* Eliminar una nota.
* Limpiar los campos de edición sin borrar la nota.
* Mostrar las notas en una lista para poder seleccionarlas fácilmente.

---

## Sistema de usuarios

La aplicación incluye un sistema básico de usuarios:

* Registro de nuevos usuarios.
* Inicio de sesión.
* Control de credenciales incorrectas.
* Cada usuario tiene sus propias notas.

---

## Seguridad

Las contraseñas **no se guardan en texto plano**.

Se utiliza un **hash SHA-256** para almacenar las contraseñas de forma segura.

---

## Persistencia de datos

Los datos se guardan utilizando **serialización de objetos en archivos**.

Esto permite:

* Mantener los usuarios registrados.
* Guardar las notas de cada usuario.
* Recuperar los datos al reiniciar la aplicación.

Archivo utilizado:

```
usuarios.dat
```

---

# Tecnologías utilizadas

* Java
* Swing (interfaces gráficas)
* Serialización de objetos
* SHA-256 para hash de contraseñas

---

# Estructura del proyecto

```
GestorNotas
│
├── Main.java
│
├── model
│   ├── Nota.java
│   └── Usuario.java
│
├── persistence
│   └── GestorArchivos.java
│
├── security
│   └── HashUtil.java
│
├── ui
│   ├── LoginFrame.java
│   ├── RegistroFrame.java
│   └── NotasFrame.java
```

Descripción de carpetas:

* **model** → clases que representan los datos (Usuario y Nota).
* **persistence** → gestión de guardado y carga de archivos.
* **security** → utilidades de seguridad como el hash de contraseñas.
* **ui** → interfaces gráficas del programa.

---

# Cómo ejecutar el programa

1. Abrir el proyecto en **IntelliJ, Eclipse, NetBeans, etc..**.
2. Ejecutar la clase:

```
Main.java
```

3. Desde la pantalla inicial se puede:

   * Registrar un nuevo usuario.
   * Iniciar sesión.
   
Ante de hacer cualquier nota devera de logearse.
---

