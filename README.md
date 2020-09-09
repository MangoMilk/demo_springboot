# Getting Started

### 环境
* [Spring Boot 2.3.3](https://spring.io/projects/spring-boot)
* Java 8
* Mysql 5.7
* Redis 5.0

### 依赖
* springboot web
* mysql
* mybatis
* druid
* redis
* fastjson
* thymeleaf
* bootstrap

### 简述
* web服务端口:8090
* 原生sql目录：/src/main/resources/sql
* 数据模型：使用 mybatis-generator 插件，通过数据库scheme生成对应的映射文件。
* 登录页：127.0.0.1:8090 或 127.0.0.1:8090/login
* 主页：127.0.0.1:8090/home

### 启动
* 方法一：mvn spring-boot:run
* 方法二：先mvn install打jar包，再切换到jar包目录使用 java -jar xxxxx.jar
* 方法三：直接在idea里面启动（开发工具是IntelliJ IDEA）


