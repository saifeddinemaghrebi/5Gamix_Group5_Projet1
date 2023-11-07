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


        stage('Test the code') {
            steps {


                        sh "mvn test"


            }
        }

        stage('SONAR') {
            steps {


                        sh "mvn sonar:sonar -Dsonar.token=SonarToken"


            }
        }
        stage('Nexus') {
            steps {


                        sh "mvn deploy -DskipTests"


            }
        }
    }
}