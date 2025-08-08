pipeline {
	agent any

    tools {
		maven 'Maven-3.8.6'
        jdk 'JDK-23'
    }

    stages {
		stage('Checkout') {
			steps {
				checkout scm
            }
        }
        stage('Build') {
			steps {
				bat 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
			steps {
				bat 'mvn test'
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
