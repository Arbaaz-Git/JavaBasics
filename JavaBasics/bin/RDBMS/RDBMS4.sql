Select tbl_borrower.name, address, title, branchName
From tbl_borrower, tbl_book_loans, tbl_book, tbl_library_branch
Where dueDate = current_timestamp() and
branchName='Sharpstown' and
tbl_book.bookId=tbl_book_loans.bookId and
tbl_book_loans.cardNo=tbl_borrower.cardNo

