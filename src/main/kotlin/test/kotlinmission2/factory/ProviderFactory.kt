package test.kotlinmission2.factory

import org.springframework.stereotype.Component
import test.kotlinmission2.provider.AProvider
import test.kotlinmission2.provider.BProvider
import test.kotlinmission2.provider.Provider
import java.lang.IllegalStateException
import kotlin.reflect.KClass

@Component
class ProviderFactory(providers : List<Provider>) {

    private val providerMap: Map<KClass<out Provider>, Int> =mapOf(
        AProvider::class to 1,
        BProvider::class to 2
    )

    private val sortedProviderMap : List<Provider> = providers.sortedBy { provider ->
        providerMap[provider::class] ?: throw IllegalStateException("noop")
    }

    fun getProviders() : List<Provider> = sortedProviderMap
}