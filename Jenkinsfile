pipeline {
    agent any

    environment {
        // dockerCredentials               = 'dockerCredentials'
        // registry                        = 'selimdeniz/selimdeniz-5gamix-g5-projet1'
        // dockerImage                     = 'selimdeniz/selimdeniz-5gamix-g5-projet1:1.0.0'
        sonarToken                      = 'squ_db1e05a9a59f0bc391d29eb867ac5c7d36511ccc'
    }

    stages {
        // stage('Clean Projects') {
        //     steps{
        //         sh "mvn clean"
        //     } 
        // }
        
        stage('Build') {
            steps {
                sh "mvn clean"
                sh "mvn validate"
                sh "mvn compile"
            }           
        }
         
        stage('Image') {
            steps {
                sh "docker build -t selimdeniz/selimdeniz-5gamix-g5-projet1:1.0.0 ."     
            }
        }
        
        stage('Push to Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerCredentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                        sh "docker push selimdeniz/selimdeniz-5gamix-g5-projet1:1.0.0"
                    }
                }
             }
        }
        
        stage("Docker Compose") {
            steps {
                sh "docker compose up -d"
            }          
        }
      //  stage('Test the code') {
      //      steps 
      //           {
      //               sh "mvn test"                                 
      //           }
      //  }
        
        stage('SONAR Test') {
            steps {
                sh "mvn sonar:sonar -Dsonar.token=$sonarToken"                                        
            }
        }
        
        // stage('Nexus') {
        //     steps{
        //       sh 'mvn deploy'
        //   }
        // }
    }
}