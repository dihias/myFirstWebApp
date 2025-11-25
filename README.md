# Spring Boot Todo List

## Project Overview

This is a simple **Todo List application** built with **Spring Boot**, demonstrating core features such as:

* **CRUD operations** on todos (Create, Read, Update, Delete)
* **Form handling** and **data validation**
* **Database integration** with H2 (development) and MySQL (production)
* **Spring Security** for user authentication
* **Frontend** using JSP, Bootstrap, and jQuery

The goal of this project is to provide a structured and practical example for learning **Spring Boot, JPA, MVC, and Security**, with clean separation of layers: Controller → Service → Repository → Database.

---

## Project Structure

```
src/main/java/com/example/todo/
│
├── TodoApplication.java         # @SpringBootApplication
├── controller/
│   └── TodoController.java      # Handles web requests
├── service/
│   └── TodoService.java         # Business logic
├── repository/
│   └── TodoRepository.java      # JPA repository
├── model/
│   └── Todo.java                # JPA entity
└── security/
    └── SecurityConfig.java      # Spring Security config
```

```
src/main/resources/
├── application.properties       # Database config (H2 / MySQL)
└── templates/ or jsp/           # JSP views
```

---

## 1. Dependencies

```xml
<dependencies>
    <dependency>spring-boot-starter-web</dependency>
    <dependency>spring-boot-starter-data-jpa</dependency>
    <dependency>spring-boot-starter-security</dependency>
    <dependency>com.h2database:h2</dependency>
    <dependency>mysql:mysql-connector-java</dependency>
    <dependency>spring-boot-starter-validation</dependency>
</dependencies>
```

---

## 2. Database Configuration

**H2 (development)**

```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
```

**MySQL (production)**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todos
spring.datasource.username=root
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update
```

---

## 3. Data Flow: Database → Service → Controller → JSP

1. **Entity**

```java
@Entity
public class Todo {
    @Id @GeneratedValue
    private Long id;

    @NotNull @Size(min=5)
    private String description;

    private LocalDate targetDate;
    private boolean done;
    private String username;

    // getters & setters
}
```

2. **Repository**

```java
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
```

3. **Service Layer**

```java
@Service
public class TodoService {
    @Autowired private TodoRepository todoRepository;

    public List<Todo> findByUser(String username) {
        return todoRepository.findByUsername(username);
    }

    public Todo save(Todo todo) { return todoRepository.save(todo); }
    public void deleteById(Long id) { todoRepository.deleteById(id); }
    public Todo findById(Long id) { return todoRepository.findById(id).orElse(null); }
}
```

4. **Controller**

```java
@Controller
public class TodoController {

    @Autowired private TodoService todoService;

    @GetMapping("/list-todos")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findByUser("user"));
        return "list-todos";
    }

    @PostMapping("/add-todo")
    public String addTodo(@Valid @ModelAttribute Todo todo, BindingResult result) {
        if(result.hasErrors()) return "todo-form";
        todoService.save(todo);
        return "redirect:/list-todos";
    }

    @GetMapping("/edit-todo")
    public String editTodo(@RequestParam int id, Model model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todo-form";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:/list-todos";
    }
}
```

5. **JSP**

```jsp
<c:forEach var="todo" items="${todos}">
    ${todo.description} - ${todo.targetDate}
</c:forEach>

<form action="/add-todo" method="post">
    <input type="text" name="description"/>
    <input type="date" name="targetDate"/>
    <button type="submit">Add</button>
</form>
```

---

## 4. Key Annotations

| Annotation                     | Usage                |
| ------------------------------ | -------------------- |
| `@SpringBootApplication`       | Main app class       |
| `@Controller`                  | Handles web requests |
| `@Service`                     | Business logic layer |
| `@Repository`                  | JPA repository layer |
| `@Entity`                      | JPA entity class     |
| `@Id`                          | Primary key          |
| `@GeneratedValue`              | Auto-generated ID    |
| `@Column`                      | DB column mapping    |
| `@Autowired`                   | Dependency injection |
| `@GetMapping` / `@PostMapping` | Map URLs to methods  |
| `@RequestParam`                | Bind query parameter |
| `@PathVariable`                | Bind URL segment     |
| `@ModelAttribute`              | Bind form data       |
| `@SessionAttributes`           | Store session data   |
| `@Valid`                       | Enable validation    |
| `@NotNull`, `@Size`            | Bean validation      |

---

## 5. Validation & Error Handling

```java
@PostMapping("/add-todo")
public String addTodo(@Valid @ModelAttribute Todo todo, BindingResult result) {
    if(result.hasErrors()) return "todo-form";
    todoService.save(todo);
    return "redirect:/list-todos";
}
```

JSP display:

```jsp
<form:errors path="description" cssClass="text-danger"/>
```

---

## 6. Spring Security

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login").permitAll()
            .and().logout().permitAll();
    }
}
```

---

## 7. Frontend / UI

* **Bootstrap** → Layout, buttons, table styling
* **jQuery** → Interaction, datepicker
* **Datepicker example**

```html
<input type="text" class="datepicker" name="targetDate"/>
<script>
  $('.datepicker').datepicker({ format: 'yyyy-mm-dd' });
</script>
```

---

## 8. Common Commands / Tips

* Run app: `mvn spring-boot:run`
* Build jar: `mvn clean package`
* Redirect after POST: `"redirect:/list-todos"`
* Use **Controller → Service → Repository → DB** pattern
* Always use `@ModelAttribute` + `BindingResult` for form binding
* Validation in backend is mandatory even if frontend checks exist
* Keep JSP simple, move logic to controller/service

---
