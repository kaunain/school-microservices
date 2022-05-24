# school-microservices
Demo micro service for school management

## Eureka Discovery Service

|Key  |Value|
|-----|-----|
|port | 8761|
|name |eureka| 

## First microservice student

|Key  |Value|
|-----|-----|
|port | 8081|
|name |student| 

## Second microservice Teacher

|Key  |Value|
|-----|-----|
|port | 8082|
|name |teacher| 

## Calling A Microservice 

We can call or communicate microservice in different ways

### Using RestTemplate

Steps as given below

1. Add below code in App Main Class
  
    ``` Java
    import org.springframework.web.client.RestTemplate;

 	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
    ```
2. Add below code

``` Java
    @Autowired
    private RestTemplate restTemplate;

    String uri = "http://localhost:8082/teacher/1";
    
    ResponseEntity<Teacher> teacher = restTemplate.getForEntity(uri, Teacher.class);
    System.out.println(teacher.getBody());
```

## How to refresh client microservice from spring boot config server

- add actuator dependency
- allow endpoint include *
- add annotation refresh scope
- call actuator/refresh