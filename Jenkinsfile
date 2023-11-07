pipeline {
    agent any

    environment {
        dockerCredentials               = 'saifDockerCredentials'
        registry                        = 'saifmag/saifeddinmaghrebi-5gamix-g5-projet1'
        dockerImage                     = ''
        sonarToken                      = credentials('saifSonarToken')
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




        stage('SONAR') {
            steps {


                        sh "mvn sonar:sonar -Dsonar.token=squ_1b14e2959ffe6b8d983adfd25250ee4076d3dc7c"


            }
        }
        stage('Test the code') {
                    steps {
                       sh "mvn -Dtest=tn.esprit.spring.CourseServicesImplTest test"
                    }
                }
        stage('Nexus') {
            steps  {
                                    sh "mvn deploy -DskipTests"
        }
    }
}
}