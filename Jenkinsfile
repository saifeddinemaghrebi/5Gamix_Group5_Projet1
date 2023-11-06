pipeline{
  agent any
  
  stages{
    stage ('MVN Clean'){
      steps{
        sh 'mvn clean install -DskipTests'
      }
    }
      stage ('MVN compile'){
      steps{
        sh 'mvn compile'
      }
    }
    stage ('build package'){
      steps{
        sh 'mvn clean package'
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