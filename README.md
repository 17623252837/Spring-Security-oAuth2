|环境|开发工具|内存|
|-------|-------|-------|
|Windows 10|idea 2019.3|32g(非必须)|

[我的博客](http://newdemome.cn/)

## 什么是 oAuth
oAuth 协议为用户资源的授权提供了一个安全的、开放而又简易的标准。与以往的授权方式不同之处是 oAuth 的授权不会使第三方触及到用户的帐号信息（如用户名与密码），即第三方无需使用用户的用户名与密码就可以申请获得该用户资源的授权，因此 oAuth 是安全的。

## 什么是 Spring Security
Spring Security 是一个安全框架，前身是 Acegi Security，能够为 Spring 企业应用系统提供声明式的安全访问控制。Spring Security 基于 Servlet 过滤器、IoC 和 AOP，为 Web 请求和方法调用提供身份确认和授权处理，避免了代码耦合，减少了大量重复代码工作。

## 客户端授权模式
### 分类
tips:客户端必须得到用户的授权（authorization grant），才能获得令牌（access token）。oAuth 2.0 定义了四种授权方式。

- implicit：简化模式，不推荐使用
- authorization code：授权码模式
- resource owner password credentials：密码模式
- client credentials：客户端模式

|工程名/项目名|类型|服务端|客户端|端口|描述|
|-------|-------|-------|-------|-------|-------|
|Spring-Security-oAuth2|pom|否|否|无|案例工程|
|Spring-Security-oAuth2-dependencies|module|否|否|无|依赖管理|
|Spring-security-oauth2-server|module|是|否|8080|内存存储令牌|
|Spring-security-oauth2-server-jdbc|module|是|否|8081|JDBC存储令牌|
|Spring-security-oauth2-server-rbac|module|是|否|8082|RBAC|
|Spring-security-oauth2-server-consumer|module|是|否|8090|结果处理服务|