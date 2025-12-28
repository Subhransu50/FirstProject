pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'Lori',
                    url: 'https://github.com/Subhransu50/FirstProject'
            }
        }

        stage('Build & Run Tests in Docker') {
            steps {
                sh 'docker build -t selenium-tests .'
                sh 'docker run --rm selenium-tests'
            }
        }
    }
}
