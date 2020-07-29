## idea SSM空框架

访问路径 例如：http://localhost/getUserInfo

## 注意一个问题
之前项目运行一直报错，原来ip地址前面多了 // ，并且端口和实例名之间用了 /（这里不知道为什么会这样写，按道理最初项目是可以运行的）
```
url=jdbc:oracle:thin:@//127.0.0.1:1521/orcl
```

修改为如下（修改后才能正常访问数据库）
```
url=jdbc:oracle:thin:@localhost:1521:orcl
```

## 参考搭建的博文
https://www.cnblogs.com/toutou/p/ssm_spring.html#_nav_3