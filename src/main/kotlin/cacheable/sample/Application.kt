package cacheable.sample

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("cacheable.sample")
                .mainClass(Application.javaClass)
                .start()
    }
}