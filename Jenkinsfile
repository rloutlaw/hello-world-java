pipeline {
    agent any
    stages {
        stage('build') {
            withMaven(
                maven: 'maven3') {
                sh 'mvn package install'
            }
        }
    }
}