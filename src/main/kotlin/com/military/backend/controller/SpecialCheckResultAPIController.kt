package com.military.backend.controller

import com.military.backend.domain.SpecialCheckResultModel
import com.military.backend.service.SpecialCheckResultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SpecialCheckResultAPIController {

    @Autowired
    var specialCheckResultService: SpecialCheckResultService? = null

    @GetMapping("api/spec-checks/")
    fun getSpecialCheckResults():
            Set<SpecialCheckResultModel> {
        return specialCheckResultService!!.getAll()
    }
    
    @GetMapping("api/spec-check/{id}")
    fun getSpecialCheckResult(@PathVariable id: Int): SpecialCheckResultModel {
        return specialCheckResultService!!.get(id)
    }

    @PostMapping("api/spec-check/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createSpecialCheckResult(@RequestBody specCheck: SpecialCheckResultModel):
            SpecialCheckResultModel {
        return specialCheckResultService!!.add(specCheck)
    }

    @PostMapping("api/spec-check/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateSpecialCheckResult(@RequestBody specCheck: SpecialCheckResultModel):
            SpecialCheckResultModel {
        return specialCheckResultService!!.edit(specCheck)
    }

    @PostMapping("api/spec-check/{id}/delete")
    fun deleteSpecialCheckResultById(@RequestParam specCheckId: Int)
    {
        specialCheckResultService!!.deleteById(specCheckId)
    }
}
