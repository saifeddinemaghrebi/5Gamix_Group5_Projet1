pipeline {
    agent any

    environment {
        dockerCredentials               = 'dockerCredentials'
        registry                        = 'makoesprit/malekjemni-5gamix-g5-projet1'
        dockerImage                     = 'makoesprit/malekjemni-5gamix-g5-projet1:1.0.0'
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
   //     stage('Test the code') {
    //        steps 
    //             {
     //                sh "mvn test"                                 
      //           }
      //  }
        stage('SONAR') {
            steps 
                 {
                 sh "mvn sonar:sonar -Dsonar.token=$sonarToken"                                        
                }
            
        }
        stage('Nexus') {
            steps 
                 {
                  nexusArtifactUploader artifacts: [
                        [
                            artifactId: 'gestion-station-ski', 
                            classifier: '',      
                            file: 'target/gestion-station-ski-1.0.jar',
                            type: 'jar'         
                        ]
                    ], 
                    credentialsId: 'nexus-credentials',   
                    groupId: 'tn.esprit.spring<',  
                    nexusUrl: '192.168.33.10:8081', 
                    nexusVersion: 'nexus3',    
                    protocol: 'http',          
                    repository: 'NexusRepo', 
                    version: '1.0'            
                                    }
            
        }
    }
}
