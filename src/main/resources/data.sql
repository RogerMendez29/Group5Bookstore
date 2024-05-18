INSERT INTO Book_StoreDB.book (title, author, isbn) VALUES
('To Kill a Mockingbird', 'Harper Lee', '9780060935467'),
('1984', 'George Orwell', '9780451524935'),
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565'),
('The Catcher in the Rye', 'J.D. Salinger', '9780316769488'),
('The Hobbit', 'J.R.R. Tolkien', '9780345339683'),
('Fahrenheit 451', 'Ray Bradbury', '9781451673319'),
('Pride and Prejudice', 'Jane Austen', '9781503290563'),
('The Chronicles of Narnia', 'C.S. Lewis', '9780064471190'),
('Animal Farm', 'George Orwell', '9780451526342'),
('Moby-Dick', 'Herman Melville', '9781503280786');

INSERT INTO Book_StoreDB.user (Username, Password) VALUES
('john_doe', 'password1'),
('jane_doe', 'password2'),
('alex_smith', 'password3'),
('emily_jones', 'password4'),
('michael_johnson', 'password5'),
('sarah_williams', 'password6'),
('david_brown', 'password7'),
('lisa_miller', 'password8'),
('kevin_davis', 'password9'),
('amanda_taylor', 'password10');

INSERT INTO Book_StoreDB.cart_item (Book_ID, Quantity, Price, User_ID) VALUES
(1, 2, 20.0, 1),  -- User 'john_doe' adds 2 books with ID 1 to cart
(2, 1, 15.0, 2);  -- User 'jane_doe' adds 1 book with ID 2 to cart