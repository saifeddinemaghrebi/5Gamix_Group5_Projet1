pipeline{
  agent any
  
  stages{
    stage ('Build'){
      steps{
        sh './mvnw clean compile'
      }
    }
    stage('Mockito'){
      steps{
        sh './mvnw test'
      }
    }
    stage ('SonarQube :Quality Test'){
      steps{
        withSonarQubeEnv(installationName: 'sonar'){
          sh './mvnw sonar:sonar'
        }
      }
    }
  }
}