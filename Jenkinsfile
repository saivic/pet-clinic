// jenkins pipeline script
// pipeline with stages compile, test, package and echo message in the stages
// use maven to compile, test and package the application
// use docker to build the image and push to docker hub
// define environment variables mavenHome and dockerHome for the tools in jenkins

pipeline {
    agent any
    environment {
        mavenHome = tool 'mavenjenkins'
        dockerHome = tool 'dockerjenkins'
        path = "${mavenHome}/bin:${dockerHome}/bin:${env.PATH}"
    }
    stages {
        stage('Info') {
            steps {
                echo 'Starting the pipeline'
                echo "Maven home: ${mavenHome}"
                echo "Docker home: ${dockerHome}"
                echo "PATH: ${path}"
                echo "$env.JOB_NAME"
            }
        }
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
                script {
                    dockerImage = docker.build("saivic/petclinicapi:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockercred') {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the application'
            }
        }
    }
}
post {
    always {
        echo 'This will always run'
    }
    success {
        echo 'This will run only if successful'
    }
    failure {
        echo 'This will run only if failed'
    }
}