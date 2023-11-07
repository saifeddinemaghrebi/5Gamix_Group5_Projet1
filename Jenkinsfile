pipeline {
    agent any
    
    environment {
        dockerImage = 'makoesprit/malekjemni-5gamix-g5-projet1:1.0.0'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Check out the source code from the repository
                    checkout scm
                }
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    // Build the Docker image
                    docker.build dockerImage, '.'
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    // Push the Docker image to Docker Hub
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerCredentials') {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Docker Compose') {
            steps {
                sh "docker-compose up -d"
            }
        }

    }
}
