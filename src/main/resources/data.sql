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


INSERT INTO Book_StoreDB.book (title, author, genre, isbn, description, publisher, year_Published, copies_Sold, price)
VALUES
  ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', '9780061120084', 'To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature.', 'J. B. Lippincott & Co.', 1960, 30000000, 9.99),
  ('1984', 'George Orwell', 'Dystopian', '9780451524935', '1984 is a dystopian novel by George Orwell published in 1949. The story takes place in an imagined future where the government controls every aspect of life.', 'Secker & Warburg', 1949, 25000000, 8.99),
  ('Pride and Prejudice', 'Jane Austen', 'Romance', '9780141439518', 'Pride and Prejudice is a romantic novel by Jane Austen published in 1813. It follows the emotional development of the protagonist Elizabeth Bennet.', 'T. Egerton, Whitehall', 1813, 20000000, 7.99),
  ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', '9780743273565', 'The Great Gatsby is a novel by F. Scott Fitzgerald published in 1925. It is set in the Roaring Twenties, a time of prosperity, excess, and jazz music.', 'Charles Scribner\'s Sons', 1925, 20000000, 8.49),
  ('Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling', 'Fantasy', '9780747532743', 'Harry Potter and the Philosopher\'s Stone is the first novel in the Harry Potter series written by J.K. Rowling. It follows the journey of a young wizard, Harry Potter.', 'Bloomsbury', 1997, 120000000, 10.99),
  ('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', '9780316769488', 'The Catcher in the Rye is a novel by J.D. Salinger published in 1951. It is known for its portrayal of teenage angst and alienation.', 'Little, Brown and Company', 1951, 65000000, 7.79),
  ('To the Lighthouse', 'Virginia Woolf', 'Modernist', '9780156907392', 'To the Lighthouse is a novel by Virginia Woolf published in 1927. It is considered one of Woolf\'s most important works and a landmark of 20th-century English literature.', 'Hogarth Press', 1927, 15000000, 9.49),
  ('Moby-Dick', 'Herman Melville', 'Adventure', '9780142437247', 'Moby-Dick is a novel by Herman Melville published in 1851. It tells the story of Captain Ahab\'s obsessive quest for revenge on the white whale Moby Dick.', 'Harper & Brothers', 1851, 10000000, 11.99),
  ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', '9780261102217', 'The Hobbit, or There and Back Again, is a children\'s fantasy novel by J.R.R. Tolkien published in 1937. It follows the journey of Bilbo Baggins as he ventures into the wild to help reclaim the Dwarven kingdom.', 'Allen & Unwin', 1937, 150000000, 12.99),
  ('The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', '9780261103252', 'The Lord of the Rings is an epic fantasy novel by J.R.R. Tolkien published in 1954. It is set in the fictional world of Middle-earth and follows the quest to destroy the One Ring.', 'Allen & Unwin', 1954, 150000000, 15.99);

INSERT INTO Book_StoreDB.credit_card (number, exp_Date, cvc)
VALUES
  ('1234567890123456', '12/25', '123'),
  ('9876543210987654', '09/23', '456'),
  ('5555666677778888', '06/24', '789'),
  ('1111222233334444', '03/22', '321'),
  ('9999888877776666', '11/25', '654'),
  ('4444333322221111', '08/23', '987'),
  ('7777888899990000', '02/26', '234'),
  ('6666555544443333', '10/24', '567'),
  ('1212121212121212', '05/22', '890'),
  ('3434343434343434', '07/23', '123'),
  ('4545454545454545', '04/25', '456'),
  ('5656565656565656', '01/24', '789'),
  ('6767676767676767', '09/22', '321'),
  ('7878787878787878', '11/24', '654'),
  ('8989898989898989', '06/25', '987'),
  ('9090909090909090', '03/23', '234'),
  ('1234123412341234', '08/26', '567'),
  ('5678567856785678', '12/24', '890'),
  ('8765876587658765', '07/22', '123'),
  ('3456345634563456', '10/25', '456');