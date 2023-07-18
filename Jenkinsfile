// jenkins pipeline script
// pipeline with stages compile, test, package and echo message in the stages
// use maven to compile, test and package the application
// use docker to build the image and push to docker hub
// define environment variables mavenHome and dockerHome for the tools in jenkins

pipeline {
    agent any
    environment {
        mavenHome = tool 'Maven'
        dockerHome = tool 'Docker'
        path = "${mavenHome}/bin:${dockerHome}/bin:${env.PATH}"
    }
    stages {
        stage('Compile') {
            steps {
                sh "mvn clean compile"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package -DskipTests"
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${dockerHome}/bin/mvn package"
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "docker push ${dockerHome}/bin/mvn package"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application'
            }
        }
    }
}