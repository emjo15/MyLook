# MyLook

MyLook is an AI-powered digital wardrobe application. Users will be able to catalog clothing items, save inspiration looks, and later receive outfit recommendations generated from their own wardrobe.

## Current architecture

MyLook is currently a **modular monolith** with two top-level applications:

- `/backend` – Spring Boot REST API (Java, Maven, JPA, PostgreSQL)
- `/frontend` – Angular application (TypeScript, HttpClient)

The backend is organized by domain/module under `com.mylook`:

- `wardrobe` (implemented in this phase)
  - `controller` – REST endpoints (`/api/clothes`)
  - `service` – business logic and orchestration
  - `repository` – persistence interfaces
  - `model` – JPA entities and enums
  - `dto` – request/response API models
- `inspiration` (structure prepared)
- `recommendation` (structure prepared)
- `user` (structure prepared)
- `config` (cross-cutting configuration)

This keeps the AI recommendation domain isolated so it can later be extracted into a dedicated Python microservice.

## Technologies used

- Angular + TypeScript
- Java 17 + Spring Boot
- Spring Web, Spring Data JPA, Bean Validation
- PostgreSQL
- Docker + Docker Compose
- Git

## Run the frontend

```bash
cd frontend
npm install
npm start
```

Frontend runs on `http://localhost:4200`.

## Run the backend

```bash
cd backend
mvn spring-boot:run
```

Backend runs on `http://localhost:8080`.

Environment variables (optional overrides):

- `SPRING_DATASOURCE_URL` (default: `jdbc:postgresql://localhost:5432/mylook`)
- `SPRING_DATASOURCE_USERNAME` (default: `mylook`)
- `SPRING_DATASOURCE_PASSWORD` (default: `mylook`)
- `APP_CORS_ALLOWED_ORIGINS` (default: `http://localhost:4200`)

## Start PostgreSQL with Docker Compose

```bash
docker compose up -d postgres
```

Optional environment variable overrides for DB container:

- `POSTGRES_DB` (default: `mylook`)
- `POSTGRES_USER` (default: `mylook`)
- `POSTGRES_PASSWORD` (default: `mylook`)

## Planned future AI architecture

The AI recommendation capabilities are intentionally deferred. Planned evolution:

1. Keep CRUD and wardrobe/inspiration features inside the modular monolith
2. Add image analysis, embeddings, vector search, and RAG pipelines
3. Extract recommendation logic into a dedicated Python microservice when boundaries are stable
4. Introduce orchestration workflows with LangChain/LangGraph later

## Roadmap

- Phase 1 – Wardrobe CRUD
- Phase 2 – Inspiration looks
- Phase 3 – Image storage
- Phase 4 – AI image analysis
- Phase 5 – Embeddings and vector search
- Phase 6 – AI outfit recommendations / RAG
- Phase 7 – LangChain and LangGraph workflows
- Phase 8 – Azure deployment and CI/CD
- Phase 9 – Message queues / microservices where appropriate
- Phase 10 – Kubernetes and MLOps
