# Frontend POC
#How to run
if you are run this project firs time, you need to follow "Installation for first time" firstly.

1. run buildjs.bat<br>
2. run OLLFePocApplication.java from IDE

#Setup Email Service in local
https://github.com/Nilhcem/FakeSMTP <br>
FakeSMTP is a Free Fake SMTP Server with GUI for testing emails in applications easily. It is written in Java.
![FakeSMTP](fakeSmtp.png "Boris")

# 4 layers architecture (Domain Driven Design)
![4Layers](4layers.png "4Layers Architecture")

#####Interface --> application | domain | infrastructure
#####application --> domain | infrastructure
#####domain --> infrastructure

![Boris](boris.png "Boris")

RestAPI document:
http://localhost:8080/swagger-ui.html



#installation for first time
0. manual create folder<br>
front/dist/ddd-console<br>
1.install nvm & nodejs <br>
中文文档: https://www.cnblogs.com/gaozejie/p/10689742.html 
<br>
English: https://github.com/coreybutler/nvm-windows
<br>
Note:version of nodejs should greater than or equal to v10.16.3
<br>
<br>
2.cd front <br>
In Terminal window run 'cd front' command<br>
![terminal](terminal.PNG "terminal")<br>
<br>

3.npm install<br>
In Terminal window run 'npm install' command to install packages<br>
![ipmInstall](npmInstall.PNG "npmInstall")<br>
<br>

4. install angualr cli
>npm install -g @angular/cli

#Start Front end for development mode
ng serve -o<br>
In Terminal window run 'ng serve -o' command to run the application<br>
![run](run.PNG "run")<br>
<br>

#About lombok
In this poc project, we introduced lombok plugin to simplify the coding work, it's cool, 
however as a third-party plugin, it's not supported in subsequent Java Version, 
so we don't suggest to use it in formal project.