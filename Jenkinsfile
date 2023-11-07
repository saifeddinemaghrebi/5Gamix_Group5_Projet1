pipeline {
    agent any

    environment {
        dockerCredentials               = 'saifDockerCredentials'
        registry                        = 'saifmag/saifeddinmaghrebi-5gamix-g5-projet1'
        dockerImage                     = ''
        sonarToken                      = 'credentials('SonarToken')'
    }

    stages {
        stage('Clean Projects') {
            steps {

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

                                        script {
                                            dockerImage = docker.build registry + ":1.0.0"
                                    }

                            }
                        }
           stage('Docker Push to hub') {
                     steps {

                             script {
                              withCredentials([usernamePassword(credentialsId: 'saifDockerCredentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                                             sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                                             sh "docker push saifmag/saifeddinmaghrebi-5gamix-g5-projet1:1.0.0"
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

       // stage('Test the code') {
         //   steps {
           //     sh "mvn -Dtest=tn.esprit.spring.CourseServicesImplTest test"
            //}
        //}


        stage('SONAR') {
            steps {


                        sh "mvn sonar:sonar -Dsonar.token=SonarToken"


            }
        }
        stage('Nexus') {
            steps  {
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