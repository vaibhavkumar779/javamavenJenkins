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
        stage("build"){
            steps{
                echo "building app"
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
                echo "testing app ...."
            }
        }

        stage("deploy"){
            steps{
                echo "deploying app version ${params.Version}..."
                echo "deploying with ${CRED}"
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
