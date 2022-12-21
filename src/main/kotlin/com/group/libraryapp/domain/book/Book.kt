package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book(
    // @Column(nullable = false)
    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,
) {

    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }
    }
}