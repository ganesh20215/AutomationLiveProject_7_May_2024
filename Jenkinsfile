pipeline {
    agent any
    stages {
         stage('Checkout') {
            steps {
                echo 'Checkout Repo'
                git url: 'https://github.com/ganesh20215/AutomationLiveProject_7_May_2024.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                echo 'Build Project'
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                // Run the Selenium test suite
                sh "mvn test"
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
