pipeline{
  agent any
  
  stages{
    stage ('Build'){
      steps{
        sh 'mvn clean compile'
      }
    }
    stage('Mockito'){
      steps{
        sh 'mvn test'
      }
    }
    stage ('SonarQube :Quality Test'){
      steps{
        withSonarQubeEnv(installationName: 'sonar'){
          sh 'mvn sonar:sonar'
        }
      }
    }
  }
}