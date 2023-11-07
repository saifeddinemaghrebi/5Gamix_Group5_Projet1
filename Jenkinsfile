pipeline {
    agent any

    environment {
        dockerCredentials               = 'DockerCredential'
        registry                        = 'saifeddinemaghrebi/5Gamix_Group5_Projet1'
        dockerImage                     = ''
        sonarToken                      = credentials('SonarToken')
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
                        docker.withRegistry('', DockerCredential) { dockerImage.push() }
                    }

            }
        }
        stage("Docker Compose") {
            steps {

                    sh "docker compose up -d"
                }

        }
        stage('Test the code') {
            steps {

                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        sh "mvn test"
                    }

            }
        }
        stage('Jacoco') {
             steps {

                    sh "mvn jacoco:report"
                }

        }
        stage('SONAR') {
            steps {

                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        sh "mvn sonar:sonar -Dsonar.token=SonarToken"
                    }

            }
        }
        stage('Nexus') {
            steps {

                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        sh "mvn deploy -DskipTests"
                    }

            }
        }
    }
}