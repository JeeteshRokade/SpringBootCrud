#!groovy

pipeline {
    agent any

    tools {
        maven "3.8.1"
		jdk 'JDK11'
    }

    stages {
        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean install"
            }
        }
		stage("SonarQube analysis") {
		steps {

					bat "mvn sonar:sonar -Dsonar.login=de04e47772c21a29cb161938e88036cdc5d1cdb8 -Dsonar.scm.disabled=true"
				
			}
		}
		stage("Quality gate") {
            steps {
				withSonarQubeEnv('sonarqube') {
					waitForQualityGate abortPipeline: true
				}
            }
        }	
    	stage('Junit Test Analysis') { 
            steps {
                bat 'mvn test' 
            }
        post {
            always  {
						junit 'target/surefire-reports/*.xml' 
					}
            }
        }
	}
}