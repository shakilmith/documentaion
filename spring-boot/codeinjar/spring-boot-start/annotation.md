## Most Common Annotations used in Spring Boot

Spring Boot relies heavily on annotations to simplify the configuration and development process. Let's explore the most common well known and required annotations (unless you use xml to build your applications) those are used frequently to build a spring boot applications.

1. **@SpringBootApplication**: This annotation combines three commonly used annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. It marks the entry point of the Spring Boot application, indicating that this class should be considered a configuration class, enables auto-configuration based on the classpath settings, and scans for Spring components within the package and its sub-packages.

2. **@Controller**: This annotation marks a class as a Spring MVC controller. It's typically used to define the endpoints for handling HTTP requests.

3. **@RestController**: Similar to @Controller, but it indicates that the returned value of methods should be directly written to the HTTP response body instead of being interpreted as a view name.

4. **@Service**: This annotation marks a class as a service bean in the Spring application context. It's typically used to denote business logic or service layers.

5. **@Repository**: This annotation marks a class as a data access object or repository. It's used for database operations and is often applied to classes that interact with databases or other data sources.

6. **@Autowired**: This annotation is used for automatic dependency injection. When Spring encounters this annotation, it automatically injects the appropriate bean into the annotated field, constructor, or method parameter.

7. **@Component**: This annotation marks a Java class as a Spring component. Spring automatically detects and registers classes annotated with @Component during component scanning.

8. **@Configuration**: This annotation indicates that a class contains bean definitions that should be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

9. **@RequestMapping**: This annotation maps HTTP requests to specific handler methods in Spring MVC controllers. It's used to define the URL pattern or patterns for which a controller method should be invoked.

10. **@PathVariable**: This annotation is used to extract values from the URI template and map them to method parameters in Spring MVC controller methods.

These are just a few examples of annotations used in Spring Boot. There are many more annotations available, each serving a specific purpose in configuring and developing Spring Boot applications.

11. **@ComponentScan**: This annotation is used to specify the base packages to scan for Spring components such as @Component, @Service, @Repository, etc. It's often used at the application's entry point alongside @SpringBootApplication.

12. **@ConfigurationProperties**: This annotation binds external configuration properties to a class or a specific field. It's commonly used to inject properties from application.properties or application.yml files into Spring beans.

13. **@Value**: This annotation is used to inject values from properties files or environment variables into Spring beans. It's more flexible than @ConfigurationProperties but less type-safe.

14. **@EnableAutoConfiguration**: This annotation enables Spring Boot's auto-configuration mechanism, which automatically configures Spring beans based on the classpath and the presence of specific libraries in the project.

15. **@EnableConfigurationProperties**: This annotation is used to enable the configuration properties binding feature for a specific class or package. It's often used in conjunction with @ConfigurationProperties.

16. **@ConditionalOnProperty**: This annotation allows conditional bean creation based on the presence or absence of specific properties in the environment. It's useful for creating beans conditionally depending on the application's configuration.

17. **@Transactional**: This annotation is used to mark a method, class, or interface as transactional, meaning that the method's execution will be wrapped in a transaction. It's commonly used in service layer methods for managing database transactions.

18. **@Scheduled**: This annotation is used to schedule the execution of a method at fixed intervals or at a specific time using cron expressions. It's commonly used for tasks such as data synchronization, cleanup, or periodic processing.

19. **@ExceptionHandler**: This annotation is used to define methods that handle specific exceptions thrown during the execution of Spring MVC controller methods. It allows for centralized exception handling logic within the application.

20. **@ModelAttribute**: This annotation is used to bind method parameters to model attributes in Spring MVC controller methods. It's commonly used to prepopulate model attributes before rendering a view.

21. **@PathVariable**: This annotation is used to extract values from the URI template and map them to method parameters in Spring MVC controller methods. It's commonly used to capture dynamic values from the URL.

22. **@RequestBody**: This annotation binds the HTTP request body to a method parameter in Spring MVC controller methods. It's used to parse incoming JSON or XML request bodies into Java objects.

