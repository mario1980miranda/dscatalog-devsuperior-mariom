# dscatalog-devsuperior-mariom

# exemplos conexões DB Docker Container

docker run -it --rm mysql:8.0.27 mysql:8.0.27 -hsome.mysql.host -usome-mysql-user -p

docker run -e MYSQL_ROOT_PASSWORD=admin123 --name mysql -d -p=3306:3306 mysql:8.0.27

docker run -p 5433:5432 --name container-pg14 -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=dscatalog postgres:14-alpine
