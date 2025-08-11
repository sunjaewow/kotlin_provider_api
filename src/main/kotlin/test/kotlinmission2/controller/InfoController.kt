package test.kotlinmission2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import test.kotlinmission2.dto.Info
import test.kotlinmission2.service.InfoService

@RestController
class InfoController(private val infoService: InfoService) {

    @GetMapping("/infos")
    fun getInfo() : Info=infoService.getInfo()
}