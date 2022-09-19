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
            input {
                message "Select the environment to deploy"
                ok "Done"
                parameters {
                    choice(name: 'ENV_one', choices:['dev','staging','prod'],description:'')
                    choice(name: 'ENV_two', choices:['dev','staging','prod'],description:'')
                }
            }
            steps{
                script {
                    gv.deploy()
                    echo "deplying for environments ${ENV_one} and ${ENV_two}"
                }
                
            }
        }
    }
}
