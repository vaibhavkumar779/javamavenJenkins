pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building application ..."
                    sh 'mvn package'
                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'PASS', usernameVariable:'USER')]){
                        sh "pwd"
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker build -t vaibhavkuma779/demo2jenkins:veriontest-2.0 .'
                        
                        sh 'docker push vaibhavkuma779/demo2jenkins:versiontest-2.0'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying application ..."
                }
            }
        }
    }
}