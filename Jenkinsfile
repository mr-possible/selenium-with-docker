pipeline {
    stages {
        stage('Build test automation project JAR') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build docker image') {
            steps {
                sh "docker build -t=samd6197/selenium-docker ."
            }
        }
        stage('Push docker image') {
            steps {
                sh "docker push samd6197/selenium-docker"
            }
        }
    }
}