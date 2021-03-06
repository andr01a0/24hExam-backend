USE kea;

INSERT INTO parties (`name`, `municipality`)
VALUES ('A. Socialdemokratiet', 'Samsø'),
       ('C. Det konservative Folkeparti', 'Samsø'),
       ('F. SF - Socialistisk Folkeparti', 'Samsø'),
       ('O. Dansk Folkeparti', 'Samsø'),
       ('V. Venstre, Danmarks Liberale Parti', 'Samsø'),
       ('Ø. Enhedslisten - De Rød-Grønne', 'Samsø');

INSERT INTO candidates (`first_name`, `last_name`, `party_id`, `votes`)
VALUES ('Marcel', 'Meijer', 1, 10),
       ('Michael', 'Kristensen', 1, 5),
       ('Helle', 'Hansen', 1, 3),
       ('Karina', 'Knobelauch', 1, 40),
       ('Stefan', 'Hafstein Wolffbrandt', 1, 25),
       ('Robert', 'V. Rasmussen', 1, 56),
       ('Pia', 'Ramsing', 1, 0),
       ('Anders', 'Baun Sørensen', 1, 2),
       ('Per', 'Urban Olsen', 2, 12),
       ('Peter', 'Askjær', 2, 70),
       ('Martin', 'Sørensen', 2, 76),
       ('Louise', 'Bramstorp', 2, 67),
       ('Sigfred', 'Jensen', 2, 90),
       ('Jørn', 'C. Nissen', 2, 88),
       ('Morten', 'Ø. Kristensen', 2, 84),
       ('Susanne', 'Andersen', 2, 35),
       ('Iulian', 'V. Paiu', 2, 3),
       ('Per', 'Hingel', 2, 19),
       ('Ulla', 'Holm', 3, 32),
       ('Kjeld', 'Bønkel', 3, 34),
       ('Anne', 'Grethe Olsen', 3, 34),
       ('Lone', 'Krag', 3, 58),
       ('Børge', 'S. Buur', 3, 98),
       ('Per', 'Mortensen', 4, 100),
       ('Søren', 'Wiese', 5, 10),
       ('Anita', 'Elgaard Højholt Olesen', 5, 15),
       ('Carsten', 'Bruun', 5, 11),
       ('Mogens', 'Exner', 5, 9),
       ('Anja', 'Guldborg', 5, 7),
       ('Klaus', 'Holdorf', 5, 84),
       ('Katrine', 'Høegh Mc Quaid', 6, 37),
       ('Jette', 'M. Søgaard', 6, 78),
       ('Søren', 'Caspersen', 6, 73),
       ('Pia', 'Birkmand', 6, 64);