use stocks;
CREATE USER 'monty'@'localhost' IDENTIFIED BY '??';
GRANT ALL ON stocks.* TO 'monty'@'localhost' WITH GRANT OPTION;