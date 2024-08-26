pipeline {
    agent any
    stages {
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
