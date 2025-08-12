package test.kotlinmission2.service

import org.springframework.stereotype.Service
import test.kotlinmission2.dto.Info
import test.kotlinmission2.provider.Provider
import java.lang.RuntimeException

@Service
class InfoServiceImpl(private val providers: List<Provider>): InfoService{
    override fun getInfo(): Info {
        var last : RuntimeException? = null
        for (provider in providers) {
            try {
                return provider.getInfo()
            } catch (e: RuntimeException) { last=e;
                continue
            }
        }
        throw last ?: IllegalStateException("No provider succeeded")
    }
}