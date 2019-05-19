# Data Miner

A software analyzing apache logs in order to find threats. This software was developed at the Serres Hackathon 2019.

## Built with
intellij IDEA
XAMPP

### Prerequisites
MySQL 5.7
Java 8 
.csv logs

### Installing
In order for the software to work you need to load the .csv file to a MySQL database initially.
Afterwards you change the login credential in the DatabaseConnection class inside com.dataminers.mine/database/
"localhost" or the ip of your server + the account credentials of the database hosted there.
Then you are ready to run the project and see the results.

## Authors
smarog
ktzouva
athaderm
anestisZioulis

## Licence
This project is licensed under the GNU General Public License v3.0 - see the [LICENSE.md](LICENSE.md) file for details.
