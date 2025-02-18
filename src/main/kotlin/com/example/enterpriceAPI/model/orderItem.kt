package com.example.enterpriceAPI.model

import jakarta.persistence.*

@Entity
@Table(name = "orderItems")
class orderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null
    var quantity: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order:Order? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product:Product? = null

}
