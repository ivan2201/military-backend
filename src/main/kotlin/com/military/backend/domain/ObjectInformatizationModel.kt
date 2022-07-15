package com.military.backend.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.military.backend.serializer.CustomObjectInformatizationSerializer
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "object_informatization")
@JsonSerialize(using = CustomObjectInformatizationSerializer::class)
data class ObjectInformatizationModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "cert_id", nullable = true)
    val cert: CertificateModel? = null,

    @ManyToOne
    @JoinColumn(name = "si_id", nullable = true)
    val specialInvestigation: SpecialInvestigationModel? = null,

    @ManyToOne
    @JoinColumn(name = "scr_id", nullable = true)
    val specialCheckResult: SpecialCheckResultModel? = null,

    @ManyToOne
    @JoinColumn(name = "military_base_id", nullable = true)
    val militaryBase: MilitaryBaseModel? = null,

    @Column(name = "name")
    val name: String? = null,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "oi_id")
    val innerDocuments: Set<InnerDocumentModel>? = null,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "oi_id")
    val components: Set<ComponentModel>? = null,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created")
    val created: LocalDateTime? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ObjectInformatizationModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , created = $created )"
    }
}
