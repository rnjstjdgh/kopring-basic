package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.User
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class UserLoanHistory(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @ManyToOne
    val user: User?,
    val bookName: String?,
    private var isReturn: Boolean
) {

    fun doReturn() {
        this.isReturn = true
    }
}