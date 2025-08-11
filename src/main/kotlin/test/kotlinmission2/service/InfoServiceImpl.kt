package test.kotlinmission2.service

import org.springframework.stereotype.Service
import test.kotlinmission2.dto.Info
import test.kotlinmission2.factory.ProviderFactory
import java.lang.RuntimeException

@Service
class InfoServiceImpl(private val providerFactory: ProviderFactory): InfoService{
    override fun getInfo(): Info {
        var last : RuntimeException? = null
        for (provider in providerFactory.getProviders()) {
            try {
                return provider.getInfo()
            } catch (e: RuntimeException) { last=e;
                continue
            }
        }
        throw last ?: IllegalStateException("No provider succeeded")
    }
}