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

INSERT INTO Book_StoreDB.user (Username, Password, Name, Email, Address) VALUES
('john_doe', 'password1', 'John Doe', 'johndoe@mail.com', '123 NW 1 ST'),
('jane_doe', 'password2', 'Jane Doe', 'janedoe@mail.com', '123 NW 2 ST'),
('alex_smith', 'password3', 'Alex Smith', 'alexsmith@mail.com', '123 NW 3 ST'),
('emily_jones', 'password4', 'Emily Jones', 'emilyjones@mail.com', '123 NW 4 ST'),
('michael_johnson', 'password5', 'Michael Johnson', 'michaeljohnson@mail.com', '123 NW 5 ST'),
('sarah_williams', 'password6', 'Sarah Williams', 'sarahwilliams@mail.com', '123 NW 6 ST'),
('david_brown', 'password7', 'David Brown', 'davidbrown@mail.com', '123 NW 7 ST'),
('lisa_miller', 'password8', 'Lisa Miller', 'lisamiller@mail.com', '123 NW 8 ST'),
('kevin_davis', 'password9', 'Kevin Davis', 'kevindavis@mail.com', '123 NW 9 ST'),
('amanda_taylor', 'password10', 'Amanda Taylor', 'amandataylor@mail.com', '123 NW 10 ST');

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
  ('Charles', 'Dickens', 'Charles Dickens was an English writer and social critic. He created some of the worlds, best-known fictional characters.', 'Chapman & Hall'),
  ('George', 'Orwell', 'George Orwell was an English novelist, essayist, journalist and critic. He is best known for his novels 1984 and Animal Farm.', 'Secker & Warburg'),
  ('Fyodor', 'Dostoevsky', 'Fyodor Dostoevsky was a Russian novelist, short story writer, essayist and journalist. He is best known for Crime and Punishment.', 'The Russian Messenger'),
  ('Herman', 'Melville', 'Herman Melville was an American novelist, short story writer, and poet of the American Renaissance period. His best known works include Moby-Dick and Bartleby, the Scrivener.', 'Harper & Brothers'),
  ('Leo', 'Tolstoy', 'Leo Tolstoy was a Russian writer who is regarded as one of the greatest authors of all time. He is best known for War and Peace and Anna Karenina.', 'The Russian Messenger'),
  ('J.K.', 'Rowling', 'J.K. Rowling is a British author and philanthropist. She is best known for writing the Harry Potter fantasy series.', 'Bloomsbury'),
  ('Ernest', 'Hemingway', 'Ernest Hemingway was an American novelist, short story writer, and journalist. He won the Nobel Prize in Literature in 1954.', 'Charles Scribners Sons'),
  ('Virginia', 'Woolf', 'Virginia Woolf was an English writer and one of the foremost modernists of the twentieth century.', 'Hogarth Press');


INSERT INTO Book_StoreDB.book (title, author, genre, isbn, description, publisher, year_Published, copies_Sold, price)
VALUES
  ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', '9780061120084', 'To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature.', 'J. B. Lippincott & Co.', 1960, 30000000, 9.99),
  ('1984', 'George Orwell', 'Dystopian', '9780451524935', '1984 is a dystopian novel by George Orwell published in 1949. The story takes place in an imagined future where the government controls every aspect of life.', 'Secker & Warburg', 1949, 25000000, 8.99),
  ('Pride and Prejudice', 'Jane Austen', 'Romance', '9780141439518', 'Pride and Prejudice is a romantic novel by Jane Austen published in 1813. It follows the emotional development of the protagonist Elizabeth Bennet.', 'T. Egerton, Whitehall', 1813, 20000000, 7.99),
  ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', '9780743273565', 'The Great Gatsby is a novel by F. Scott Fitzgerald published in 1925. It is set in the Roaring Twenties, a time of prosperity, excess, and jazz music.', 'Charles Scribners Sons', 1925, 20000000, 8.49),
  ('Harry Potter and the Philosophers Stone', 'J.K. Rowling', 'Fantasy', '9780747532743', 'Harry Potter and the Philosophers Stone is the first novel in the Harry Potter series written by J.K. Rowling. It follows the journey of a young wizard, Harry Potter.', 'Bloomsbury', 1997, 120000000, 10.99),
  ('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', '9780316769488', 'The Catcher in the Rye is a novel by J.D. Salinger published in 1951. It is known for its portrayal of teenage angst and alienation.', 'Little, Brown and Company', 1951, 65000000, 7.79),
  ('To the Lighthouse', 'Virginia Woolf', 'Modernist', '9780156907392', 'To the Lighthouse is a novel by Virginia Woolf published in 1927. It is considered one of Woolfs most important works and a landmark of 20th-century English literature.', 'Hogarth Press', 1927, 15000000, 9.49),
  ('Moby-Dick', 'Herman Melville', 'Adventure', '9780142437247', 'Moby-Dick is a novel by Herman Melville published in 1851. It tells the story of Captain Ahabs obsessive quest for revenge on the white whale Moby Dick.', 'Harper & Brothers', 1851, 10000000, 11.99),
  ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', '9780261102217', 'The Hobbit, or There and Back Again, is a childrens fantasy novel by J.R.R. Tolkien published in 1937. It follows the journey of Bilbo Baggins as he ventures into the wild to help reclaim the Dwarven kingdom.', 'Allen & Unwin', 1937, 150000000, 12.99),
  ('The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', '9780261103252', 'The Lord of the Rings is an epic fantasy novel by J.R.R. Tolkien published in 1954. It is set in the fictional world of Middle-earth and follows the quest to destroy the One Ring.', 'Allen & Unwin', 1954, 150000000, 15.99);
