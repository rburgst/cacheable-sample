package cacheable.sample

import io.micronaut.cache.annotation.Cacheable
import io.micronaut.core.async.annotation.SingleResult
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import javax.inject.Singleton


@Singleton
open class HelloService {
    val logger = LoggerFactory.getLogger(this.javaClass)

    @Cacheable("num-cache")
    @SingleResult
    open fun calculateValue(num: Int): Publisher<String> {
        logger.info("Calculating value for {}", num)
        return Flowable.just("Hello $num")
    }

}
