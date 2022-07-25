package com.military.backend.domain.dto

import com.military.backend.domain.ComponentModel

data class ComponentDTO(
    val id: Int,
    val name: String?,
    val series: String?
) {
    constructor(componentModel: ComponentModel) :
            this(componentModel.id!!, componentModel.name, componentModel.seriesNumber)

    companion object {
        fun fromComponentModelSet(components: Set<ComponentModel>): Set<ComponentDTO>
        {
            val result = ArrayList<ComponentDTO>(components.size)
            for (component in components)
            {
                result.add(ComponentDTO(component))
            }
            return result.toSet()
        }
    }
}
