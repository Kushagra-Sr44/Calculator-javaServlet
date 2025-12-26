# Calculator (Java Servlet)

A small Java Servlet calculator demo that uses multiple servlets and RequestDispatcher to forward requests between them.

## Overview
This project demonstrates a simple web calculator implemented with multiple servlets. A front / dispatcher servlet reads the request (for example the `op` parameter) and uses `RequestDispatcher` to forward the request to the appropriate operation servlet (add, subtract, multiply, divide). All processing is done server-side and the result is returned as an HTML response.

## Key points
- Uses multiple servlets (one per operation or logical responsibility).
- Uses `RequestDispatcher.forward()` (and optionally `include()`) to dispatch requests between servlets.
- Parameters are passed through the request (e.g., `a`, `b`, `op`).
- Simple HTML response shows the result or an error message (e.g., division by zero, invalid input).

## Example endpoints (typical)
- Dispatcher: `/calculate` — accepts `a`, `b`, `op` and forwards to an operation servlet.
- Add servlet: `/add`
- Subtract servlet: `/sub`
- Multiply servlet: `/mul`
- Divide servlet: `/div`

Example request:
```
GET /calculate?op=mul&a=4&b=5
```
Expected response body (example):
```
Result: 20
```

## How it works (summary)
1. Client sends request to dispatcher servlet (e.g., `/calculate`).
2. Dispatcher checks `op` parameter (e.g., `add`, `sub`, `mul`, `div`).
3. Dispatcher obtains a `RequestDispatcher` for the target servlet path and calls `forward(request, response)`.
4. Target servlet reads parameters (`a`, `b`), performs calculation, and writes the HTML response.

## Requirements
- Java 8+
- Servlet API (provided by the servlet container)
- Servlet container (e.g., Apache Tomcat)
- (Optional) Maven/Gradle if the project is built with a build tool

## Build & Deploy (basic)
If using Maven:
```
mvn clean package
```
Deploy the generated WAR to Tomcat's `webapps/` folder and start Tomcat. Visit:
```
http://localhost:8080/<context-path>/calculate?op=add&a=2&b=3
```

## Notes & tips
- Use `RequestDispatcher.forward()` when the response should be produced by the target servlet and the client URL should not change.
- Use `RequestDispatcher.include()` to include output from another servlet inside a response.
- Validate inputs (numeric parsing, division by zero) in the operation servlets and show friendly errors.
- Consider centralizing common parsing/validation in the dispatcher or a utility class.
