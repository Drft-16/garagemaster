1. Open in Visual Studio Code
2. Open a terminal and go to the project directory
3. Run the following cmd [mvn clean package] {Maven ver. 11}
4. Set up Tomcat {

   I. Install Apache TomCat ver. 11

   II. Add a user with all the privileges.[
        -->TOMCAT_HOME\conf\tomcat-users.xml
        -->Under first user name tag add another tag like <user username="******" password="******" roles="manager-gui,admin-gui,manager-script,manager-status" /> this.
        -->Save the file
    ]

   III. Go to the bin folder and run the startup.bat file

   IV. Open a browser. Go to localhost:8080 and click on the manager app button. 

   V. Deploy the war file from the PROJECT_DIR\target
}

6. Go to localhost:8080/GarageMaster
8. Use the application.
