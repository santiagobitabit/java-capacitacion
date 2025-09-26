# Proyecto Banco

Este proyecto es una aplicación web desarrollada en **Java** usando **Spring Boot** y **Maven**. Permite la gestión de clientes y empleados de un banco.

## Características

- Gestión de clientes y empleados
- Persistencia con base de datos PostgreSQL
- Arquitectura basada en puertos y adaptadores
- API RESTful

## Estructura del proyecto

- `src/main/java/com/bitabit/banco/domain/`: Entidades del dominio (`Cliente`, `Empleado`)
- `src/main/java/com/bitabit/banco/infra/in/`: Adaptadores y puertos de entrada
- `src/main/resources/`: Configuración y recursos
- `schema.sql`: Script de base de datos

## Requisitos

- Java 17+
- Maven 3.8+
- PostgreSQL

## Instalación

1. Clona el repositorio
2. Configura la base de datos en `src/main/resources/application.properties`
3. Ejecuta el proyecto.

## Documentación

http://localhost:8080/swagger-ui/index.html

<hr>Santiago Morelli</hr>