23. **@ResponseBody**: This annotation indicates that the return value of a method should be serialized directly to the HTTP response body. It's commonly used in RESTful APIs to return JSON or XML responses.

24. **@CrossOrigin**: This annotation enables Cross-Origin Resource Sharing (CORS) for specific controller methods or the entire controller. It's used to allow web clients from different origins to access resources served by the application.

25. **@EnableWebMvc**: This annotation is used to enable Spring MVC configuration in a Spring Boot application. It's typically used when you want to customize MVC configuration beyond what Spring Boot auto-configuration provides.

26. **@EnableTransactionManagement**: This annotation enables Spring's annotation-driven transaction management. It's commonly used in configuration classes to enable declarative transaction management for Spring beans.

27. **@RestControllerAdvice**: This annotation is used to define global exception handling and response body customization for Spring MVC controllers. It allows you to define methods that will be invoked for exceptions thrown by any controller in the application.

28. **@EnableCaching**: This annotation enables Spring's caching support for the application. It's used to enable caching of method results by annotating configuration classes with this annotation.

29. **@Cacheable**: This annotation is used to mark methods for caching results. When applied to a method, Spring will check the cache before executing the method and return the cached result if available.

30. **@CacheEvict**: This annotation is used to trigger cache eviction operations. When applied to a method, it instructs Spring to remove entries from the cache either before or after the method execution.

31. **@Async**: This annotation is used to mark methods as asynchronous. When applied to a method, Spring will execute it in a separate thread, allowing for non-blocking execution.

32. **@EnableScheduling**: This annotation enables Spring's scheduling support, allowing for the scheduling of methods using the @Scheduled annotation. It's commonly used in combination with @Scheduled for tasks like cron jobs or periodic tasks.

33. **@Validated**: This annotation is used to enable method-level validation in Spring MVC controllers. It's typically applied to controller classes or handler methods and works in conjunction with javax.validation annotations like @NotNull and @Size.

34. **@ResponseStatus**: This annotation is used to define the HTTP status code returned by a Spring MVC controller method. It's commonly used to customize the response status based on specific conditions or outcomes.

35. **@ModelAttribute**: This annotation is used to bind method parameters to model attributes in Spring MVC controller methods. It's commonly used to populate form backing objects or model attributes before rendering a view.

36. **@RequestParam**: This annotation is used to bind request parameters to method parameters in Spring MVC controller methods. It's commonly used to extract query parameters or form data from HTTP requests.

37. **@SessionAttribute**: This annotation is used to bind a specific session attribute to a model attribute in Spring MVC controllers. It allows for storing and accessing session attributes in the model during request handling.

38. **@InitBinder**: This annotation is used to customize request data binding in Spring MVC controllers. It allows for configuring custom property editors or validators for specific model attributes.

39. **@RequestHeader**: This annotation is used to bind HTTP request headers to method parameters in Spring MVC controller methods. It's commonly used to extract information from request headers, such as authorization tokens or content types.

40. **@PathVariableMap**: This annotation is used to bind all path variables to a Map parameter in Spring MVC controller methods. It's useful when dealing with dynamic path variables in RESTful APIs.

41. **@Qualifier**: This annotation is used to disambiguate beans when multiple beans of the same type are available. It's typically used in conjunction with @Autowired to specify which bean should be injected.

42. **@Lazy**: This annotation is used to indicate that a bean should be lazily initialized. It's commonly used for beans that are expensive to create or for resolving circular dependencies.

43. **@EntityScan**: This annotation specifies the base package for entity scanning. It's often used in conjunction with Spring Data JPA to scan for entity classes.



These annotations provide further control and customization options for developing Spring Boot applications, allowing developers to handle various scenarios and requirements effectively.

Note, I have used **chatGPT** to create list of annotations used usually in spring or spring boot. And later I have updated the details based on the official documentation. But remember, use these annotations based on your requirements and experienced otherwise, your app will become more more vulnerable and unsecure. Hence, chatGPT saves my few hours!


## Annotations those are usually used in Spring Web

Most commonly used annotations in Spring Web:

