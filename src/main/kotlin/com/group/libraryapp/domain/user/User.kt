package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import java.lang.IllegalArgumentException
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    name: String,
    age: Integer?,
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf<UserLoanHistory>()
) {
    var name = name
        private set //https://stackoverflow.com/questions/33428957/kotlin-public-get-private-set-var
    var age = age
        private set

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun loanBook(book: Book) {
        this.userLoanHistories.add(
            UserLoanHistory(
                user = this,
                bookName = book.name,
                isReturn = false
            )
        )
    }

    fun returnBook(bookName: String) {
        this.userLoanHistories.first {
                history -> history.bookName == bookName
        }.doReturn();
    }
}