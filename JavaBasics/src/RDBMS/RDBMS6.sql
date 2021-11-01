Select name, address, Count(bookId)
From tbl_borrower, tbl_book_loans
Where tbl_borrower.cardNo=tbl_book_loans.cardNo
group by name
Having count(bookId)>5