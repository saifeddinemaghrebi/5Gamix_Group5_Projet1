pipeline {
    agent any

    environment {
        dockerCredentials               = 'dockerCredentials'
        registry                        = 'saifmag/saifeddinmaghrebi-5gamix-g5-projet1'
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
                        docker.withRegistry('', dockerCredentials) { dockerImage.push() }
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