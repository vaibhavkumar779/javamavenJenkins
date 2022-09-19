//CODE_CHANGES = getGitChange()
pipeline {
    agent any
    environment{
        NEW_VERSION = '1.2.1'
        CRED = credentials('server-cred-id') // for using credentials from jenkins server
    }
    parameters{
        choice(name: 'Version', choices:['1.2.1','1.2.3'],description:'')
        booleanParam(name: 'executeTests', defaultValue: true, description:'')
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
                echo "building version ${NEW_VERSION}"
            }
        }

        stage("test"){
            when{
                expression {
                    params.executeTests
                }
            }
            steps{
                script {
                    gv.test()
                }
            }
        }

        stage("deploy"){
            steps{
                script {
                    gv.deploy()
                }
                
            }
        }
    }
}

post {
    always{
        //
    }
    success{
        //
    }
    failure{
        //
    }
}
