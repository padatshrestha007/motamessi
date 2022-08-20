# Set up shorcut keys
>> ![](20220819054657.png)  
# Setting up string boot rest api app
>>Download spring boot rest api template from https://spring.io/guides/gs/motamessi-webapi/
Extract All, Open intellj and open the mvnw file inside \initial.
If error with getting dependency to go File-->settings-->build execution deployment-->Maven and set the the maven home path to the downloaded and extracted maven template root <br>
![](20220818083411.png)  
<br>Oepn application.properties file and add server.port=54366. If that port is in use by other app in you local keep adding one to it until you get a successfull run.
<br>![](20220818084242.png)  
<br>To rename module, right click on the project folder
<br>![](20220818092000.png)  

# Connecting to mysql database
<br> Add dependency in pom.xml
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
<br>![](20220819062512.png)  
# ...

# Createing new spring project
>> Go to https://start.spring.io/
<br> Keep all defaults except the project metatdata, modify according to your needs.
<br> Add depencies as in the picture ( do some research what they are for)
<br>![](20220820051155.png)  
<br>Click Generate to download the project template.

# Setting up mysql
>>sudo ufw allow from 76.85.82.231 to any port 3306
<strong>Connection to mysql in cloud or remote ubuntu from local machine</Strong>
You need type the following commands which will allow remote connections to a mysql server.<br>
<strong>Step # 1: Login Using SSH (if server is outside your data center)</strong><br>
First, login over ssh to remote MySQL database server. You may need to login to your MySQL server as the root user:
>>>ssh user@server1.cyberciti.biz
login as the root using su or sudo ##
su
or use sudo  ##
sudo -i
OR directly login as root user if allowed:
ssh root@server1.cyberciti.biz
>><strong>Step # 2: Edit the my.cnf file</Strong><br>
Once connected you need to edit the MySQL server configuration file my.cnf using a text editor such as vi:
If you are using Debian/Ubuntu Linux file is located at /etc/mysql/my.cnf location.
If you are using Red Hat Linux/Fedora/Centos Linux file is located at /etc/my.cnf location.
If you are using FreeBSD you need to create a file /var/db/mysql/my.cnf location.
Edit the /etc/my.cnf using vi or nano
vi /etc/my.cnf
<Br><strong>
Step # 3: Once file opened, locate line that read as follows</Strong><br>
[mysqld] 
Make sure line skip-networking is commented (or remove line) and add following line
>>>bind-address=YOUR-SERVER-IP
For example, if your MySQL server IP is 65.55.55.2 then entire block should be look like as follows:
[mysqld]
user            = mysql
pid-file        = /var/run/mysqld/mysqld.pid
socket          = /var/run/mysqld/mysqld.sock
port            = 3306
basedir         = /usr
datadir         = /var/lib/mysql
tmpdir          = /tmp
language        = /usr/share/mysql/English
bind-address    = 65.55.55.2
>>skip-networking
....
..
....
Where,
bind-address: IP address to bind to.
skip-networking : Do not listen for TCP/IP connections at all. All interaction with mysqld must be made via Unix sockets. This option is highly recommended for systems where only local requests are allowed. Since you need to allow remote connection this line should be removed from my.cnf or put it in comment state.
<br><strong>
Step# 4 Save and Close the file</Strong><br>
If you are using Debian / Ubuntu Linux, type the following command to restart the mysql server:
 /etc/init.d/mysql restart
OR
 systemctl restart mysql
If you are using RHEL / CentOS / Fedora / Scientific Linux, type the following command to restart the mysql server:
/etc/init.d/mysqld restart
OR
 systemctl restart mysqld
If you are using FreeBSD, type the following command to restart the mysql server:
 /usr/local/etc/rc.d/mysql-server restart
OR
 service mysql-server restart<br>
<Strong>Step # 5 Grant access to remote IP address</Strong>
Connect to mysql server:
 mysql -u root -p mysql
<br>
Grant access to a new database
If you want to add a new database called foo for user bar and remote IP 202.54.10.20 then you need to type the following commands at mysql> prompt:
mysql> CREATE DATABASE foo;
mysql> GRANT ALL ON foo.* TO bar@'202.54.10.20' IDENTIFIED BY 'PASSWORD';<br>
How Do I Grant Access To An Existing Database?
Let us assume that you are always making connection from remote IP called 202.54.10.20 for database called webdb for user webadmin, To grant access to this IP address type the following command At mysql> prompt for existing database, enter:
mysql> update db set Host='202.54.10.20' where Db='webdb';
mysql> update user set Host='202.54.10.20' where user='webadmin';<br>
<Strong>Step # 6: Logout of MySQL</Strong>
Type exit command to logout mysql:
mysql> exit<br>
<Strong>Step # 7: Open port 3306</Strong>
You need to open TCP port 3306 using iptables or BSD pf firewall.<br>
A sample iptables rule to open Linux iptables firewall
/sbin/iptables -A INPUT -i eth0 -p tcp --destination-port 3306 -j ACCEPT
OR only allow remote connection from your web server located at 10.5.1.3:<br>
/sbin/iptables -A INPUT -i eth0 -s 10.5.1.3 -p tcp --destination-port 3306 -j ACCEPT<br>
OR only allow remote connection from your lan subnet 192.168.1.0/24:<br>
/sbin/iptables -A INPUT -i eth0 -s 192.168.1.0/24 -p tcp --destination-port 3306 -j ACCEPT<br>
Finally save all rules (RHEL / CentOS specific command):<br>
>>>service iptables save<br>
>>A sample FreeBSD / OpenBSD / NetBSD pf firewall rule ( /etc/pf.conf)
Use the following to open port # 3306 on a BSD based systems:<br>
pass in on $ext_if proto tcp from any to any port 3306
OR allow only access from your web server located at 10.5.1.3:<br>
pass in on $ext_if proto tcp from 10.5.1.3 to any port 3306  flags S/SA synproxy state
<br><strong>Step # 8: Test it</strong><br>
From your remote system or your desktop type the following command:
$ mysql -u webadmin -h 65.55.55.2 -p<br>
Where,<br>
-u webadmin: webadmin is MySQL username
-h IP or hostname: 65.55.55.2 is MySQL server IP address or hostname (FQDN)
-p : Prompt for password
You can also use the telnet or nc command to connect to port 3306 for testing purpose:
$ echo X | telnet -e X 65.55.55.2 3306<br>
OR
$ nc -z -w1 65.55.55.2 3306<br>
Sample outputs:<br>
Connection to 65.55.55.2 3306 port [tcp/mysql] succeeded!<br>
