API REST – Gestión de Tareas (Spring Boot)

 Descripción

Este proyecto implementa una API REST para la gestión de tareas utilizando **Spring Boot**, siguiendo una **arquitectura en capas** que separa responsabilidades en presentación, aplicación, dominio e infraestructura.

El sistema permite crear, consultar, actualizar y eliminar tareas, manteniendo coherencia con principios de diseño de software como **SRP (Single Responsibility Principle)** y separación de preocupaciones.

---

2. Arquitectura en capas

La aplicación está organizada en cuatro capas principales:

### 2.1 Presentación (Controller)

Responsable de manejar las solicitudes HTTP y devolver respuestas.

**Ubicación:**

```
com.example.tareas.controller
```

**Clases:**

* `TareaController`
* `GlobalExceptionHandler`

---

### 2.2 Aplicación (Service)

Contiene la lógica de negocio del sistema.

**Ubicación:**

```
com.example.tareas.service
```

**Clase:**

* `TareaService`

---

### 2.3 Dominio (Domain)

Define las entidades, reglas del negocio y excepciones.

**Ubicación:**

```
com.example.tareas.domain
com.example.tareas.domain.model
```

**Clases:**

* `Tarea`
* `EstadoTarea`
* `TareaNotFoundException`

---

### 2.4 Infraestructura (Repository)

Gestiona el acceso a datos mediante JPA.

**Ubicación:**

```
com.example.tareas.repository
```

**Clase:**

* `TareaRepository`

---

## 3. Estructura del proyecto

```
tareas/
│
├── src/main/java/com/example/tareas/
│   ├── TareasApplication.java
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── domain/
│       └── model/
│
└── resources/
    └── application.properties
```

---

 Tecnologías utilizadas

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* H2 Database
* Maven

---

 Ejecución del proyecto

<img width="701" height="887" alt="image" src="https://github.com/user-attachments/assets/08944ca5-185d-40f1-a09c-5fc2b1a28e58" />


<img width="1597" height="1002" alt="image" src="https://github.com/user-attachments/assets/8684639f-6c79-4a3d-980b-e084ecc44fe1" />


<img width="1208" height="946" alt="image" src="https://github.com/user-attachments/assets/eb8ab05e-66c6-4462-be22-24339e39454c" />



 Manejo de errores

* 400 → Validación (datos incorrectos)
* 404 → Tarea no encontrada

Ejemplo:

```json
{
  "error": "Tarea con id 1 no encontrada"
}
```

---
 Validaciones

La entidad `Tarea` implementa validación:

* `titulo` obligatorio (`@NotBlank`)

---

Base de datos

Se utiliza **H2 en memoria**, por lo que los datos se reinician al reiniciar la aplicación.

Acceso:

```
http://localhost:8080/h2-console
```

---

Conclusión

El sistema implementa correctamente una arquitectura en capas, separando responsabilidades y permitiendo escalabilidad, mantenibilidad y extensibilidad, cumpliendo con buenas prácticas de ingeniería de software en aplicaciones backend modernas.


