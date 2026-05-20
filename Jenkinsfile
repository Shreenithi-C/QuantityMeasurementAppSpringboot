pipeline {

    agent any

    environment {
        AWS_ACCOUNT_ID = "354307070722"
        AWS_REGION = "us-east-2"
        IMAGE_REPO_NAME = "quantity-app"
        IMAGE_TAG = "latest"

        ECR_REPO = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${IMAGE_TAG}"

        DOCKER_SERVER = "172.31.xx.xx"
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'dev',
                url: 'https://github.com/Shreenithi-C/QuantityMeasurementAppSpringboot.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t quantity-app .'
            }
        }

        stage('Login to ECR') {
            steps {

                withCredentials([[
                    $class: 'AmazonWebServicesCredentialsBinding',
                    credentialsId: 'aws-ecr-creds'
                ]]) {

                    sh '''
                    aws ecr get-login-password --region $AWS_REGION | \
                    docker login --username AWS --password-stdin \
                    $AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com
                    '''
                }
            }
        }

        stage('Tag Docker Image') {
            steps {

                sh '''
                docker tag quantity-app:latest $ECR_REPO
                '''
            }
        }

        stage('Push Docker Image to ECR') {
            steps {

                sh '''
                docker push $ECR_REPO
                '''
            }
        }

        stage('Deploy To Docker Server') {

            steps {

                sh """
                ssh ubuntu@$DOCKER_SERVER '

                docker stop quantity-container || true

                docker rm quantity-container || true

                docker pull $ECR_REPO

                docker run -d \
                --name quantity-container \
                -p 8080:8080 \
                $ECR_REPO
                '
                """
            }
        }
    }
}