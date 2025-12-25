1. Open in Visual Studio Code
2. Open a terminal and go to the project directory
3. run following cmd [mvn clean package]{maven ver. 11}
4. Setup Tomcat{
    I. Install Apache TomCat ver. 11
    II. Add user with all the privileges.[
        -->TOMCAT_HOME\conf\tomcat-users.xml
        -->Under first user name tag add another tag like <user username="******" password="******" roles="manager-gui,admin-gui,manager-script,manager-status" /> this.
        -->Save the file
    ]
    III. Go to bin folder and run the startup.bat file
    IV. Open Browser Go to localhost:8080 and click on manager app button. 
    V. Deploye the war file from the PROJECT_DIR\targer
}
5. Goto localhost:8080/GarageMaster
6. Use the ap
plication.