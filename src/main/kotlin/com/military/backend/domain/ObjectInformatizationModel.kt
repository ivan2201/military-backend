package com.military.backend.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.military.backend.serializer.CustomObjectInformatizationSerializer
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectInformatization")
    val innerDocuments: Set<InnerDocumentModel>? = null,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objectInformatization")
    val components: Set<ComponentModel>? = null
)
{
    override fun hashCode(): Int {
        return militaryBase?.baseNumber.hashCode() + name.hashCode()
    }
    override fun equals(other: Any?): Boolean {
        if (other is ObjectInformatizationModel) {
            if (( id == null || id == -1 || other.id == null || other.id == -1 || other.id == id)
                && other.name == name && other.militaryBase == militaryBase)
                return true
        }
        return false
    }
}
