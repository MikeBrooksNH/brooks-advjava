# revert the adding of rows for unint testing
use stocks;
delete from quotes where symbol = 'MAB'
