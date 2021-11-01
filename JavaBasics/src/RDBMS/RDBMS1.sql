Select noOfCopies
From tbl_book_copies, tbl_book, tbl_library_branch
where tbl_book_copies.bookId=tbl_book.bookId and
tbl_library_branch.branchId=tbl_book_copies.bookId and
title='The Lost Tribe ' and
branchName = 'Sharpstown'
