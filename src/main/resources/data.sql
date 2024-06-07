INSERT INTO Book_StoreDB.book (title, author, isbn, price) VALUES
('To Kill a Mockingbird', 'Harper Lee', '9780060935467', 12.99),
('1984', 'George Orwell', '9780451524935', 9.99),
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 10.99),
('The Catcher in the Rye', 'J.D. Salinger', '9780316769488', 11.99),
('The Hobbit', 'J.R.R. Tolkien', '9780345339683', 14.99),
('Fahrenheit 451', 'Ray Bradbury', '9781451673319', 13.99),
('Pride and Prejudice', 'Jane Austen', '9781503290563', 8.99),
('The Chronicles of Narnia', 'C.S. Lewis', '9780064471190', 15.99),
('Animal Farm', 'George Orwell', '9780451526342', 7.99),
('Moby-Dick', 'Herman Melville', '9781503280786', 11.49);

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

INSERT INTO Book_StoreDB.cart_item (Book_ID, Quantity, Total_Price, User_ID) VALUES
(1, 2, 20.0, 1),  -- User 'john_doe' adds 2 books with ID 1 to cart
(2, 1, 30.0, 2),  -- User 'jane_doe' adds 1 book with ID 2 to cart
(3, 1, 10.99, 1), -- User 'john_doe' adds 1 book with ID 3 to cart
(4, 3, 35.97, 3), -- User 'alice_smith' adds 3 books with ID 4 to cart
(5, 2, 29.98, 4), -- User 'bob_jones' adds 2 books with ID 5 to cart
(6, 1, 13.99, 2), -- User 'jane_doe' adds 1 book with ID 6 to cart
(7, 4, 35.96, 1), -- User 'john_doe' adds 4 books with ID 7 to cart
(8, 1, 15.99, 5), -- User 'carol_white' adds 1 book with ID 8 to cart
(9, 2, 15.98, 3), -- User 'alice_smith' adds 2 books with ID 9 to cart
(10, 1, 11.49, 4); -- User 'bob_jones' adds 1 book with ID 10 to cart

INSERT INTO Book_StoreDB.author (first_Name, last_Name, bio, publisher)
VALUES
  ('Jane', 'Austen', 'Jane Austen was an English novelist known primarily for her six major novels.', 'Thomas Egerton'),
  ('Mark', 'Twain', 'Mark Twain was an American writer, humorist, entrepreneur, publisher, and lecturer.', 'American Publishing Company'),
  ('Charles', 'Dickens', 'Charles Dickens was an English writer and social critic. He created some of the world\'s best-known fictional characters.', 'Chapman & Hall'),
  ('George', 'Orwell', 'George Orwell was an English novelist, essayist, journalist and critic. He is best known for his novels 1984 and Animal Farm.', 'Secker & Warburg'),
  ('Fyodor', 'Dostoevsky', 'Fyodor Dostoevsky was a Russian novelist, short story writer, essayist and journalist. He is best known for Crime and Punishment.', 'The Russian Messenger'),
  ('Herman', 'Melville', 'Herman Melville was an American novelist, short story writer, and poet of the American Renaissance period. His best known works include Moby-Dick and Bartleby, the Scrivener.', 'Harper & Brothers'),
  ('Leo', 'Tolstoy', 'Leo Tolstoy was a Russian writer who is regarded as one of the greatest authors of all time. He is best known for War and Peace and Anna Karenina.', 'The Russian Messenger'),
  ('J.K.', 'Rowling', 'J.K. Rowling is a British author and philanthropist. She is best known for writing the Harry Potter fantasy series.', 'Bloomsbury'),
  ('Ernest', 'Hemingway', 'Ernest Hemingway was an American novelist, short story writer, and journalist. He won the Nobel Prize in Literature in 1954.', 'Charles Scribner\'s Sons'),
  ('Virginia', 'Woolf', 'Virginia Woolf was an English writer and one of the foremost modernists of the twentieth century.', 'Hogarth Press');
