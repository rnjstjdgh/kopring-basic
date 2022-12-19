package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book(
    // @Column(nullable = false)
    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    init {
        if(name.isBlank()) {

        }
    }

    fun test() {
        val s1 = ""
        s1.isEmpty() // true
        val s2 = "  "
        s2.isEmpty() // false
    }
}