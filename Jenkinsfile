#!groovy

pipeline {
    agent any
    tools {
        maven "maven3.81"
	jdk 'jdk11'
    }
    stages {
        stage('git repo & clean') {
            steps {
               bat "rmdir  /s /q SpringBootCrud"
                bat "git clone https://github.com/JeeteshRokade/SpringBootCrud.git"
                bat "mvn clean -f SpringBootCrud"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f SpringBootCrud"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f SpringBootCrud"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f SpringBootCrud"
            }
        }
    }
}