--added more book entries so we can get top 10 ratings as there are only 10 books
  ('The Da Vinci Code', 'Dan Brown', 'Mystery', '9780307474278', 'The Da Vinci Code is a mystery thriller novel by Dan Brown published in 2003. The novel explores an alternative religious history through the eyes of symbologist Robert Langdon.', 'Doubleday', 2003, 80000000, 9.99),
  ('The Alchemist', 'Paulo Coelho', 'Adventure', '9780062315007', 'The Alchemist is a novel by Brazilian author Paulo Coelho published in 1988. It is an allegorical novel that follows a young shepherd named Santiago in his journey to Egypt, after having a recurring dream of finding treasure there.', 'HarperCollins', 1988, 65000000, 10.99),
  ('The Hunger Games', 'Suzanne Collins', 'Dystopian', '9780439023481', 'The Hunger Games is a dystopian novel by Suzanne Collins published in 2008. It is set in a post-apocalyptic world and follows Katniss Everdeen who participates in a televised competition in which participants must fight to the death.', 'Scholastic Press', 2008, 23000000, 8.49),
  ('The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', '9780064471190', 'The Chronicles of Narnia is a series of seven fantasy novels by C.S. Lewis, published between 1950 and 1956. The series is set in the fictional realm of Narnia, a fantasy world of magic, mythical beasts, and talking animals.', 'Geoffrey Bles', 1950, 120000000, 12.99),
  ('The Book Thief', 'Markus Zusak', 'Historical', '9780375842207', 'The Book Thief is a historical novel by Australian author Markus Zusak, published in 2005. The novel is about the story of Liesel Meminger and her life in Nazi Germany.', 'Picador', 2005, 16000000, 10.99),
  ('Gone with the Wind', 'Margaret Mitchell', 'Historical', '9781416548942', 'Gone with the Wind is a novel by Margaret Mitchell published in 1936. The story is set in the American South during the Civil War and Reconstruction era.', 'Macmillan Publishers', 1936, 30000000, 11.99),
  ('The Kite Runner', 'Khaled Hosseini', 'Drama', '9781594631931', 'The Kite Runner is the first novel by Afghan-American author Khaled Hosseini. Published in 2003, it tells the story of Amir, a young boy from Kabul, and his complicated relationship with his father and his friend Hassan.', 'Riverhead Books', 2003, 31000000, 9.99),
  ('Life of Pi', 'Yann Martel', 'Adventure', '9780156027328', 'Life of Pi is a novel by Yann Martel published in 2001. It tells the story of a young boy who survives a shipwreck and shares a lifeboat with a Bengal tiger.', 'Knopf Canada', 2001, 10000000, 8.99),
  ('The Girl with the Dragon Tattoo', 'Stieg Larsson', 'Mystery', '9780307454546', 'The Girl with the Dragon Tattoo is a mystery novel by Swedish author Stieg Larsson, published posthumously in 2005. The novel follows journalist Mikael Blomkvist as he investigates the disappearance of a wealthy patriarch\'s niece.', 'Norstedts Förlag', 2005, 30000000, 9.49),
  ('The Help', 'Kathryn Stockett', 'Historical', '9780425232200', 'The Help is a novel by Kathryn Stockett published in 2009. It is set in the early 1960s in Jackson, Mississippi, and deals with themes of race and segregation.', 'Penguin Books', 2009, 11000000, 10.49);

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

   INSERT INTO Book_StoreDB.Rating (book_id, user_id, rating, datestamp)
  VALUES
  (1, 1, 5, '2024-06-01 10'),
  (2, 2, 4, '2024-06-02 11'),
  (3, 3, 3, '2024-06-03 12'),
  (4, 4, 2, '2024-06-04 13'),
  (5, 5, 1, '2024-06-05 14'),
  (1, 2, 5, '2024-06-06 15'),
  (2, 3, 4, '2024-06-07 16'),
  (3, 4, 3, '2024-06-05 17'),
  (4, 5, 2, '2024-06-04 18'),
  (5, 1, 1, '2024-06-03 19');

  insert into book_storedb.comment(book_id, user_id, comment, datestamp) values
  (1, 1, 'great book', '2024-06-01 10'),
  (2, 2, 'recommend book', '2024-06-02 11'),
  (3, 3, 'great read', '2024-06-03 12'),
  (4, 4, 'loved', '2024-06-04 13'),
  (5, 5, 'highly recommend', '2024-06-05 14'),
  (1, 2, 'nice story', '2024-06-06 15'),
  (2, 3, '10/10 !', '2024-06-07 16'),
  (3, 4, 'enjoyable', '2024-06-05 17'),
  (4, 5, 'great for kids', '2024-06-04 18'),
  (5, 1, 'book was so-so', '2024-06-03 19');


INSERT INTO Book_StoreDB.wishlist (Wishlist_ID, User_ID, Wishlist_Name)
VALUES
  (1, 1, 'Wishlist 1'),
  (2, 2, 'Wishlist 2'),
  (3, 3, 'Wishlist 3');

INSERT INTO Book_StoreDB.wish_item (Book_ID, Wishlist_ID)
VALUES
  (1, 1),
  (2, 2),
  (3, 3);