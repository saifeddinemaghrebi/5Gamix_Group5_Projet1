pipeline {
    agent any

    environment {
        // dockerCredentials               = 'dockerCredentials'
        // registry                        = 'eyadhaouadi/eyadhaouadi-5gamix-g5-projet1'
        // dockerImage                     = 'eyadhaouadi/eyadhaouadi-5gamix-g5-projet1:1.0.0'
        sonarToken                      = 'squ_7c76de121a8521a3290b5d5f1cb1e120410b9fbd'
    }

    stages {
        stage('Clean Projects') {
            steps{
                sh "mvn clean"
            } 
        }
        
        stage('Building project') {
            steps {
                sh "mvn validate"
                sh "mvn compile"
            }           
        }
         
        stage('Docker Image') {
            steps {
                sh "sudo docker build -t eyadhaouadi/eyadhaouadi-5gamix-g5-projet1:1.0.0 ."     
            }
        }
        
        stage('Docker Push to hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerCredentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                        sh "docker push eyadhaouadi/eyadhaouadi-5gamix-g5-projet1:1.0.0"
                    }
                }
             }
        }
        
        stage("Docker Compose") {
            steps 
                 {
                    sh "docker compose up -d"
                }          
        }
      //  stage('Test the code') {
      //      steps 
      //           {
      //               sh "mvn test"                                 
      //           }
      //  }
        
        stage('SONAR') {
            steps 
                 {
                 sh "mvn sonar:sonar -Dsonar.token=$sonarToken"                                        
                }
            
        }
        
        stage('Nexus') {
            steps{
              sh 'mvn deploy'
          }
            
        }
    }
}