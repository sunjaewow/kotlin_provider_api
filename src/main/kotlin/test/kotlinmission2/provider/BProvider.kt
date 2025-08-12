package test.kotlinmission2.provider

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import test.kotlinmission2.dto.Info

@Component
@Order(1)
class BProvider : Provider {
    override fun getInfo(): Info {
        Thread.sleep(2000)
        return Info("BProvider")
    }
}