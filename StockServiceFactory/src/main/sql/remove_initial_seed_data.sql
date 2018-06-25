#!!!!!!!  W A R N I N G  !!!!!!!!!!
#
# Use this at your own risk. If any data with the symbols 
#
#     GOOG
#     APPL
#     AMZN
#     IBM
#
# has been created since the initial seeding, it will be destroyed.
#
# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

use stocks;

DELETE FROM quotes where symbol = 'GOOG';
Delete from quotes where symbol ='APPL';
DELETE FROM quotes where symbol = 'AMZN';
DELETE FROM quotes where symbol = 'IBM';

