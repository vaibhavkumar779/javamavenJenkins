//CODE_CHANGES = getGitChange()
pipeline {
    agent any
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
                    gv.build()
                }
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
