package test.kotlinmission2.provider

import test.kotlinmission2.dto.Info

interface Provider {
    fun getInfo() : Info
}