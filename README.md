# SpringBatchMVC
1. 将springmvc的WEB页面等资源复制到springbatch下.
2. 更改pom.xml的信息
3. 将HelloController类复制到springbatch下,增加batch页面,创建访问batch页面时的函数,会执行原来App类中main函数的内容.
4. 在Springbatch下运行mvn jetty:run后,访问localhost:8080/batch/a即能执行batch任务.