1. **@Controller**: Marks a class as a Spring MVC controller, allowing it to handle incoming HTTP requests.

2. **@RestController**: A specialized version of @Controller that combines @Controller and @ResponseBody, indicating that the returned objects should be written directly to the HTTP response body.

3. **@RequestMapping**: Maps HTTP requests to handler methods in a controller class. It specifies the URL path and HTTP method(s) that the method should respond to.

4. **@GetMapping**, **@PostMapping**, **@PutMapping**, **@DeleteMapping**: Convenience annotations that specialize @RequestMapping for specific HTTP methods.

5. **@RequestParam**: Binds request parameters to method parameters in controller methods. It's used to extract query parameters or form data from the request.

6. **@PathVariable**: Extracts values from the URI path and binds them to method parameters in controller methods.

7. **@RequestBody**: Binds the HTTP request body to a method parameter in controller methods. It's used to parse JSON or XML request bodies into Java objects.

8. **@ResponseBody**: Indicates that the return value of a method should be serialized directly to the HTTP response body. It's commonly used to return JSON or XML responses in RESTful APIs.

9. **@ModelAttribute**: Binds method parameters to model attributes in controller methods. It's used to prepopulate model attributes before rendering a view.

10. **@SessionAttribute**: Binds a session attribute to a model attribute in controller methods. It allows for storing and accessing session attributes in the model during request handling.

11. **@Valid** and **@Validated**: Mark method parameters as subject to validation, triggering validation of the object before the controller method is invoked.

12. **@ExceptionHandler**: Defines methods to handle specific exceptions thrown during the execution of controller methods. It allows for centralized exception handling logic within the application.

13. **@InitBinder**: Customizes request data binding in controller methods. It allows for configuring custom property editors or validators for specific model attributes.

14. **@CrossOrigin**: Enables Cross-Origin Resource Sharing (CORS) for specific controller methods or the entire controller. It's used to allow web clients from different origins to access resources served by the application.

Certainly! Here are some more annotations commonly used in Spring MVC:

15. **@SessionAttributes**: This annotation is used at the class level to specify which model attributes should be stored in the session between requests. It allows for keeping model attributes across multiple requests within the same session.

16. **@ModelAttribute**: Besides being used at the method level, @ModelAttribute can also be used at the parameter level in controller methods to bind model attributes directly to method parameters. It's useful for prepopulating model attributes based on request data.

17. **@RequestHeader**: Binds HTTP request headers to method parameters in controller methods. It's used to extract information from request headers, such as authorization tokens or content types.

18. **@CookieValue**: Binds HTTP cookies to method parameters in controller methods. It allows for extracting cookie values from incoming requests.

19. **@ResponseBodyAdvice**: This annotation is used to define global response body advice that applies to all controller methods returning a response body. It allows for customizing the response body before it's written to the HTTP response.

20. **@RequestMappingHandlerMapping** and **@RequestMappingHandlerAdapter**: These annotations are used to customize the behavior of request mapping and request handling in Spring MVC. They allow for advanced configuration and customization of request mapping and request handling processes.

21. **@ControllerAdvice**: This annotation is used to define global controller advice that applies to all controllers in the application. It's commonly used for centralized exception handling, model attribute preprocessing, or response body customization.

22. **@JsonView**: This annotation is used to customize JSON serialization and deserialization in Spring MVC controllers. It allows for specifying different views of the same object to be serialized or deserialized based on specific criteria.

23. **@Validated**: Similar to @Valid, @Validated is used to trigger validation of method parameters in controller methods. However, @Validated provides additional features, such as group-based validation.

24. **@ResponseStatus**: This annotation is used to define the HTTP status code returned by a controller method. It allows for customizing the response status based on specific conditions or outcomes.

25. **@ModelAttributeMethodsProcessor**: This annotation is used to customize the behavior of model attribute methods processing in Spring MVC. It allows for extending or modifying the default behavior of @ModelAttribute methods.

These annotations provide the foundation for building RESTful APIs and web applications using Spring MVC, allowing for declarative configuration and concise development.