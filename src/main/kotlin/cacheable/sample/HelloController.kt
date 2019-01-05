package cacheable.sample

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single

@Controller("/hello")
class HelloController(private val helloService: HelloService) {

    @Get("/")
    fun index(): Single<HttpResponse<String>> {
        return cached(0)
    }

    @Get("/{num}")
    fun cached(num: Int): Single<HttpResponse<String>> {
        return Single.fromPublisher(helloService.calculateValue(num))
                .map { HttpResponse.ok(it) }
    }
}
