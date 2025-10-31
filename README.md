# 🎯 Club Service

Microservicio encargado de la gestión de clubes deportivos, desarrollado con Spring Boot y PostgreSQL. Se ejecuta en un contenedor Docker y se conecta a una base de datos en otro contenedor.

---

## 🚀 Tecnologías

- Java 21
- Spring Boot 3
- PostgreSQL
- Docker & Docker Compose

---

## ⚙️ Requisitos

- Docker v20+
- Docker Compose v2.29+
- Java (opcional, para desarrollo local)

---

## 📦 Variables de entorno

Crea un archivo `.env.local` en la raíz del proyecto con el siguiente contenido:

```
DATABASE_HOST=postgres
DATABASE_PORT=5432
DATABASE_NAME=tu_base_de_datos
DATABASE_USER=tu_usuario
DATABASE_PASSWORD=tu_contraseña
```

> Asegúrate de que `postgres` coincida con el nombre del contenedor de la base de datos.

---

## 🔧 Construcción del contenedor

```
docker-compose build
```

---

## ▶️ Ejecución

```
docker-compose up
```

La aplicación estará disponible en: [http://localhost:8080](http://localhost:8080)

---

## 📘 Documentación API (Swagger)

Una vez levantado el servicio, accede a la documentación interactiva de la API en:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- o [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

> La URL exacta puede variar según la configuración y la versión de SpringDoc/OpenAPI.

---

## 📈 Escalar instancias

Puedes escalar el servicio para mejorar el rendimiento:

```
docker-compose up --scale club-service=3
```

> Requiere un balanceador de carga como NGINX o Traefik si se usa en producción.

---

## ✍️ Autor

**Winston Barrera**  
_Software Engineer & Tech Enthusiast_

---

## 📝 Licencia

Este proyecto está bajo licencia MIT.
