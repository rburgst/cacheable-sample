## Sample for micronaut caching issue

Sample source to demonstrate that `@Cacheable` on a method that returns a `Publisher` does not work.

### Steps to reproduce

1. run the app

    ```bash
    ./gradlew run
    ``` 
    
2. send an http request multiple times

    ```bash
    http :8080/hello
    ```
    
### Expected 

the method `HelloService.calculateValue(0)` should only be called once, which should produce the following
output:


```
20:18:07.133 [nioEventLoopGroup-1-3] INFO  c.s.$HelloServiceDefinition$Intercepted - Calculating value for 0
```

### Actual

the method is called multiple times producing the output

```
20:17:53.374 [nioEventLoopGroup-1-2] INFO  c.s.$HelloServiceDefinition$Intercepted - Calculating value for 0
20:18:07.133 [nioEventLoopGroup-1-3] INFO  c.s.$HelloServiceDefinition$Intercepted - Calculating value for 0
20:18:17.442 [nioEventLoopGroup-1-3] DEBUG i.m.c.interceptor.CacheInterceptor - Value found in cache [num-cache] for invocation: Publisher calculateValue(int num)
20:18:20.828 [nioEventLoopGroup-1-4] INFO  c.s.$HelloServiceDefinition$Intercepted - Calculating value for 0
20:18:23.043 [nioEventLoopGroup-1-4] DEBUG i.m.c.interceptor.CacheInterceptor - Value found in cache [num-cache] for invocation: Publisher calculateValue(int num)
```
