Select title, noOfCopies
From tbl_library_branch, tbl_book_copies, tbl_book
inner join tbl_author On tbl_book.authId=tbl_author.authorId
Where authorName='Stephen King' and
branchName = 'Central' and
tbl_book_copies.bookId=tbl_book.bookId