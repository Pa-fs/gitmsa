# 기본 MySQL 이미지를 사용합니다.
FROM mysql:latest

# 초기화 SQL 파일을 컨테이너 내로 복사합니다.
COPY ./demo_hr.sql /docker-entrypoint-initdb.d/
COPY ./my.cnf /etc/mysql/my.cnf

# 컨테이너 포트 노출
EXPOSE 3306

# MySQL 서버 시작
CMD ["mysqld"]