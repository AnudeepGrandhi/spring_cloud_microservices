The demos are using the public git repository in Infygit.
a) If the private repo is used then we need to provide the below two properties additionally:

spring.cloud.config.server.git.username=xxxxxxxxxxx
spring.cloud.config.server.git.password=xxxxxxxxxxx

b)Instead of Infygit if Infygithub or any other git is used then change the url accordingly.