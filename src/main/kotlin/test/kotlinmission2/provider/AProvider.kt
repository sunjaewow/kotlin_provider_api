package test.kotlinmission2.provider

import org.springframework.stereotype.Component
import test.kotlinmission2.dto.Info
import java.lang.RuntimeException
import java.util.concurrent.atomic.AtomicInteger

@Component
class AProvider : Provider {

    private val counter= AtomicInteger(0)

    override fun getInfo(): Info {

        val n =counter.incrementAndGet()

        if (n % 3 == 0) {
            throw RuntimeException()
        }
        Thread.sleep(3000)
        return Info("AProvider")
    }
}