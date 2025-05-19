# 📘 Spring Boot REST API - Todo Application

Today, I learned the fundamentals of building RESTful APIs using **Spring Boot**. I built a simple Todo application with in-memory data and explored how to handle basic HTTP methods like GET and POST.

---

## 🚀 What I Learned

### ✅ REST Controller
- `@RestController`: A convenience annotation that combines @Controller and @ResponseBody. It tells Spring that this class will handle REST API requests and return JSON responses.

```java
@RestController
```

### 📍 Request Mapping
* `@RequestMapping`: Used at the class level to define a base URL for all methods inside the controller.

```java
@RequestMapping("/api/v1/todos")
```

### 📥 Handling GET Requests
* `@GetMapping`: Used to handle HTTP GET requests.
    * I created two endpoints:
        * `/api/v1/todos`: Returns all todos.
        * `/api/v1/todos/get/{todoId}`: Returns a todo by its ID.

```java
@GetMapping
public List<Todo> getTodos() { ... }

@GetMapping("/get/{todoId}")
public ResponseEntity<?> getTodoById(@PathVariable int todoId) { ... }
```

### 📤 Handling POST Requests
* `@PostMapping`: Used to handle HTTP POST requests.
    * Accepts a new `Todo` object in the request body and adds it to the list.

```java
@PostMapping("/post")
public ResponseEntity<String> setTodos(@RequestBody Todo todo) { ... }
```

### 📦 Working with Request and Response
* `@RequestBody`: Maps the request JSON body to a Java object.
* `ResponseEntity`: Allows custom HTTP status codes and response bodies.

### ⚠️ Error Handling
* I created a custom `ErrorResponse` class to send meaningful error messages when a requested todo is not found.

### ✅ Dependency Injection (DI)

- Used `@Service` to let Spring Boot manage and initialize service layer beans.
- Used `@Qualifier` to specify which implementation to inject when multiple beans of the same type exist.
- Explored other core annotations like `@Autowired` and `@Repository`.
- Practiced **Dependency Inversion** (from SOLID principles) by coding to interfaces instead of concrete classes and injecting dependencies via constructors.
