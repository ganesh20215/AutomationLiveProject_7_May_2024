pipeline {
    agent any
        environment {
            MAVEN_HOME = tool 'Maven' // Assuming Maven is installed and configured in Jenkins
            JAVA_HOME = tool 'JDK17'  // Assuming JDK 11 is installed and configured in Jenkins
        }
    stages {
/*         stage('Checkout') {
            steps {
                echo 'Checkout Repo'
                git url: 'https://github.com/ganesh20215/AutomationLiveProject_7_May_2024.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                echo 'Build Project'
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        } */
        stage('Test') {
            steps {
                // Run the Selenium test suite
                sh "${MAVEN_HOME}/bin/mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml"
            }
        }
        stage('Post Actions') {
            steps {
                 // Archive the test results and any other artifacts
                 archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
                 junit '**/target/surefire-reports/*.xml' // For TestNG results
            }
        }
    }
	post
	{
		always
		{
			emailext body: 'Summary', subject: 'Pipeline Status', to: 'ganesh20215@gmail.com'
		}
	}
}
