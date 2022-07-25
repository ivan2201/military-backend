package com.military.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.domain.dto.NewComponentDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "component")
data class ComponentModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "oi_id", nullable = true)
    val objectInformatization: ObjectInformatizationModel? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "series_number")
    val seriesNumber: String? = null,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created")
    val created: LocalDateTime? = null

) {
    constructor(componentDTO: NewComponentDTO, informatizationModel: ObjectInformatizationModel?): this(
        name = componentDTO.name, seriesNumber = componentDTO.series,
        objectInformatization = informatizationModel)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ComponentModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , seriesNumber = $seriesNumber , created = $created )"
    }
}
