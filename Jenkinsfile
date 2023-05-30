pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Clean') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
  }

  post {
    always {
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'target/cucumber-reports', reportFiles: 'extent-report.html', reportName: 'Extent Report', reportTitles: 'Extent Report'])
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'target/cucumber-reports', reportFiles: 'cucumber-html-report.html', reportName: 'Cucumber Report', reportTitles: 'Cucumber Report'])
      deleteDir()
    }
  }
}