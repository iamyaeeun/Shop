node {
    def app
    def PROJECT_ID = 'opensource-398212'
    def CLUSTER_NAME = 'kube'
    def LOCATION = 'asia-northeast3-a'
    def CREDENTIALS_ID = 'bb429487-8eb3-4417-84a5-2d23f10f81cf'
    
    stage('Clone repository') {
        git 'https://github.com/iamyaeeun/Shop.git'
    }
    stage('Build image') {
        app = docker.build("hyaeeun/opensource")
    }
    /*
    stage('Test image') {
        app.inside {
            sh 'make test'
        }
    }
    */
    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
           app.push("${env.BUILD_NUMBER}")
           app.push("latest")
        }
    }
    stage('Deploy to GKE') {
        if (env.BRANCH_NAME == 'master') {
            // Replace image tag in deployment.yaml with the current build ID
            sed -i 's/opensource:latest/opensource:${env.BUILD_ID}/g' deployment.yaml

            // Deploy to GKE using KubernetesEngineBuilder
            step([$class: 'KubernetesEngineBuilder', 
                  projectId: env.PROJECT_ID, 
                  clusterName: env.CLUSTER_NAME, 
                  location: env.LOCATION, 
                  manifestPattern: 'deployment.yaml', 
                  credentialsId: env.CREDENTIALS_ID, 
                  verifyDeployments: true])
        }
    }
}
