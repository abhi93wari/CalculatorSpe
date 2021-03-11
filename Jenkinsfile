pipeline {
  environment {
    registry = "abhinav6636/calculator_container"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/abhi93wari/CalculatorSpe.git'
      }
    }
    stage('Building JAR file'){
        steps{
          sh 'mvn install'
        }
        }
    stage('MVN TEST') {
      steps {
        echo "Running the test cases of the project"
        sh "mvn test"
      }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
    stage('Deploy using rundeck'){
        steps{
             script {
              step([
                $class: "RundeckNotifier",
                includeRundeckLogs: true,
                rundeckInstance: "Rundeck server",
                jobId: "e01fe93a-b715-4c6e-9d07-70671f2ce91e",
                shouldWaitForRundeckJob: true,
                shouldFailTheBuild: true,
                tailLog: true
              ])
            }
        }
    }
  }
}