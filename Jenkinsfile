pipeline {
    agent any

    environment {
        sonarToken                      = 'squ_868a2f12743ae28c8e533e6779f7d246d56565cc'
    }

    stages {
        stage('Clean Projects') {
            steps 
                 {
                    sh "mvn clean"
                }
            
        }
        stage('Building project') {
            steps 
                 {
                    sh "mvn validate"
                    sh "mvn compile"
                }           
        }
         
         stage('Docker Image') {
            steps {
                    sh "docker build -t makoesprit/malekjemni-5gamix-g5-projet1:1.0.0 ."                  
                 
            }
        }
        stage('Docker Push to hub') {
            steps {
                script {
                 withCredentials([usernamePassword(credentialsId: 'dockerCredentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                sh "docker push makoesprit/malekjemni-5gamix-g5-projet1:1.0.0"
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
          stage('SONAR') {
            steps 
                 {
                 sh "mvn sonar:sonar -Dsonar.token=$sonarToken"                                        
                }
            
        }
        stage('Test Junit') {
            steps {
                     sh "mvn -Dtest=tn.esprit.spring.PisteServicesTest test"
                }
            }
       stage('Nexus') {
            steps 
                 {
                  sh 'mvn deploy'
                 }
            
        }
     
    }
}
