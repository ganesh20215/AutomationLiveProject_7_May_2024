pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                // Run the Selenium test suite
                sh "mvn test"
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
