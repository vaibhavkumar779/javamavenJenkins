def build(){
    echo "building app ..."
}

def test(){
    echo "testing app ..."
}

def deploy(){
    echo "deploying app version ${params.Version}..."
    echo "deploying application ..."
}

return this