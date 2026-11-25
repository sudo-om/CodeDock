# Repository Guidelines

## Project Structure

- `CodeDock/` is the Java 21 Spring Boot backend. Application code lives under `CodeDock/src/main/java/in/thexor/CodeDock/`, configuration under `src/main/resources/`, and tests under `src/test/java/` within the module.
- `client/` is the Next.js and TypeScript frontend. Place routes and layouts in `app/`, reusable UI primitives in `components/ui/`, hooks in `hooks/`, shared utilities in `lib/`, and static assets in `public/`. Follow `client/AGENTS.md` when working in the frontend.

## Build and Run Locally

From `CodeDock/`, use JDK 21 and the Maven wrapper:

- `./mvnw test` runs the backend tests.
- `./mvnw package` runs tests and builds the application JAR in `target/`.
- `./mvnw spring-boot:run` starts the backend locally.

From `client/`, run `npm ci` to install the locked dependencies. Use `npm run dev` for the development server, `npm run lint` for ESLint, and `npm run build` to verify the production build. Run `npm start` after building to serve it locally.

## Coding Style

Match the surrounding code. Use tabs in Java, PascalCase for classes, and camelCase for methods and variables. Keep backend additions under the existing `in.thexor.CodeDock` package. Use two-space indentation in TypeScript, PascalCase component names, and kebab-case filenames such as `code-block.tsx` and `use-mobile.ts`.

## Testing

Use JUnit Jupiter for backend tests. Mirror the production package structure and name test classes `*Tests`, following `CodeDockApplicationTests`. Use `./mvnw -Dtest=CodeDockApplicationTests test` to run the Spring context smoke test by itself. The project defines no coverage threshold or frontend test script. For frontend changes, run lint and build checks and exercise the affected flows in a browser.

## Commits and Pull Requests

The available Git history is in `client/` and contains only the Create Next App initial commit. Use short imperative subjects for new commits, such as `Add chat message validation`. In pull requests, summarize the change, list the checks you ran, link relevant issues, and include screenshots for visible UI changes.
