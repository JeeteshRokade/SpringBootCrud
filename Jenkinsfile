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

					bat "mvn sonar:sonar -Dsonar.login=b4906dfcdcc4c0826256c34ad1a0829eef088281 -Dsonar.scm.disabled=true"
				
			}
		}
		stage("Quality gate") {
            steps {
				withSonarQubeEnv('sonar') {
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
