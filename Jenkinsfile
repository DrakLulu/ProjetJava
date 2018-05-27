pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '''-v /root/.m2:/root/.m2
-v /var/run/docker.sock:/var/run/docker.sock
--network host
'''
    }

  }
  stages {
    stage('Build') {
      agent any
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn -B verify'
      }
    }

  }
  post {
    always {
      archiveArtifacts(artifacts: 'main/target/*.jar', fingerprint: true)
      //junit 'target/surefire-reports/*.xml'

    }

  }
}