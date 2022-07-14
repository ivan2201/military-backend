package com.military.backend.domain

import javax.persistence.*

@Entity
@Table(name = "object_informatization")
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
    val components: Set<ComponentModel>? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ObjectInformatizationModel

        if (id != other.id) return false
        if (cert != other.cert) return false
        if (specialInvestigation != other.specialInvestigation) return false
        if (specialCheckResult != other.specialCheckResult) return false
        if (militaryBase != other.militaryBase) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (cert?.hashCode() ?: 0)
        result = 31 * result + (specialInvestigation?.hashCode() ?: 0)
        result = 31 * result + (specialCheckResult?.hashCode() ?: 0)
        result = 31 * result + (militaryBase?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ObjectInformatizationModel(id=$id, cert=$cert, specialInvestigation=$specialInvestigation, specialCheckResult=$specialCheckResult, militaryBase=$militaryBase, name=$name)"
    }
}
