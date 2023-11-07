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
    stage('Docker image'){
      steps {
        sh 'docker build -t aminetr/springapp .'
      }
    }
    stage('DockerCompose') {    
      steps {                      
				sh 'docker-compose up -d'
      }                    
    }
  }
}