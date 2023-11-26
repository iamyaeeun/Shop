node {
    def app
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
        docker.withRegistry('https://registry.hub.docker.com', 'hyaeeun') {
           app.push("${env.BUILD_NUMBER}")
           app.push("latest")
        }
    }
}
