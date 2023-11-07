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

                            sh "mvn validate"
                            sh "mvn compile"

                    }
                }


        stage('Test the code') {
            steps {
                sh "mvn -Dtest=tn.esprit.spring.CourseServicesImplTest test"
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