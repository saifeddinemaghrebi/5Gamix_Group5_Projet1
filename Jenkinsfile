pipeline {
    agent any

    environment {
        dockerCredentials               = 'dockerCredentials'
        registry                        = 'makoesprit/malekjemni-5gamix-g5-projet1'
        dockerImage                     = 'makoesprit/malekjemni-5gamix-g5-projet1:1.0.0'
        sonarToken                      = 'squ_b8419827111116f7100abef12468d028123cd190'
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
         stage('Docker Build') {
            steps {
                        sh "docker build -t makoesprit/malekjemni-5gamix-g5-projet1:1.0.0 -f docker/Dockerfile ."               
            }
        }
        stage('Docker run') {
            steps {
                        sh "docker run -itd makoesprit/malekjemni-5gamix-g5-projet1:1.0.0 /bin/sh"               

            }
        }

        stage('Docker Push') {
            steps {
                        sh "docker push makoesprit/malekjemni-5gamix-g5-projet1:1.0.0"
                    
            }
        }
        stage("Docker Compose") {
            steps 
                 {
                    sh "docker compose up -d"
                }          
        }
        stage('Test the code') {
            steps 
                 {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        sh "mvn test"
                    }               
            }
        }
        stage('SONAR') {
            steps 
                 {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        sh "mvn sonar:sonar -Dsonar.token=$sonarToken"
                    }
                }
            
        }
        stage('Nexus') {
            steps 
                 {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        sh "mvn deploy -DskipTests"
                    }
                }
            
        }
    }
}
