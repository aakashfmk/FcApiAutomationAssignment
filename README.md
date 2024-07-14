# FcApiAutomationAssignment
This project demonstrates an API automation framework using Java, RestAssured, JUnit, and SLF4J for logging. It includes tests to verify that users from the "FanCode" city have completed more than 50% of their todos.

# Prerequisites
Before running this project, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- IntelliJ IDEA or any preferred Java IDE
- Git (optional, for cloning the repository)

# Setup Instructions
1. Clone the Repository:
git clone https://github.com/aakashfmk/FcApiAutomationAssignment.git

2. Import the Project into IntelliJ or any preferred IDE:
    a. Open IDE.
    b. Select File > Open... and navigate to the project directory.
    c. Select the pom.xml file and click Open to import the project.
    IntelliJ IDEA should automatically recognize the Maven project and start importing dependencies.

# Running Tests
1. Navigate to src/test/java/org/fancode/FcApiTest.java.
2. Right-click on the file or the testTodoCompletionPercentage method.
3. Select Run 'FcApiTest' or Run 'testTodoCompletionPercentage'.

# View Test Results
1. Test results will be displayed in the console including information about each user's completion percentage.
2. Logs will also be saved in app.log file. 

# Project Structure

- src/main/java: Contains the main Java source files (not used extensively in this example).
- src/test/java/org/fancode: FcApiTest.java: Contains the test methods to verify the API behavior.
- models: Contains Java classes (User.java, Todo.java) representing JSON response structures.
- ApiUtils.java: Contains utility methods to interact with the API using RestAssured.
- pom.xml: Maven project configuration file specifying dependencies and build settings.
