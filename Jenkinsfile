pipeline {
	agent any
//mewa
    tools {
		maven 'Maven-3.8.6'
        jdk 'JDK-23'
    }
//mewa

    stages {
		stage('Checkout') {
			steps {
				checkout scm
            }
        }
        stage('Build') {
			steps {
				sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
			steps {
				sh 'mvn test'
            }
        }
        stage('Archive') {
			steps {
				archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
		success {
			echo 'Build and tests completed successfully!'
        }
        failure {
			echo 'Build or tests failed.'
        }
    }
}
